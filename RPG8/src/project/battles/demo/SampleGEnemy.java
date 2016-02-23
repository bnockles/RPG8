package project.battles.demo;

import project.controls.OverworldSpriteControl;
import project.items.Weapon;
import project.save.ItemState;

public class SampleGEnemy extends SampleEnemyAI{
	
	public SampleGEnemy(String imgsrc,int[] stats, SampleWeapon weapon){
		this.imgsrc=imgsrc;
		maxhp = stats[0];
		positionX = stats[1];
		positionY = stats[2];
		visionrangeX = stats[3];
		visionrangeY = stats[4];
		visiondegree = stats[5];
		this.weapon = weapon;
	}

	public SampleGEnemy(String imgsrc, int[] stats, SampleWeapon weapon, boolean[] conditions){
		this.imgsrc=imgsrc;
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
		// first step is to shoot them back
		// at a certain range this enemy will stop attacking and go back to where he belonged
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		// locate the main character
		// run in the opposite direection of the main character
		// run out of the map
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
