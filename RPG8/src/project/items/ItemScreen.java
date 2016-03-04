package project.items;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import project.directors.Game;
import project.directors.Screen;

public class ItemScreen extends Screen implements KeyListener,ItemResources{
	TargetDemo you = new TargetDemo(100, Rifles[1],incendiaryGrenadeAmmo,0,0);
	
	BufferedImage weaponEquiped;
	int color=1;
	BufferedImage reG;
	BufferedImage enG;
	BufferedImage melee;
	BufferedImage pistol;
	BufferedImage rifle;
	BufferedImage heavy;
	BufferedImage smg;
	BufferedImage explosive;
	
	
	
	public ItemScreen(Game game) {
		super(game);
		createImages();
		// TODO Auto-generated constructor stub
	}

	@Override
	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return this;
	}

	public void createImages() {
		URL reGurl = getClass().getResource("/images/items/handgunStill.png");
		URL enGurl = getClass().getResource("/images/items/energyGun.png");
		URL rifleurl = getClass().getResource(Rifles[1].getGunImage());

		try {
			reG = ImageIO.read(reGurl);
			enG = ImageIO.read(enGurl);
			rifle = ImageIO.read(rifleurl);
			weaponEquiped = rifle;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void drawWeapon(BufferedImage pic, Graphics2D g2, int color){

		if(color==1)g2.setColor(Color.blue);
		if(color==2)g2.setColor(Color.green);
		if(color==3)g2.setColor(Color.yellow);
		if(color==4)g2.setColor(Color.black);
		if(color==5)g2.setColor(Color.orange);
		if(color==6)g2.setColor(Color.red);
		//System.out.println(pic.getWidth());
		//g2.drawRect(265, 495, pic.getWidth()+60, pic.getHeight()+60);
		g2.fillRect(265, 495, pic.getWidth()+60, pic.getHeight()+60);
	
		g2.drawImage(pic, 295, 525, pic.getWidth(), pic.getHeight(), null);			
	}
	
	@Override
	public void paintScreen(Graphics2D g2) {
		Font tr=new Font("TimesRoman", Font.PLAIN, 28);
		g2.setFont(tr);
		g2.setColor(Color.white);
		g2.fillRect(0, 0, width, height);
		g2.setColor(Color.green);
		g2.fillRect(30, 90, you.health, 20);
		g2.setColor(Color.black);
		g2.drawString("You", 30, 70);
		g2.drawRect(30,90,100,20);
		g2.drawString("Health: "+you.health+"/100", 400, 70);
		g2.drawString("Press E to heal", 30, 135);
		g2.drawString("Press S to take damage", 30, 160);
		g2.drawString("Press R to reload", 30, 185);
		g2.drawString("Press H to switch weapons", 30, 210);
		g2.drawString("Clips: "+you.weapon.getAmmoCapacity(), 400, 135);
		g2.drawString("Ammo in Clip: "+you.weapon.getAmmoTotal(), 400, 160);
		g2.drawString("Current Weapon: "+you.weapon.getName(), 400, 185);
		g2.drawString("Coins: "+you.coins, 400, 210);
		g2.drawString("Scrap: "+you.scrap, 400, 235);
		g2.drawOval(50, 250, 40, 40);
		g2.drawLine(70,290,70,330);
		g2.drawLine(70,290,50,310);
		g2.drawLine(70,290,90,310);
		g2.drawLine(70,330,50,350);
		g2.drawLine(70,330,90,350);
		drawWeapon(weaponEquiped, g2,color);
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_E){
			System.out.println(you.health);
			smallkit.giveHealth(you);
			System.out.println(you.health);
		}
		if(e.getKeyCode()==KeyEvent.VK_1){
			you.weapon = Melee[0];
			weaponEquiped = melee;
			color=1;
		}
		if(e.getKeyCode()==KeyEvent.VK_2){
			you.weapon = Pistol[0];
			weaponEquiped = pistol;
			color=2;
		}
		if(e.getKeyCode()==KeyEvent.VK_3){
			you.weapon = Rifles[1];
			weaponEquiped = rifle;
			color=3;
		}
		if(e.getKeyCode()==KeyEvent.VK_4){
			you.weapon = Heavy[0];
			weaponEquiped = heavy;
			color=4;
		}
		if(e.getKeyCode()==KeyEvent.VK_5){
			you.weapon = SMG[0];
			weaponEquiped = smg;
			color=5;
		}
		if(e.getKeyCode()==KeyEvent.VK_6){
			you.weapon = Explosives[0];
			weaponEquiped = explosive;
			color=6;
		}
		if(e.getKeyCode() == KeyEvent.VK_R){ 
			you.reload();
		}
		if(e.getKeyCode()==KeyEvent.VK_S){
			if(you.health>0){
				you.attack(you);
				if(you.weapon.getAmmoTotal()>0){
					you.coins+=10;
					you.scrap+=1;
					
				}
			}
//			if((int)(Math.random()*100+1)<45){
//				target.attack(you);
//			}
		}
		update();
		game.repaint();
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
