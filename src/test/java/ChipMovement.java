package ts.connectn.test;

import ts.connectn.Chip;

public class ChipMovement {

	private Chip chip;
	private int column;
	
	public ChipMovement(Chip chip, int column) {
		super();
		this.chip = chip;
		this.column = column;
	}

	public Chip getChip() {
		return chip;
	}

	public int getColumn() {
		return column;
	}
	
	
}
