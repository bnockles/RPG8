package project.battles.demo;

import java.awt.image.BufferedImage;

import project.controls.OverworldSpriteControl;
import project.items.Weapon;
import project.save.ItemState;

public class SampleKEnemy extends SampleEnemyAI{
	public SampleKEnemy(BufferedImage[][] images, int[] stats, SampleWeapon weapon, int positionX, int positionY){
		this.bsprite = images[0];
		this.fsprite = images[1];
		this.lsprite = images[2];
		this.rsprite = images[3];
		this.positionX = positionX;
		this.positionY = positionY;
		maxhp = stats[0];
		hp = stats[0];
		//hp = 0;
		visionrangeX = stats[1];
		visionrangeY = stats[2];
		visiondegree = stats[3];
		this.weapon = weapon;
	}
 
	public SampleKEnemy(BufferedImage[][] images, int[] stats, SampleWeapon weapon, boolean[] conditions, int positionX, int positionY){
		this.bsprite = images[0];
		this.fsprite = images[1];
		this.lsprite = images[2];
		this.rsprite = images[3];
		maxhp = stats[0];
		hp = stats[0];
		this.positionX = positionX;
		this.positionY = positionY;
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
		weapon.fire(true);
		
	}

	@Override
	public void run() {
		System.out.println("hello");
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
