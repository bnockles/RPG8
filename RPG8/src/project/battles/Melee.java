package project.battles;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Melee extends Collision{
	protected int width;
	protected int height;
	protected Rectangle hitBox;
	protected int frames;//out of 30, e.g. 15/30fps = .5 seconds
	
	public Melee(int x, int y, int damage, int width, int height, int frames, BufferedImage image){
		super(x, y, damage);
		this.width = width;
		this.height = height;
		this.hitBox = new Rectangle(x,y,width,height);
		this.frames = frames;
		this.image = image;
		collided = false;
		
	}
	
	public void updateTime(){
		if(--frames <= 0)collided = true;
	}
	@Override
	public void updateAndCheckAll() {
		updateTime();
	}

	@Override
	public void collideWith(Character c) {
		// TODO Auto-generated method stub
		collided = true;
	}

	@Override
	public boolean canPassThrough() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void paintImage() {
		// TODO Auto-generated method stub
		
	}

	
}
