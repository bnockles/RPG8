package project.items;


import java.util.Timer;
import java.util.TimerTask;

import project.battles.HaveStats;

public class MedKit extends Item implements UsableItem{
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
<<<<<<< HEAD
	public void giveHealth(TargetDemo b){
		if(b.health==0) return;
		b.health+=this.healthGained;
=======
	public void giveHealth(HaveStats b){
		int health= b.getCurrentHP()+this.healthGained;
		b.setCurrentHP(health);
>>>>>>> refs/heads/battles
		regen(b);
		if(b.getCurrentHP()>b.getMaxHP()){
			b.setCurrentHP(b.getMaxHP());
		}
	}
<<<<<<< HEAD
	public void regen(final TargetDemo b){
		System.out.println("CALL REGEN");
	
=======
	public void regen(final HaveStats b){
		
		
>>>>>>> refs/heads/battles
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
<<<<<<< HEAD
						count++;
						b.health+=healRegen;
						if(b.health>100)b.health=100;
						regenDuration++;
=======
						
						int health= b.getCurrentHP()+healRegen;
						b.setCurrentHP(health);
						if(b.getCurrentHP()>b.getMaxHP())b.setCurrentHP(b.getMaxHP());
						duration++;
>>>>>>> refs/heads/battles
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
<<<<<<< HEAD
=======
	
	public String getItemImage() {
		return itemImage;
	}

	@Override
	public void useItem(HaveStats c) {
		// TODO Auto-generated method stub
		giveHealth(c);
	}
>>>>>>> refs/heads/battles

}
