package project.story;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import project.directors.Game;

@SuppressWarnings("serial")
public class storyDemo extends Game{
	private Image landscape;
	final static ArrayList<String> AyaForward = new ArrayList<String>();
	private static String forward = "/images/heroes/sForward.png";
	private static String forward1 = "/images/heroes/forward1.png";
	private static String forward2 = "/images/heroes/forward2.png";
	final static ArrayList<String> AyaLeft = new ArrayList<String>();
	private static String left = "/images/heroes/sLeft.png";
	private static String left1 = "/images/heroes/left1.png";
	private static String left2 = "/images/heroes/left2.png";
	final static ArrayList<String> AyaRight = new ArrayList<String>();
	private static String right = "/images/heroes/sRight.png";
	private static String right1 = "/images/heroes/right1.png";
	private static String right2 = "/images/heroes/right2.png";
	final static ArrayList<String> AyaBack = new ArrayList<String>();
	private static String back = "/images/heroes/sBack.png";
	private static String back1 = "/images/heroes/back1.png";
	private static String back2 = "/images/heroes/back2.png";
	final static ArrayList<String> AyaStanding = new ArrayList<String>();
	public static Hero Aya = new Hero("Aya Drevis", 100, 100);
	
	public static void main(String args[]){
		new storyDemo();
		
	}

	public storyDemo(){
		super();
		AyaForward.add(forward1);
		AyaForward.add(forward2);
		AyaLeft.add(left1);
		AyaLeft.add(left2);
		AyaRight.add(right1);
		AyaRight.add(right2);
		AyaBack.add(back1);
		AyaBack.add(back2);
		AyaStanding.add(forward);
		AyaStanding.add(left);
		AyaStanding.add(right);
		AyaStanding.add(back);
//		for(int i = 0; i < AyaForward.size(); i ++){
//			storyDemo.Aya.animate(AyaForward.get(i));
//		}
		Aya = new Hero("Aya Drevis", 100, 100);
		Aya.animate(AyaStanding.get(0));
		
	}
	
	public void reset(){
		storyScreen screen = new storyScreen(this);
		setScreen(screen);
		repaint();
	}
	
	@SuppressWarnings("unused")
	public void paint(Graphics g){
		//sets image to current windowWidth/height
		int width = 600;
		int height = 600;
		setSize(width, height);
		BufferedImage bi = new BufferedImage(width, height+20, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.black);
		g2.fillRect(0, 0, width, height);
		g2.drawImage(landscape, 0, 0, null);
		g2.drawImage(Aya.getImage(), Aya.getX(), Aya.getY(), null);
	}
	
	
}
