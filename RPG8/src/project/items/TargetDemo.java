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
	boolean isBurned=false;
	

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
		if(target.health<0){
			target.health=0;
		}
		if(ammo.getEffect() == 1){
			if(!isBurned){
				final Timer timer = new Timer();
				final TimerTask countDown = new TimerTask(){
					public void run(){
						if(duration>=1){
							duration=0;
							isBurned=false;
							timer.cancel();
						}else{
							target.health -=2;
							if(target.health<0){
								target.health=0;
							}
							duration++;
						}
					}
				};
				timer.scheduleAtFixedRate(countDown, 1000, 1000);
				isBurned=true;
			}	
		}
		if(ammo.getEffect() == 2){
			
		}
		if(ammo.getEffect() == 3){
			ItemScreen.isStun = true;
			final int count = (int) (Math.random()*5+1);
			final Timer timer = new Timer();
			final TimerTask countDown = new TimerTask(){
				public void run(){
					if(duration>=count){
						duration=0;
						ItemScreen.isStun=false;
						timer.cancel();
					}else{
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
