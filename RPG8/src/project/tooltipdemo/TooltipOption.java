package project.tooltipdemo;

import java.awt.image.BufferedImage;
import java.io.File;

import project.menus.Selectable;

public class TooltipOption implements Selectable {
	
	public String text;
	public File file;
	public String description;
	
	public TooltipOption(String text, File file, String description){
		this.text = text;
		this.file = file;
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
