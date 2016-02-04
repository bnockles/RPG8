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
	  	
	  	How 'gunNum' works
	  	
	  	First Number:
	  	1. Melee 
		2. Pistols
		3. Rifles
		4. Heavy
		5. SMG
		6. Explosives
		7. Plasma
		
		Second Number:
		Which gun in the category. ex pistol3 is 3
		
		So gunNum is 23

	 */
	Weapons pistol3 = new Weapons("CT-Roaring Thunder", "Pistol", pistolAmmo, 62, 20, 140, .20, 2, 
			1, false, 0.0, "Auto", 13, .55, true, true, 23);
	Weapons pistol4 = new Weapons("Desert Phoenix", "Pistol", pistolAmmo, 88, 7, 70, .35, 2,
			1, true, 1850.00, "Semi", 0, 1.2, false, false, 24);
	
}
