package project.battles;

import java.awt.image.BufferedImage;

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
		steriods();
		goToPlayer();
	}
	
	@Override
	protected void run() {
		/*
		 * Andy Zheng
		 */
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
	
	public void steriods(){
		/*
		 * Andy Zheng
		 */
		if (strength != BattlesScreen.KE_STRENGTH*2)
		strength+= 1;
	}
	protected void goToPlayer(){
		int pX = BattlesScreen.character.getX();
		int pY = BattlesScreen.character.getY();
		if(Math.abs(pX-x) < 100 && Math.abs(pY-y) < 100){
			backToSpawn();
		}
		else{
			if(pX-x<0)
				x-=speed;
			else
				x+=speed;
			if(pY-y<0)
				y-=speed;
			else
				y+=speed;
		}
	}
	
	public void backToSpawn(){
		int  a = spawnedX - x;
		int b = spawnedY - y;
		if(a<0){
			x+=speed;
		}
		else
			x-=speed;
		if(b<0)
			y+=speed;
		else
			y-=speed;
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
