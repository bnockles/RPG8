package project.demo;

import project.controls.OverworldSpriteControl;
import project.items.Weapon;
import project.save.ItemState;

public class SampleKEnemy extends SampleEnemyAI{
	public SampleKEnemy(int[] stats, Weapon weapon){
		maxhp = stats[0];
		positionX = stats[1];
		positionY = stats[2];
		visionrangeX = stats[3];
		visionrangeY = stats[4];
		visiondegree = stats[5];
		this.weapon = weapon;
	}

	public SampleKEnemy(int[] stats, Weapon weapon, boolean[] conditions){
		maxhp = stats[0];
		positionX = stats[1];
		positionY = stats[2];
		visionrangeX = stats[3];
		visionrangeY = stats[4];
		visiondegree = stats[5];
		this.weapon = weapon;
		this.targetlock = conditions[0];
		this.left = conditions[1];
		this.up = conditions[2];
		this.boss = conditions[3];
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
