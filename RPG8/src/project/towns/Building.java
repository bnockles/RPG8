package project.towns;

import java.awt.image.BufferedImage;

public class Building {
	
	int y;
	int x;
	BufferedImage image;
	
	public Building(BufferedImage image,int y, int x){
		this.image = image;
		this.y = y;
		this.x = x;
	}

}
