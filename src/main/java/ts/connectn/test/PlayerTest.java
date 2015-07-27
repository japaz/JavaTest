package ts.connectn.test;

import ts.connectn.Chip;

public class PlayerTest implements PlayerIfc{

	private int[] columnMovements;
	private Chip chip;
	private int movementPointer;
	
	public PlayerTest(int[] movements, Chip chip){
		this.columnMovements=movements;
		this.chip=chip;
		this.movementPointer=0;
	}
	
	@Override
	public ChipMovement nextMovement() {
		movementPointer++;
		ChipMovement chipMovement = new ChipMovement(chip, columnMovements[movementPointer-1]);
		return chipMovement;
	}

	@Override
	public boolean hasMoreMovements() {
		return movementPointer<columnMovements.length;
	}

	@Override
	public Chip getChipType() {
		return Chip.RED;
	}
	
	public int getMovementsSize(){
		return columnMovements.length;
	}


}
