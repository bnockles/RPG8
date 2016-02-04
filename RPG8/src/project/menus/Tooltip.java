package project.menus;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Tooltip extends VerticalMenu{
	
	private int width = 50;
	private int height = 100;
	private int x;
	private int y;
	private int imgX;
	private int imgY;
	private String text;
	private BufferedImage image;
	
	public Tooltip(int width, int height, int x, int y, String text, BufferedImage image, int imgX, int imgY) {
		super(width, height);
		this.x = x;
		this.y = y;
		this.text = text;
		this.image = image;
		this.imgX = imgX;
		this.imgY = imgY;
	}
	
	public Tooltip(int width, int height, int x, int y, String text) {
		super(width, height);
		this.x = x;
		this.y = y;
		this.text = text;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getImgX() {
		return imgX;
	}

	public int getImgY() {
		return imgY;
	}

	public String getText() {
		return text;
	}

	@Override
	public void addSelections() {
		//We don't put selectors into a tooltip, just a text box.
		//or we could add a single selector, which is just text, and nothing happens when it is clicked.
	}
}
