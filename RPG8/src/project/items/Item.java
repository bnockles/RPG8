package project.items;

import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

import project.menus.Selectable;

public abstract class Item implements Selectable {
	private String name;
	private String description;
	private int cost;
	private int effect;
	private String itemImage;
	

	public Item(String name,String desc,int cost, int effect, String itemImage){
		this.name=name;
		description=desc;
		this.cost=cost;
		this.effect = effect;
		this.itemImage=itemImage;
		/** possible param String imageName
		with a method that paint pictures
		current status: no idea if we do or not
		item location?*/
	}
	private static void useEffect(int duration,int effect) {
		// TODO Auto-generated method stub
//		if(effect==4){
//			int changed=0;
//			long timenow=System.nanoTime();
//			System.out.println(timenow);
//			while((System.nanoTime()-timenow)/1000000000<=duration){
//				if((System.nanoTime()-timenow)/1000000000!=changed){
//					changed++;
					//health+=10;
					//System.out.println("Health"+health);
//				}
//			}
//		}
		//System.out.println("Final Health"+health);
	}
	public int getCost() {
		return cost;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
	public int getEffect() {
		return effect;
	}
	
	public String getItemImage() {
		return itemImage;
	}
	
	public void confirm() {
		// TODO Auto-generated method stub
	
	}

	
	@Override
	public void setSelect(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public BufferedImage getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
