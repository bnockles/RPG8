package project.battles;

import project.controls.OverworldSpriteControl;
import project.save.ItemState;

public class IEnemy extends EnemyAI{
	private int[] stats;

	void movement() {
		// TODO Auto-generated method stub
		
	}

	void sight() {
		// TODO Auto-generated method stub
		
	}
	public IEnemy(int[] stats){
		this.stats = stats;
	}

	@Override
	public ItemState getItems() {
		// TODO Auto-generated method stub
		return null;
	}


	public OverworldSpriteControl move() {
		// TODO Auto-generated method stub
		return null;
	}
}
