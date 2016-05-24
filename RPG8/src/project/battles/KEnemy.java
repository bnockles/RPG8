package project.battles;

import java.awt.Point;
import java.awt.geom.Arc2D;
import project.storyV2.demo.StoryDemo;
import java.awt.image.BufferedImage;
import java.util.Collection;

import project.battles.demo.BattlesScreen;
import project.items.Weapon;
//import project.save.ItemState;
import project.storyV2.demo.StoryDemo;

public class KEnemy extends EnemyAI implements LoggableEnemy{

	/*
	 * Author :Andy Zheng
	 */
	private int[] stats;
	public KEnemy(BufferedImage[][] images, int[] stats, int[] vision, Weapon weapon,int type){
		super(images,stats,vision,weapon,type);
		this.weapon = weapon;
		this.stats = BattlesScreen.enemyK;
		this.enemyClass = BattlesScreen.KENEMY;
		returnToSpawn = false;
		this.enemyRotation = 90;
	}

	public KEnemy(BufferedImage[][] images, int[] stats,int[] vision, Weapon weapon, int type, boolean[] conditions){
		super(images,stats,vision,weapon,type);
		this.stats = BattlesScreen.enemyK;
		this.targetLock = conditions[0];
		this.left = conditions[1];
		this.up = conditions[2];
		this.boss = conditions[3];
		returnToSpawn = false;
		}

	@Override
	protected void reaction() {
		int vx = BattlesScreen.calculateVComponentPlayerToCursor(10, x, y, true);
		int vy = BattlesScreen.calculateVComponentPlayerToCursor(10, x, y, false);
		fire(x,y,-vx,-vy);
		dodge();
		goToPlayer();
	}

	public void scale(){
		for (int i = 2; i < stats.length; i++){
			stats[i] *= StoryDemo.storyScreen.getMissionLevel();
		}
	}

	protected Collision nearestBullet(){
		Collision nearest = null;
		int close = Integer.MAX_VALUE;
		for (Collision a: BattlesScreen.pBullets){
			int distance = (int) distance(a.getX(),a.getY(),x,y);
			if (distance < close){
				close = distance;
				nearest = a;
			}
		}
		return nearest;
	}
	protected void dodge(){
		//Arc2D.Double temp = checkForPlayer(this);
		Collision bulletToDodge = nearestBullet();
		if (bulletToDodge != null && visioncone.intersects(bulletToDodge.getHitBox())){
			int bX = bulletToDodge.getX();
			int bY = bulletToDodge.getY();
			float angle = getAngle(new Point(bX,bY));
			int distance = (int) distance(bX,bY,x,y);
			if(distance < 50){
				if (bX - x >= 0)
					moveLeft();
				else
					moveRight();
				if (bY - y > 0)
					moveDown();
				else
					moveUp();
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
			moveDown();
		}
		else {
			moveUp();
		} 
	}

	protected void goToPlayer(){
		int pX = BattlesScreen.character.getX();
		int pY = BattlesScreen.character.getY();
		if (distance(pX,pY,x,y) < 100){
			if(!visioncone.intersects(BattlesScreen.character.getBounds())){
				setTargetLock(false);
			}
		}
		else{
			goTo(new Point(pX,pY));
		}
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "KEnemy";
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
	public boolean isRegen() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setRegen(boolean regen) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void backToSpawn() {
		// TODO Auto-generated method stub
		
	}


}
