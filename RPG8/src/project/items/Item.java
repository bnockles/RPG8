package project.items;

import java.awt.image.BufferedImage;

import project.menus.Selectable;

public abstract class Item implements Selectable {
	String name;
	String description;
	
	public Item(String name,String desc){
		this.name=name;
		description=desc;
		/** possible param String imageName
		with a method that paint pictures
		current status: no idea if we do or not
		item location?*/
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
