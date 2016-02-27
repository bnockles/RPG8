package project.items;

import java.awt.image.BufferedImage;

import project.battles.demo.BattlesScreen;
import project.battles.demo.SampleProjectiles;

public class Weapon {

	private BufferedImage[] weaponimg;
	private BufferedImage projectileimg;
	private int dmg;
	private int velocity;//i'm just guessing that velocity will be the multiplier of vx and vy not sure.
	private int maxammo;
	private int ammo;
	private int range;
	
	public Weapon(BufferedImage[] weaponimg, BufferedImage projectileimg, int[] projectilestats){
		this.weaponimg = weaponimg;
		this.projectileimg = projectileimg;
		this.dmg = projectilestats[0];
		this.velocity = projectilestats[1];
		this.maxammo = projectilestats[2];
		this.ammo = projectilestats[2];
		this.range = projectilestats[3];
	}

	public void fire(boolean hostile,int x, int y, int vx, int vy){
		if(checkAmmo())
			if(hostile){
				//BattlesScreen.player.add(new SampleProjectiles(100,100,100,100,100,100,BattlesScreen.projectiledemo));
				firePistol(hostile,x,y,vx,vy);
				ammo--;
			}
			else{
				//			SampleProjectiles bullet = new SampleProjectiles(x, y, 0, vx, vy, 400, BattlesScreen.projectiledemo);
				//			BattlesScreen.player.add(bullet);

			}
		else
			return;
	}
	public boolean checkAmmo(){
		if(ammo<=0){
			return false;
		}
		return true;
	}

	public void firePistol(boolean hostile, int x, int y, int vx, int vy){//target location
		/**
		 * Yifan
		 */
		SampleProjectiles bullet = new SampleProjectiles(x, y, 0, vx, vy, 400, projectileimg);
		if(hostile)
			BattlesScreen.enemy.add(bullet);
		else
			BattlesScreen.player.add(bullet);
	}
	public void useMelee(){
		//requires pelham's class
	}
	public void useExplovies(){
		//requires a new class
	}
	public void fireRifle(boolean hostile, int x, int y, int vx, int vy){
		/**
		 * Yifan
		 */
		SampleProjectiles bullet = new SampleProjectiles(x, y, 0, vx, vy, 800, BattlesScreen.projectiledemo);
		BattlesScreen.player.add(bullet);
		reduceAmmoByOne();
	}
	public void fireHeavy(boolean hostile, int x, int y, int vx, int vy){
		/**
		 * Yifan
		 */
		SampleProjectiles bullet = new SampleProjectiles(x, y, 0, vx, vy, 800, BattlesScreen.projectiledemo);
		SampleProjectiles bullet1 = new SampleProjectiles(x, y, 0, vx, vy, 800, BattlesScreen.projectiledemo);
		BattlesScreen.player.add(bullet);
		BattlesScreen.player.add(bullet1);
		reduceAmmoByOne();
	}
	public void fireSMG(boolean hostile, int x, int y, int vx, int vy){
		/**
		 * Yifan
		 */
		SampleProjectiles bullet = new SampleProjectiles(x, y, 0, vx, vy, 800, BattlesScreen.projectiledemo);
		BattlesScreen.player.add(bullet);
		reduceAmmoByOne();
	}
	public void setAmmo(int ammo) {
		this.ammo = ammo;
	}

	public int getRange() {
		return range;
	}
	
	public int getDmg() {
		return dmg;
	}

	public int getVelocity() {
		return velocity;
	}

	public int getMaxammo() {
		return maxammo;
	}

	public int getAmmo() {
		return ammo;
	}
	public void reduceAmmoByOne(){
		ammo--;
	}

}
