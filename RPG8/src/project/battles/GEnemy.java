package project.battles;
import project.storyV2.demo.*;

import java.awt.Point;
import java.awt.image.BufferedImage;

import project.battles.demo.BattlesScreen;
import project.items.Weapon;
//import project.save.ItemState;

public class GEnemy extends EnemyAI implements LoggableEnemy{

	/*
	 * Author :Andy Zheng
	 */
	private int[] stats;
	//stats = { 0 X, 1 Y, 2 hp, 3 armor, 4 sneak, 5 speed,6 recovery, 7 exp, 8 strength,9 level}
	public GEnemy(BufferedImage[][] images, int[] stats, int[] vision, Weapon weapon, int type){
		super(images,stats,vision,weapon,type);
		this.weapon = weapon;
		this.stats = BattlesScreen.enemyG;
		this.enemyClass = BattlesScreen.GENEMY;
		returnToSpawn = false;
	}

	public void scale(){
		try{
			for (int i = 2; i < stats.length; i++){
				stats[i] *= StoryDemo.storyScreen.getMissionLevel();
			}
		}catch(NullPointerException e){

		}	
	}
	public GEnemy(BufferedImage[][] images, int[] stats,int[] vision, Weapon weapon, int type, boolean[] conditions){
		super(images,stats,vision,weapon,type);
		this.targetLock = conditions[0];
		this.left = conditions[1];
		this.up = conditions[2];
		this.boss = conditions[3];
		this.stats = BattlesScreen.enemyG;
		returnToSpawn = false;
	}

	float distance;
	float awayFromSpawn;
	@Override
	protected void reaction() {
		distance = distance(x,y,BattlesScreen.character.getX(),BattlesScreen.character.getY());
		awayFromSpawn = distance(x,y,spawnedX,spawnedY);
		int vx = BattlesScreen.calculateVComponentPlayerToCursor(10, x, y, true);
		int vy = BattlesScreen.calculateVComponentPlayerToCursor(10, x, y, false);
		fire(x,y,-vx,-vy);
		if (awayFromSpawn > 600){
			returnToSpawn = true;
			backToSpawn();
		}
		else{
			returnToSpawn = false;
			if (distance > 100){
				goToPlayer();
				dodge();
			}
		}
	}

	@Override
	protected void run() {
		int distanceX = x - BattlesScreen.character.getX();
		int distanceY = y - BattlesScreen.character.getY();
		if (distanceX >= 0){
			moveRight();
		}
		else {
			moveLeft();
		}

		if (distanceY >= 0) {
			moveUp();
		}
		else {
			moveDown();
		} 
	}

	protected void goToPlayer(){
		int pX = BattlesScreen.character.getX();
		int pY = BattlesScreen.character.getY();
		goTo(new Point(pX,pY));
//		if(pX-x<0)
//			moveLeft();
//		else
//			moveRight();
//		if(pY-y<0)
//			moveUp();
//		else
//			moveDown();
	}

	public void backToSpawn(){
		targetLock = false;
//		int  a = spawnedX - x;
//		int b = spawnedY - y;
//		if(a<0){
//			moveLeft();
//		}
//		else
//			moveRight();
//		if(b<0)
//			moveUp();
//		else
//			moveDown();
		goTo(new Point(spawnedX,spawnedY));
		if (distance(x,y,spawnedX,spawnedY) < 10) returnToSpawn = false;
	}

	//	public void distanceAway(){
	//		float dist = distance(spawnedX,spawnedY,x,y);
	//		if (dist > 700 && returnToSpawn == false) returnToSpawn = true;
	//		if(returnToSpawn){
	//			backToSpawn();
	//			if(dist < 50){
	//				returnToSpawn = false;
	//				targetLock = false;
	//			}
	//		}
	//		else
	//			goToPlayer();
	//	}



	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "GEnemy";
	}

	@Override
	public int getLevel() {
		// TODO Auto-generated method stub
		return stats[9];
	}

	@Override
	public int getDeaths() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getKills() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected void dodge() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isRegen() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setRegen(boolean regen) {
		// TODO Auto-generated method stub

	}

}
