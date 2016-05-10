package project.items;

import java.util.Timer;
import java.util.TimerTask;

public class TargetDemo implements Target{
	int health;
	Weapons weapon;
	int coins;
	int scrap;
	Ammo ammo;
	int duration=0;
	boolean isBurned=false;
	String name;
	boolean isStunned;
	int armor;
	/**
	 * @author Qing Ning Huang, Stanley Ren, Jia Liu
	 */
	public TargetDemo(int health,Weapons weapon,Ammo ammo,int coins,int scrap,String name,Armor armor){
		this.weapon = weapon;
		this.health=health;
		this.ammo=ammo;
		this.coins=coins;
		this.scrap=scrap;
		this.name=name;
		this.armor=armor.getArmor();
		isStunned=false;
	}
	
	public void attack(final TargetDemo target){
		
		if(this.weapon.getAmmoTotal()!=0 || this.weapon.getGunNum()/10 ==1){
			int[] calcs = Armor.damageCalcs(this.weapon.getDamage(), target.health, target.armor);
			target.health = calcs[0];
			target.armor = calcs[1];
			//target.health-=this.weapon.getDamage();
			System.out.println(this.name + " Armor is: " + target.armor);
			if(this.weapon.getGunNum()/10 !=1){
				this.weapon.setAmmoTotal(this.weapon.getAmmoTotal()-1);				
			}
		}
		if(target.health<0){
			target.health=0;
		}
		//Qing Ning
		if(ammo.getEffect() == ItemResources.FIRE){
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
		if(ammo.getEffect() == ItemResources.CORROSIVE){
			
		}
		if(ammo.getEffect()==ItemResources.STUN){
			target.isStunned=true;
			final Timer timer = new Timer();
			final TimerTask countDown = new TimerTask(){
				public void run(){
					if(duration>=3){
						duration=0;
						target.isStunned=false;
						timer.cancel();
					}else{
						duration++;
					}
				}
			};
			timer.scheduleAtFixedRate(countDown, 1000, 1000);
		}
//		if(ammo.getEffect() == 3){
//			ItemScreen.isStun = true;
//			final int count = (int) (Math.random()*5+1);
//			final Timer timer = new Timer();
//			final TimerTask countDown = new TimerTask(){
//				public void run(){
//					if(duration>=count){
//						duration=0;
//						ItemScreen.isStun=false;
//						timer.cancel();
//					}else{
//						duration++;
//					}
//				}
//			};
//			timer.scheduleAtFixedRate(countDown, 1000, 1000);
//		}
	}
	
	public void reload(){
		if(this.weapon.getAmmoCapacity()!=0){
			this.weapon.setAmmoTotal(this.weapon.getAmmoClip());
			this.weapon.setAmmoCapacity(this.weapon.getAmmoCapacity()-1);
		}
	}

	@Override
	public int getHealth() {
		// TODO Auto-generated method stub
		return 0;
	}
}
