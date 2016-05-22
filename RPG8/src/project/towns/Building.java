package project.towns;

import java.awt.image.BufferedImage;

public class Building {
	
	int y;
	int x;
	BufferedImage image;
	boolean portal;
	String nameOfBuiliding;
	
	public Building(BufferedImage image,int x, int y, boolean portal,String nameOfBuiliding){
		this.image = image;
		this.y = y;
		this.x = x;
		this.portal = portal;
		this.nameOfBuiliding = nameOfBuiliding;
		//http://www.javatpoint.com/constructor
	}
	

	
	public  BufferedImage getImage(){
		return image;
	}
	public  int getxcoord(){
		return x;
	}
	public  int getycoord(){
		return y;
	}
	public boolean getIsPortal(){
		return portal;
	}
}
