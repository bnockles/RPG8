package project.items;


public class Armor extends Item{
	private int armor;

	private String itemImage;
	
	public Armor(String name, String desc,int cost, int effect, int armor, String itemImage) {
		super(name, desc, cost, effect, itemImage);
		this.armor = armor;
	}

//	Armor reduces damage taken by all attacks except the plasma and stun gun. 
//	Formula (If it’s not plasma or stun gun) : Damage multiplier = 
//	{100/(100 + Armor), if Armor >= 0 
//	2 - 100/(100 + Armor), otherwise}
//
//	Health = (int) (Health  - (Damage*damageMultiplier));
//	Armor = (int) (Armor - ((Damage*damageMultiplier)/2));
	public static int[] damageCalcs(int damage, int health, int armor){
		double damageMul;
		int[] calcs = new int[2];
		if(armor >= 0){
			damageMul = 100/(100 + (double)armor);
			System.out.println("1: " + damageMul);
		}
		else{
			damageMul = 2 - 100/(100 + armor);
		}
		health = (int) (health  - (damage*damageMul));
		System.out.println("The Armor absorbed: " + (damage - (damage*damageMul)) + " Damage.");
		armor = (int) (armor - ((damage*damageMul)/2));
//		System.out.println("2: " + health);
//		System.out.println("3: " + armor);
		calcs[0] = health;
		calcs[1] = armor;
		return calcs;
	}
	
	public int getArmor(){
		return armor;
	}
	
	public String getItemImage() {
		return itemImage;
	}
}
