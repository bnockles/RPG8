package project.mainmenudemo;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import project.directors.Game;
import project.directors.Screen;

import java.awt.*;
import java.applet.*;

import java.awt.*;
import java.applet.*;

public class MainMenuScreen extends Screen implements KeyListener{

	public static String gameTitle = "Cyborg Exodus";
	
	ArrayList<MainMenuSelectables> options; 
	// I will add the pictures of the characters once the
	//character group has chosen them
	
	public static int selected;
	
	public MainMenuScreen(Game game) {
		super(game);
		
		new MainMenuSelection();
		selected=1;
		this.options = new ArrayList<MainMenuSelectables>();
		options.add(new MainMenuSelectables("New Game"));
		options.add(new MainMenuSelectables("Load Game"));
		options.add(new MainMenuSelectables("Settings"));
		options.add(new MainMenuSelectables("Help"));
	
		//adds the 4 selections. This will be private once the game is done
		//however until I know these are the final options of the main menu
		//I will leave it public 
		
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()== KeyEvent.VK_DOWN){
			playSound(new File("resources/button-19.wav"));
			selected ++;
			if(selected>4) selected=1;
			update();
		}
		if(e.getKeyCode()== KeyEvent.VK_UP){
			playSound(new File("resources/button-19.wav"));
			selected --;
			if(selected<1) selected=4;
			update();
			
		}
		if(e.getKeyCode()== KeyEvent.VK_SPACE){
			//when I have the options from other groups I will 
			//update what the spacebar does
		}
		
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
		return this;
	}

	@Override
	public void paintScreen(Graphics2D g2) {
		g2.setColor(Color.white);
		g2.fillRect(0, 0, width, height);
		
		g2.setColor(Color.black);
		
		BufferedImage imgr = null;
		try {
		    imgr = ImageIO.read(new File("resources/samusr.jpg"));
		} catch (IOException e) {
		}
		BufferedImage imgl = null;
		try {
		    imgl = ImageIO.read(new File("resources/samusl.jpg"));
		} catch (IOException e) {
		}
		g2.drawImage(imgr, 10, 330, 290, 412, null);
		g2.drawImage(imgl, 700, 330, 290, 412, null);
		
		g2.fillRect(125,50, 750,200);
		g2.fillRect(312, 280, 375,100);
		g2.fillRect(312, 400, 375,100);
		g2.fillRect(312, 520, 375,100);
		g2.fillRect(312, 640, 375,100);
		
		
		int x=308;
		int y=0;
		int h=108;
		int w=383;
		if(selected ==1) y=276;
		if(selected ==2) y=396;
		if(selected ==3) y=516;
		if(selected ==4) y=636;
		g2.setColor(Color.darkGray);
		g2.fillRect(x,y,w,h);
		//pictures
		//g2.fillRect(62, 330, 187,412);
		//g2.fillRect(750, 330, 187,412);
		
		
		Font times = new Font ("TimesRoman", Font.CENTER_BASELINE, 60);
		Font subTimes = new Font ("TimesRoman", Font.ROMAN_BASELINE, 50);
		g2.setFont(times);
		g2.setColor(Color.white);
		g2.drawString(gameTitle, 310,165);
		g2.setFont(subTimes);
		g2.drawString(options.get(0).name, 395, 350);
		g2.drawString(options.get(1).name, 390, 470);
		g2.drawString(options.get(2).name, 420, 590);
		g2.drawString(options.get(3).name, 450, 710);
		
	}
	
	 public void playSound(File soundName)
	    {
	      try 
	      {
	       AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundName.getAbsoluteFile( ));
	       Clip clip = AudioSystem.getClip( );
	       clip.open(audioInputStream);
	       clip.start( );
	      }
	      catch(Exception ex)
	      {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace( );
	      }
	    }

}
