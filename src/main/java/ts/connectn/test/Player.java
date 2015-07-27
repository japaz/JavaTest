package ts.connectn.test;

import ts.connectn.GameResult;
import ts.connectn.GameResult.GameResultType;
import ts.connectn.game.GameIfc;

public class Player{

	public GameResult play(GameIfc gameIfc, PlayerIfc playerA, PlayerIfc playerB) {
		GameResult gameResult=null;
		while(playerA.hasMoreMovements()||playerB.hasMoreMovements()){
			ChipMovement movementA = playerA.nextMovement();
			gameIfc.putChip(movementA.getChip(), movementA.getColumn());
			gameResult=gameIfc.checkGameResult();
			if(gameResult.getGameResultType()==GameResultType.NOT_EVEN){
				break;
			}

			ChipMovement movementB = playerB.nextMovement();
			gameIfc.putChip(movementB.getChip(), movementB.getColumn());
			gameResult=gameIfc.checkGameResult();
			if(gameResult.getGameResultType()==GameResultType.NOT_EVEN){
				break;
			}
		}
		
		return gameResult;
		
	}

}
