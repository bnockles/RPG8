package project.story;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

import javax.imageio.ImageIO;

public class Hero {

	BufferedImage sprite;
	public String name;
	public int x;
	public int y;
	int width = 30;
	int height = 46;
	boolean zero = true;
	public static int weapon = 10;
	public int strength = 100;
	
	public Hero(String name, int x, int y){
		this.name = name;
		this.x = x;
		this.y = y;
	}	
	
	public void animate(String picLocation){
		URL url = getClass().getResource(picLocation);
		try {		
			sprite = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			BufferedImage original = ImageIO.read(url);
			//draw the image file into a scaled version on the sprite canvas
			Graphics2D g = (Graphics2D) sprite.getGraphics();
			int w = original.getWidth();
			int h = original.getHeight();
			//what to draw, where to start (x and y coords), width of canvas relative to start, height of canvas relative to start,
			//where to start from original (x and y coords), width of original, height, null
			g.drawImage(original, 0, 0, width, height, 0, 0, w, h, null);
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}

	public void setX(int i){
		x = i;
	}
	
	public void setY(int i){
		y = i;
	}
	
	public void moveUp() {
		y = y - 4;
		if(zero)storyDemo.Aya.animate(storyDemo.AyaBack.get(0));
		else{
			storyDemo.Aya.animate(storyDemo.AyaBack.get(1));
		}
		zero = !zero;
	}

	public void moveDown() {
		y = y + 4;
		if(zero)storyDemo.Aya.animate(storyDemo.AyaForward.get(0));
		else{
			storyDemo.Aya.animate(storyDemo.AyaForward.get(1));
		}
		zero = !zero;
	}

	public void moveRight() {
		x = x + 4;
		if(zero)storyDemo.Aya.animate(storyDemo.AyaRight.get(0));
		else{
			storyDemo.Aya.animate(storyDemo.AyaRight.get(1));
		}
		zero = !zero;
	}

	public void moveLeft() {
		x = x - 4;
		if(zero)storyDemo.Aya.animate(storyDemo.AyaLeft.get(0));
		else{
			storyDemo.Aya.animate(storyDemo.AyaLeft.get(1));
		}
		zero = !zero;
	}
	public void randomX() {
		Random random = new Random();
		x +=75; //(random.nextInt(500 - 10 + 1) + 10);
	}
	public void randomY() {
		Random random = new Random();
		y +=75; //(random.nextInt(500 - 10 + 1) + 10);
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public void shoot() {
		if(weapon > 0) {
			weapon--;
			System.out.println("Bang!");
		}
		else{
			System.out.println("No Ammo");
		}
	}
	public void radio() {
		Radio.radioCall();
	}
	
	public BufferedImage getImage(){
		return sprite;
	}
}
