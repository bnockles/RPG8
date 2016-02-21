package project.tooltipdemo;

import java.awt.image.BufferedImage;

import project.menus.Selectable;

public class TooltipOption implements Selectable {
	
	public String text;
	public BufferedImage image;
	public String description;
	
	public TooltipOption(String text, BufferedImage image, String description){
		this.text = text;
		this.image = image;
		this.description = description;
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

	@Override
	public void confirm() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSelect(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
