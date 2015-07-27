package ts.connectn.game;

import ts.connectn.Chip;
import ts.connectn.ChipPosition;
import ts.connectn.GameResult;
import ts.connectn.GameResult.GameResultType;

public class GameImpl implements GameIfc{
	int rows;
	int columns;
	int n;
	Chip[][] board;
	int[] firstFreePositionInColumn; // indicates the first free possition in each column
	
	// this attributes should be extracted to an additional class
	// They are used to go through the matrix to look for sequences of chips
	int consecutives = 0; // number of chips consecutive of the same color
	Chip current_chip =  null; // color of the serie of consecutive chips 
	ChipPosition[] positions = new ChipPosition[n]; // positions of the consecutive chips
	GameResultType result_type = GameResultType.EVEN; // temporal game result 
	
	/**
	 * 
	 * @param rows
	 * @param columns
	 * @param n
	 */
	public GameImpl (int rows, int columns, int n) {
		this.rows = rows;
	    this.columns = columns;
		this.n = n;
		board = new Chip[columns][rows];
		firstFreePositionInColumn = new int[columns];
		for (int i = 0; i < rows; i++) {
			firstFreePositionInColumn[0] = 0; // initially the
		}
	}

	@Override
	public void putChip(Chip chip, int column) {
		int next_position_in_column = firstFreePositionInColumn[column];
		if (next_position_in_column == rows) {
			throw new RuntimeException("Column full");
		}
	    board[column][next_position_in_column] = chip;
	    firstFreePositionInColumn[column] = next_position_in_column+1;
	}

	@Override
	public GameResult checkGameResult() {
		result_type = GameResultType.EVEN;
		
		// Check if there is any win position on any of the columns
		for (int i = 0 ; i < columns; i++) {
			if (result_type == GameResultType.NOT_EVEN) {
				break;
			}
			
			initializeCounters();
			for (int j = 0; j < rows; j++) {
				if (isThereWinPossition(i, j)) {
					break;
				}
			}
		}
		
		// Check if there is any win position on any of the rows
		if (result_type == GameResultType.EVEN) {
			for (int j = 0 ; j < rows; j++) {
				if (result_type == GameResultType.NOT_EVEN) {
					break;
				}
				
				initializeCounters();
				for (int i = 0; i < columns; i++) {
					if (isThereWinPossition(i, j)) {
						break;
					}
				}
			}
		}
		
		// Check if there is any win position in a diagonal from right to left
		if (result_type == GameResultType.EVEN) {
			recorrerAllDiagonalesRL();
		}
		
		// Check if there is any win position in a diagonal from lefth to right
		if (result_type == GameResultType.EVEN) {
			recorrerAllDiagonalesLR();
		}
		
		return new GameResult(result_type, current_chip, positions);
	}

	private boolean isThereWinPossition(int i, int j) {
		Chip chip = board[i][j];
		if (chip != null) {
			if (chip.equals(current_chip)) {
				positions[consecutives] = new ChipPosition(j, i);
				consecutives++;
			} else {
				current_chip = chip;
				positions = new ChipPosition[n];
				positions[0] = new ChipPosition(j, i);
				consecutives=1;
			}
			if (consecutives == n) {
				result_type = GameResultType.NOT_EVEN;
				return true;
			}
		} else {
			initializeCounters();
		}
		
		return false;
	}

	private void initializeCounters() {
		consecutives = 0;
		current_chip =  null;
		positions = new ChipPosition[n];
	}
	
	public void recorrerAllDiagonalesRL() {
		// Should be optimized to don't go through diagonals that cant handle the needed chips for a vistory
		for (int i = 0; i < columns; i++) {
			if (recorrerDiagonalRL(i, 0)) {
				break;
			}
		}
		
		if (result_type == GameResultType.EVEN) {
			for (int j = 1; j < rows; j++) {
				if (recorrerDiagonalRL(columns-1, j)) {
					break;
				}
			}
		}
	}
	
	public boolean recorrerDiagonalRL(int column, int row) {
		initializeCounters();
		int i = column;
		int j = row;
		
		while (i >= 0 && j < rows ) {
			if (isThereWinPossition(i, j)) {
				result_type = GameResultType.NOT_EVEN;
				return true;
			}
			i--;
			j++;
		}
		
		return false;
	}
	
	public void recorrerAllDiagonalesLR() {
		// Should be optimized to don't go through diagonals that cant handle the needed chips for a vistory
		for (int j = rows-1; j >= 0; j--) {
			if (recorrerDiagonalLR(0, j)) {
				break;
			}
		}
		
		if (result_type == GameResultType.EVEN) {
			for (int i = 1; i < columns; i++) {
				if (recorrerDiagonalLR(i, 0)) {
					break;
				}
			}
		}
	}
	
	public boolean recorrerDiagonalLR(int column, int row) {
		initializeCounters();
		int i = column;
		int j = row;
		
		while (j < rows && i < columns ) {
			if (isThereWinPossition(i, j)) {
				result_type = GameResultType.NOT_EVEN;
				return true;
			}
			i++;
			j++;
		}
		
		return false;
	}

}
