package project.items;


import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

import project.battles.HaveStats;
import project.directors.UtilityMethods;

public class MedKit extends Item implements UsableItem{
	//stanley's class
	private String name;
	private String desc;
	private int cost;
	private int healthGained;
	private int effect;
	private String itemImage;
	private boolean visible = false;
	int count;
	int regenDuration=0;
	Timer regenTimer;
	public MedKit(String name, String desc,int cost, int healthGained, int effect, String itemImage, boolean buyable,int x, int y) {
		super(name, desc, cost, effect, itemImage, buyable);
		this.healthGained=healthGained;
		this.effect=effect;
		this.itemImage=itemImage;
		this.itemBImage = UtilityMethods.getImageFromFile(this, itemImage);
		rectitem = new Rectangle(x,y,itemBImage.getWidth(),itemBImage.getHeight());
		this.x = x;
		this.y = y;
	}
	
	//Health regained by clicking to use
	/**public int giveHealth(Character b){
		int charHealth=b.getHealth();
		charHealth+=this.healthGained;
	}**/
	public void giveHealth(HaveStats b){
		System.out.println(b.getCurrentHP());
		if(b.getCurrentHP()==0)return;
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
				count=0;
				regenTimer.cancel();
			}
			catch(NullPointerException e){
			}
			regenTimer=new Timer();
			final TimerTask countDown = new TimerTask(){
				boolean timerStack=false;
				public void run(){
					System.out.println(b.getCurrentHP());
					if(b.getCurrentHP()==0) {
						System.out.println("CALLED");
						b.setRegen(false);
						regenTimer.cancel();
						return;
					}
					b.setRegen(true);
					
					if(regenDuration>3){
						b.setRegen(false);
						regenDuration=0;
						regenTimer.cancel();
					}else{int health= b.getCurrentHP()+healRegen;
						System.out.println("REGEN"+count);
						count++;
						b.setCurrentHP(health);
						if(b.getCurrentHP()>b.getMaxHP())b.setCurrentHP(b.getMaxHP());
						regenDuration++;
					}
					this.timerStack=true;
				}
			};
			regenTimer.scheduleAtFixedRate(countDown, 1000, 1000);
		}
	}

	public BufferedImage getItemBImage(){
		return itemBImage;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public boolean getVisible(){
		return visible;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public Rectangle getRectitem() {
		return rectitem;
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
