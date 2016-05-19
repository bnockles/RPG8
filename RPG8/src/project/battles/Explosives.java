//Jason Lyan & Melvin Cherian

package project.battles;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import project.battles.demo.BattlesScreen;
import project.directors.UtilityMethods;
import project.items.Weapon;

public class Explosives extends Collision {

	protected Collision activeType;
	protected boolean isExploded;
	protected BufferedImage sheet;
	public Explosives(int x, int y, int damage, double vx, double vy, int range, BufferedImage image, boolean fromHostile) {
		super(x, y);
		activeType = new Projectiles(x, y, 0, vx, vy, range, image, fromHostile);
		isExploded = false;
		paintImage();
		sheet = image;
	}

	
	public void collideWith(Character c) {
		// TODO Auto-generated method stub
		//unnecessary?
		
	}

	@Override
	public void updateAndCheckAll() {//??????????
		activeType.updateAndCheckAll();
		x = activeType.getX();
		y = activeType.getY();
		if(activeType.isCollided() && isExploded) {
			collided = true;
		}
		if(activeType.isCollided() && !isExploded) {
			activeType = new Melee(x, y, damage, 100, 100, 15, sheet, 0);
			isExploded = true;
		}
		paintImage();
		//change image
	}

	@Override
	public boolean canPassThrough() {
		return true;
	}

	@Override
	public void paintImage() {
		//explosive spritez
		image = activeType.getImage();
	}

}
