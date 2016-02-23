package project.controls;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import project.directors.Game;
import project.directors.Screen;

public class Shooting extends Screen implements KeyListener{
	private Hero swarm;
	int width=500;
	int height=500;
	BufferedImage landscape;
	public Shooting(Game game) {
		super(game);
		swarm = new Hero ("Swarm", "/Images/yarg/objection.png",0,0);
		Graphics2D g2 = (Graphics2D)landscape.getGraphics();
		paintLandscape(g2);
		setVisible(true);
		setSize(width,height);
		setLocation(200,150);//200 over, 150 down
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//static constant reference for special close operation
		addKeyListener(this)
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
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
