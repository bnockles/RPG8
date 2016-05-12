package project.menus;

/**
 * Mark Mozgovoy
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

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
	private int buyPrice;
	private int sellPrice;
	
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
	
	public Tooltip(int width, int height, int x, int y, String title, File file, String description, int imgX, int imgY, int buyPrice, int sellPrice) {
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
		this.buyPrice = buyPrice;
		this.sellPrice = sellPrice;
	}
	
	public Tooltip(int width, int height, int x, int y, String title, String description) {
		super(width, height);
		this.width = width;
		this.height = height;
		this.description = description;
		this.x = x;
		this.y = y;
		this.title = title;
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
		//A tooltip doesn't have selections. Other menus will take care of this.
	}

	public void drawTooltipInventory(Graphics2D g2){
		g2.setColor(Color.black);
		g2.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		g2.setColor(Color.yellow);
		Font font1 = new Font("Courier", Font.ROMAN_BASELINE, 50);
		g2.setFont(font1);
		g2.drawString(this.getTitle(), this.getX()+110, this.getY()+60);
		BufferedImage img = returnImage(this.getFile(), 64, 64);
		g2.drawImage(img, null, this.getX()+185, this.getY()+100);
		Font font2 = new Font("Courier", Font.ROMAN_BASELINE, 25);
		g2.setFont(font2);
		g2.setColor(Color.white);
		g2.drawString(this.getDescription(), this.getX()+50, this.getY()+200);
	}
	
	public void drawTooltipStore(Graphics2D g2) {
		g2.setColor(Color.black);
		g2.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		g2.setColor(Color.yellow);
		Font font1 = new Font("Courier", Font.ROMAN_BASELINE, 50);
		g2.setFont(font1);
		g2.drawString(this.getTitle(), this.getX()+110, this.getY()+60);
		BufferedImage img = returnImage(this.getFile(), 64, 64);
		g2.drawImage(img, null, this.getX()+185, this.getY()+100);
		Font font2 = new Font("Courier", Font.ROMAN_BASELINE, 25);
		g2.setFont(font2);
		g2.setColor(Color.white);
		g2.drawString(this.getDescription(), this.getX()+50, this.getY()+200);
		g2.drawString("Buy Price: $"+this.getBuyPrice()+"", this.getX()+50, this.getY()+230);
		g2.drawString("Sell Price: $"+this.getSellPrice()+"", this.getX()+50, this.getY()+260);
	}
	
	public void drawTooltipDialogue(Graphics2D g2) {
		g2.setColor(Color.black);
		g2.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		g2.setColor(Color.yellow);
		Font font1 = new Font("Courier", Font.ROMAN_BASELINE, 30);
		g2.setFont(font1);
		g2.drawString(this.getTitle() + " says...", this.getX()+300, this.getY()+60);
		Font font2 = new Font("Courier", Font.ROMAN_BASELINE, 25);
		g2.setFont(font2);
		g2.setColor(Color.white);
		g2.drawString(this.getDescription(), this.getX()+50, this.getY()+105);
	}

	public int getBuyPrice() {
		return buyPrice;
	}

	public int getSellPrice() {
		return sellPrice;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public void setBuyPrice(int buyPrice) {
		this.buyPrice = buyPrice;
	}

	public void setSellPrice(int sellPrice) {
		this.sellPrice = sellPrice;
	}
	
	public static BufferedImage returnImage(File file, int width, int height){
		//this method will take a file and return a buffered image which could be used on the screen.
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		try{
			img = ImageIO.read(file);
		}
		catch(IOException e){};
		return img;
	}
}
