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
	boolean passable;

	public Obstacle(String name, int xPos, int yPos, int sizeX, int sizeY, String image,int region,boolean destructable,boolean state,boolean passable) {
		super(xPos, yPos, sizeX, sizeY,region);
		this.name = name;
		this.state = state;
		this.destructable = destructable;
		this.passable = passable;
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
	public boolean getPass(){
		return passable;
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
	public void removeObstacle(){
		if(destructable){
			state = false;
		}
	}
}
