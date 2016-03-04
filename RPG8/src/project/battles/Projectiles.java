//Jason Lyan ---> Corrected by Melvin Cherian
//Collisions done by Pelham Van Cooten 
package project.battles;

import java.awt.image.BufferedImage;

import project.battles.demo.BattlesScreen;
import project.items.Weapon;

public class Projectiles extends Collision{
	protected double vx;
	protected double vy;
	protected int range;
	protected final int initX;
	protected final int initY;	

	public Projectiles(int x, int y, int damage, double vx, double vy, int range, BufferedImage image){
		super(x, y, damage);
		//this.bulletType = bulletType; //this needs more clarity because it has to be created
		this.vx = vx;
		this.vy = vy;
		this.image = image;
		this.initX = x;
		this.initY = y;
		this.range= range;
		collided = false;
	}
	public BufferedImage getImage() {
		return image;
	}
	
	//Pelham
	public void checkCollision(){
		if(getHitBox().intersects(BattlesScreen.enemy1.getBounds()) || getHitBox().intersects(BattlesScreen.enemy2.getBounds())){
			collided = true; 
		}
	}

	public void updatePosition(){
		x += vx;
		y += vy;
		
	}
	//I see where you were going with this, but it's with rectangles - Pelham 
	public void checkRange(){//melvino
		double distance = Math.sqrt(Math.pow((x-initX), 2) + Math.pow((y-initY), 2));
		if(distance >= range)collided=true;
	}
	
	@Override
	public void updateAndCheckAll(){
		updatePosition();
		//checkRange();
		checkCollision(); 
	}
	
	@Override
	public void collideWith(Character C) {//Working on this
		// TBD after discussing
		collided = true;
	}

	@Override
	public boolean canPassThrough() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void paintImage() {
		// TODO Auto-generated method stub
		
	}

}
