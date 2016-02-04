package project.battles;

import project.controls.OverworldSpriteControl;
import project.save.ItemState;

public class KEnemy extends EnemyAI{
	private int[] nstats;
	private int[] rstats;

	void movement() {
		// TODO Auto-generated method stub
		
	}

	void sight() {
		// TODO Auto-generated method stub
		
	}
	public KEnemy(int[] nstats){
		this.nstats = nstats;
	}
	public KEnemy(int[] nstats, int[] rstats){
		this.nstats = nstats;
		this.rstats = rstats;
	}

	public ItemState getItems() {
		// TODO Auto-generated method stub
		return null;
	}

	public OverworldSpriteControl move() {
		// TODO Auto-generated method stub
		return null;
	}
}
