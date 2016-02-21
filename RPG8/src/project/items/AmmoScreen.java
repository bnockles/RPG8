package project.items;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;

import project.directors.Game;
import project.directors.Screen;

public class AmmoScreen extends Screen implements KeyListener {

	int regAmmoRemaining =100;
	int engAmmoRemaining =100;
	int x=100;
	int y=500;
	ArrayList<Integer> pressedKeys;
	BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
	Graphics2D g2 = (Graphics2D) image.getGraphics();

	//BufferedImage[] images = new BufferedImage[7];
	//BufferedImage reG;
	BufferedImage reGStill;
	BufferedImage enG;
	//BufferedImage enGShoot;
	BufferedImage reGA;
	BufferedImage enGA;
	//BufferedImage sprite;
//	images[0] = reG;
//	images[1] = reGStill;
//	images[2] = enG;
//	images[3] = enGShoot;
//	images[4] = reGA;
//	images[5] = enGA;
//	images[6] = Sprite;
	

	public void createImages() {
		//URL reGurl = getClass().getResource("/images/items/handgunAnimated.gif");
		URL reGStillurl = getClass().getResource("/images/items/handgunStill.png");
		URL enGurl = getClass().getResource("/images/items/energyGun.png");
		//URL enGShooturl = getClass().getResource("/images/items/energyBlast.gif");
		URL reGAurl = getClass().getResource("/images/items/regularAmmoEX.png");
		URL enGAurl = getClass().getResource("/images/items/energyAmmoEX.png");
		//URL spriteurl = getClass().getResource("/images/sprites/standing.png");
		try {
			//reG = ImageIO.read(reGurl);
			reGStill = ImageIO.read(reGStillurl);
			enG = ImageIO.read(enGurl);
			//enGShoot = ImageIO.read(enGShooturl);
			reGA = ImageIO.read(reGAurl);
			enGA = ImageIO.read(enGAurl);
			//sprite = ImageIO.read(spriteurl);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public AmmoScreen(Game game) {
		super(game);
		Timer timer = new Timer();
		TimerTask countDown = new TimerTask(){
			public void run(){
				regAmmoRemaining --;
				engAmmoRemaining --;
				updatePics();
			}
		};
			timer.scheduleAtFixedRate(countDown, 1000, 1000);
			if(regAmmoRemaining <=0)regAmmoRemaining =0;
			if(engAmmoRemaining <=0)engAmmoRemaining =0;
			updatePics();				

		
	}

	@Override
	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public void paintScreen(Graphics2D g2) {
		createImages();
		g2.drawString("Press up to replenish regular ammo and press down to replenish energy ammo.", 100, 100);
		g2.drawString("You have " + regAmmoRemaining + " shots left.", 500, 150);
		g2.drawString("You have " + engAmmoRemaining + " shots left.", 500, 350);
		
		//g2.drawImage(sprite, x, y, sprite.getWidth()/6,sprite.getHeight()/6,null);
		g2.drawImage(reGStill, 500, 200, reGStill.getWidth()/3, reGStill.getHeight()/3, null);			
		g2.drawImage(enG, 450, 225, enG.getWidth(), enG.getHeight(), null);
		
		g2.drawImage(reGA, 200, 210, reGA.getWidth()/2, reGA.getHeight()/2, null);
		g2.drawImage(enGA, 200, 400, enGA.getWidth()/6, enGA.getHeight()/6, null);

	}

	@Override
	public synchronized void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();

		//check if an arrow key is pressed and add it to pressedKeys if it is
		if(keyCode == KeyEvent.VK_UP){ 
			regAmmoRemaining +=5;
			if(regAmmoRemaining>100)regAmmoRemaining=100;
		}else if(keyCode == KeyEvent.VK_DOWN){
			engAmmoRemaining+=5;
			if(engAmmoRemaining>100)engAmmoRemaining=100;
		}
//		else if(keyCode == KeyEvent.VK_RIGHT){
//			x+=5;
//		}
//		else if(keyCode == KeyEvent.VK_LEFT){
//			x-=5;
//		}
		
//		if(Math.abs(x-200)+Math.abs(y-200)<100){
//			regAmmoRemaining+=50;
//			if(regAmmoRemaining>100)regAmmoRemaining=100;
//		}
//		if(Math.abs(x-200)+Math.abs(y-400)<100){
//			engAmmoRemaining+=50;
//			if(engAmmoRemaining>100)engAmmoRemaining=100;
//		}
		//if pressing keys should change the graphics, call update()
		updatePics();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	
	public final void updatePics(){
		//for(int i=0;i<images.length;i++){
			Graphics2D g2 = (Graphics2D)image.getGraphics();
			paintScreen(g2);	
		//}
	}
	

}
