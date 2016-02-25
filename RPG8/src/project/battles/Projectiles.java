package project.battles;

import java.awt.image.BufferedImage;

import project.items.Weapon;

public class Projectiles extends Collision{
	protected BufferedImage pImgSrc;
	protected int vx;
	protected int vy;
	protected int range;
	protected final int initX;
	protected final int initY;
	protected boolean collided;

	public Projectiles(int x, int y, int damage, int vx, int vy, int range, BufferedImage pImgSrc){
		super(x, y, damage);
		//this.bulletType = bulletType; //this needs more clarity because it has to be created
		this.vx = vx;
		this.vy = vy;
		this.pImgSrc = pImgSrc;
		this.initX = x;
		this.initY = y;
		collided = false;
	}
	public BufferedImage getpImgSrc() {
		return pImgSrc;
	}

	public void updatePosition(){
		x += vx;
		y += vy;
	}
	public boolean isCollided() {
		return collided;
	}
	public void checkRange(){
		double distance = Math.sqrt(Math.pow((x-initX), 2) + Math.pow((y-initY), 2));
		if(distance >= range)collided=true;
	}
	
	public void updateAndCheckAll(){
		updatePosition();
		checkRange();
	}
	
	@Override
	void collideWith(Character C) {
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
