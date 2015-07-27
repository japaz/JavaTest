package ts.connectn.test;

import ts.connectn.Chip;

public interface PlayerIfc {

	
	public boolean hasMoreMovements();
	
	public ChipMovement nextMovement();

	public Chip getChipType();
	
	public int getMovementsSize();
}
