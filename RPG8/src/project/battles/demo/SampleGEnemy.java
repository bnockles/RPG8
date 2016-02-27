package project.battles.demo;

import java.awt.image.BufferedImage;

import project.controls.OverworldSpriteControl;
import project.items.Weapon;
import project.save.ItemState;

public class SampleGEnemy extends SampleEnemyAI{
	
	public SampleGEnemy(BufferedImage[][] images,int[] stats, SampleWeapon weapon, int x, int y){
		super(images,stats,x,y);
		this.weapon = weapon;
	}

	public SampleGEnemy(BufferedImage[][] images, int[] stats, SampleWeapon weapon, int x, int y,boolean[] conditions){
		super(images,stats,x,y);
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
		// first step is to shoot them back
		// at a certain range this enemy will stop attacking and go back to where he belonged
		weapon.fire(true,x,y,10,10);
	}

	//Andy Zheng
	@Override
	public void run() {
		// TODO Auto-generated method stub
		// locate the main character
		// run in the opposite direection of the main character
		// run out of the map
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
