package project.battles.demo;

import java.awt.image.BufferedImage;

import project.controls.OverworldSpriteControl;
import project.items.Weapon;
import project.save.ItemState;

public class SampleGEnemy extends SampleEnemyAI{
	
	public SampleGEnemy(BufferedImage[][] images,int[] stats, SampleWeapon weapon, int positionX, int positionY){
		this.bsprite = images[0];
		this.fsprite = images[1];
		this.lsprite = images[2];
		this.rsprite = images[3];
		this.positionX = positionX;
		this.positionY = positionY;
		maxhp = stats[0];
		visionrangeX = stats[1];
		visionrangeY = stats[2];
		visiondegree = stats[3];
		this.weapon = weapon;
	}

	public SampleGEnemy(BufferedImage[][] images, int[] stats, SampleWeapon weapon, boolean[] conditions){
		this.bsprite = images[0];
		this.fsprite = images[1];
		this.lsprite = images[2];
		this.rsprite = images[3];
		this.positionX = positionX;
		this.positionY = positionY;
		maxhp = stats[0];
		visionrangeX = stats[1];
		visionrangeY = stats[2];
		visiondegree = stats[3];
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
		weapon.fire(true);
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		// locate the main character
		// run in the opposite direection of the main character
		// run out of the map
		int distanceX = positionX - BattlesScreen.char1.getPositionX();
		int distanceY = positionY - BattlesScreen.char1.getPositionY();
		if (distanceX >= 0){
			positionX++;
		}
		else {
			positionX--;
		}
		
		if (distanceY >= 0) {
			positionY++;
		}
		else {
			positionY--;
		}
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
