package project.overworld;

import javax.swing.*;

import project.directors.Game;
import project.directors.Screen;
import project.directors.StartScreen;
import project.overworld.Obstacle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class MapDemonstration extends Game {

	public static void main(String[] args){
		new MapDemonstration();
	}
	public MapDemonstration(){
		super();
	}
	public void reset() {
		MapDemoScreen MapDemoScreen = new MapDemoScreen(this);
		setScreen(MapDemoScreen);
	}
//	Boundaries barrel;
//
//	public MapDemonstration(){
//		
//		setBounds(30, 30, 900, 900);
//		setVisible(true);
//		barrel = new Boundaries("B", 10, 10, 500, 500, "/images/Map/barrelblue.jpg",false);
//		System.out.println(barrel.getxPos());
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//	}
//	public static void main(String[] args) {
//		new MapDemonstration();
//		//update();
//	}
//	
//	@Override
//	public void paint(Graphics g) {
//		BufferedImage image = new BufferedImage(900, 900,
//				BufferedImage.TYPE_INT_ARGB);
//		Graphics2D g2 = (Graphics2D) image.getGraphics();
//		g2.setColor(Color.white);
//		g2.fillRect(0, 0, 900, 900);
//		g2.setColor(Color.black);
//		try{
//			g2.drawString(barrel.getName(),30,30);
//		}
//		catch (NullPointerException e){
//			System.out.println("767");
//		}
//		//g2.drawImage(barrel.getImage(),barrel.getxPos(),barrel.getyPos(),null);
//	
//	}

	
	
}
