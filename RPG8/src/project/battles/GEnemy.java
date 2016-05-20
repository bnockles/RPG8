package project.battles;

import java.awt.image.BufferedImage;

import project.battles.demo.BattlesScreen;
import project.items.Weapon;
import project.save.ItemState;

public class GEnemy extends EnemyAI implements LoggableEnemy{

	private boolean returnToSpawn = false;
	
	/*
	 * Author :Andy Zheng
	 */
	private int[] stats;
	//stats = { 0 X, 1 Y, 2 hp, 3 armor, 4 sneak, 5 speed,6 recovery, 7 exp, 8 strength,9 level}
	public GEnemy(BufferedImage[][] images, int[] stats, int[] vision, Weapon weapon, int type){
		super(images,stats,vision,weapon,type);
		this.weapon = weapon;
		this.stats = stats;
		this.enemyClass = BattlesScreen.GENEMY;
	}
	
	public void scaleG(){
		for (int i = 2; i < stats.length; i++){
			stats[i] *= 1;
		}
	}
	public GEnemy(BufferedImage[][] images, int[] stats,int[] vision, Weapon weapon, int type, boolean[] conditions){
		super(images,stats,vision,weapon,type);
		this.targetLock = conditions[0];
		this.left = conditions[1];
		this.up = conditions[2];
		this.boss = conditions[3];
	}

	@Override
	protected void reaction() {
		// TODO Auto-generated method stub
		int vx = BattlesScreen.calculateVComponentPlayerToCursor(10, x, y, true);
		int vy = BattlesScreen.calculateVComponentPlayerToCursor(10, x, y, false);
		fire(x,y,-vx,-vy);
		distanceAway();
	}

	@Override
	protected void run() {
		// TODO Auto-generated method stub
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
		if(Math.abs(pX-x) < 10 && Math.abs(pY-y) < 10){
			returnToSpawn = true;
			targetLock = false;
		}
		else{
			if(pX-x<0)
				moveLeft();
			else
				moveRight();
			if(pY-y<0)
				moveUp();
			else
				moveDown();
		}
	}
	
	public void backToSpawn(){
		int  a = spawnedX - x;
		int b = spawnedY - y;
		if(a<0){
			moveLeft();
		}
		else
			moveRight();
		if(b<0)
			moveUp();
		else
			moveDown();
	}
	
	public void distanceAway(){
		float dist = (float) Math.sqrt(
				Math.pow(x - spawnedX, 2) +
				Math.pow(y - spawnedY, 2) );
		System.out.println(dist);
		if (dist > 300 && returnToSpawn == false) returnToSpawn = true;
		if(returnToSpawn){
			backToSpawn();
			if(dist < 50){
				returnToSpawn = false;
				targetLock = false;
			}
		}
		else
			goToPlayer();
	}
	


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

}
