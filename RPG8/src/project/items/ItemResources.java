package project.items;

public interface ItemResources {
	//Medkits
	MedKit smallkit=new MedKit("Small Medkit","It's crap.",0, 50);
	
	//Ammo
	Ammo shotgunAmmo=new Ammo("Shotgun Ammo", "It's shotgun ammo", 0, 1);
	Ammo pistolAmmo=new Ammo("Pistol Ammo", "It's pistol ammo", 0,1);
	
	//Weapons
	/**
	 * Weapons(name, desc, ammo, damage, ammoClip, ammoCapacity, criticalHit, critHitMul,
	  		weight, buyable, cost, rof, rofRPS, reloadSpd, 
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
		Which gun in the category. ex pistol3GradeS1 is a pistol which is 2 and number of the pistol is 3
		
		So gunNum is 23

	 */
	Weapons pistol2GradeB1 = new Weapons("RIA-45S", "The Rancor Intelligence Arms pistol is a lightweight weapon that deals medium damage and also can be augmented with a secondary fire.", 
			pistolAmmo, 33, 18, 126, .00, 2, 0, true, 150, "Semi", 0, .45, true, true, 22);
	Weapons pistol3GradeS1 = new Weapons("CT-Roaring Thunder", "Pistol", pistolAmmo, 62, 20, 140, .20, 2, 
			1, false, 0, "Auto", 13, .55, true, true, 23);
	Weapons pistol4GradeA1 = new Weapons("Desert Phoenix", "Pistol", pistolAmmo, 88, 7, 70, .35, 2,
			1, true, 1850, "Semi", 0, 1.2, false, false, 24);
	
	Weapons[] Melee = { };
	Weapons[] Pistol = { pistol2GradeB1, pistol3GradeS1, pistol4GradeA1};
	Weapons[] Rifles = { };
	Weapons[] Heavy = { };
	Weapons[] SMG = { };
	Weapons[] Explosives = { };

	
}
