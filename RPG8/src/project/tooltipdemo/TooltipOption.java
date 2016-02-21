package project.tooltipdemo;

import java.awt.image.BufferedImage;

import project.menus.Selectable;

public class TooltipOption implements Selectable {
	
	public String text;
	
	public TooltipOption(String text){
		this.text = text;
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
