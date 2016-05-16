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
	public int buyPrice;
	public int sellPrice;
	
	public TooltipOption(String text, File file, String description, int buyPrice){
		this.text = text;
		this.file = file;
		this.description = description;
		this.buyPrice = buyPrice;
		this.sellPrice = this.buyPrice/2;
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
