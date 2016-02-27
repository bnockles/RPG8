package project.battles.demo;

import java.awt.image.BufferedImage;

import project.controls.OverworldSpriteControl;
import project.items.Weapon;
import project.save.ItemState;

public class SampleKEnemy extends SampleEnemyAI{
	public SampleKEnemy(BufferedImage[][] images, int[] stats, SampleWeapon weapon, int x, int y){
		this.bsprite = images[0];
		this.fsprite = images[1];
		this.lsprite = images[2];
		this.rsprite = images[3];
		this.x = x;
		this.y = y;
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
		this.x = positionX;
		this.y = positionY;
		visionrangeX = stats[1];
		visionrangeY = stats[2];
		visiondegree = stats[3];
		this.weapon = weapon;
		this.targetlock = conditions[0];
		this.left = conditions[1];
		this.up = conditions[2];
		this.boss = conditions[3];
	}
	//Andy Zheng
	@Override
	public void reaction() {
		// TODO Auto-generated method stub
		weapon.fire(true);
		
	}
	//Andy Zheng
	@Override
	public void run() {
		System.out.println("hello");
		int distanceX = x - BattlesScreen.character.getX();
		int distanceY = y - BattlesScreen.character.getY();
		if (distanceX >= 0){
			x++;
		}
		else {
			x--;
		}
		
		if (distanceY >= 0) {
			y++;
		}
		else {
			y--;
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
