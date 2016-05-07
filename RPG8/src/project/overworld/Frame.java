package project.overworld;

import java.awt.Rectangle;

public abstract class Frame {
	 int xPos;
	 int yPos;
	 int sizeX;
	 int sizeY;
	 int region;
	public Frame(int xPos, int yPos, int sizeX, int sizeY, int region) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.region = region;
	}
	public Rectangle getBounds() {
		return new Rectangle(xPos, yPos, sizeX, sizeY);
	}
	public int getxPos() {
		return xPos;
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
	public int getRegion(){
		return region;
	}
	public boolean isColliding(Rectangle r){
		if(this.getBounds().intersects(r))
			return true;
		return false;
	}
	public boolean isSameZone(int n){
		if(region == n || n == -1)
			return true;
		return false;
	}
}
