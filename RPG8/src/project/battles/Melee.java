package project.battles;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import project.directors.UtilityMethods;

public class Melee extends Collision{
	protected int width;
	protected int height;
	protected Rectangle hitBox;
	protected double rotation;
	protected int frames;//out of 30, e.g. 15/30fps = .5 seconds
	protected BufferedImage imageSheet;
	
	public Melee(int x, int y, int damage, int width, int height, int frames, BufferedImage imageSheet, double rotation){
		super(x, y, damage);
		this.width = width;
		this.height = height;
		this.hitBox = new Rectangle(x,y,width,height);
		this.frames = frames;
		this.imageSheet = imageSheet;
		updateImage();
		this.rotation = rotation;
		collided = false;
	}
	
	public void updateTime(){
		if(--frames <= 0)collided = true;
	}
	public void updateImage(){
		 int count = 7 - Math.round(frames/2);
		 int imageWidth = imageSheet.getWidth()/8;
		 int imageHeight = imageSheet.getHeight();
		 BufferedImage imageSub = imageSheet.getSubimage(imageWidth*count, 0, imageWidth, imageHeight);
		 image = UtilityMethods.getScaledImage(imageSub, width, height);
		 paintImage();
	}
	public Rectangle getHitBox() {
		return hitBox;
	}
	@Override
	public void updateAndCheckAll() {
		updateImage();
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
	public void paintImage() {//paints image based on rotation field
		//CAN I GET EXTRA CREDIT FOR THIS DAMN
		BufferedImage slashImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = slashImage.createGraphics();
		AffineTransform oldtrans = new AffineTransform();
	    AffineTransform trans = new AffineTransform();
	    trans.setToIdentity();
	    trans.rotate(rotation, width/2, height/2);
	    //trans.translate(0,0);
	    g.setTransform(trans);
	    g.drawImage(image, 0, 0, width, height, null);
	    trans.setToIdentity();
	    g.setTransform(oldtrans);
	    image = slashImage;
		
	}

	@Override
	Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
