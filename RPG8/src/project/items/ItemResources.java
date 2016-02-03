package project.items;

public class ItemResources {
	//Medkits
	MedKit smallkit=new MedKit("Small Medkit","It's crap.",50);
	
	//Ammo
	Ammo shotgunAmmo=new Ammo("Shotgun Ammo", "It's shotgun ammo", 1);
	Ammo pistolAmmo=new Ammo("Pistol Ammo", "It's pistol ammo", 1);
	
	//Weapons
	/**
	 * Weapons(name, desc, ammo, damage, ammoClip, ammoCapacity, criticalHit, critHitMul, 
	  		weight, buyable, cost, rof, rofRPS, reloadSpd, armourPiercing, 
	  		secondaryFire, canSilence, gunNum)
	 */
	Weapons pistol3 = new Weapons("CT-Roaring Thunder", "Pistol", pistolAmmo, 62, 20, 140, .20, 2, 
			1, false, 0.0, "Auto", 13, .55, true, true, true, 3);
	Weapons pistol4 = new Weapons("Desert Phoenix", "Pistol", pistolAmmo, 88, 7, 70, .35, 2, 
			1, true, 1850.00, "Semi", 0, 1.2, true, false, false, 4);
	
}
