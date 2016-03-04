package project.battles;

import java.awt.image.BufferedImage;

import project.battles.demo.BattlesScreen;
import project.items.Weapon;
import project.save.ItemState;

public class GEnemy extends EnemyAI{

	public GEnemy(BufferedImage[][] images, int[] stats, int[] vision, Weapon weapon, int type){
		super(images,stats,vision,weapon,type);
		this.weapon = weapon;
	}

	public GEnemy(BufferedImage[][] images, int[] stats,int[] vision, Weapon weapon, int type, boolean[] conditions){
		super(images,stats,vision,weapon,type);
		this.targetLock = conditions[0];
		this.left = conditions[1];
		this.up = conditions[2];
		this.boss = conditions[3];
	}

	public void distanceAway(){
		float dist = (float) Math.sqrt(
				Math.pow(spawnedX - spawnedY, 2) +
				Math.pow(x - y, 2) );
		if (dist > 100) backToSpawn();
	}

	public void backToSpawn(){
		int  a = spawnedX - x;
		int b = spawnedY - y;
		x+= BattlesScreen.GE_SPEED * (Math.signum(a));
		y+= BattlesScreen.GE_SPEED * (Math.signum(b));

	}
	@Override
	protected void reaction() {
		// TODO Auto-generated method stub
		int vx = BattlesScreen.calculateVComponentPlayerToCursor(10, x, y, true);
		int vy = BattlesScreen.calculateVComponentPlayerToCursor(10, x, y, false);
		fire(x,y,-vx,-vy);
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


}
