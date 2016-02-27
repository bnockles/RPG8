package project.battles;

import java.awt.image.BufferedImage;

import project.items.Weapon;
/**
 * 
 * @ Author: Melvin Cherian
 * 
 */
public abstract class Collision implements Collidable{
	protected BufferedImage image;
	protected int damage;
	protected int x;
	protected int y;
	protected boolean collided;
	//protected int delayTime ... will implement later
	
	public Collision(int x, int y, int damage){
		this(x,y);
		this.damage = damage;
	}
	public Collision(int x, int y){
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	public boolean isCollided() {
		return collided;
	}
	public BufferedImage getImage() {
		return image;
	}
	public int getDamage() {
		return damage;
	}
	public boolean doesDamage(){
		return true;
	}
	public abstract void collideWith(Character c);
	public abstract void updateAndCheckAll();
	
	public abstract boolean canPassThrough();
	public abstract void paintImage();
}
