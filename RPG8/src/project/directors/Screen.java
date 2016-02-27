package project.directors;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import project.battles.EnemyAI;
import project.battles.demo.SampleEnemyAI;

public abstract class Screen implements Visible{

	protected Game game;//all screens must be able to reference the Game instance in order to change to a different screen
	BufferedImage screenImage;//what the screen displays
	public static int width;//width
	public static int height;//height
	KeyListener keyListener;//every screen is either itself a KeyListener or contains implementations of KeyListeners (menus)
	
	public Screen(Game game) {
		this.game = game;
		this.width = game.getWindowWidth();
		this.height = game.getWindowHeight();
		screenImage=new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D) screenImage.getGraphics();
		g2.setColor(Color.blue);
		g2.fillRect(0, 0, width, height);
		g2.setColor(Color.black);
//		paintScreen(g2);
	}

	/**
	 * 
	 * @return returns the image of this screen
	 */
	public final BufferedImage getImage() {
		//screenImage is always same dimension, but gets dilated only if the game window size changes
		return screenImage;
	}
	
	public abstract KeyListener getKeyListener();
	
	/**
	 * called by game when this screen is active
	 */
	public final void update(){
		Graphics2D g2 = (Graphics2D) screenImage.getGraphics();
		g2.setColor(Color.white);
		g2.fillRect(0, 0, width, height);
		g2.setColor(Color.black);
		paintScreen(g2);
		EnemyAI.paintArc(g2);
	}
	
	/**
	 * paints the screen
	 */
	public abstract void paintScreen(Graphics2D g2);
	

	
}
