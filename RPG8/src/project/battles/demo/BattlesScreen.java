package project.battles.demo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.geom.Arc2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Timer;

import project.directors.Game;
import project.directors.Screen;
import project.directors.UtilityMethods;
import project.items.Weapon;

public class BattlesScreen extends Screen implements KeyListener,ActionListener, MouseListener{
	static SampleMCharacter char1;
	SampleKEnemy enemy1;
	SampleGEnemy enemy2;
	public static ArrayList<SampleEnemyAI> enemiesOnScreen= new ArrayList<SampleEnemyAI>();
	public static ArrayList<SampleProjectiles> player = new ArrayList<SampleProjectiles>();
	public static ArrayList<SampleProjectiles> enemy = new ArrayList<SampleProjectiles>();
	Timer timer = new Timer(5,this);
	ArrayList<Integer> pressedKeys = new ArrayList<Integer>();
	public static final long MOVE_UNIT = 5;
	public static BufferedImage projectiledemo;
	SampleProjectiles bullet;
	public BattlesScreen(Game game){
		super(game);
		Mainchar1();
		Enemy();
		Weapon();
		Projectile();
		//enemy1 = new SampleKEnemy(new int[6],new Weapon(),true);
		//enemy2 = new SampleGEnemy(new int[6],new Weapon(),true);
		//update();
		//enemy1 = new SampleKEnemy(new int[6],new Weapon(),true);
		//enemy2 = new SampleGEnemy(new int[6],new Weapon(),true);
		enemiesOnScreen.add(enemy1);
		enemiesOnScreen.add(enemy2);
		update();
	}
	public void Mainchar1(){
		/**
		 * 
		 * @ Author: Chieh-Huang Chen
		 * 
		 */
		BufferedImage [][] animation = new BufferedImage [4][3];
//		BufferedImage walk1 = null;
//		BufferedImage walk2 = null;
//		BufferedImage walk3 = null;
		BufferedImage origimage0 = UtilityMethods.getImageFromFile(this, "/maincharacter/mback1.png");
		BufferedImage origimage1 = UtilityMethods.getImageFromFile(this, "/maincharacter/mback2.png");
		BufferedImage origimage2 = UtilityMethods.getImageFromFile(this, "/maincharacter/mback3.png");
		//scale each image
		//walk1=UtilityMethods.getScaledImage(origimage0,100,SPRITE_HEIGHT);
		//walk2=UtilityMethods.getScaledImage(origimage1,90,SPRITE_HEIGHT);
		//walk3=UtilityMethods.getScaledImage(origimage2,90,SPRITE_HEIGHT);
		animation[0] = UtilityMethods.addImage(origimage0,origimage1,origimage2);
		origimage0 = UtilityMethods.getImageFromFile(this, "/maincharacter/mfront1.png");
		origimage1 = UtilityMethods.getImageFromFile(this, "/maincharacter/mfront2.png");
		origimage2 = UtilityMethods.getImageFromFile(this, "/maincharacter/mfront3.png");
		animation[1] = UtilityMethods.addImage(origimage0,origimage1,origimage2);
		origimage0 = UtilityMethods.getImageFromFile(this, "/maincharacter/mleft1.png");
		origimage1 = UtilityMethods.getImageFromFile(this, "/maincharacter/mleft2.png");
		origimage2 = UtilityMethods.getImageFromFile(this, "/maincharacter/mleft3.png");
		animation[2] = UtilityMethods.addImage(origimage0,origimage1,origimage2);
		origimage0 = UtilityMethods.getImageFromFile(this, "/maincharacter/mright1.png");
		origimage1 = UtilityMethods.getImageFromFile(this, "/maincharacter/mright2.png");
		origimage2 = UtilityMethods.getImageFromFile(this, "/maincharacter/mright3.png");
		animation[3] = UtilityMethods.addImage(origimage0,origimage1,origimage2);
		char1 =  new SampleMCharacter(animation,100,100,100,100);
	}
	public void Enemy(){
		BufferedImage [][] animation = new BufferedImage [4][3];
		BufferedImage origimage0 = UtilityMethods.getImageFromFile(this, "/enemy/eback1.png");
		BufferedImage origimage1 = UtilityMethods.getImageFromFile(this, "/enemy/eback2.png");
		BufferedImage origimage2 = UtilityMethods.getImageFromFile(this, "/enemy/eback3.png");
		animation[0] = UtilityMethods.addImage(origimage0,origimage1,origimage2);
		origimage0 = UtilityMethods.getImageFromFile(this, "/enemy/efront1.png");
		origimage1 = UtilityMethods.getImageFromFile(this, "/enemy/efront2.png");
		origimage2 = UtilityMethods.getImageFromFile(this, "/enemy/efront3.png");
		animation[1] = UtilityMethods.addImage(origimage0,origimage1,origimage2);
		origimage0 = UtilityMethods.getImageFromFile(this, "/enemy/eleft1.png");
		origimage1 = UtilityMethods.getImageFromFile(this, "/enemy/eleft2.png");
		origimage2 = UtilityMethods.getImageFromFile(this, "/enemy/eleft3.png");
		animation[2] = UtilityMethods.addImage(origimage0,origimage1,origimage2);
		origimage0 = UtilityMethods.getImageFromFile(this, "/enemy/eright1.png");
		origimage1 = UtilityMethods.getImageFromFile(this, "/enemy/eright2.png");
		origimage2 = UtilityMethods.getImageFromFile(this, "/enemy/eright3.png");
		animation[3] = UtilityMethods.addImage(origimage0,origimage1,origimage2);
		enemy1 = new SampleGEnemy(animation,100,100,100,100);
		enemy2 = new SampleKEnemy(animation,100,100,100,100);
	}
	public void Weapon(){
		
	}
	public void Projectile(){
		projectiledemo = UtilityMethods.getImageFromFile(this, "/images/items/bullet.png");
		bullet = new SampleProjectiles(10, 10, 0, 10, 10, 100, projectiledemo);
	}
	@Override
	public void paintScreen(Graphics2D g2) {
		// TODO Auto-generated method stub
		checkMotion();
		g2.setColor(Color.white);
		g2.fillRect(0, 0, width, height);
		g2.setColor(Color.black);
		try{
			g2.drawString("Battles Team's Demo", 100, 100);
			g2.setColor(Color.green);
			timer.start();
			g2.drawImage(char1.getImage(count),char1.getPositionX(),char1.getPositionY(),null);
			g2.drawImage(bullet.getpImgSrc(), 100, 100, null);
			
			for(int i = 0; i < player.size(); i++){
				g2.drawImage(player.get(i).getpImgSrc(), player.get(i).getX(), player.get(i).getY(), null);
			}
			for(int i = 0; i < enemy.size(); i++){
				g2.drawImage(enemy.get(i).getpImgSrc(), enemy.get(i).getX(), enemy.get(i).getY(), null);
			}
		}
		catch(Exception e){
			
		}
	}
	@Override
	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_LEFT){
			if(!pressedKeys.contains(keyCode))
				pressedKeys.add(keyCode);
		}
		if(!pressedKeys.isEmpty()){
			char1.setWalking(true);
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_UP){
			pressedKeys.remove(pressedKeys.indexOf(keyCode));
			char1.setMoveUp(false);
		}
		if(keyCode == KeyEvent.VK_DOWN){
			pressedKeys.remove(pressedKeys.indexOf(keyCode));
			char1.setMoveDown(false);
		}
		if(keyCode == KeyEvent.VK_LEFT){
			pressedKeys.remove(pressedKeys.indexOf(keyCode));
			char1.setMoveLeft(false);
		}
		if(keyCode == KeyEvent.VK_RIGHT){
			pressedKeys.remove(pressedKeys.indexOf(keyCode));
			char1.setMoveRight(false);
		}
		if(pressedKeys.isEmpty())
			char1.setWalking(false);
	}
	
	public void increaseCount(){
		count++;
		if(count>10)
			count=0;
	}
	public void checkMotion() {
		Graphics2D g = null;
		if(pressedKeys == null)
			 return;
		 int proposedNewY=char1.getPositionY();
		 int proposedNewX=char1.getPositionX();
		 if(pressedKeys.contains(KeyEvent.VK_UP) && !pressedKeys.contains(KeyEvent.VK_DOWN)){
			 proposedNewY-=MOVE_UNIT;
			 char1.setPositionY(proposedNewY);
			 increaseCount();
			 char1.setMoveUp(true);
		 }
		 if(!pressedKeys.contains(KeyEvent.VK_UP) && pressedKeys.contains(KeyEvent.VK_DOWN)){
			 proposedNewY+=MOVE_UNIT;
			 char1.setPositionY(proposedNewY);
			 increaseCount();
			 char1.setMoveDown(true);
		 }
		 if(pressedKeys.contains(KeyEvent.VK_RIGHT) && !pressedKeys.contains(KeyEvent.VK_LEFT)){
			 proposedNewX+=MOVE_UNIT;
			 char1.setPositionX(proposedNewX);
			 increaseCount();
			 char1.setMoveRight(true);
		 }
		 if(!pressedKeys.contains(KeyEvent.VK_RIGHT) && pressedKeys.contains(KeyEvent.VK_LEFT)){
			 proposedNewX-=MOVE_UNIT;
			 char1.setPositionX(proposedNewX);
			 increaseCount();
			 char1.setMoveLeft(true);
		 }

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub/
		for(int i=0;i<player.size();i++){
			player.get(i).updatePosition();//.fly(); what in the world is fly
		}
		for(int i=0;i<enemy.size();i++){
			enemy.get(i).updatePosition();//.fly();
		}
		update();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {//Jason Lyan
		if(e.getButton() == MouseEvent.BUTTON1){
			char1.firePistol(10,10);
		}
		
	}
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
