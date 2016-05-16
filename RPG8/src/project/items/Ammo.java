package project.items;

import java.util.Timer;
import java.util.TimerTask;

public class Ammo extends Item{
	private String name;
	private String desc;
	private int ammoType;
	private String itemImage;
	private boolean buyable;
	

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
			final Timer timer = new Timer();
			final TimerTask countDown = new TimerTask(){
				public void run(){
					if(target.duration>=2){
						target.armor*=2;
						target.duration=0;
						timer.cancel();
					}else{
						target.armor/=2;
						if(target.health<0){
							target.health=0;
						}
					}
					target.duration++;
				}
			};
			timer.scheduleAtFixedRate(countDown, 1000, 1000);
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
	
}
