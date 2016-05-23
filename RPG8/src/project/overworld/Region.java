package project.overworld;

import java.awt.Color;
import java.awt.Rectangle;

public class Region extends Frame {
	int goTo;
	int startX;
	int startY;
	String enemyName; 
	Color color;
	public Region(String enemyName,Color color, int xPos,int yPos,int xSize,int sizeY,int goTo,int startX,int startY,int region) {
		super(xPos,yPos,xSize,sizeY,region);
		this.goTo = goTo;
		this.startX = startX;
		this.startY = startY;
		this.enemyName=enemyName;
		this.color = color;
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
	public String getEnemyName(){
		return enemyName;
	}
	public Color getColor(){
		return color;
	}
	
}
