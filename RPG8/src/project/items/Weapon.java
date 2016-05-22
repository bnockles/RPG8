package project.items;

import java.awt.image.BufferedImage;

import project.battles.demo.BattlesScreen;
import project.battles.Projectiles;

public class Weapon {

	private BufferedImage[] weaponimg;
	private BufferedImage projectileimg;
	private int damage;
	private int velocity;//i'm just guessing that velocity will be the multiplier of vx and vy not sure.
	private int maxammo;
	private int ammo;
	private int range;
	
	public Weapon(BufferedImage[] weaponimg, BufferedImage projectileimg, int[] projectilestats){
		this.weaponimg = weaponimg;
		this.projectileimg = projectileimg;
		this.damage = projectilestats[0];
		this.velocity = projectilestats[1];
		this.maxammo = projectilestats[2];
		this.ammo = projectilestats[2];
		this.range = projectilestats[3];
	}
	public void setAmmo(int ammo) {
		this.ammo = ammo;
	}

	public int getRange() {
		return range;
	}
	
	public int getDamage() {
		return damage;
	}

	public int getVelocity() {
		return velocity;
	}

	public int getMaxAmmo() {
		return maxammo;
	}

	public int getAmmo() {
		return ammo;
	}
	public void reduceAmmoByOne(){
		ammo--;
	}
	public BufferedImage getProjectileImg() {
		return projectileimg;
	}

}
