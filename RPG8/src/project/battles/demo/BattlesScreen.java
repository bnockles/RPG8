package project.battles.demo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.geom.Arc2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Timer;

import project.battles.Collision;
import project.battles.EnemyAI;
import project.battles.GEnemy;
import project.battles.KEnemy;
import project.battles.MCharacter;
import project.battles.Projectiles;
import project.directors.Game;
import project.directors.Screen;
import project.directors.UtilityMethods;
import project.items.Weapon;

public class BattlesScreen extends Screen implements ActionListener, KeyListener , MouseListener,MouseMotionListener{
	/**
	 * ***********CHANGES! MUST READ********************
	 * RENAMING: 
	 * 	VARIABLES
	 * 		- char1 -> character
	 * 		- positionX -> x
	 * 		- positionY -> y
	 * 		- enemy1 -> enemyK
	 * 		- enemy2 -> enemyG
	 * 		
	 * 
	 * 	CONSTANTS
	 * 		- MOVE_UNIT -> P_SPEED
	 * 		- PPOSITION_X -> P_X
	 * 		- PPOSITION_Y -> P_Y
	 * 		- EPOSITION_X -> GE_X	GUARDENEMIES
	 * 		- EPOSITION_Y -> GE_Y
	 * 		- EPOSITION_X -> KE_X	KILLONSIGHTENEMIES
	 * 		- EPOSITION_Y -> KE_Y
	 * 
	 * NEW:
	 * 	VARIABLES
	 * 
	 * 	CONSTANTS // too lazy to list all the constants gave up
	 * 		-GE_SPEED	GUARDENEMIES' SPEED
	 * 		-KE_SPEED	KILLENEMIES' SPEED
	 * 		-FPS 1000/TIMER
	 * 		-GE_VISION ENEMIES' VISION RANGE
	 * 		-KE_VISION 
	 * 		-GE_DEGREE ENEMIES' LINE OF SIGHT
	 *		-KE_DEGREE
	 *
	 *
	 * RESPONSIBILITY:
	 * YIFAN - 
	 * 		    
	 *
	 *	
	 */
	
	public static final int P_SPEED = 8;
	public static final int P_X = 300;
	public static final int P_Y = 300;
	public static final int P_HP = 100;
	public static final int P_ARMOR = 100;
	public static final int P_SNEAK = 100;
	public static final int P_RECOVERY = 100;
	public static final int P_EXP = 0;
	public static final int P_STRENGTH = 10;
	public static final int P_LEVEL = 10;
	
	public static final int GE_SPEED = 1;
	public static final int GE_X = 100; //
	public static final int GE_Y = 100;
	public static final int GE_HP = 150;
	public static final int GE_ARMOR = 100;
	public static final int GE_SNEAK = 100;
	public static final int GE_RECOVERY = 10;
	public static final int GE_EXP = 10;
	public static final int GE_STRENGTH = 10;
	public static final int GE_LEVEL = 10;
	public static final int GE_DEGREE = 100;
	public static final int GE_VISION = 300;
	public static final int GE_AWARE = 50;
	
	public static final int KE_SPEED = 1;
	public static final int KE_X = 100;
	public static final int KE_Y = 300;
	public static final int KE_HP = 100;
	public static final int KE_ARMOR = 100;
	public static final int KE_SNEAK = 100;
	public static final int KE_RECOVERY = 10;
	public static final int KE_EXP = 10;
	public static final int KE_STRENGTH = 10;
	public static final int KE_LEVEL = 10;
	public static final int KE_DEGREE = 100;
	public static final int KE_VISION = 300;
	public static final int KE_AWARE = 50;
	
	public static final int FPS = 30;
	
	public static final int W_DMG = 10;
	public static final int W_VELOCITY = 10;
	public static final int W_AMMO = 100;
	public static final int W_RANGE = 100;
	
	public static final int LEFT_RIGHT = 0;
	public static final int UP_DOWN = 1;
	public static final int AROUND = 2;
	public static final int GOTOPLAYER = 3;
	public static final int WANDER = 4;
	
	public static final int GENEMY = 0;
	public static final int KENEMY = 1;
	
	public static final int ENEMYMOVE = AROUND;
	public static final int UP = 1;
	public static final int DOWN = 2;
	public static final int LEFT = 3;
	public static final int RIGHT = 4;
	
	public static MCharacter character;
	public static KEnemy enemy1;
	public static GEnemy enemy2;
	
	public static ArrayList<EnemyAI> enemiesOnScreen= new ArrayList<EnemyAI>();
	public static ArrayList<Collision> pBullets = new ArrayList<Collision>();
	public static ArrayList<Collision> eBullets = new ArrayList<Collision>();
	
	Timer timer = new Timer(FPS,this);
	public static ArrayList<Integer> pressedKeys = new ArrayList<Integer>();
	public static ArrayList<Integer> pressedMouse = new ArrayList<Integer>();
	
	public static BufferedImage projectiledemo;
	public static BufferedImage weapondemo;
	
	Projectiles bullet;
	Weapon weapon;
	Weapon weapon1;
	Weapon weapon2;
	int cursorX;
	int cursorY;
	
	//stats = { 0 X, 1 Y, 2 hp, 3 armor, 4 sneak, 5 speed,6 recovery, 7 exp, 8 strength,9 level}
	public int[] enemyG = {GE_X,GE_Y,GE_HP,GE_ARMOR,GE_SNEAK,GE_SPEED,GE_RECOVERY,GE_EXP,GE_STRENGTH,GE_LEVEL};
	public int[] enemyK = {KE_X,KE_Y,KE_HP,KE_ARMOR,KE_SNEAK,KE_SPEED,KE_RECOVERY,KE_EXP,KE_STRENGTH,KE_LEVEL};
	public int[] visionG = {GE_VISION, GE_DEGREE, GE_AWARE};
	public int[] visionK = {KE_VISION, KE_DEGREE, KE_AWARE};
	public int[] projectilestats = {W_DMG,W_VELOCITY,W_AMMO,W_RANGE};
	public int[] playerstats = {P_X,P_Y,P_HP,P_ARMOR,P_SNEAK,P_SPEED,P_RECOVERY,P_EXP,P_STRENGTH,P_LEVEL};
	public BattlesScreen(Game game){
		super(game);
		Projectile();
		Weapon();
		MainCharacter();
		Enemy();
		//enemiesOnScreen.add(enemy1);
		//enemiesOnScreen.add(enemy2); change the type later
		update();
	}
	public void Projectile(){
		projectiledemo = UtilityMethods.getImageFromFile(this, "/images/items/bullet.png");
		bullet = new Projectiles(10, 10, 0, 10, 10, 100, projectiledemo);
	}
	public void Weapon(){
		 weapondemo = null;
		 BufferedImage [] pics = new BufferedImage [4];
		 weapon = new Weapon(pics,projectiledemo,projectilestats);
		 weapon1 = new Weapon(pics,projectiledemo,projectilestats);
		 weapon2 = new Weapon(pics,projectiledemo,projectilestats);
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
		character =  new MCharacter(animation,playerstats,weapon);
	}
	public BufferedImage[][] Enemy(){
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
		enemy1 = new KEnemy(animation,enemyK,visionK,weapon1,ENEMYMOVE);
		enemy2 = new GEnemy(animation,enemyG, visionG,weapon2,ENEMYMOVE);
		return animation;
	}
	@Override
	public void paintScreen(Graphics2D g2) {
		/**
		 * Chieh-Huang Chen
		 */
		// TODO Auto-generated method stub
		checkMotion();
		checkProjectileRange();
		g2.setColor(Color.white);
		g2.fillRect(0, 0, width, height);
		g2.setColor(Color.black);
		try{
			g2.drawString("Battles Team's Demo", 100, 100);
			g2.setColor(Color.red);
			timer.start();
			g2.drawImage(character.getImage(),character.getX(),character.getY(),null);
			g2.drawImage(bullet.getImage(), 100, 100, null);
			for (EnemyAI a : enemiesOnScreen){
				a.GeneralEnemyAI();
				g2.drawImage(a.getImage(),a.getX(),a.getY(),null);
				g2.setColor(Color.BLACK);
				if(a.getEnemyClass() == BattlesScreen.KENEMY)
					g2.drawString("enemyK", a.getX(), a.getY()+100);
				else
					g2.drawString("enemyG", a.getX(), a.getY()+100);
				g2.draw(getNColorVisionCone(a,g2));
			}
//			g2.drawImage(enemy1.getImage(),enemy1.getX(),enemy1.getY(),null);
//			g2.drawString("enemyK", enemy1.getX(), enemy1.getY()+25);
//			g2.drawImage(enemy2.getImage(),enemy2.getX(),enemy2.getY(),null);
//			g2.drawString("enemyG", enemy2.getX(), enemy2.getY()+25);
			/**
			 * Yifan He
			 */
			for(int i = 0; i < pBullets.size(); i++){
				g2.drawImage(pBullets.get(i).getImage(), pBullets.get(i).getX(), pBullets.get(i).getY(), null);
			}
			for(int i = 0; i < eBullets.size(); i++){
				g2.drawImage(eBullets.get(i).getImage(), eBullets.get(i).getX(), eBullets.get(i).getY(), null);
			}
//			g2.draw(getNColorVisionCone(enemy1,g2));
//			g2.draw(getNColorVisionCone(enemy2,g2));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	private Arc2D.Double getNColorVisionCone(EnemyAI enemy,Graphics2D g2){
		if(enemy.isTargetLock()){
			g2.setColor(Color.red);
		}
		else
			g2.setColor(Color.green);
		return enemy.getVisioncone();
	}
	private void checkProjectileRange() {
		/**
		 * Jason Lyan
		 */
		for(int i = pBullets.size() - 1 ; i > -1; i--){
			if(pBullets.get(i).isCollided()){
				pBullets.remove(i);
			}
		}
		for(int i = eBullets.size() - 1 ; i > -1; i--){
			if(eBullets.get(i).isCollided()){
				eBullets.remove(i);
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
		

		/**
		 * Yifan He
		 */
		if(keyCode == KeyEvent.VK_8){
			enemiesOnScreen.clear(); //Clear the array list
			addEnemies(enemy1,enemy1);
		}
		if(keyCode == KeyEvent.VK_9){
			enemiesOnScreen.clear();
			addEnemies(enemy2,enemy2);
		}
		if(keyCode == KeyEvent.VK_0){
			enemiesOnScreen.clear();
			addEnemies(enemy1,enemy2);
		}
	}
	public void addEnemies(EnemyAI a, EnemyAI b){ //add random number of enemies for scenarios
		/**
		 * Yifan He
		 */
		int enemy1Num = (int) (Math.random()*2+1);
		int randomNumber = (int) (Math.random()*4+2);
		for(int i=0; i<enemy1Num; i++)
		{
			if (a.getEnemyClass() == KENEMY) enemiesOnScreen.add(new KEnemy(Enemy(),enemyK,visionK,weapon1,ENEMYMOVE));
			else enemiesOnScreen.add(new GEnemy(Enemy(),enemyG,visionK,weapon1,ENEMYMOVE));
			enemiesOnScreen.get(i).setX((int) (Math.random()*400+100));
			enemiesOnScreen.get(i).setY((int) (Math.random()*400+100));
		}
		for(int j=0; j<randomNumber-enemy1Num; j++){
			if (b.getEnemyClass() == KENEMY) enemiesOnScreen.add(new KEnemy(Enemy(),enemyK,visionK,weapon1,ENEMYMOVE));
			else enemiesOnScreen.add(new GEnemy(Enemy(),enemyG,visionK,weapon1,ENEMYMOVE));
			enemiesOnScreen.get(enemy1Num+j).setX((int) (Math.random()*400+100));
			enemiesOnScreen.get(enemy1Num+j).setY((int) (Math.random()*400+100));
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
			character.setStopImage(character.getBsprite()[0]);
		}
		if(keyCode == KeyEvent.VK_DOWN){
			pressedKeys.remove(pressedKeys.indexOf(keyCode));
			character.setMoveDown(false);
			character.setStopImage(character.getFsprite()[0]);
		}
		if(keyCode == KeyEvent.VK_LEFT){
			pressedKeys.remove(pressedKeys.indexOf(keyCode));
			character.setMoveLeft(false);
			character.setStopImage(character.getLsprite()[0]);
		}
		if(keyCode == KeyEvent.VK_RIGHT){
			pressedKeys.remove(pressedKeys.indexOf(keyCode));
			character.setMoveRight(false);
			character.setStopImage(character.getRsprite()[0]);
		}
		character.setFacingDirection();
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
			proposedNewY-=P_SPEED;
			character.setY(proposedNewY);
			character.setMoveUp(true);
		}
		if(!pressedKeys.contains(KeyEvent.VK_UP) && pressedKeys.contains(KeyEvent.VK_DOWN)){
			proposedNewY+=P_SPEED;
			character.setY(proposedNewY);
			character.setMoveDown(true);
		}
		if(pressedKeys.contains(KeyEvent.VK_RIGHT) && !pressedKeys.contains(KeyEvent.VK_LEFT)){
			proposedNewX+=P_SPEED;
			character.setX(proposedNewX);
			character.setMoveRight(true);
		}
		if(!pressedKeys.contains(KeyEvent.VK_RIGHT) && pressedKeys.contains(KeyEvent.VK_LEFT)){
			proposedNewX-=P_SPEED;
			character.setX(proposedNewX);
			character.setMoveLeft(true);
		}

	}

	public void update(){
		super.update();
//		Graphics2D g2 = (Graphics2D)getImage().getGraphics();
//		EnemyAI.paintArc(g2);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	public static int calculateVComponentPlayerToCursor(int velocityScalar, int cursorX, int cursorY, boolean isX){
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
		for(int i=0;i<pBullets.size();i++){
			pBullets.get(i).updateAndCheckAll();
		}
		for(int i=0;i<eBullets.size();i++){
			eBullets.get(i).updateAndCheckAll();
		}
		update();
	}

	@Override
	public void mousePressed(MouseEvent e) {//Jason Lyan
		if(e.getButton() == MouseEvent.BUTTON1){
			System.out.println("Hello");
			int cursorX = e.getX();
			int cursorY = e.getY();
			int vx = calculateVComponentPlayerToCursor(10, cursorX, cursorY, true);
			int vy = calculateVComponentPlayerToCursor(10, cursorX, cursorY, false);
			int direction = calculateDirectionAttackFromPlayer(cursorX, cursorY);
			System.out.println(direction);
			character.fire(character.getX(),character.getY(),vx,vy, direction);//change it up
		}
	}
	private int calculateDirectionAttackFromPlayer(int cursorX2, int cursorY2) {
		int x = character.getX();
		int y = character.getY();
		int cursorX = cursorX2;
		int cursorY = cursorY2;
		int direction = UP;
		double radians = Math.atan2((-cursorY+y),(cursorX - x));
		System.out.println(radians);
		if(radians>-Math.PI/4 || radians <= Math.PI/4)direction = RIGHT;
		if(radians>Math.PI/4 && radians <= Math.PI*3/4)direction = UP;
		if(radians>Math.PI*3/4 || radians <= -Math.PI*3/4)direction = LEFT;
		if(radians<-Math.PI/4 && radians >= -Math.PI*3/4)direction = DOWN;
		return direction;
	}
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
