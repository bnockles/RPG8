package project.battles.demo;

import java.awt.Color;
import java.awt.Font;
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
import java.awt.print.PrinterException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import javax.imageio.ImageIO;
import javax.swing.Timer;

import project.battles.BattlesActions;
import project.battles.CheatCodeDeterminer;
import project.battles.Collision;
import project.battles.EnemyAI;
import project.battles.GEnemy;
import project.battles.KEnemy;
import project.battles.MCharacter;
import project.battles.Projectiles;
import project.battles.overworldIntegration;
import project.controls.ActionDeterminer;
import project.controls.Contoltles;
import project.controls.DemoControls;
import project.controls.cheatCode;
import project.controls.cheatCodeInterface;
import project.directors.Game;
import project.directors.Screen;
import project.directors.UtilityMethods;
import project.items.Item;
import project.items.ItemResources;
import project.items.MedKit;
import project.items.Misc;
import project.items.Weapon;
import project.overworld.BattleInterface;
import project.overworld.MapDemoScreen;

public class BattlesScreen extends Screen implements ItemResources,cheatCodeInterface,BattleInterface, BattlesActions, ActionListener, KeyListener , MouseListener,MouseMotionListener{
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

	public static final int GE_SPEED = 5;
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
	public static final int GE_BPERSEC = 100;

	public static final int KE_SPEED = 5;
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
	public static final int KE_BPERSEC = 100;

	public static final int FPS = 30;

	public static final int W_DMG = 10;
	public static final int W_VELOCITY = 10;
	public static final int W_AMMO = 200;
	public static final int W_RANGE = 500;

	public static final int LEFT_RIGHT = 0;
	public static final int UP_DOWN = 1;
	public static final int AROUND = 2;
	public static final int GOTOPLAYER = 3;
	public static final int WANDER = 4;

	public static final int GENEMY = 0;
	public static final int KENEMY = 1;

	public static int ENEMYMOVE = UP_DOWN;
	public static final int UP = 1;
	public static final int DOWN = 2;
	public static final int LEFT = 3;
	public static final int RIGHT = 4;

	public static MCharacter character;
	public static KEnemy enemy1;
	public static GEnemy enemy2;

	public static ArrayList<MedKit> medkits = new ArrayList<MedKit>();
	public static ArrayList<EnemyAI> enemiesOnScreen= new ArrayList<EnemyAI>();
	public static ArrayList<Collision> pBullets = new ArrayList<Collision>();
	public static ArrayList<Collision> eBullets = new ArrayList<Collision>();

	Timer timer = new Timer(FPS,this);
	public static ArrayList<Integer> pressedKeys = new ArrayList<Integer>();
	public static ArrayList<Integer> pressedMouse = new ArrayList<Integer>();

	public static BufferedImage projectiledemo;
	public static BufferedImage weapondemo;
	public static int keycodedemo;

	Projectiles bullet;
	public static Weapon weapon;
	Weapon weapon1;
	Weapon weapon2;
	int cursorX;
	int cursorY;
	ActionDeterminer controller = new Contoltles();
	CheatCodeDeterminer cheater = new cheatCode();
	//stats = { 0 X, 1 Y, 2 hp, 3 armor, 4 sneak, 5 speed,6 recovery, 7 exp, 8 strength,9 level}
	public int[] enemyG = {GE_X,GE_Y,GE_HP,GE_ARMOR,GE_SNEAK,GE_SPEED,GE_RECOVERY,GE_EXP,GE_STRENGTH,GE_LEVEL};
	public int[] enemyK = {KE_X,KE_Y,KE_HP,KE_ARMOR,KE_SNEAK,KE_SPEED,KE_RECOVERY,KE_EXP,KE_STRENGTH,KE_LEVEL};
	public int[] statsG = {GE_VISION, GE_DEGREE, GE_AWARE,GE_BPERSEC};
	public int[] statsK = {KE_VISION, KE_DEGREE, KE_AWARE,KE_BPERSEC};
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
		//bullet = new Projectiles(10, 10, 0, 10, 10, 100, projectiledemo);
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
	public void Medkit(){
		medkits.add(smallkit);
		medkits.add(medkit);
		medkits.add(bigkit);
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
		enemy1 = new KEnemy(animation,enemyK,statsK,weapon1,ENEMYMOVE);
		enemy2 = new GEnemy(animation,enemyG, statsG,weapon2,ENEMYMOVE);
		return animation;
	}
	int previousRegion = 5;
	@Override
	public void paintScreen(Graphics2D g2) {
		/**
		 * Chieh-Huang Chen
		 */
		//checkMotion();
		checkProjectileRange();
		controller.determineMovement(this);
		MapDemoScreen temp = project.overworld.MapDemonstration.mapDemo;
		try{
			int numb = temp.getBackgroundNumber();
			g2.setColor(temp.getRegionColor(numb));
			g2.fillRect(0, 0, width, height);
			String enemyType = temp.getEnemyType(numb);
			if(previousRegion!=0 && enemyType.equals("enemy1")){
				addEnemies(enemy1,enemy1);
				previousRegion=numb;
			}
		}catch(NullPointerException e){
			
		}	
		g2.setColor(Color.black);
		if(isDead()){ //YIFAN TESTING
			g2.drawString("After 5 seconds, this shows up (Because character will die and "
					+ "we will exit back to the overworld", 100, 600);
		}
		g2.setFont(new Font("TimesRoman", Font.PLAIN, 20)); 
		//			g2.drawString("Battles Team's Demo", 100, 100);
		//			g2.drawString("Press the arrow keys to move", 100, 150);
		//			g2.drawString("Press 8 9 0 to switch battle scenarios", 100, 200);
		//			g2.drawString("Press Q W E R T to switch enemy movements", 100, 250);
		//			g2.drawString("Press A/S to -/+ the enemy's fire rate", 100, 300);
		//			g2.drawString("Press D to reload ammo", 100, 350);
		//			g2.drawString("Press Z/X to -/+ the enemy's moevement", 100, 400);
		//			g2.drawString("Press 1 to use the rifle and 2 to use the explosives", 100, 450);
		g2.setColor(Color.red);
		timer.start();
		g2.drawImage(character.getImage(),character.getX(),character.getY(),null);
		try{
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
		}
		catch(ConcurrentModificationException e){
		}
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
		return this;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		/**
		 * Chieh-Huang Chen
		 */
		int keyCode = e.getKeyCode();
		//		if(keyCode == KeyEvent.VK_W){
		//			if(!pressedKeys.contains(keyCode))
		//				pressedKeys.add(keyCode);
		//		}
		//		if(keyCode == KeyEvent.VK_A){
		//			if(!pressedKeys.contains(keyCode))
		//				pressedKeys.add(keyCode);
		//		}
		//		if(keyCode == KeyEvent.VK_S){
		//			if(!pressedKeys.contains(keyCode))
		//				pressedKeys.add(keyCode);
		//		}
		//		if(keyCode == KeyEvent.VK_D){
		//			if(!pressedKeys.contains(keyCode))
		//				pressedKeys.add(keyCode);
		//		}
		//		if(!pressedKeys.isEmpty()){
		//			character.setWalking(true);
		//		}
		doSomething(keyCode);
		//DEMO PURPOSES ONLY BELOW
		/**
		 * Chieh
		 */
		if(keyCode == KeyEvent.VK_8 || keyCode == KeyEvent.VK_9 || keyCode == KeyEvent.VK_0 || keyCode == KeyEvent.VK_Q  || keyCode == KeyEvent.VK_E || keyCode == KeyEvent.VK_R || keyCode == KeyEvent.VK_T){
			if(keyCode == KeyEvent.VK_8 || keyCode == KeyEvent.VK_9 || keyCode == KeyEvent.VK_0)
				keycodedemo = keyCode;
			//PLEASE DON'T DELETE THE THREE LINES ABOVE - YIFAN HE
			//			
			//			if(keyCode == KeyEvent.VK_Q)
			//				ENEMYMOVE = UP_DOWN;
			//			if(keyCode == KeyEvent.VK_W)
			//				ENEMYMOVE = LEFT_RIGHT;
			//			if(keyCode == KeyEvent.VK_E)
			//				ENEMYMOVE = AROUND;
			//			if(keyCode == KeyEvent.VK_R)
			//				ENEMYMOVE = GOTOPLAYER;
			//			if(keyCode == KeyEvent.VK_T)
			//				ENEMYMOVE = WANDER;
			refreshEnemies();//PLEASE DON'T DELETE - YIFAN HE
		}
		//Vincent
		//WASD is used for moving.
		if(keyCode == KeyEvent.VK_J)
			character.weapon.setAmmo(1000);
		if(keyCode == KeyEvent.VK_3)
			for(int i=0;i<enemiesOnScreen.size();i++)
				if(enemiesOnScreen.get(i).getBulletpersec() > 100)
					enemiesOnScreen.get(i).setBulletpersec(enemiesOnScreen.get(i).getBulletpersec()-25);
		if(keyCode == KeyEvent.VK_4)
			for(int i=0;i<enemiesOnScreen.size();i++)
				if(enemiesOnScreen.get(i).getBulletpersec() < 900){
					enemiesOnScreen.get(i).setBulletpersec(enemiesOnScreen.get(i).getBulletpersec()+25);
					System.out.println(enemiesOnScreen.get(i).getBulletpersec());
				}
		if(keyCode == KeyEvent.VK_5){
			for(int i=0;i<enemiesOnScreen.size();i++){
				enemiesOnScreen.get(i).getWeapon().setAmmo(1000);
			}
		}
		if(keyCode == KeyEvent.VK_Z){
			for(int i=0;i<enemiesOnScreen.size();i++){
				if(enemiesOnScreen.get(i).getSpeed() > 0)
					enemiesOnScreen.get(i).setSpeed(enemiesOnScreen.get(i).getSpeed()-1);
			}
		}
		if(keyCode == KeyEvent.VK_X){
			for(int i=0;i<enemiesOnScreen.size();i++){
				if(enemiesOnScreen.get(i).getSpeed() < 15)
					enemiesOnScreen.get(i).setSpeed(enemiesOnScreen.get(i).getSpeed()+1);
			}
		}
		if(keyCode == KeyEvent.VK_1){
			character.setRifle(true);
		}
		if(keyCode == KeyEvent.VK_2){
			character.setRifle(false);
		}
	}
	public void refreshEnemies(){
		/**
		 *  Yifan He
		 */
		enemiesOnScreen.clear();//Clear the array list
		if(keycodedemo == KeyEvent.VK_8)
			addEnemies(enemy1,enemy1);
		if(keycodedemo == KeyEvent.VK_9)
			addEnemies(enemy2,enemy2);
		if(keycodedemo == KeyEvent.VK_0)
			addEnemies(enemy1,enemy2);
	}
	public void addEnemies(EnemyAI a, EnemyAI b){ //add random number of enemies for scenarios
		/**
		 * Yifan He
		 */
		int enemy1Num = (int) (Math.random()*2+1);
		int randomNumber = (int) (Math.random()*4+2);
		int randomNumberX;
		int randomNumberY;
		for(int i=0; i<enemy1Num+randomNumber; i++)
		{ // the enemy appears every 4 seconds until the total enemy numbers reach the temp;
			EnemyAI temp;
			if (i < enemy1Num) 
				temp = a;
			else
				temp = b;
			randomNumberX = (int) (Math.random()*width-100);
			randomNumberY = (int) (Math.random()*height-100);
			int[] randomEnemyStats = {(int) (Math.random()*300+100),
					(int) (Math.random()*400+200),
					(int) (Math.random()*30+30),
					(int) (Math.random()*400+100)};
			if (temp.getEnemyClass() == KENEMY)
				enemiesOnScreen.add(new KEnemy(Enemy(),enemyK,randomEnemyStats,weapon1,ENEMYMOVE));
			else 
				enemiesOnScreen.add(new GEnemy(Enemy(),enemyG,randomEnemyStats,weapon1,ENEMYMOVE));
			enemiesOnScreen.get(i).setX(randomNumberX);
			enemiesOnScreen.get(i).setY(randomNumberY);
			enemiesOnScreen.get(i).setSpawnedX(randomNumberX);
			enemiesOnScreen.get(i).setSpawnedY(randomNumberY);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		/**
		 * Chieh-Huang Chen
		 */
		int keyCode = e.getKeyCode();
		controller.removeKeys(keyCode);
		if(pressedKeys.isEmpty())
			character.setWalking(false);//YOGTSERIGBSDFIOB

		//		character.setFacingDirection();
		//		if(pressedKeys.isEmpty())
		//			character.setWalking(false);
	}
	//	public void checkMotion() {
	//		/**
	//		 * Chieh-Huang Chen
	//		 */
	//		Graphics2D g = null;
	//		if(pressedKeys == null)
	//			return;
	//		if(pressedKeys.contains(KeyEvent.VK_UP) && !pressedKeys.contains(KeyEvent.VK_DOWN)){
	//			proposedNewY-=P_SPEED;
	//			character.setY(proposedNewY);
	//			character.setMoveUp(true);
	//		}
	//		if(!pressedKeys.contains(KeyEvent.VK_UP) && pressedKeys.contains(KeyEvent.VK_DOWN)){
	//			proposedNewY+=P_SPEED;
	//			character.setY(proposedNewY);
	//			character.setMoveDown(true);
	//		}
	//		if(pressedKeys.contains(KeyEvent.VK_RIGHT) && !pressedKeys.contains(KeyEvent.VK_LEFT)){
	//			proposedNewX+=P_SPEED;
	//			character.setX(proposedNewX);
	//			character.setMoveRight(true);
	//		}
	//		if(!pressedKeys.contains(KeyEvent.VK_RIGHT) && pressedKeys.contains(KeyEvent.VK_LEFT)){
	//			proposedNewX-=P_SPEED;
	//			character.setX(proposedNewX);
	//			character.setMoveLeft(true);
	//		}
	//
	//	}

	public void update(){
		super.update();
		//		Graphics2D g2 = (Graphics2D)getImage().getGraphics();
		//		EnemyAI.paintArc(g2);
	}

	@Override
	public void keyTyped(KeyEvent e) {

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
			int cursorX = e.getX();
			int cursorY = e.getY();
			int vx = calculateVComponentPlayerToCursor(10, cursorX, cursorY, true);
			int vy = calculateVComponentPlayerToCursor(10, cursorX, cursorY, false);
			int direction = calculateDirectionAttackFromPlayer(cursorX, cursorY);
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
		if(radians>-Math.PI/4 || radians <= Math.PI/4)direction = RIGHT;
		if(radians>Math.PI/4 && radians <= Math.PI*3/4)direction = UP;
		if(radians>Math.PI*3/4 || radians <= -Math.PI*3/4)direction = LEFT;
		if(radians<-Math.PI/4 && radians >= -Math.PI*3/4)direction = DOWN;
		return direction;
	}
	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {

	}
	@Override
	public void mouseDragged(MouseEvent e) {

	}
	@Override
	public void mouseMoved(MouseEvent e) {

	}
	public void fireWeapon(MouseEvent e) {
		int cursorX = e.getX();
		int cursorY = e.getY();
		int vx = calculateVComponentPlayerToCursor(10, cursorX, cursorY, true);
		int vy = calculateVComponentPlayerToCursor(10, cursorX, cursorY, false);
		int direction = calculateDirectionAttackFromPlayer(cursorX, cursorY);
		character.fire(character.getX(),character.getY(),vx,vy, direction);

	}
	@Override
	public void moveCharacterLeft() {
		character.setX(character.getX()+-P_SPEED);
		character.setMoveLeft(true);
		character.setMoveRight(false);
		character.setMoveUp(false);
		character.setMoveDown(false);
		character.setFacingLeft(true);
		character.setFacingRight(false);
		character.setFacingUp(false);
		character.setFacingDown(false);
		character.setStopImage(character.getLsprite()[0]);
	}
	@Override
	public void moveCharacterRight() {
		character.setX(character.getX()+P_SPEED);
		character.setMoveRight(true);
		character.setMoveLeft(false);
		character.setMoveUp(false);
		character.setMoveDown(false);
		character.setFacingRight(true);
		character.setFacingLeft(false);
		character.setFacingUp(false);
		character.setFacingDown(false);
		character.setStopImage(character.getRsprite()[0]);
	}
	@Override
	public void moveCharacterUp() {
		character.setY(character.getY()-P_SPEED);
		character.setMoveUp(true);
		character.setMoveRight(false);
		character.setMoveLeft(false);
		character.setMoveDown(false);
		character.setFacingUp(true);
		character.setFacingRight(false);
		character.setFacingLeft(false);
		character.setFacingDown(false);
		character.setStopImage(character.getBsprite()[0]);
	}
	@Override
	public void moveCharacterDown() {
		character.setY(character.getY()+P_SPEED);
		character.setMoveDown(true);
		character.setMoveRight(false);
		character.setMoveUp(false);
		character.setMoveLeft(false);
		character.setFacingDown(true);
		character.setFacingLeft(false);
		character.setFacingRight(false);
		character.setFacingUp(false);
		character.setStopImage(character.getFsprite()[0]);
	}
	@Override
	public void reloadWeapon() {
	}
	public void doSomething(int e){
		controller.determineKeyAction(e);
		controller.checkEmpty(character);
	}

	//Yifan He 
	boolean test = false;
	ActionListener taskPerformer = new ActionListener(){
		public void actionPerformed(ActionEvent evt){
			test = true;
		}
	};

	Timer temp = new Timer(100000,taskPerformer);
	@Override
	public boolean isDead(){ //Yifan He 
		// for testing
		temp.setRepeats(false);
		temp.start();
		return test;
	}
	@Override
	public boolean killCharacter() { //Yifan He 
		temp.setRepeats(false);
		temp.start();
		return test;
	}
	@Override
	public int getCharX() {//Yifan He 
		return character.getX();
	}
	@Override
	public int getCharY() {//Yifan He 

		return character.getY();
	}
	@Override
	public BufferedImage[] getFrontImage() {//Yifan He 
		return character.getFsprite();
	}
	@Override
	public BufferedImage[] getBack() {//Yifan He 

		return character.getBsprite();
	}
	@Override
	public BufferedImage[] getRight() {//Yifan He 
		return character.getRsprite();
	}
	@Override
	public BufferedImage[] getLeft() {//Yifan He 

		return character.getLsprite();
	}
	@Override
	public void cheatLevel() {
		character.gainExp(1000);
	}
	@Override
	public void cheatDamage() {

		character.setStrength(100);
	}
	@Override
	public void cheatSpeed() {
		// TODO Auto-generated method stub
		character.setSpeed(16);
	}
	@Override
	public void cheatAmmo() {
		// TODO Auto-generated method stub
		character.getWeapon().setAmmo(1000000);
	}
	@Override
	public cheatCodeInterface getCCI(cheatCodeInterface c) {
		// TODO Auto-generated method stub
		return this;
	}
	@Override
	public int buy(Misc gold) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int sell(Misc gold, Misc scrap) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String printStats(double[] stats) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Item[] getItem() {
		// TODO Auto-generated method stub
		return null;
	}


}
