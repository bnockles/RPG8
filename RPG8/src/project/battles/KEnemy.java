package project.battles;

import java.awt.geom.Arc2D;
import java.awt.image.BufferedImage;
import java.util.Collection;

import project.battles.demo.BattlesScreen;
import project.items.Weapon;
import project.save.ItemState;

public class KEnemy extends EnemyAI implements LoggableEnemy{

	/*
	 * Author :Andy Zheng
	 */
	private int[] stats;
	public KEnemy(BufferedImage[][] images, int[] stats, int[] vision, Weapon weapon,int type){
		super(images,stats,vision,weapon,type);
		this.weapon = weapon;
		this.stats = stats;
		this.enemyClass = BattlesScreen.KENEMY;
	}

	public KEnemy(BufferedImage[][] images, int[] stats,int[] vision, Weapon weapon, int type, boolean[] conditions){
		super(images,stats,vision,weapon,type);
		this.targetLock = conditions[0];
		this.left = conditions[1];
		this.up = conditions[2];
		this.boss = conditions[3];
	}

	public ItemState getItems() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	protected void reaction() {
		/*
		 * Andy Zheng
		 */
		// TODO Auto-generated method stub
		int vx = BattlesScreen.calculateVComponentPlayerToCursor(10, x, y, true);
		int vy = BattlesScreen.calculateVComponentPlayerToCursor(10, x, y, false);
		fire(x,y,-vx,-vy);
		goToPlayer();
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
		Collision bulletToDodge = nearestBullet();
		if (bulletToDodge != null){
			int bX = bulletToDodge.getX();
			int bY = bulletToDodge.getY();
			if(distance(bX,bY,x,y) <= 50){
				if (bX - x > 0) moveLeft();
				else
					moveRight();
//				if (bY - y > 0) moveDown();
//				else
//					moveUp();
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
		if(Math.abs(pX-x) <= 200 && Math.abs(pY-y) <= 200){
			Arc2D.Double temp = checkForPlayer(this);
			if(temp.intersects(BattlesScreen.character.getBounds())){
				setTargetLock(true);
			}
			else{
				setTargetLock(false);
			}
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


}
