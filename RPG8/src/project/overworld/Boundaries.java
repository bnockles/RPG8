package project.overworld;

import java.awt.Rectangle;

public class Boundaries  {
	public boolean lethal;
	int xPos;
	String name;
	int yPos;
	int sizeX;
	int sizeY;
	public Boundaries(String name, int xPos, int yPos, int sizeX, int sizeY, boolean lethal) {
		
		this.xPos = xPos;
		this.lethal = lethal;
	}
	public boolean isLethal() {
		return lethal;
	}
	public int getxPos() {
		return xPos;
	}
	public String getName() {
		return name;
	}
	public int getyPos() {
		return yPos;
	}
	public int getSizeX() {
		return sizeX;
	}
	public int getSizeY() {
		return sizeY;
	}
	public Rectangle getBounds(){
		return new Rectangle(xPos,yPos,sizeX,sizeY);
	}
}
