package project.battles.demo;

import java.awt.Graphics2D;
import java.awt.geom.Arc2D;

import project.items.Weapon;
	/**
	 * 
	 * @ Author: Chieh-Huang Chen
	 * 
	 */
public abstract class SampleEnemyAI extends SampleCharacter{
	protected int hp;//static idk
	protected int maxhp;
	protected int visionrangeX;
	protected int visionrangeY;
	protected int visiondegree;
	protected SampleWeapon weapon;
	protected boolean targetlock = false;
	protected boolean left = false;
	protected boolean up = false;
	protected boolean boss = false;
	protected abstract void reaction();
	protected abstract void run();
	public void GeneralEnemyAI(){
		if(checkAlive()){
			//do something
			//System.out.println("hello");
			if(targetlock == false)
				checkForPlayer();
			else
				reaction();
			if(maxhp/10>hp)
				run();
		}
		//animation of death
		//dropItem();
	}
	public boolean checkAlive(){
		if(hp<0)
			return false;
		return true;
	}
	public void checkForPlayer(){
		int playerXposition=0;
		int playerYposition=0;
		//System.out.println("hello");
		Arc2D.Double visionrange = new Arc2D.Double(positionX, positionY, visionrangeX, visionrangeY, visiondegree, visiondegree+90, Arc2D.PIE);
		if(visionrange.contains(playerXposition, playerYposition)){
			targetlock = true;
		}
		else{
			wander();
		}
	}
	public void wander(){
		System.out.println("a"+positionX);
		if(Math.abs(positionX-BattlesScreen.char1.getPositionX()) < 100){
			positionX--;
		}
		else{
			positionX++;
		}
		System.out.println("b"+positionX);
//		if(true){
//			left = !left;
//		}; // check if its gonna crash into a wall or something
//		// need variables for other objects and boundaries
//		if(true){
//			up = !up;
//		}
	}
	public void firePistol(int vx, int vy){//target location
		SampleProjectiles bullet = new SampleProjectiles(0, 0, 0, vx, vy, 0, BattlesScreen.projectiledemo);
		BattlesScreen.enemy.add(bullet);
		equippedWeapon.reduceAmmoByOne();
	}
	
	public void dropItem(){
		if (hp <= 0){
			BattlesScreen.char1.gainExp(10);
		}
	}
}
