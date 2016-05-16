package project.items.UselessDemos;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import project.directors.Game;
import project.directors.Screen;
import project.items.ItemResources;

public class WeaponsScreen  extends Screen implements KeyListener, ItemResources{
	
	int regAmmoRemaining = rifles1GradeC1.getAmmoClip();
	int engAmmoRemaining = rifles3GradeA2.getAmmoClip();
	int x=100;
	int y=500;
	//fef
	ArrayList<Integer> pressedKeys;
	BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
	Graphics2D g2 = (Graphics2D) image.getGraphics();
	
	BufferedImage reGStill;
	BufferedImage enG;
	BufferedImage reGun;
	BufferedImage enGun;

	public void createImages() {
		URL M4Pic = getClass().getResource("/images/items/M4A1.png");
		URL NGPic = getClass().getResource("/images/items/NGM4.png");
		try {
			reGun = ImageIO.read(M4Pic);
			enGun = ImageIO.read(NGPic);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public WeaponsScreen(Game game) {
		super(game);
		if(regAmmoRemaining <=0)regAmmoRemaining =0;
		if(engAmmoRemaining <=0)engAmmoRemaining =0;
		updatePics();
	}

	@Override
	public KeyListener getKeyListener() {
		return this;
	}

	@Override
	public void paintScreen(Graphics2D g2) {
		createImages();
		g2.drawString("Press S to shoot the gun and press D to shoot energy gun.", 100, 100);
		g2.drawString(rifles1GradeC1.getName() + "Damage: " +  rifles1GradeC1.getDamage() + " Cost: $" + rifles1GradeC1.getCost(), 500, 235);
		g2.drawString(" [Ammo:" + regAmmoRemaining + "/" + rifles1GradeC1.getAmmoCapacity() + "]", 500, 250);
		g2.drawString(rifles3GradeA2.getName() + "Damage: " +  rifles3GradeA2.getDamage() + " Cost: $" + rifles3GradeA2.getCost(), 500, 435);
		g2.drawString(" [Ammo:" + engAmmoRemaining + "/" + rifles3GradeA2.getAmmoCapacity() + "]", 500, 450);
		
		
		g2.drawImage(reGun, 200, 200, reGun.getWidth(), reGun.getHeight(), null);
		g2.drawImage(enGun, 200, 400, enGun.getWidth(), enGun.getHeight(), null);

	}

	@Override
	public synchronized void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		//check if an arrow key is pressed and add it to pressedKeys if it is
		if(keyCode == KeyEvent.VK_S){ 
			regAmmoRemaining -=1;
		}
		else if(keyCode == KeyEvent.VK_D){
			engAmmoRemaining -=1;
		}
		if(engAmmoRemaining<=0){
			engAmmoRemaining=0;
		}
		if(regAmmoRemaining<=0){
			regAmmoRemaining=0;	
		}
		//if pressing keys should change the graphics, call update()
		updatePics();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
	
	public final void updatePics(){
		Graphics2D g2 = (Graphics2D)image.getGraphics();
		paintScreen(g2);
	}
	

}