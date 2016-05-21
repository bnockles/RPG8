package project.items;

import java.util.Timer;
import java.util.TimerTask;

public class MedKit extends Item {
	//stanley's class
	private String name;
	private String desc;
	private int cost;
	private int healthGained;
	private int effect;
	int count;
	int regenDuration=0;
	Timer regenTimer;
	public MedKit(String name, String desc,int cost, int healthGained, int effect, String itemImage, boolean buyable) {
		super(name, desc, cost, effect, itemImage, buyable);
		this.healthGained=healthGained;
		this.effect=effect;
		// TODO Auto-generated constructor stub
	}
	
	//Health regained by clicking to use
	/**public int giveHealth(Character b){
		int charHealth=b.getHealth();
		charHealth+=this.healthGained;
	}**/
	public void giveHealth(TargetDemo b){
		if(b.health==0) return;
		b.health+=this.healthGained;
		regen(b);
		if(b.health>100){
			b.health=100;
		}
	}
	public void regen(final TargetDemo b){
		System.out.println("CALL REGEN");
	
		final int healRegen=this.healthGained;
		if(this.getEffect()==ItemResources.REGEN){
			try{	
				count=0;
				regenTimer.cancel();
			}
			catch(NullPointerException e){
			}
			regenTimer=new Timer();
			final TimerTask countDown = new TimerTask(){
				boolean timerStack=false;
				public void run(){
					if(b.health==0) regenTimer.cancel();
					b.isRegen=true;
					System.out.println("REGEN"+count);
					if(regenDuration>3){
						b.isRegen=false;
						regenDuration=0;
						regenTimer.cancel();
					}else{
						count++;
						b.health+=healRegen;
						if(b.health>100)b.health=100;
						regenDuration++;
					}
					this.timerStack=true;
				}
			};
			regenTimer.scheduleAtFixedRate(countDown, 1000, 1000);
		}
	}

	public int getEffect() {
		return effect;
	}
	public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
	}

	public int getCost() {
		return cost;
	}

	public int getHealthGained() {
		return healthGained;
	}

}
