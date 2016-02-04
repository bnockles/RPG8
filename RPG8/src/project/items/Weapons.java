package project.items;

public class Weapons extends Item{
	Ammo ammo;
	int damage;
	int ammoClip;
	int ammoCapacity;
	double criticalHit;
	int critHitMul;
	int weight;
	boolean buyable;
	double cost;
	String rof;
	int rofRPS;
	double reloadSpd;
	boolean secondaryFire;
	boolean canSilence;
	int gunNum;
	
	public Weapons(String name, String desc, Ammo ammo, int damage, int ammoClip, int ammoCapacity,
			double criticalHit, int critHitMul, int weight, boolean buyable, double cost, String rof, int rofRPS, 
			double reloadSpd, boolean secondaryFire, boolean canSilence, int gunNum) {
		super(name, desc);
		
		this.ammo = ammo;
		this.damage = damage;
		this.ammoClip = ammoClip;
		this.ammoCapacity = ammoCapacity;
		this.criticalHit = criticalHit;
		this.critHitMul = critHitMul;
		this.weight = weight;
		buyable = true;
		this.cost = cost;
		this.rof = rof;
		this.rofRPS = rofRPS;
		this.reloadSpd = reloadSpd;
		secondaryFire = false;
		canSilence = true;
		this.gunNum = gunNum;
	}
	
}
