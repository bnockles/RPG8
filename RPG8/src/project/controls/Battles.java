package project.controls;

import java.awt.Graphics2D;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import project.directors.Game;
import project.directors.Screen;

public class Battles extends Screen implements BattlesControls{
	BufferedImage landscape
	public Battles(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}
		public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void moveUp() {
		// TODO Auto-generated method stub
		y-=5;
	}
	public void moveDown() {
		// TODO Auto-generated method stub
		y+=5;
	}
	public void moveRight() {
		// TODO Auto-generated method stub
		x+=5;
	}
	public void moveLeft() {
		// TODO Auto-generated method stub
		x-=5;
	}
	@Override
	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void paintScreen(Graphics2D g2) {
		// TODO Auto-generated method stub
		
	}
	
}
