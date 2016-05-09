package project.items;

public interface ItemResources {
	static final int NO_EFFECT = 0;
	static final int FIRE = 1;
	static final int CORROSIVE = 2;
	static final int STUN = 3;
	static final int REGEN = 4;
	
	public int buy(Misc gold);
	public int sell(Misc gold);
	
	//Armor
	final Armor yourarmor = new Armor("Armor", "It's Armor", 0, 0, 100,"");
	final Armor enemyarmor = new Armor("Armor", "It's Armor", 0, 0, 100,"");
	
	//Medkits
	final MedKit smallkit=new MedKit("Small Medkit","It's crap.",0, 5, REGEN,"");
	final MedKit medkit=new MedKit("Medium Medkit","It's better.",0, 20, NO_EFFECT,"");
	final MedKit bigkit=new MedKit("Big Medkit","It's the best.",0, 30, NO_EFFECT,"");
	
	//Ammo
	final Ammo pistolAmmo=new Ammo("Pistol Ammo", "It's pistol ammo", 0, 1, NO_EFFECT,"");
	final Ammo rifleAmmo=new Ammo("Rifle Ammo", "It's rifle ammo", 0, 1, NO_EFFECT,"");
	final Ammo heavyAmmo = new Ammo("Heavy Ammo", "It's heavy ammo", 0, 1, NO_EFFECT,"");
	final Ammo SMGAmmo=new Ammo("SMG Ammo", "It's SMG ammo", 0, 1, NO_EFFECT,"");
	final Ammo explosiveAmmo = new Ammo("Explosive Ammo", "It's explosive ammo", 0, 1, NO_EFFECT,"");
	
	final Ammo firePistolAmmo=new Ammo("Burning Pistol Ammo", "It's burning pistol ammo", 0, 1, FIRE,"");
	final Ammo fireRifleAmmo=new Ammo("Burning Rifle Ammo", "It's burning rifle ammo", 0, 1, FIRE,"");
	final Ammo fireHeavyAmmo = new Ammo("Burning Heavy Ammo", "It's burning heavy ammo", 0, 1, FIRE,"");
	final Ammo fireSMGAmmo=new Ammo("Burning SMG Ammo", "It's burning SMG ammo", 0, 1, FIRE,"");
	final Ammo fireExplosiveAmmo = new Ammo("Burning Explosive Ammo", "It's burning explosive ammo", 0, 1, FIRE,"");
	
	final Ammo stunPistolAmmo=new Ammo("Stunning Pistol Ammo", "It's stunning pistol ammo", 0, 1, STUN,"");
	final Ammo stunRifleAmmo=new Ammo("Stunning Rifle Ammo", "It's stunning rifle ammo", 0, 1, STUN,"");
	final Ammo stunHeavyAmmo = new Ammo("Stunning Heavy Ammo", "It's stunning heavy ammo", 0, 1, STUN,"");
	final Ammo stunSMGAmmo=new Ammo("Stunning SMG Ammo", "It's stunning SMG ammo", 0, 1, STUN,"");
	final Ammo stunExplosiveAmmo = new Ammo("Stunning Explosive Ammo", "It's stunning explosive ammo", 0, 1, STUN,"");
	
	//final Ammo shotgunAmmo=new Ammo("Shotgun Ammo", "It's shotgun ammo", 0, 1, NO_EFFECT,"");
	final Ammo grenadeAmmo = new Ammo("Grenade Ammo", "It's grenade ammo", 0, 1, NO_EFFECT,"");
	final Ammo incendiaryGrenadeAmmo = new Ammo("Incendiary Grenade Ammo", "It's incendiary grenade ammo", 0, 1, FIRE,"");
	final Ammo energyAmmo=new Ammo("Energy Ammo", "It's energy ammo", 0, 2, NO_EFFECT,"");
	
	//Weapons
	/**
	 * 
	  	How 'gunNum' works
	  	
	  	First Number:
	  	1. Melee 
		2. Pistols
		3. Rifles
		4. Heavy
		5. SMG
		6. Explosives
		-----------------
		7. Plasma
		
		Second Number:
		Which gun in the category. ex pistol3GradeS1 is a pistol which is 2 and number of the pistol is 3
		
		So gunNum is 23
		
		Weapons(name, desc, ammo, damage, ammoClip, ammoCapacity, criticalHit, critHitMul,
	  		weight, buyable, cost, rof, rofRPS, reloadSpd, 
	  		secondaryFire, canSilence, effect, pellets, splash, gunImage, gunNum)
	 */
	//Melee
	final Weapons melee1GradeC1 = new Weapons("Stun-Baton", "Melee Weapon", 
			energyAmmo, 60, 0, 0, .10, 2, 0, true, 130, "Single", 1, 0, false, false, NO_EFFECT, 0, 0, "/images/items/Stun-Baton.png", 11);
	
	//Pistols
	final Weapons pistol2GradeB1 = new Weapons("RIA-45S", "The Rancor Intelligence Arms pistol is a lightweight weapon that deals medium damage and also can be augmented with a secondary fire.", 
			pistolAmmo, 33, 18, 7, .00, 2, 0, true, 150, "Semi", 0, .45, true, true, NO_EFFECT, 0, 0,"/images/items/RIA-45S.png", 22);
	final Weapons pistol3GradeS1 = new Weapons("CT-Roaring Thunder", "Pistol", pistolAmmo, 62, 20, 7, .20, 2, 
			1, false, 0, "Auto", 13, .55, true, true, NO_EFFECT, 0, 0,"/images/items/CT-Roaring Thunder.png", 23);
	final Weapons pistol4GradeA1 = new Weapons("Desert Phoenix", "Pistol", pistolAmmo, 88, 7, 7, .35, 2,
			1, true, 1850, "Semi", 0, 1.2, false, false, NO_EFFECT, 0, 0,"/images/items/Desert Phoenix.png", 24);
	
	//Rifles
		//Assault Rifle
	final Weapons rifles1GradeC1 = new Weapons("RIA-10S", "Rifles", rifleAmmo, 36, 40, 7, .10, 2,
			3, true, 550, "Auto", 12, 2.4, false, true, NO_EFFECT, 0, 0,"/images/items/RIA-10S.png", 31);
	final Weapons rifles3GradeA2 = new Weapons("NGM4", "Rifles", energyAmmo, 25, 40, 7, .10, 2,
			2, true, 9850, "Auto", 12, 1.3, false, false, NO_EFFECT, 0, 0,"/images/items/NGM4.png", 33);
		//Sniper Rifles
	final Weapons rifles4GradeA3 = new Weapons("RIA-97A6", "Sniper Rifle", rifleAmmo, 120, 7, 7, .50, 2,
			6, true, 1000, "Bolt", .7, 3.5, false, true, NO_EFFECT, 0, 0,"/images/items/RIA-97A6.png", 34);
	
	//Heavy
		//Shotguns
	final Weapons heavy1GradeB1 = new Weapons("Heavy Mustang", "Shotgun", heavyAmmo, 75, 8, 7, .10, 2,
			2, true, 380, "Auto", 1, .50, false, false, NO_EFFECT, 6, 0,"/images/items/Heavy Mustang Drum.png", 41);
		//Machine Guns
	final Weapons heavy4GradeB2 = new Weapons("NG-60", "Machine Gun", heavyAmmo, 49, 60, 7, .10, 2,
			4, true, 900, "Auto", 14, 4.3, true, false, NO_EFFECT, 0, 0,"/images/items/NG-60.png", 44);
	
	//SMGS
	final Weapons smg1GradeC1 = new Weapons("MP-600", "SMG", SMGAmmo, 25, 35, 7, .10, 2,
			0, true, 430, "Auto", 16, 2.10, true, true, NO_EFFECT, 0, 0,"/images/items/MP-600.png", 51);
	final Weapons smg2GradeB1 = new Weapons("RIA-30", "SMG", SMGAmmo, 38, 40, 7, .10, 2,
			1, true, 800, "Auto", 15, 2.20, false, true, NO_EFFECT, 0, 0,"/images/items/RIA-30.png", 52);
	
	//Explosives
	final Weapons explosives1GradeC1 = new Weapons("RIA-EPS15", "Explosives", explosiveAmmo, 96, 1, 39, .10, 2,
			3, true, 830, "Single", 0, 1.30, false, false, NO_EFFECT, 0, 140,"/images/items/RIA-EPS15.png", 61);
	final Weapons explosives6GradeB1 = new Weapons("M10-SuperFrag", "Explosives", grenadeAmmo, 200, 1, 9, .10, 2,
			1, true, 400, "Single", 2, .20, false, false, NO_EFFECT, 0, 180,"/images/items/M10-SuperFrag.png", 66);
	
	//Test Guns
//	Weapons rifles2GradeA1 = new Weapons("M4A1", "Rifles", rifleAmmo, 36, 30, 210, .10, 2,
//			3, true, 1850, "Auto", 13, 1.3, false, true, 0, 32);
	
	final Weapons[] Melee = { melee1GradeC1 };
	final Weapons[] Pistol = { pistol2GradeB1, pistol3GradeS1, pistol4GradeA1};
	final Weapons[] Rifles = { rifles1GradeC1, rifles3GradeA2, rifles4GradeA3 };
	final Weapons[] Heavy = { heavy1GradeB1, heavy4GradeB2};
	final Weapons[] SMG = { smg1GradeC1, smg2GradeB1};
	final Weapons[] Explosives = { explosives1GradeC1, explosives6GradeB1};
	
	// Misc
	final Misc gold = new Misc("Gold", "Get more of this and you're rich!", true , 0, NO_EFFECT,"");
	final Misc scrap = new Misc("Scrap Metal", "Useless trash.",false , 1, NO_EFFECT,"");
	
	public Item[] getItem();
}
