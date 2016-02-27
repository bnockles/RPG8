package project.battles;

import java.awt.Rectangle;

public class Melee extends Collision{
	protected int width;
	protected int height;
	protected Rectangle hitBox;
	protected int frames;//out of 30, e.g. 15/30fps = .5 seconds
	
	public Melee(int x, int y, int damage, Rectangle hitBox, int frames){
		super(x, y, damage);
		this.hitBox = hitBox;
		this.frames = frames;
	}
	
	@Override
	public void updateAndCheckAll() {
		frames--;
		
	}

	@Override
	void collideWith(Character c) {
		// TODO Auto-generated method stub
		
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
