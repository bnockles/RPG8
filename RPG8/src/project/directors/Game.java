
package project.directors;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.Timer;

import project.overworld.DemoOverworld;
import project.save.ItemState;
import project.save.SaveFile;



/**
 * 
 * @author bnockles
 * @date January 2016
 */

public class Game extends JFrame{


	/**
	 * 
	 */
	private static final long serialVersionUID = -1357293344654297721L;
	private int windowWidth = 1000;
	private int windowHeight = 800;
	//the active Screen is the screen that is currently being updated and shown
	private Screen activeScreen;
	private SaveFile openGame;

	//the states of the following screens should be preserved even when they are not being shown
//	private Screen overWorldScreen;
//	private Screen battleScreen;
//	private Screen pauseScreen;

	public static void main(String[] args) {
		new Game();
	}

	/**
	 * creates an instance of the Game and displays the screen
	 */
	private Game() {
		applySettings();
		setVisible(true);
		reset();
		Timer timer = new Timer(30, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				activeScreen.update();
				Game.this.repaint();
			}
		});
		timer.start();
	}

	private void applySettings() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int monitorWidth = (int) screenSize.getWidth();
		int monitorHeight = (int) screenSize.getHeight();
		windowWidth = 1000;
		windowHeight = 800;
		setSize(windowWidth,windowHeight);
		setLocation((monitorWidth-windowWidth)/2, (monitorHeight-windowHeight)/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//so that the game terminates after the windo is closed
		setUndecorated(false);//windowBar
		setResizable(true);
	}

	public void reset() {
		StartScreen startScreen = new StartScreen(this);
		setScreen(startScreen);
		activeScreen.update();
		repaint();
	}

	public void paint(Graphics g){
		//sets image to current windowWidth/height
		int width = this.getContentPane().getWidth();
		int height = this.getContentPane().getHeight();
		BufferedImage bi = new BufferedImage(width, height+20, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D) bi.getGraphics();
		g2.setColor(Color.black);
		g2.fillRect(0, 20, this.getContentPane().getWidth(), this.getContentPane().getHeight());
		if(activeScreen!=null){
			BufferedImage before = activeScreen.getScreenImage();
			int w = before.getWidth();
			int h = before.getHeight();
			g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			double windowWHRatio = (double)width/(double)height;
			double imageWHRatio = (double)w/(double)h;
			if(windowWHRatio<imageWHRatio) {
				int newHeight = (int)(((double)width*h)/w);
				g2.drawImage(before, 0, (height-newHeight)/2, width,newHeight+(height-newHeight)/2, 0, 0, w, h, null);
			}
			else {
				int newWidth = (int)(((double)w*height)/h);
				g2.drawImage(before,(width-newWidth)/2, 0, newWidth+(width-newWidth)/2, height, 0, 0, w, h, null);
			}
		}
		g.drawImage(bi, 0, 0, null);

	}

	public void setScreen(Screen screen) {
		try{
			removeKeyListener(activeScreen.getKeyListener());
		}catch(NullPointerException e){
			//will not remove a listener when first initialized
		}
		activeScreen=screen;
		addKeyListener(screen.getKeyListener());
	}

	public int getWindowWidth() {
		return windowWidth;
	}

	public int getWindowHeight() {
		return windowHeight;
	}

	public void loadGame(String fileLocation){
		String line = null;
		BufferedReader txtReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(fileLocation)));
		String rawSaveText="";
		try {
			while((line = txtReader.readLine()) != null) {
				rawSaveText+=line;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}   
		openGame = new SaveFile(rawSaveText);
	}
	
	public SaveFile getSaveFile(){
		return openGame;
	}
	
	public boolean save(DemoOverworld overworld) {
		ItemState i = openGame.getItemState();
		i.setPotionCollected(overworld.isPotionCollected());
		openGame.setOverWorldX(overworld.getSpriteX());
		openGame.setOverWorldY(overworld.getSpriteY());
		return openGame.save();
	}






}
