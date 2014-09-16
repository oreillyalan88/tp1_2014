package ca.csf.hanoi;

import ca.csf.stack.LinkedListStack;

public class HanoiTowers {
	public Tower[] towers;
	// The three towers used in the game. Towers are listed from left to right.
	private int nbrOfDisks; // The number of disks set for this game.
	public Disk heldDisk; // The disk that is currently being held. (Used when picking up a disk from a tower
	private final static int NBR_OF_TOWERS = 3; // If for whatever reason some hipster would want to play this game with a different amount of towers.
	
	public HanoiTowers () { // When first created, uses the default 3-disk configuration.
	}
	
	public void newGame (int numberOfDisks) throws Exception { // Begins a new game
		towers = new Tower[NBR_OF_TOWERS];
		for (int i = 0; i < NBR_OF_TOWERS; i++) {
			towers[i] = new Tower(new LinkedListStack());
		}
		nbrOfDisks = numberOfDisks;
		heldDisk = null;
		if (numberOfDisks < 1) throw new Exception("Number of disks needs to be greater than 0");
		for (int i = numberOfDisks; i > 0; i--){
			towers[0].addDisk(new Disk(i));
		}
	}

	public void pickUpDisk (int towerPosition){
		heldDisk = towers[towerPosition-1].getDiskOnTop();
		towers[towerPosition-1].removeDisk();
	}
	
	public boolean canPickUp (int towerPosition){
		if (heldDisk == null && towers[towerPosition-1].disks.isEmpty()){ // Not currently holding a disk, selected tower has disks.
			return true;
		}
		else{
			return false;
		}
		
	}
	
	public void dropDisk (int towerPosition){
		towers[towerPosition-1].addDisk(heldDisk); // Adds a disk to the tower, player is no longer holding a disk.
		heldDisk = null;
	}
	
	public boolean canDrop (int towerPosition){
		if (heldDisk != null && heldDisk.getSize() < towers[towerPosition-1].getDiskOnTop().getSize()){ // Currently holding a disk. Held disk is smaller than the disk on top of target tower.
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isFinished () { // "Did we win?"
		if (towers[2].getSize() == nbrOfDisks){ // If the right tower has all the disks in the game.
			return true;
		}
		else {
			return false;
		}
	}
	
}
