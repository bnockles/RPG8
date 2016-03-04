package project.battles;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import project.battles.demo.BattlesScreen;
import project.directors.UtilityMethods;
import project.items.Weapon;

public class Explosives extends Collision {

	protected Collision activeType;
	
	public Explosives(int x, int y, int damage, double vx, double vy, int range, BufferedImage image, boolean fromHostile) {
		super(x, y);
		activeType = new Projectiles(x, y, damage, vx, vy, range, image, fromHostile);
	}

	
	public void collideWith(Character c) {
		// TODO Auto-generated method stub
		//unnecessary?
		
	}

	@Override
	public void updateAndCheckAll() {
		BufferedImage sheet = UtilityMethods.getImageFromFile(this, "/images/slash/slash.png");
		if(activeType.isCollided()) activeType = new Melee(x, y, damage, sheet.getWidth(), sheet.getHeight(), 15, sheet, 0);
		//change image
	}

	@Override
	public boolean canPassThrough() {
		return true;
	}

	@Override
	public void paintImage() {
		//explosive spritez
		
	}

}
