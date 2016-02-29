package project.items;

import java.awt.image.BufferedImage;

import project.menus.Selectable;

public abstract class Item implements Selectable {
	private String name;
	private String description;
	private int cost;
	private int effect;
	

	public Item(String name,String desc,int cost, int effect){
		this.name=name;
		description=desc;
		this.cost=cost;
		this.effect = effect;
		/** possible param String imageName
		with a method that paint pictures
		current status: no idea if we do or not
		item location?*/
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
