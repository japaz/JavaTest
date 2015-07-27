package ts.connectn;



/**
 * Describes the position for a chip, just indicating the row and column coordinates.
 *
 */
public class ChipPosition {
	private int column, row;
	
	public ChipPosition(int row, int column){
		this.column=column;
		this.row=row;
	}
	
	public int getColumn(){
		return column;
	}
	
	public int getRow(){
		return row;
	}
	
	public String toString(){
		return "["+row+","+column+"]";
	}
}
