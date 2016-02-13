package project.demo;

import project.controls.OverworldSpriteControl;
import project.items.Weapon;
import project.save.ItemState;

public class SampleGEnemy extends SampleEnemyAI{
	
	public SampleGEnemy(int[] stats, Weapon weapon){
		maxhp = stats[0];
		positionx = stats[1];
		positiony = stats[2];
		visionrangeX = stats[3];
		visionrangeY = stats[4];
		visiondegree = stats[5];
		this.weapon = weapon;
	}

	public SampleGEnemy(int[] stats, Weapon weapon, boolean boss){
		maxhp = stats[0];
		positionx = stats[1];
		positiony = stats[2];
		visionrangeX = stats[3];
		visionrangeY = stats[4];
		visiondegree = stats[5];
		this.weapon = weapon;
		this.boss = boss;
	}
	
	@Override
	public void reaction() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ItemState getItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OverworldSpriteControl move() {
		// TODO Auto-generated method stub
		return null;
	}
}
