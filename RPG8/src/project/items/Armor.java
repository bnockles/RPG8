package project.items;


public class Armor extends Item{

	public Armor(String name, String desc,int cost) {
		super(name, desc,cost);
		// TODO Auto-generated constructor stub
	}

//	Armor reduces damage taken by all attacks except the plasma and stun gun. 
//	Formula (If it’s not plasma or stun gun) : Damage multiplier = 
//	{100/(100 + Armor), if Armor >= 0 
//	2 - 100/(100 + Armor), otherwise}
//
//	Health = (int) (Health  - (Damage*damageMultiplier));
//	Armor = (int) (Armor - ((Damage*damageMultiplier)/2));
	public static int[] damageCalcs(int damage, int health, int armor){
		int damageMul = 0;
		int[] calcs = new int[2];
		if(armor >= 0){
			damageMul = 100/(100 + armor);
		}
		else{
			damageMul = 2 - 100/(100 + armor);
		}
		health = (int) (health  - (damage*damageMul));
		armor = (int) (armor - ((damage*damageMul)/2));
		calcs[0] = health;
		calcs[1] = armor;
		return calcs;
	}
}
