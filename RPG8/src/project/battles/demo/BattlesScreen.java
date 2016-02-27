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
	/**
	 * ***********CHANGES! MUST READ********************
	 * VARIABLE CHANGES:
	 * 		- char1 -> character
	 * 		- positionX -> x
	 * 		- positionY -> y
	 * 		
	 */
	static SampleMCharacter character;
	public static SampleKEnemy enemy1;
	SampleGEnemy enemy2;
	public static ArrayList<SampleEnemyAI> enemiesOnScreen= new ArrayList<SampleEnemyAI>();
	public static ArrayList<SampleProjectiles> player = new ArrayList<SampleProjectiles>();
	public static ArrayList<SampleProjectiles> enemy = new ArrayList<SampleProjectiles>();
	Timer timer = new Timer(5,this);
	ArrayList<Integer> pressedKeys = new ArrayList<Integer>();
	public static final long MOVE_UNIT = 5;
	public static final int PPOSITION_X = 300;
	public static final int PPOSITION_Y = 300;
	public static final int EPOSITION_X = 100;
	public static final int EPOSITION_Y = 100;
	public static BufferedImage projectiledemo;
	SampleProjectiles bullet;
	public int[] enemystats = {100,100,100,100,};
	public BattlesScreen(Game game){
		super(game);
		MainCharacter();
		Enemy();
		Weapon();
		Projectile();
		enemiesOnScreen.add(enemy1);
		enemiesOnScreen.add(enemy2);
		update();
	}
	public void MainCharacter(){
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
		character =  new SampleMCharacter(animation,100,100,100,100,PPOSITION_X,PPOSITION_Y);
	}
	public void Enemy(){
		/**
		 * Chieh-Huang Chen
		 */
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
		enemy1 = new SampleKEnemy(animation,enemystats, new SampleWeapon(), EPOSITION_X, EPOSITION_Y);
//		enemy1.GeneralEnemyAI();
		enemy2 = new SampleGEnemy(animation,enemystats, new SampleWeapon(), EPOSITION_X, EPOSITION_Y);
	}
	public void Weapon(){
 
	}
	public void Projectile(){
		projectiledemo = UtilityMethods.getImageFromFile(this, "/images/items/bullet.png");
		bullet = new SampleProjectiles(10, 10, 0, 10, 10, 100, projectiledemo);
	}
	@Override
	public void paintScreen(Graphics2D g2) {
		/**
		 * Chieh-Huang Chen
		 */
		// TODO Auto-generated method stub
		checkMotion();
		enemy1.GeneralEnemyAI();
		checkProjectileRange();
		g2.setColor(Color.white);
		g2.fillRect(0, 0, width, height);
		g2.setColor(Color.black);
		try{
			g2.drawString("Battles Team's Demo", 100, 100);
			g2.setColor(Color.green);
			timer.start();
			//System.out.println(char1.getPositionY());
			g2.drawImage(character.getImage(),character.getX(),character.getY(),null);
			g2.drawImage(bullet.getpImgSrc(), 100, 100, null);
			g2.drawImage(enemy1.getImage(),enemy1.getX(),enemy1.getY(),null);
			//g2.drawImage(enemy2.getImage(count),enemy2.getPositionX(),enemy2.getPositionY(),null);
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
	private void checkProjectileRange() {
		/**
		 * Jason Lyan
		 */
		for(int i = player.size() - 1 ; i > -1; i--){
			if(player.get(i).isCollided()){
				player.remove(i);
			}
		}
	}


	@Override
	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		/**
		 * Chieh-Huang Chen
		 */
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_LEFT){
			if(!pressedKeys.contains(keyCode))
				pressedKeys.add(keyCode);
		}
		if(!pressedKeys.isEmpty()){
			character.setWalking(true);
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		/**
		 * Chieh-Huang Chen
		 */
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_UP){
			pressedKeys.remove(pressedKeys.indexOf(keyCode));
			character.setMoveUp(false);
		}
		if(keyCode == KeyEvent.VK_DOWN){
			pressedKeys.remove(pressedKeys.indexOf(keyCode));
			character.setMoveDown(false);
		}
		if(keyCode == KeyEvent.VK_LEFT){
			pressedKeys.remove(pressedKeys.indexOf(keyCode));
			character.setMoveLeft(false);
		}
		if(keyCode == KeyEvent.VK_RIGHT){
			pressedKeys.remove(pressedKeys.indexOf(keyCode));
			character.setMoveRight(false);
		}
		if(pressedKeys.isEmpty())
			character.setWalking(false);
	}
	public void checkMotion() {
		/**
		 * Chieh-Huang Chen
		 */
		Graphics2D g = null;
		if(pressedKeys == null)
			return;
		int proposedNewY=character.getY();
		int proposedNewX=character.getX();
		if(pressedKeys.contains(KeyEvent.VK_UP) && !pressedKeys.contains(KeyEvent.VK_DOWN)){
			proposedNewY-=MOVE_UNIT;
			character.setY(proposedNewY);
			character.increaseCount();
			character.setMoveUp(true);
		}
		if(!pressedKeys.contains(KeyEvent.VK_UP) && pressedKeys.contains(KeyEvent.VK_DOWN)){
			proposedNewY+=MOVE_UNIT;
			character.setY(proposedNewY);
			character.increaseCount();
			character.setMoveDown(true);
		}
		if(pressedKeys.contains(KeyEvent.VK_RIGHT) && !pressedKeys.contains(KeyEvent.VK_LEFT)){
			proposedNewX+=MOVE_UNIT;
			character.setX(proposedNewX);
			character.increaseCount();
			character.setMoveRight(true);
		}
		if(!pressedKeys.contains(KeyEvent.VK_RIGHT) && pressedKeys.contains(KeyEvent.VK_LEFT)){
			proposedNewX-=MOVE_UNIT;
			character.setX(proposedNewX);
			character.increaseCount();
			character.setMoveLeft(true);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	public int calculateVComponentPlayerToCursor(int velocityScalar, int cursorX, int cursorY, boolean isX){
		/**
		 * Melvin
		 */
		int x = character.getX();
		int y = character.getY();
		/*System.out.println("1: " + (Math.atan2(-193,372)));
		System.out.println("2: " + (int) (velocityScalar*(Math.cos(Math.atan2((y-cursorY),(cursorX - x))))));
		System.out.println("3: " + cursorX + " " + cursorY);
		System.out.println("4: " + x + " " + y);
		System.out.println("5: " + velocityScalar*(Math.cos(Math.atan2((y-cursorY),(cursorX - x)))));
		System.out.println("6: " + velocityScalar*(Math.sin(Math.atan2((y-cursorY),(cursorX - x)))));*/
		if(isX)return (int) (velocityScalar*(Math.cos(Math.atan2((cursorY-y),(cursorX - x)))));
		return (int) (velocityScalar*(Math.sin(Math.atan2((cursorY-y),(cursorX - x)))));
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * Chieh-Huang Chen
		 */
		// TODO Auto-generated method stub/
		for(int i=0;i<player.size();i++){
			player.get(i).updateAndCheckAll();
		}
		for(int i=0;i<enemy.size();i++){
			enemy.get(i).updateAndCheckAll();
		}
		update();
	}

	@Override
	public void mousePressed(MouseEvent e) {//Jason Lyan
		if(e.getButton() == MouseEvent.BUTTON1){
			int cursorX = e.getX();
			int cursorY = e.getY();
			int vx = calculateVComponentPlayerToCursor(10, cursorX, cursorY, true);
			int vy = calculateVComponentPlayerToCursor(10, cursorX, cursorY, false);
			character.firePistol(vx,vy);
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
