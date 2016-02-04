package project.menus;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Tooltip extends VerticalMenu{
	
	int width;
	int height;
	int x;
	int y;
	int imgX;
	int imgY;
	String text;
	BufferedImage image;
	
	public Tooltip(int width, int height, int x, int y, String text, BufferedImage image, int imgX, int imgY) {
		super(width, height);
		this.x = x;
		this.y = y;
		this.text = text;
		this.image = image;
		this.imgX = imgX;
		this.imgY = imgY;
	}

	@Override
	public void addSelections() {
		//We don't put selectors into a tooltip, just a text box.
		//or we could add a single selector, which is just text, and nothing happens when it is clicked.
	}
}
