package ts.connectn.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ts.connectn.Chip;
import ts.connectn.ChipPosition;
import ts.connectn.GameResult;
import ts.connectn.GameResult.GameResultType;
import ts.connectn.game.GameIfc;
import ts.connectn.game.GameImpl;

public class GameTest{

	@Test
	public void test1(){
		GameResult gameResult=test(6, 7, 2,
			new PlayerTest(new int[]{1,3,5}, Chip.RED),
			new PlayerTest(new int[]{0,2,0}, Chip.YELLOW));		
		assertTrue(gameResult.getGameResultType()==GameResultType.NOT_EVEN);
		assertTrue(gameResult.getWinnerChipType()==Chip.YELLOW);
		assertTrue(contains(gameResult.getWinnerPositions(), new ChipPosition(0,0)));
		assertTrue(contains(gameResult.getWinnerPositions(), new ChipPosition(1,0)));
	}
	
	@Test
	public void test2(){
		GameResult gameResult=test(6, 7, 3,
			new PlayerTest(new int[]{1,2,4,3,5,5}, Chip.RED),
			new PlayerTest(new int[]{1,2,3,2,3,3}, Chip.YELLOW));		
		assertTrue(gameResult.getGameResultType()==GameResultType.NOT_EVEN);
		assertTrue(gameResult.getWinnerChipType()==Chip.YELLOW);
		assertTrue(contains(gameResult.getWinnerPositions(), new ChipPosition(1,1)));
		assertTrue(contains(gameResult.getWinnerPositions(), new ChipPosition(2,2)));
		assertTrue(contains(gameResult.getWinnerPositions(), new ChipPosition(3,3)));
	}
	
	
	@Test
	public void test3(){
		GameResult gameResult=test(6, 7, 5,
			new PlayerTest(new int[]{1,2,4,3,5,5,4,4,5}, Chip.RED),
			new PlayerTest(new int[]{1,2,3,2,3,3,4,0,4}, Chip.YELLOW));		
		assertTrue(gameResult.getGameResultType()==GameResultType.NOT_EVEN);
		assertTrue(gameResult.getWinnerChipType()==Chip.YELLOW);
		assertTrue(contains(gameResult.getWinnerPositions(), new ChipPosition(0,0)));
		assertTrue(contains(gameResult.getWinnerPositions(), new ChipPosition(1,1)));
		assertTrue(contains(gameResult.getWinnerPositions(), new ChipPosition(2,2)));
		assertTrue(contains(gameResult.getWinnerPositions(), new ChipPosition(3,3)));
		assertTrue(contains(gameResult.getWinnerPositions(), new ChipPosition(4,4)));
	}
	
	@Test
	public void test4(){
		GameResult gameResult=test(6, 7, 6,
			new PlayerTest(new int[]{1,2,4,3,5,5,4,4,5,0,2,1}, Chip.RED),
			new PlayerTest(new int[]{1,2,3,2,3,3,4,0,4,1,0,1}, Chip.YELLOW));		
		assertTrue(gameResult.getGameResultType()==GameResultType.EVEN);
	}
	
	@Test
	public void test5(){
		GameResult gameResult=test(6, 7, 4,
			new PlayerTest(new int[]{1,2,3,4}, Chip.RED), //winner horizontal
			new PlayerTest(new int[]{1,1,1,5}, Chip.YELLOW));		
		assertTrue(gameResult.getGameResultType()==GameResultType.NOT_EVEN);
		assertTrue(gameResult.getWinnerChipType()==Chip.RED);
		assertTrue(contains(gameResult.getWinnerPositions(), new ChipPosition(0,1)));
		assertTrue(contains(gameResult.getWinnerPositions(), new ChipPosition(0,2)));
		assertTrue(contains(gameResult.getWinnerPositions(), new ChipPosition(0,3)));
		assertTrue(contains(gameResult.getWinnerPositions(), new ChipPosition(0,4)));
	}
	
	@Test
	public void test6(){
		GameResult gameResult=test(6, 7, 4,
				new PlayerTest(new int[]{1,1,2,2}, Chip.RED), 
				new PlayerTest(new int[]{3,3,3,3}, Chip.YELLOW));//winner vertical
		assertTrue(gameResult.getGameResultType()==GameResultType.NOT_EVEN);
		assertTrue(gameResult.getWinnerChipType()==Chip.YELLOW);
		assertTrue(contains(gameResult.getWinnerPositions(), new ChipPosition(0,3)));
		assertTrue(contains(gameResult.getWinnerPositions(), new ChipPosition(1,3)));
		assertTrue(contains(gameResult.getWinnerPositions(), new ChipPosition(2,3)));
		assertTrue(contains(gameResult.getWinnerPositions(), new ChipPosition(3,3)));
	}
	
	@Test
	public void test7(){
		GameResult gameResult=test(6, 7, 4,
						new PlayerTest(new int[]{1,2,2,3,3,3,4}, Chip.RED), //winner diagonal UP
						new PlayerTest(new int[]{2,3,3,4,4,4,6}, Chip.YELLOW));	
		assertTrue(gameResult.getGameResultType()==GameResultType.NOT_EVEN);
		assertTrue(gameResult.getWinnerChipType()==Chip.RED);
		assertTrue(contains(gameResult.getWinnerPositions(), new ChipPosition(0,1)));
		assertTrue(contains(gameResult.getWinnerPositions(), new ChipPosition(1,2)));
		assertTrue(contains(gameResult.getWinnerPositions(), new ChipPosition(2,3)));
		assertTrue(contains(gameResult.getWinnerPositions(), new ChipPosition(3,4)));
	}
	
	@Test
	public void test8(){
		GameResult gameResult=test(6, 7, 4,
						new PlayerTest(new int[]{1,1,1,2,3,4}, Chip.RED),
						new PlayerTest(new int[]{2,1,2,3,5,5}, Chip.YELLOW));	
		assertTrue(gameResult.getGameResultType()==GameResultType.NOT_EVEN);
		assertTrue(gameResult.getWinnerChipType()==Chip.RED);
		assertTrue(contains(gameResult.getWinnerPositions(), new ChipPosition(3,1)));
		assertTrue(contains(gameResult.getWinnerPositions(), new ChipPosition(2,2)));
		assertTrue(contains(gameResult.getWinnerPositions(), new ChipPosition(1,3)));
		assertTrue(contains(gameResult.getWinnerPositions(), new ChipPosition(0,4)));
	}
	
	@Test
	public void test9(){
		GameResult gameResult=test(6, 7, 4,
				new PlayerTest(new int[]{2,3,4,2,3,4,6,6,6}, Chip.RED), 
				new PlayerTest(new int[]{1,2,2,5,2,3,4,5,3}, Chip.YELLOW));
		assertTrue(gameResult.getGameResultType()==GameResultType.NOT_EVEN);
		assertTrue(gameResult.getWinnerChipType()==Chip.YELLOW);
		assertTrue(contains(gameResult.getWinnerPositions(), new ChipPosition(4,2)));
		assertTrue(contains(gameResult.getWinnerPositions(), new ChipPosition(3,3)));
		assertTrue(contains(gameResult.getWinnerPositions(), new ChipPosition(2,4)));
		assertTrue(contains(gameResult.getWinnerPositions(), new ChipPosition(1,5)));
	}
	
	@Test
	public void test10(){
		GameResult gameResult=test(6, 7, 4,
				new PlayerTest(new int[]{0,2,2,5,2,3,4,5,4,6,5}, Chip.RED),
				new PlayerTest(new int[]{2,3,4,2,3,4,6,6,5,5,6}, Chip.YELLOW));	
		assertTrue(gameResult.getGameResultType()==GameResultType.NOT_EVEN);
		assertTrue(gameResult.getWinnerChipType()==Chip.RED);
		assertTrue(contains(gameResult.getWinnerPositions(), new ChipPosition(1,2)));
		assertTrue(contains(gameResult.getWinnerPositions(), new ChipPosition(2,3)));
		assertTrue(contains(gameResult.getWinnerPositions(), new ChipPosition(3,4)));
		assertTrue(contains(gameResult.getWinnerPositions(), new ChipPosition(4,5)));
	}
	
	private static boolean contains(ChipPosition[] chipPositions, ChipPosition pos){
		boolean contains=false;
		for(int i=0;i<chipPositions.length;i++){
			if(chipPositions[i].getColumn()==pos.getColumn()&&chipPositions[i].getRow()==pos.getRow()){
				contains=true;
				break;
			}
		}
		
		return contains;
	}
	
	private static GameResult test(int rows, int columns, int connectN, PlayerTest playerA, PlayerTest playerB){
		Player game = new Player();		
		GameIfc gameIfc = new GameImpl(rows, columns, connectN);		
		GameResult gameResult = game.play(gameIfc, playerA, playerB);	
		System.out.println(gameResult.toString());
		return gameResult;
	}
}
