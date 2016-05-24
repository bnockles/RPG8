package project.items;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

<<<<<<< HEAD
import javax.imageio.ImageIO;
=======
import project.menus.Selectable;
import project.towns.ShopItems;
>>>>>>> refs/heads/develop

<<<<<<< HEAD
import project.menus.Selectable;
import project.towns.ShopItems;

=======
>>>>>>> refs/heads/develop
public abstract class Item implements Selectable, ShopItems{
	private String name;
	private String description;
	private int cost;
	private int effect;
	private String itemImage;
	private boolean buyable;
<<<<<<< HEAD
	protected BufferedImage itemBImage;
	protected int x;
	protected int y;
	protected Rectangle rectitem;
=======
>>>>>>> refs/heads/develop
	
<<<<<<< HEAD
=======

>>>>>>> refs/heads/develop
	public Item(String name,String desc,int cost, int effect, String itemImage, boolean buyable){
		this.name=name;
		description=desc;
		this.cost=cost;
		this.effect = effect;
		this.itemImage=itemImage;
		buyable = true;
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
<<<<<<< HEAD
	int[] getDimensions(){
		int[] array={0,0};
		try {
			BufferedImage dimension=ImageIO.read(getClass().getResource(getItemImage()));
			array[0]=dimension.getWidth();
			array[1]=dimension.getHeight();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Failed reading.");
		}
		return array;
	}
=======
	
>>>>>>> refs/heads/develop
	public double getPrice(){
		return getCost();
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

	public boolean isBuyable() {
		return buyable;
	}

	public void setBuyable(boolean buyable) {
		this.buyable = buyable;
	}

	public void setCost(int cost) {
		this.cost = cost;
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
