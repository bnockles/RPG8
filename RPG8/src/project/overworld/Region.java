package project.overworld;

import java.awt.Rectangle;

public class Region extends Frame {
	int goTo;
	int startX;
	int startY;
	public Region(int xPos,int yPos,int xSize,int sizeY,int goTo,int startX,int startY,int region) {
		super(xPos,yPos,xSize,sizeY,region);
		this.goTo = goTo;
		this.startX = startX;
		this.startY = startY;
	}
	public int getGoTo() {
		return goTo;
	}
	public int getStartX() {
		return startX;
	}
	public int getStartY() {
		return startY;
	}
	
	
}
