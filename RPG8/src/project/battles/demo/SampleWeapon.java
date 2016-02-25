package project.battles.demo;

import project.battles.demo.BattlesScreen;

public class SampleWeapon {
	private String wimagesrc;
	private String pimagesrc;
	private int dmg;
	private int velocity;
	private int maxammo;
	private int ammo;
	private int range;
	
	public SampleWeapon(String wimagesrc, String pimagesrc, int[] weaponstats){
		this.wimagesrc = wimagesrc;
		this.pimagesrc = pimagesrc;
		this.dmg = weaponstats[0];
		this.velocity = weaponstats[1];
		this.maxammo = weaponstats[2];
		this.ammo = weaponstats[2];
		this.range = weaponstats[3];
	}
	
	public SampleWeapon() {
		// TODO Auto-generated constructor stub
	}

	public void fire(boolean hostile){
		if(hostile){
			BattlesScreen.player.add(new SampleProjectiles(100,100,100,100,100,100,BattlesScreen.projectiledemo));
		}
		else{
			BattlesScreen.enemy.add(new SampleProjectiles(100,100,100,100,100,100,BattlesScreen.projectiledemo));
		}
	}
	
	public void setAmmo(int ammo) {
		this.ammo = ammo;
	}

	public int getRange() {
		return range;
	}
	public String getWimagesrc() {
		return wimagesrc;
	}
	
	public String getPimagesrc() {
		return pimagesrc;
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
