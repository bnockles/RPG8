package project.items;

public class TargetDemo {
	int health;
	Weapons weapon;
	/**
	 * @param args
	 */
	public TargetDemo(int health,Weapons weapon){
		this.weapon = weapon;
		this.health=health;
	}
	
	public void attack(TargetDemo target){
		if(this.weapon.ammoTotal!=0){
			target.health-=this.weapon.damage;
			this.weapon.ammoTotal--;
		}
		else{
			this.weapon.ammoTotal=this.weapon.ammoClip;
			this.weapon.ammoCapacity--;
		}
	}
}
