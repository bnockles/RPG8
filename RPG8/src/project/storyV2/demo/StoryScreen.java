package project.storyV2.demo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import project.directors.Game;
import project.directors.Screen;
import project.overworld.DemoOverworld;
import project.storyV2.Cutscenes;
import project.storyV2.IntroCut;

public class StoryScreen extends Screen implements KeyListener {

	final static ArrayList<String> AyaForward = new ArrayList<String>();
	private static String forward = "/images/heroes/sForward.png";
	private static String forward1 = "/images/heroes/forward1.png";
	private static String forward2 = "/images/heroes/forward2.png";
	final static ArrayList<String> AyaLeft = new ArrayList<String>();
	private static String left = "/images/heroes/sLeft.png";
	private static String left1 = "/images/heroes/left1.png";
	private static String left2 = "/images/heroes/left2.png";
	final static ArrayList<String> AyaRight = new ArrayList<String>();
	private static String right = "/images/heroes/sRight.png";
	private static String right1 = "/images/heroes/right1.png";
	private static String right2 = "/images/heroes/right2.png";
	final static ArrayList<String> AyaBack = new ArrayList<String>();
	private static String back = "/images/heroes/sBack.png";
	private static String back1 = "/images/heroes/back1.png";
	private static String back2 = "/images/heroes/back2.png";
	final static ArrayList<String> AyaStanding = new ArrayList<String>();
	private static final int MOVE_UNIT = 5;
	public static Hero Swarm;
	public ArrayList<Integer> pressedKeys = new ArrayList<Integer>();
	public Cutscenes cutscene;
	public String[][] params = {{"Mission 1: Recover the datapad", "Kill all enemies"},{"Side Mission: Install the backdoor", "Remain undetected"},{"Mission 5: Escape the facility", "Get out alive"}};
	public ArrayList<Color> colors = new ArrayList<Color>();
	public ArrayList<Font> fonts = new ArrayList<Font>();
	public ArrayList<Cutscenes> cuts = new ArrayList<Cutscenes>();
	public int counter = 0;
	public boolean decide = true;
	public int SwarmsXpos;
	public int SwarmsYpos;
	public boolean play = true;
	public ArrayList<Integer> travelled  = new ArrayList<Integer>();
	//getenemykilled interface for melvin
	//unlocked location for me
	public StoryScreen(Game game) {
		super(game);
		AyaForward.add(forward1);
		AyaForward.add(forward2);
		AyaLeft.add(left1);
		AyaLeft.add(left2);
		AyaRight.add(right1);
		AyaRight.add(right2);
		AyaBack.add(back1);
		AyaBack.add(back2);
		AyaStanding.add(forward);
		AyaStanding.add(left);
		AyaStanding.add(right);
		AyaStanding.add(back);
		Swarm = new Hero("Aya Drevis", 105, 105);
		Swarm.animate(AyaStanding.get(0));
		Font temp = new Font("Onyx", Font.ITALIC, 32);
		Font temp2 = new Font("Cochin", Font.BOLD, 48);
		Font temp3 = new Font("Cracked", Font.PLAIN, 18);
		fonts.add(temp);
		fonts.add(temp2);
		fonts.add(temp3);
		colors.add(Color.BLUE);
		colors.add(Color.RED);
		colors.add(Color.GREEN);
		colors.add(Color.ORANGE);
		colors.add(Color.cyan);
		colors.add(Color.darkGray);
		cutscene =  new IntroCut("Mission 1: Recover the datapad", "Kill all enemie", temp, 30, 1000,800,colors);

		cuts.add(cutscene);
		cuts.remove(cutscene);
		//=================
	
		

		// TODO Auto-generated constructor stub
	}


	public void checkFor(){
		//only haveo ne cutscene play at a time
		//no moving in cutscene
		while(play == true){
			if(SwarmsXpos >= 0 && SwarmsXpos <= 700 && SwarmsXpos >= 0 && SwarmsYpos <=700){
				Font temp = new Font("Onyx", Font.ITALIC, 32);
				cutscene =  new IntroCut("You are entering", "a highly dangerous area", temp, 30, 1000,800,colors);

				cuts.add(cutscene);



				stopmovement();

				dontplayforawhile();



			}


			//cutscene number two
			if(SwarmsXpos >= 0 && SwarmsXpos <= 0 && SwarmsXpos >= 0 && SwarmsYpos <=0){
				Font temp = new Font("Onyx", Font.ITALIC, 32);
				cutscene =  new IntroCut("Wander this area to", "search for the lost key", temp, 30, 1000,800,colors);

				cuts.add(cutscene);


			
				stopmovement();
				dontplayforawhile();



			}
			
			if(SwarmsXpos >= 0 && SwarmsXpos <= 0 && SwarmsXpos >= 0 && SwarmsYpos <=0){
				Font temp = new Font("Onyx", Font.ITALIC, 32);
				cutscene =  new IntroCut("Final boss fight", "dodge his projectiles!", temp, 30, 1000,800,colors);

				cuts.add(cutscene);



				stopmovement();
				dontplayforawhile();



			}




		}
		
		
		
		
		
	}

	public void dontplayforawhile(){
		Thread s = new Thread(new Runnable() {
			public void run() {
				play = false;
				while (play == false){
					try {
						Thread.sleep(15000);
						play = true;
					} 
					catch(InterruptedException ex) {
						Thread.currentThread().interrupt();
					}
				}	
			}
		});
		s.start();
	}
// interface EnemySpawnable{
//	int getEnemyLevels();
	
	
	
//interface EnemyCreator{
//	PoopMan getEnemyCharacter(EnemySpawnable b);
	
//interface PoopMan{
//	BufferedImage getBufferedImage();
//	int getX();
//	int getY();


	public void stopmovement(){
		//decide = false;
		//long now = System.currentTimeMillis();
		//while (System.currentTimeMillis() < now + 3000) {

		//}
		//decide = true;



		Thread t = new Thread(new Runnable() {
			public void run() {
				decide = false;
				while (decide == false){
					try {
						Thread.sleep(7000);
						decide = true;
					} 
					catch(InterruptedException ex) {
						Thread.currentThread().interrupt();
					}
				}	
			}
		});
		t.start();}

public void addlocation(){
	travelled.add(Swarm.getX());
	travelled.add(Swarm.getY());
};

	
	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public void paintScreen(Graphics2D g2) {
		// TODO Auto-generated method stub
		for(int i =0; i < cuts.size();i++){
			g2.drawImage(cuts.get(i).getBufferedImage(), 0, 0, null);
		}
		g2.drawImage(Swarm.getImage(), Swarm.getX(), Swarm.getY(), null);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		//check if an arrow key is pressed and add it to pressedKeys if it is
		if(keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_LEFT){
			//only add keys if they aren't already in the ArrayList
			if(!pressedKeys.contains(keyCode))pressedKeys.add(keyCode);
		}

		//other keys don't get combined with other keys, so they don't need to be added
		if(keyCode == KeyEvent.VK_SPACE){
			//stuff that happens when the spacebar is pressed
			//				Screen mainMenu = new DemoOverworld(game);
			//				game.setScreen(mainMenu);
		}
		if(keyCode == KeyEvent.VK_A){
			int current = ++counter%3;
			cutscene =  new IntroCut(params[current][0], params[current][1], fonts.get(current), 30, 1000,800,colors.subList(current, current+3));
			cuts.add(cutscene);
		}

		if(keyCode == KeyEvent.VK_UP){
			if(decide == true){
			Swarm.animate(AyaStanding.get(3));
			Swarm.moveUp();
			SwarmsYpos = Swarm.getY();
			checkFor();
			}
		}


		else if(keyCode == KeyEvent.VK_DOWN){	
			if(decide == true){
			Swarm.animate(AyaStanding.get(0));
			Swarm.moveDown();
			SwarmsYpos = Swarm.getY();
			checkFor();
			}
		}
		else if(keyCode == KeyEvent.VK_RIGHT){
			if(decide == true){
			Swarm.animate(AyaStanding.get(2));
			Swarm.moveRight();
			SwarmsXpos = Swarm.getX();
			checkFor();
			}
		}
		else if(keyCode == KeyEvent.VK_LEFT){
			if(decide == true){
			Swarm.animate(AyaStanding.get(1));
			Swarm.moveLeft();
			SwarmsXpos = Swarm.getX();
			checkFor();
			}
		}
		else if(keyCode == KeyEvent.VK_S) {
			//Swarm.shoot();
		}
		else if(keyCode == KeyEvent.VK_R) {
			//Swarm.radio();
		}

		Swarm.checkDimensions();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		//check if an arrow key is released and removes it from pressedKeys if it is
		if(keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_LEFT){
			pressedKeys.remove(pressedKeys.indexOf(keyCode));
		}

		if(keyCode == KeyEvent.VK_UP){
			Swarm.animate(AyaStanding.get(3));
		}
		else if(keyCode == KeyEvent.VK_DOWN){			
			Swarm.animate(AyaStanding.get(0));
		}
		else if(keyCode == KeyEvent.VK_RIGHT){
			Swarm.animate(AyaStanding.get(2));
		}
		else if(keyCode == KeyEvent.VK_LEFT){
			Swarm.animate(AyaStanding.get(1));
		}

		respondToKeyInput();
	}
	private void respondToKeyInput() { 
		if(pressedKeys.contains(KeyEvent.VK_UP) && !pressedKeys.contains(KeyEvent.VK_DOWN)) Swarm.setY(Swarm.getY() - MOVE_UNIT); 
		if(!pressedKeys.contains(KeyEvent.VK_UP) && pressedKeys.contains(KeyEvent.VK_DOWN)) Swarm.setY(Swarm.getY() + MOVE_UNIT); 
		if(pressedKeys.contains(KeyEvent.VK_RIGHT) && !pressedKeys.contains(KeyEvent.VK_LEFT)) Swarm.setX(Swarm.getX() - MOVE_UNIT); 
		if(!pressedKeys.contains(KeyEvent.VK_RIGHT) && pressedKeys.contains(KeyEvent.VK_LEFT)) Swarm.setX(Swarm.getX() + MOVE_UNIT); 
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}