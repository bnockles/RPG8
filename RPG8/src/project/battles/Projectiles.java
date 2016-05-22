//Jason Lyan ---> Corrected by Melvin Cherian
//Collisions done by Pelham Van Cooten 
package project.battles;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import project.battles.demo.BattlesScreen;
import project.items.Weapon;

public class Projectiles extends Collision{
	protected double vx;
	protected double vy;
	protected int range;
	protected final int initX;
	protected final int initY;

	public Projectiles(int x, int y, int damage, double vx, double vy, int range, BufferedImage image, boolean fromHostile){
		super(x, y, damage,fromHostile);
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
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, 20, 20);
	}
	
	//Pelham
	public void checkCollision(){
		if(this.fromHostile){
			if(getHitBox().intersects(BattlesScreen.character.getBounds())){
				collided = true;
				BattlesScreen.pBullets.remove(this);
			}
		}
		else{
			for(EnemyAI enemy: BattlesScreen.enemiesOnScreen){
				if(getHitBox().intersects(enemy.getBounds())){
					collided = true;
					enemy.setCurrentHP(enemy.getCurrentHP()-10);
					BattlesScreen.eBullets.remove(this);
				}
			}
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
		checkRange();
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
