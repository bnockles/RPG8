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
		
		if(this.weapon.ammoTotal!=0){
			target.health-=this.weapon.damage;
			this.weapon.ammoTotal--;
		}
		if(this.health<0){
			this.health=0;
		}
	}
	
	public void reload(){
		if(this.weapon.ammoCapacity!=0){
			this.weapon.ammoTotal=this.weapon.ammoClip;
			this.weapon.ammoCapacity--;
		}
	}
}
