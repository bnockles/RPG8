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
	int ammoTotal;

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
		ammoTotal = ammoClip;
	}
	
	public Ammo getAmmo() {
		return ammo;
	}

	public void setAmmo(Ammo ammo) {
		this.ammo = ammo;
	}

	public int getDamage() {
		return damage;
	}

	public int getAmmoClip() {
		return ammoClip;
	}

	public void setAmmoClip(int ammoClip) {
		if(ammoTotal <= ammoClip){
			this.ammoClip = ammoClip;
		}	
	}

	public int getAmmoCapacity() {
		return ammoCapacity;
	}

	public void setAmmoCapacity(int ammoCapacity) {
		this.ammoCapacity = ammoCapacity;
	}

	public double getCriticalHit() {
		return criticalHit;
	}

	public void setCriticalHit(double criticalHit) {
		this.criticalHit = criticalHit;
	}

	public int getCritHitMul() {
		return critHitMul;
	}

	public void setCritHitMul(int critHitMul) {
		this.critHitMul = critHitMul;
	}

	public boolean isBuyable() {
		return buyable;
	}

	public void setBuyable(boolean buyable) {
		this.buyable = buyable;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getReloadSpd() {
		return reloadSpd;
	}

	public boolean isSecondaryFire() {
		return secondaryFire;
	}

	public void setSecondaryFire(boolean secondaryFire) {
		this.secondaryFire = secondaryFire;
	}

	public boolean isCanSilence() {
		return canSilence;
	}

	public void setCanSilence(boolean canSilence) {
		this.canSilence = canSilence;
	}

	public int getGunNum() {
		return gunNum;
	}

	public int getWeight() {
		return weight;
	}

	public String getRof() {
		return rof;
	}

	public int getRofRPS() {
		return rofRPS;
	}

}
