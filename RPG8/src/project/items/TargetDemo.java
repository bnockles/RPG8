package project.items;

public class TargetDemo {
	int health;
	Weapons weapon;
	int coins;
	int scrap;
	/**
	 * @author Qing Ning Huang, Stanley Ren, Jia Liu
	 */
	public TargetDemo(int health,Weapons weapon,int coins,int scrap){
		this.weapon = weapon;
		this.health=health;
		this.coins=coins;
		this.scrap=scrap;
	}
	
	public void attack(TargetDemo target){
		
		if(this.weapon.getAmmoTotal()!=0){
			target.health-=this.weapon.getDamage();
			this.weapon.setAmmoTotal(this.weapon.getAmmoTotal()-1);
		}
		if(this.health<0){
			this.health=1;
		}
	}
	
	public void reload(){
		if(this.weapon.getAmmoCapacity()!=0){
			this.weapon.setAmmoTotal(this.weapon.getAmmoClip());
			this.weapon.setAmmoCapacity(this.weapon.getAmmoCapacity()-1);
		}
	}
}
