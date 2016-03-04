package project.battles;

import java.awt.image.BufferedImage;

import project.battles.demo.BattlesScreen;
import project.items.Weapon;
import project.save.ItemState;

public class GEnemy extends EnemyAI{

	private boolean returnToSpawn = false;
	
	/*
	 * Author :Andy Zheng
	 */
	
	public GEnemy(BufferedImage[][] images, int[] stats, int[] vision, Weapon weapon, int type){
		super(images,stats,vision,weapon,type);
		this.weapon = weapon;
		this.enemyClass = BattlesScreen.GENEMY;
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
	
	public void distanceAway(){
		float dist = (float) Math.sqrt(
				Math.pow(x - spawnedX, 2) +
				Math.pow(y - spawnedY, 2) );
		if (dist > 300 && returnToSpawn == false) 
			returnToSpawn = true;
		if(returnToSpawn){
			backToSpawn();
			if(dist < 50){
				returnToSpawn = false;
				targetLock = false;
			}
		}
		else
			goToPlayer();
		//if (dist < 10) targetLock = false;
	}

	public void backToSpawn(){
		int  a = spawnedX - x;
		int b = spawnedY - y;
		if(Math.signum(a)<0){
			moveLeft();
		}
		else
			moveRight();
		if(Math.signum(b)<0)
			moveUp();
		else
			moveDown();
	}

}
