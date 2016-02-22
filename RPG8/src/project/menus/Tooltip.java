package project.menus;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

public class Tooltip extends VerticalMenu{
	
	private int width = 200;
	private int height = 200;
	private int x;
	private int y;
	private int imgX;
	private int imgY;
	private String title;
	private File file;
	private String description;
	
	public Tooltip(int width, int height, int x, int y, String title, File file, String description, int imgX, int imgY) {
		super(width, height);
		this.width = width;
		this.height = height;
		this.description = description;
		this.x = x;
		this.y = y;
		this.title = title;
		this.file = file;
		this.imgX = imgX;
		this.imgY = imgY;
	}
	
	public String getTitle() {
		return title;
	}

	public File getFile() {
		return file;
	}

	public String getDescription() {
		return description;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setImgX(int imgX) {
		this.imgX = imgX;
	}

	public void setImgY(int imgY) {
		this.imgY = imgY;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Tooltip(int width, int height, int x, int y, String title, String description) {
		super(width, height);
		this.x = x;
		this.y = y;
		this.title = title;
		this.description = description;
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

	@Override
	public void addSelections() {
		//We don't put selectors into a tooltip, just a text box.
		//or we could add a single selector, which is just text, and nothing happens when it is clicked.
	}
}
