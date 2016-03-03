package project.items;

import java.util.Timer;
import java.util.TimerTask;

public class TargetDemo {
	int health;
	Weapons weapon;
	int coins;
	int scrap;
	Ammo ammo;
	int duration=0;
	Timer timer = new Timer();
	/**
	 * @author Qing Ning Huang, Stanley Ren, Jia Liu
	 */
	public TargetDemo(int health,Weapons weapon,Ammo ammo,int coins,int scrap){
		this.weapon = weapon;
		this.health=health;
		this.ammo=ammo;
		this.coins=coins;
		this.scrap=scrap;
	}
	
	public void attack(final TargetDemo target){
		
		if(this.weapon.getAmmoTotal()!=0){
			target.health-=this.weapon.getDamage();
			this.weapon.setAmmoTotal(this.weapon.getAmmoTotal()-1);
		}
		if(this.health<0){
			this.health=0;
		}
		if(ammo.getEffect()==1){
			final TimerTask countDown = new TimerTask(){
				public void run(){
					if(duration>5){
						duration=0;
						timer.cancel();
					}else{
						target.health -=5;
						duration++;
					}
				}
			};
			timer.scheduleAtFixedRate(countDown, 1000, 1000);
				
		}
	}
	
	public void reload(){
		if(this.weapon.getAmmoCapacity()!=0){
			this.weapon.setAmmoTotal(this.weapon.getAmmoClip());
			this.weapon.setAmmoCapacity(this.weapon.getAmmoCapacity()-1);
		}
	}
}
