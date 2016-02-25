package project.battles.demo;

import java.awt.image.BufferedImage;

import project.battles.Projectiles;

public class SampleProjectiles extends Projectiles{
	public SampleProjectiles(int x, int y, int damage, int vx, int vy, int range, BufferedImage pImgSrc){
		super(x, y, damage, vx, vy, range, pImgSrc);
	}

}
