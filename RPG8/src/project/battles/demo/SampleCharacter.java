package project.battles.demo;

import java.awt.image.BufferedImage;
import java.awt.Rectangle;

import project.controls.OverworldSpriteControl;
import project.items.Weapon;
import project.save.ItemState;

public abstract class SampleCharacter {
	protected abstract ItemState getItems();
	protected abstract OverworldSpriteControl move();
	public int[] rawr = {50,5,200,100};
	protected BufferedImage[] fsprite;
	protected BufferedImage[] bsprite;
	protected BufferedImage[] lsprite;
	protected BufferedImage[] rsprite;
	protected int count;
	protected boolean moveUp = false;
	protected boolean moveDown = false;
	protected boolean moveLeft = false;
	protected boolean moveRight = false;
	protected SampleWeapon equippedWeapon = new SampleWeapon("blah","blah",rawr);
	protected int width;
	protected int height;
	protected boolean Hostile;
	protected boolean walking = false;
	protected int maxHP;
	protected int currentHP;
	protected int x;
	protected int y;
	
	protected SampleCharacter(BufferedImage[][] images,int maxHP,int x, int y){
		this.bsprite = images[0];
		this.fsprite = images[1];
		this.lsprite = images[2];
		this.rsprite = images[3];
		this.width = bsprite[0].getWidth();
		this.height = bsprite[0].getHeight();
		this.x = x;
		this.y = y;
		this.maxHP = maxHP;
		this.currentHP = maxHP;
	}
	
	public Rectangle getBounds(){ //Pelham made this change sorry in advance for changing your code
		return new Rectangle(x, y, width, height);
	}
	
	public void increaseCount(){
		/**
		 * Chieh-Huang Chen
		 */
		count++;
		if(count>=20)
			count=0;
	}
	
	
	
	public abstract BufferedImage getImage();
	
	public SampleWeapon getEquippedWeapon() {
		return equippedWeapon;
	}
	public void setEquippedWeapon(SampleWeapon equippedWeapon) {
		this.equippedWeapon = equippedWeapon;
	}
	public boolean isHostile() {
		return Hostile;
	}
	public void setHostile(boolean hostile) {
		Hostile = hostile;
	}
	public int getMaxHP() {
		return maxHP;
	}
	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}
	public int getCurrentHP() {
		return currentHP;
	}
	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
	}
	public int getX() {
		return x;
	}
	public void setX(int positionX) {
		this.x = positionX;
	}
	public int getY() {
		return y;
	}
	public void setY(int positionY) {
		this.y = positionY;
	}
	public void setMoveUp(boolean moveUp) {
		this.moveUp = moveUp;
	}
	public void setMoveDown(boolean moveDown) {
		this.moveDown = moveDown;
	}
	public void setMoveLeft(boolean moveLeft) {
		this.moveLeft = moveLeft;
	}
	public void setMoveRight(boolean moveRight) {
		this.moveRight = moveRight;
	}
	public boolean isMoveUp() {
		return moveUp;
	}
	public boolean isMoveDown() {
		return moveDown;
	}
	public boolean isMoveLeft() {
		return moveLeft;
	}
	public boolean isMoveRight() {
		return moveRight;
	}
	public void setWalking(boolean walking) {
		this.walking = walking;
	}
	
}
