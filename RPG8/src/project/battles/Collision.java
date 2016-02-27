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
	//protected int delay time ... will implement later
	abstract void collideWith(Character c);
	abstract public void updateAndCheckAll();
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

	public BufferedImage getImage() {
		return image;
	}
	public int getDamage() {
		return damage;
	}
	public boolean doesDamage(){
		return true;
	}
	
	public abstract boolean canPassThrough();
	public abstract void paintImage();
}
