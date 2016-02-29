package project.tooltipdemo;

/**
 * Mark Mozgovoy
 */

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
		
		return null;
	}

	@Override
	public void update() {
		
		
	}

	@Override
	public void confirm() {
		
		
	}

	@Override
	public void setSelect(boolean b) {
		
		
	}

}
