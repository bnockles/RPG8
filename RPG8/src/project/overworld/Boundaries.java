package project.overworld;

import java.awt.Image;

public class Boundaries extends Obstacle {
	public boolean lethal;
	public Boundaries(String name, int xPos, int yPos, int sizeX, int sizeY,String image, boolean lethal) {
		super(name, xPos, yPos, sizeX, sizeY,image);
		this.lethal = lethal;
	}
	public boolean isLethal() {
		return lethal;
	}
	
}
