package project.items;

import java.util.Timer;
import java.util.TimerTask;

public class Ammo extends Item{
	private String name;
	private String desc;
	private int ammoType;
	private String itemImage;
	private boolean buyable;
<<<<<<< HEAD
	private int burnDuration=0;
	private int corrodeDuration;
	private int stunDuration;
=======
>>>>>>> refs/heads/develop
	

	public Ammo(String name, String desc,int cost,int ammoType, int effect, String itemImage, boolean buyable) {
		super(name, desc, cost, effect, itemImage, buyable);
		// TODO Auto-generated constructor stub
		this.name=name;
		this.desc=desc;
		this.ammoType=ammoType;
		this.buyable=buyable;
	}

	public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
	}

	public int getAmmoType() {
		return ammoType;
	}

	public String getItemImage() {
		return itemImage;
	}
<<<<<<< HEAD
=======
	
	public void applyEffect(int eff,final TargetDemo target){
		if(eff == ItemResources.FIRE){
			if(!target.isBurned){
				final Timer timer = new Timer();
				final TimerTask countDown = new TimerTask(){
					public void run(){
						if(target.duration>=1){
							target.duration=0;
							target.isBurned=false;
							timer.cancel();
						}else{
							target.health -=2;
							if(target.health<0){
								target.health=0;
							}
							target.duration++;
						}
					}
				};
				timer.scheduleAtFixedRate(countDown, 1000, 1000);
				target.isBurned=true;
			}	
		}
		if(eff == ItemResources.CORROSIVE){
			
		}
		if(eff==ItemResources.STUN){
			target.isStunned=true;
			final Timer timer = new Timer();
			final TimerTask countDown = new TimerTask(){
				public void run(){
					if(target.duration>=3){
						target.duration=0;
						target.isStunned=false;
						timer.cancel();
					}else{
						target.duration++;
					}
				}
			};
			timer.scheduleAtFixedRate(countDown, 1000, 1000);
		}
	}
	/** Type
	 *[1-Regular, 2-Energy] Qing Ning Huang
	 */
>>>>>>> refs/heads/develop
	
	public void applyEffect(int eff,final TargetDemo target){
		if(eff != ItemResources.NO_EFFECT){
			final Timer timer = new Timer();
			
			final TimerTask applyBurn = new TimerTask(){
				public void run(){
					if(burnDuration>=5){
						burnDuration=0;
						target.isBurned=false;
						timer.cancel();
					}else{
						System.out.println("BURNING");
						target.health -=5;
						if(target.health<0){
							target.health=0;
						}
						burnDuration++;
					}
				}
			};
			
			final TimerTask applyCorrosive = new TimerTask(){
				public void run(){
					System.out.println("CORR");
					if(corrodeDuration==0){
						
						target.armor/=2;
						System.out.println("Corroded Armor" + target.armor);
						
					}
					if(corrodeDuration>=4){
						target.armor*=2;
						System.out.println("Normal Armor" + target.armor);
						corrodeDuration=-1;
						target.isCorrosive=false;
						timer.cancel();
						System.out.println("now:"+target.name + " Armor is: " + target.armor);
					}
					corrodeDuration++;
					if(target.health<0){
						target.health=0;
					}
				}
			};
			
			final TimerTask applyStun = new TimerTask(){
				public void run(){
					System.out.println("STUNNED");
					if(stunDuration>=3){
						stunDuration=0;
						target.isStunned=false;
						timer.cancel();
					}else{
						stunDuration++;
					}
				}
			};
			
			if(eff==ItemResources.FIRE && !target.isBurned){
				target.isBurned=true;
				timer.scheduleAtFixedRate(applyBurn, 1000, 1000);
			}
			if(eff==ItemResources.CORROSIVE && !target.isCorrosive){
				target.isCorrosive=true;
				timer.scheduleAtFixedRate(applyCorrosive, 1000, 1000);
			}
			if(eff==ItemResources.STUN){
				target.isStunned=true;
				timer.scheduleAtFixedRate(applyStun, 1000, 1000);
			}
		}
		
		
		
//		if(eff == ItemResources.FIRE){
//			if(!target.isBurned){
//				final Timer timer = new Timer();
//				final TimerTask applyBurn = new TimerTask(){
//					public void run(){
//						if(burnDuration>=5){
//							burnDuration=0;
//							target.isBurned=false;
//							timer.cancel();
//						}else{
//							System.out.println("BURNING");
//							target.health -=5;
//							if(target.health<0){
//								target.health=0;
//							}
//							burnDuration++;
//						}
//					}
//				};
//				timer.scheduleAtFixedRate(applyBurn, 1000, 1000);
//				target.isBurned=true;
//			}	
//		}
//		if(eff == ItemResources.CORROSIVE){
//			if(!target.isCorrosive){
//				target.isCorrosive=true;
//				final Timer timer = new Timer();
//				final TimerTask applyCorrosive = new TimerTask(){
//					public void run(){
//						System.out.println("CORR");
//						if(corrodeDuration==0){
//							
//							target.armor/=2;
//							System.out.println("Corroded Armor" + target.armor);
//							
//						}
//						if(corrodeDuration>=4){
//							target.armor*=2;
//							System.out.println("Normal Armor" + target.armor);
//							corrodeDuration=0;
//							target.isCorrosive=false;
//							timer.cancel();
//							System.out.println("now:"+target.name + " Armor is: " + target.armor);
//						}
//						corrodeDuration++;
//						if(target.health<0){
//							target.health=0;
//						}
//					}
//				};
//				timer.scheduleAtFixedRate(applyCorrosive, 0, 1000);
//			}
//		}
//		if(eff==ItemResources.STUN){
//			target.isStunned=true;
//			final Timer timer = new Timer();
//			final TimerTask applyStun = new TimerTask(){
//				public void run(){
//					System.out.println("STUNNED");
//					if(stunDuration>=3){
//						stunDuration=0;
//						target.isStunned=false;
//						timer.cancel();
//					}else{
//						stunDuration++;
//					}
//				}
//			};
//			timer.scheduleAtFixedRate(applyStun, 1000, 1000);
//		}
	}

}
