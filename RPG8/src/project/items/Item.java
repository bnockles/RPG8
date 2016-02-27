package project.items;

import java.awt.image.BufferedImage;

import project.menus.Selectable;

public abstract class Item implements Selectable {
	private String name;
	private String description;
	private int cost;
	
	public Item(String name,String desc,int cost){
		this.name=name;
		description=desc;
		this.cost=cost;
		/** possible param String imageName
		with a method that paint pictures
		current status: no idea if we do or not
		item location?*/
	}
	
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
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
