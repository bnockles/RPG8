package project.overworld;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Obstacle extends Frame {
	public String name;
	String image;
	BufferedImage object;
	boolean destructable;
	boolean state;

	public Obstacle(String name, int xPos, int yPos, int sizeX, int sizeY, String image,int region,boolean destructable,boolean state) {
		super(xPos, yPos, sizeX, sizeY,region);
		this.name = name;
		this.state = state;
		this.destructable = destructable;
		if (image != "") {
			this.image = image;
			try {
				URL url = getClass().getResource(image);
				this.object = ImageIO.read(url);

			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			this.image = "";
		}
	}
	public String getName() {
		return name;
	}
	public BufferedImage getImage() {
		return object;
	}
	public boolean getDest(){
		return destructable;
	}
	public boolean getState(){
		return state;
	}
	public void setState(boolean state){
		this.state = state;
	}
}
