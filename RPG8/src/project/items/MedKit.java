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
	private String itemImage;

		int duration=0;
	Timer timer;
	public MedKit(String name, String desc,int cost, int healthGained, int effect, String itemImage) {
		super(name, desc, cost, effect, itemImage);
		this.healthGained=healthGained;
		this.effect=effect;
		// TODO Auto-generated constructor stub
	}
	
	//Health regained by clicking to use
	/**public int giveHealth(Character b){
		int charHealth=b.getHealth();
		charHealth+=this.healthGained;
	}**/
	public void giveHealth(HaveStats b){
		int health= b.getCurrentHP()+this.healthGained;
		b.setCurrentHP(health);
		regen(b);
		if(b.getCurrentHP()>b.getMaxHP()){
			b.setCurrentHP(b.getMaxHP());
		}
	}
	public void regen(final HaveStats b){
		
		
		final int healRegen=this.healthGained;
		if(this.getEffect()==ItemResources.REGEN){
			try{
				timer.cancel();
			}
			catch(NullPointerException e){
				
			}
			timer=new Timer();
			final TimerTask countDown = new TimerTask(){
				boolean timerStack=false;

				public void run(){
					if(duration>5){
						duration=0;
						timer.cancel();
					}else{
						
						int health= b.getCurrentHP()+healRegen;
						b.setCurrentHP(health);
						if(b.getCurrentHP()>b.getMaxHP())b.setCurrentHP(b.getMaxHP());
						duration++;
					}
					this.timerStack=true;
				}
			};
			timer.scheduleAtFixedRate(countDown, 1000, 1000);
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
	
	public String getItemImage() {
		return itemImage;
	}

	@Override
	public void useItem(HaveStats c) {
		// TODO Auto-generated method stub
		giveHealth(c);
	}

}
