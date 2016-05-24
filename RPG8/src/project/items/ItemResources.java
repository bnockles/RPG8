package project.items;


public interface ItemResources {
	static final int NO_EFFECT = 0;
	static final int FIRE = 1;
	static final int CORROSIVE = 2;
	static final int STUN = 3;
	static final int REGEN = 4;
	
	//For Shops
	public int buy(Misc gold);
	public int sell(Misc gold, Misc scrap);
	public String printStats(double[] stats);
	
	//Armor
<<<<<<< HEAD
	final Armor yourarmor = new Armor("Armor", "It's Armor", 300, 0, 100,"/images/items/Armor.png",true);
=======
	final Armor yourarmor = new Armor("Armor", "It's Armor", 300, 0, 100,"",true);
>>>>>>> refs/heads/develop
	final Armor enemyarmor = new Armor("Armor", "It's Armor", 0, 0, 100,"",false);
	
	//Medkits
<<<<<<< HEAD
	final MedKit smallkit=new MedKit("Small Medkit","It's crap.",100, 5, REGEN,"/images/items/Small Medkit.png",true,100,100);
	final MedKit medkit=new MedKit("Medium Medkit","It's better.",500, 20, NO_EFFECT,"/images/items/Medium Medkit.png",true,300,300);
	final MedKit bigkit=new MedKit("Big Medkit","It's the best.",1000, 30, NO_EFFECT,"/images/items/Large Medkit.png",true,500,500);
=======
	final MedKit smallkit=new MedKit("Small Medkit","It's crap.",100, 5, REGEN,"/images/items/Small Medkit.png",true);
	final MedKit medkit=new MedKit("Medium Medkit","It's better.",500, 20, NO_EFFECT,"/images/items/Medium Medkit.png",true);
	final MedKit bigkit=new MedKit("Big Medkit","It's the best.",1000, 30, NO_EFFECT,"/images/items/Large Medkit.png",true);
>>>>>>> refs/heads/develop
	
	//Ammo
	final Ammo pistolAmmo=new Ammo("Pistol Ammo", "It's pistol ammo", 50, 1, NO_EFFECT,"/images/items/regular.png",true);
	final Ammo rifleAmmo=new Ammo("Rifle Ammo", "It's rifle ammo", 50, 1, NO_EFFECT,"/images/items/regular.png",true);
	final Ammo heavyAmmo = new Ammo("Heavy Ammo", "It's heavy ammo", 50, 1, NO_EFFECT,"/images/items/regular.png",true);
	final Ammo SMGAmmo=new Ammo("SMG Ammo", "It's SMG ammo", 50, 1, NO_EFFECT,"/images/items/regular.png",true);
	final Ammo explosiveAmmo = new Ammo("Explosive Ammo", "It's explosive ammo", 50, 1, NO_EFFECT,"/images/items/regular.png",true);
	
	final Ammo firePistolAmmo=new Ammo("Burning Pistol Ammo", "It's burning pistol ammo", 150, 1, FIRE,"/images/items/burn.png",true);
	final Ammo fireRifleAmmo=new Ammo("Burning Rifle Ammo", "It's burning rifle ammo", 150, 1, FIRE,"/images/items/burn.png",true);
	final Ammo fireHeavyAmmo = new Ammo("Burning Heavy Ammo", "It's burning heavy ammo", 150, 1, FIRE,"/images/items/burn.png",true);
	final Ammo fireSMGAmmo=new Ammo("Burning SMG Ammo", "It's burning SMG ammo", 150, 1, FIRE,"/images/items/burn.png",true);
	final Ammo fireExplosiveAmmo = new Ammo("Burning Explosive Ammo", "It's burning explosive ammo", 150, 1, FIRE,"/images/items/burn.png",true);
	
	final Ammo stunPistolAmmo=new Ammo("Stunning Pistol Ammo", "It's stunning pistol ammo", 100, 1, STUN,"/images/items/stun.png",true);
	final Ammo stunRifleAmmo=new Ammo("Stunning Rifle Ammo", "It's stunning rifle ammo", 100, 1, STUN,"/images/items/stun.png",true);
	final Ammo stunHeavyAmmo = new Ammo("Stunning Heavy Ammo", "It's stunning heavy ammo", 100, 1, STUN,"/images/items/stun.png",true);
	final Ammo stunSMGAmmo=new Ammo("Stunning SMG Ammo", "It's stunning SMG ammo", 100, 1, STUN,"/images/items/stun.png",true);
	final Ammo stunExplosiveAmmo = new Ammo("Stunning Explosive Ammo", "It's stunning explosive ammo", 100, 1, STUN,"/images/items/stun.png",true);
<<<<<<< HEAD
	
	final Ammo corrosivePistolAmmo=new Ammo("Corrosive Pistol Ammo", "It's corrosive pistol ammo", 100, 1, CORROSIVE,"/images/items/corrosive.png",true);
	final Ammo corrosiveRifleAmmo=new Ammo("Corrosive Rifle Ammo", "It's corrosive rifle ammo", 100, 1, CORROSIVE,"/images/items/corrosive.png",true);
	final Ammo corrosiveHeavyAmmo = new Ammo("Corrosive Heavy Ammo", "It's corrosive heavy ammo", 100, 1, CORROSIVE,"/images/items/corrosive.png",true);
	final Ammo corrosiveSMGAmmo=new Ammo("Corrosive SMG Ammo", "It's corrosive SMG ammo", 100, 1, CORROSIVE,"/images/items/corrosive.png",true);
	final Ammo corrosiveExplosiveAmmo = new Ammo("Corrosive Explosive Ammo", "It's corrosive explosive ammo", 100, 1, CORROSIVE,"/images/items/corrosive.png",true);
=======
>>>>>>> refs/heads/develop
	
	//final Ammo shotgunAmmo=new Ammo("Shotgun Ammo", "It's shotgun ammo", 0, 1, NO_EFFECT,"");
	final Ammo grenadeAmmo = new Ammo("Grenade Ammo", "It's grenade ammo", 0, 1, NO_EFFECT,"/images/items/M10-SuperFrag.png",true);
	final Ammo incendiaryGrenadeAmmo = new Ammo("Incendiary Grenade Ammo", "It's incendiary grenade ammo", 0, 1, FIRE,"",true);
	final Ammo energyAmmo=new Ammo("Energy Ammo", "It's energy ammo", 0, 2, NO_EFFECT,"",true);
	
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
	final Weapons pistol2GradeB1 = new Weapons("RIA-45S", 
			"The Rancor Intelligence Arms pistol is a lightweight weapon that deals medium damage and also can be augmented with a secondary fire.", 
			pistolAmmo, 33, 18, 7, .00, 2, 0, true, 150, "Semi", 0, .45, true, true, NO_EFFECT, 0, 0,"/images/items/RIA-45S.png", 22);
	final Weapons pistol3GradeS1 = new Weapons("CT-Roaring Thunder", "Pistol", pistolAmmo, 62, 20, 7, .20, 2, 
			1, false, 0, "Auto", 13, .55, true, true, NO_EFFECT, 0, 0,"/images/items/CT-Roaring Thunder.png", 23);
	final Weapons pistol4GradeA1 = new Weapons("Desert Phoenix", "Magnum Pistol", pistolAmmo, 77, 7, 7, .35, 2,
			1, true, 1850, "Semi", 0, 1.2, false, false, NO_EFFECT, 0, 0,"/images/items/Desert Phoenix.png", 24);
	final Weapons pistol5GradeA2 = new Weapons("NG-45", "Revolver Pistol", pistolAmmo, 85, 6, 60, .25, 2,
			1, true, 2350, "Semi", 0, 1.5, false, false, NO_EFFECT, 0, 0,"/images/items/NG-45.png", 25);
	final Weapons pistol6GradeA3 = new Weapons("Desert Eagle", "Magnum Pistol", pistolAmmo, 70, 7, 7, .35, 2,
			1, true, 1850, "Semi", 0, 1.2, false, false, NO_EFFECT, 0, 0,"/images/items/Desert Phoenix Steel Edition.png", 26);
	
	
	//Rifles
		//Assault Rifle
	final Weapons rifles1GradeC1 = new Weapons("RIA-10S", "Rifles", rifleAmmo, 36, 40, 7, .10, 2,
			3, true, 550, "Auto", 12, 2.4, false, true, NO_EFFECT, 0, 0,"/images/items/RIA-10S.png", 31);
	final Weapons rifles2GradeB1 = new Weapons("NG-BR40", "Rifles", rifleAmmo, 28, 35, 7, .10, 2,
			2, true, 1250, "Auto", 14, 1.2, false, false, NO_EFFECT, 0, 0,"/images/items/NG-BR40.png", 32);
	final Weapons rifles3GradeS1 = new Weapons("CT-Decimator", "Rifles", rifleAmmo, 57, 50, 7, .30, 2,
			2, true, 7850, "Auto", 12, 2.3, false, false, NO_EFFECT, 0, 0,"/images/items/CT-Decimator.png", 33);
		//Sniper Rifles
	final Weapons rifles4GradeA3 = new Weapons("RIA-97A6", "Sniper Rifle", rifleAmmo, 120, 7, 7, .50, 2,
			6, true, 1000, "Bolt", .7, 3.5, false, true, NO_EFFECT, 0, 0,"/images/items/RIA-97A6S.png", 34);
	
	//Heavy
		//Shotguns
	final Weapons heavy1GradeB1 = new Weapons("Heavy Mustang", "Shotgun", heavyAmmo, 75, 8, 7, .10, 2,
			2, true, 380, "Auto", 1, .50, false, false, NO_EFFECT, 6, 0,"/images/items/Heavy Mustang Drum.png", 41);
		//Machine Guns
	final Weapons heavy4GradeB2 = new Weapons("NG-60", "Machine Gun", heavyAmmo, 49, 60, 7, .10, 2,
			6, true, 900, "Auto", 14, 4.3, true, false, NO_EFFECT, 0, 0,"/images/items/NG-60.png", 44);
	final Weapons heavy5GradeA3 = new Weapons("RIA-125S", "Machine Gun", heavyAmmo, 68, 125, 7, .10, 2,
			5, true, 1900, "Auto", 17, 4.1, true, false, NO_EFFECT, 0, 0,"/images/items/RIA-125S.png", 45);
	final Weapons heavy7GradeS4 = new Weapons("Vulcan-Minigun", "Machine Gun", heavyAmmo, 125, 500, 2, .50, 4,
			10, true, 9900, "Auto", 100, 3.9, false, false, NO_EFFECT, 0, 0,"/images/items/Vulcan-Minigun.png", 47);
	
	
	//SMGS
	final Weapons smg1GradeC1 = new Weapons("MP-600", "SMG", SMGAmmo, 25, 35, 7, .10, 2,
			0, true, 430, "Auto", 16, 2.10, true, true, NO_EFFECT, 0, 0,"/images/items/MP-600.png", 51);
	final Weapons smg2GradeB1 = new Weapons("RIA-30", "SMG", SMGAmmo, 38, 40, 7, .10, 2,
			1, true, 800, "Auto", 15, 2.20, false, true, NO_EFFECT, 0, 0,"/images/items/RIA-30.png", 52);
	
	//Explosives
	final Weapons explosives1GradeC1 = new Weapons("RIA-EPS15", "Explosives", explosiveAmmo, 96, 1, 39, .10, 2,
			3, true, 830, "Single", 0, 1.30, false, false, NO_EFFECT, 0, 140,"/images/items/RIA-EPS15.png", 61);
	final Weapons explosives6GradeB1 = new Weapons("M10-SuperFrag", "Explosives", grenadeAmmo, 200, 1, 9, .10, 2,
			1, true, 40, "Single", 2, .20, false, false, NO_EFFECT, 0, 180,"/images/items/M10-SuperFrag.png", 66);
	final Weapons explosives7GradeB2 = new Weapons("M11-Incendiary", "Explosives", grenadeAmmo, 70, 1, 9, .10, 2,
			1, true, 60, "Single", 2, .20, false, false, FIRE, 0, 280,"/images/items/Incendiary Grenade.png", 67);
	
	//Test Guns
//	Weapons rifles2GradeA1 = new Weapons("M4A1", "Rifles", rifleAmmo, 36, 30, 210, .10, 2,
//			3, true, 1850, "Auto", 13, 1.3, false, true, 0, 32);
	
	final Weapons[] Melee = { melee1GradeC1 };
	final Weapons[] Pistol = { pistol2GradeB1, pistol3GradeS1, pistol4GradeA1, pistol6GradeA3, pistol5GradeA2};
	final Weapons[] Rifles = { rifles1GradeC1, rifles2GradeB1, rifles3GradeS1, rifles4GradeA3  };
	final Weapons[] Heavy = { heavy1GradeB1, heavy4GradeB2, heavy5GradeA3, heavy7GradeS4};
	final Weapons[] SMG = { smg1GradeC1, smg2GradeB1};
	final Weapons[] Explosives = { explosives1GradeC1, explosives6GradeB1, explosives7GradeB2};
	
	static final int ARMOR_INDEX= 0;
	static final int SMALLKIT_INDEX = 1;
	static final int MED_INDEX = 2;
	static final int BIG_INDEX = 3;
	static final int PISTOLAMMO_INDEX = 4;
	static final int RIFLEAMMO_INDEX = 5;
	static final int FIREPISTOLAMMO_INDEX = 6;
	static final int FIRERIFLEAMMO_INDEX = 7;
	static final int STUNPISTOLAMMO_INDEX = 8;
	static final int STUNRIFLEAMMO_INDEX = 9;
	
	final Item[] MiscItems = {yourarmor, smallkit , medkit, bigkit, pistolAmmo, rifleAmmo, firePistolAmmo, 
			fireRifleAmmo, stunPistolAmmo, stunRifleAmmo,};
	
	static final int MElEE_INDEX= 0;
	static final int PISTOL_INDEX = 1;
	static final int RIFLES_INDEX = 2;
	static final int HEAVY_INDEX = 3;
	static final int SMG_INDEX = 4;
	static final int EXPLOSIVE_INDEX = 5;
	
	final Weapons[] TheWeapons = {melee1GradeC1, pistol2GradeB1, pistol3GradeS1, pistol4GradeA1, pistol6GradeA3, pistol5GradeA2,  
			rifles1GradeC1, rifles2GradeB1, rifles3GradeS1, rifles4GradeA3,
			heavy1GradeB1, heavy4GradeB2, heavy5GradeA3, heavy7GradeS4,
			smg1GradeC1, smg2GradeB1,
			explosives1GradeC1, explosives6GradeB1, explosives7GradeB2
	};
	final Weapons[][] AllWeapons = {Melee, Pistol, Rifles, Heavy, SMG, Explosives};
	/** AllWeapons
	 *Number of column                 [     0       ,      1       ,      2       ,      3        ,      4       ,         5        ]
	 *The weapon type                   [ Melee   ,   Pistol   ,   Rifles   ,   Heavy   ,   SMG   ,   Explosives]
	 *Amount of weapons per type  [     1       ,      5       ,      4       ,      4        ,      2       ,         2        ]
	 * 
	 */
	
	static final int MElEE_INDEX= 0;
	static final int PISTOL_INDEX = 1;
	static final int RIFLES_INDEX = 2;
	static final int HEAVY_INDEX = 3;
	static final int SMG_INDEX = 4;
	static final int EXPLOSIVE_INDEX = 5;
	
	final Weapons[][] AllWeapons = {Melee, Pistol, Rifles, Heavy, SMG, Explosives};
	/** AllWeapons
	 *Number of column                 [     0       ,      1       ,      2       ,      3        ,      4       ,         5        ]
	 *The weapon type                   [ Melee   ,   Pistol   ,   Rifles   ,   Heavy   ,   SMG   ,   Explosives]
	 *Amount of weapons per type  [     1       ,      3       ,      3       ,      2        ,      2       ,         2        ]
	 * 
	 */
	
	// Misc
	final Misc gold = new Misc("Gold", "Get more of this and you're rich!", true , 10, NO_EFFECT,"/images/items/coin.png", false);
	final Misc scrap = new Misc("Scrap Metal", "Useless trash.",false , 2, NO_EFFECT,"/images/items/scrapMetal.png", true);
	
	public Item[] getItem();
}
