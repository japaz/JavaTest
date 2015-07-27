package ts.connectn;

/**
 * 
 * Represents the result of a ConnectN game
 */
public class GameResult {
	
	/**
	 * A game can be even, or not even (not even = we have a winner)
	 *
	 */
	public enum GameResultType {
		EVEN,
		NOT_EVEN;
	}
	
	private GameResultType gameResultType;
	
	/**
	 * ChipType for the winner
	 */
	private Chip winnerChipType;
	
	/**
	 * Array with the chip positions of the winner
	 */
	private ChipPosition[] winnerChipPositions;
	
	/**
	 * Use this constructor when there is a Winner (NOT_EVEN GameResultType)
	 * @param gameResultType
	 * @param winnerChipType
	 * @param winnerPositions
	 */
	public GameResult(GameResultType gameResultType, Chip winnerChipType, ChipPosition[] winnerPositions){
		this.winnerChipType=winnerChipType;
		this.gameResultType=gameResultType;
		this.winnerChipPositions=winnerPositions;
	}
	
	/**
	 * 
	 * Use this constructor when there is no Winner (EVEN GameResultType) 
	 * 
	 * @param gameResultType
	 */
	public GameResult(GameResultType gameResultType){
		this.gameResultType=gameResultType;
		this.winnerChipPositions=new ChipPosition[]{};
	}

	public GameResultType getGameResultType() {
		return gameResultType;
	}

	public Chip getWinnerChipType() {
		return winnerChipType;
	}

	public ChipPosition[] getWinnerPositions() {
		return winnerChipPositions;
	}
		
	public String toString(){
		String result=""+gameResultType;
		
		if(gameResultType==GameResultType.NOT_EVEN){
			String positionsString="";
			for(int i=0;i<winnerChipPositions.length;i++){
				positionsString+=winnerChipPositions[i].toString();
			}
			result+=", and the winner is: "+winnerChipType+"!, with positions: "+positionsString;
		}
		
		return result;
	}
	
	
	
}
