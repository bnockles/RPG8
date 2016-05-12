package project.items;

import java.util.Timer;
import java.util.TimerTask;

public class Ammo extends Item{
	private String name;
	private String desc;
	private int ammoType;
	private String itemImage;
	

	public Ammo(String name, String desc,int cost,int ammoType, int effect, String itemImage) {
		super(name, desc, cost, effect, itemImage);
		// TODO Auto-generated constructor stub
		this.name=name;
		this.desc=desc;
		this.ammoType=ammoType;
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
	
	public void applyEffect(int eff){
		int duration=0;
		if(eff == ItemResources.FIRE){
				final Timer timer = new Timer();
				final TimerTask countDown = new TimerTask(){
					public void run(){
						if(duration>=1){
							duration=0;
							
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
			}	
		}
	
		if(eff == ItemResources.CORROSIVE){
			
		}
		if(eff==ItemResources.STUN){
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
	}
	/** Type
	 *[1-Regular, 2-Energy] Qing Ning Huang
	 */
	
}
