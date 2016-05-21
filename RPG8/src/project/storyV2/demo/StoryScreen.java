package project.storyV2.demo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import project.directors.Game;
import project.directors.Screen;
import project.storyV2.Cutscenes;
import project.storyV2.IntroCut;

public class StoryScreen extends Screen implements KeyListener,project.battles.EnemyDifficulty {
	private static final int MOVE_UNIT = 5;
	private static final String STEALTH = "0";
	private static final String ATTACK = "1";
	public static Hero mc;
	public ArrayList<Integer> pressedKeys = new ArrayList<Integer>();
	public Cutscenes cutscene;
	private String[][] params = {{"Mission 1: Recover the datapad", "Kill all enemies", "1", ATTACK},
			{"Side Mission: Install the backdoor", "Remain undetected", "1.5", STEALTH},
			{"Mission 5: Escape the facility", "Get out alive", "5", ATTACK}};
	public ArrayList<Color> colors = new ArrayList<Color>();
	public ArrayList<Font> fonts = new ArrayList<Font>();
	public ArrayList<Cutscenes> cuts = new ArrayList<Cutscenes>();
	public int counter = 0;
	public static int height;
	public static int width;
	private boolean disable = false;
	private int current = 0;
	public StoryScreen(Game game) {
		super(game);
		mc = new Hero("Aya Drevis", 105, 105);
		mc.animate(mc.AyaStanding.get(0));
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
		cutscene =  new IntroCut(params[current][0], params[current][1], temp, 30, 1000,800,colors);
		cuts.add(cutscene);
		setHeight();
		setWidth();
	}

	@Override
	public KeyListener getKeyListener() {
		return this;
	}

	@Override
	public void paintScreen(Graphics2D g2) {
		for(int i =0; i < cuts.size();i++){
			g2.drawImage(cuts.get(i).getBufferedImage(), 0, 0, null);
		}
		g2.drawImage(mc.getImage(), mc.getX(), mc.getY(), null);
	}

	public void setHeight(){
		height = super.height;
	}

	public void setWidth(){
		width = super.width;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		//check if an arrow key is pressed and add it to pressedKeys if it is
		if(keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_LEFT){
			//only add keys if they aren't already in the ArrayList
			if(!pressedKeys.contains(keyCode))pressedKeys.add(keyCode);
		}

		//other keys don't get combined with other keys, so they don't need to be added
		if(keyCode == KeyEvent.VK_SPACE){
			//stuff that happens when the spacebar is pressed
			disable = !disable;
		}
		if(disable){
			if(pressedKeys.contains(keyCode))pressedKeys.remove(pressedKeys.indexOf(keyCode));
		}
		if(disable == false){
			if(keyCode == KeyEvent.VK_A){
				current = ++counter%3;
				cutscene =  new IntroCut(params[current][0], params[current][1], fonts.get(current), 30, 1000,800,colors.subList(current, current+3));
				cuts.add(cutscene);
			}

			if(keyCode == KeyEvent.VK_UP){
				mc.animate(mc.AyaStanding.get(3));
				mc.moveUp();
			}
			if(keyCode == KeyEvent.VK_DOWN){			
				mc.animate(mc.AyaStanding.get(0));
				mc.moveDown();
			}
			else if(keyCode == KeyEvent.VK_RIGHT){
				mc.animate(mc.AyaStanding.get(2));
				mc.moveRight();
			}
			else if(keyCode == KeyEvent.VK_LEFT){
				mc.animate(mc.AyaStanding.get(1));
				mc.moveLeft();
			}
			else if(keyCode == KeyEvent.VK_S) {
				//Swarm.shoot();
			}
			else if(keyCode == KeyEvent.VK_R) {
				//Swarm.radio();
			}
		}
		mc.checkDimensions();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		//check if an arrow key is released and removes it from pressedKeys if it is
		if(keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_LEFT){
			if(pressedKeys.contains(keyCode))pressedKeys.remove(pressedKeys.indexOf(keyCode));
		}
		if(disable == false){
			if(keyCode == KeyEvent.VK_UP){
				mc.animate(mc.AyaStanding.get(3));
			}
			else if(keyCode == KeyEvent.VK_DOWN){			
				mc.animate(mc.AyaStanding.get(0));
			}
			else if(keyCode == KeyEvent.VK_RIGHT){
				mc.animate(mc.AyaStanding.get(2));
			}
			else if(keyCode == KeyEvent.VK_LEFT){
				mc.animate(mc.AyaStanding.get(1));
			}
		}
		respondToKeyInput();
	}
	private void respondToKeyInput() { 
		if(pressedKeys.contains(KeyEvent.VK_UP) && !pressedKeys.contains(KeyEvent.VK_DOWN)) mc.setY(mc.getY() - MOVE_UNIT); 
		if(!pressedKeys.contains(KeyEvent.VK_UP) && pressedKeys.contains(KeyEvent.VK_DOWN)) mc.setY(mc.getY() + MOVE_UNIT); 
		if(pressedKeys.contains(KeyEvent.VK_RIGHT) && !pressedKeys.contains(KeyEvent.VK_LEFT)) mc.setX(mc.getX() - MOVE_UNIT); 
		if(!pressedKeys.contains(KeyEvent.VK_RIGHT) && pressedKeys.contains(KeyEvent.VK_LEFT)) mc.setX(mc.getX() + MOVE_UNIT); 
	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

	@Override
	public int getCharacterLevel() {
		// TODO Auto-generated method stub
		return -10;
	}

	@Override
	public int getMapLevel() {
		// TODO Auto-generated method stub
		return Integer.parseInt(params[current][3]);
	}

	@Override
	public int getProgress() {
		// TODO Auto-generated method stub
		return Integer.parseInt(params[current][2]);
	}

	@Override
	public String getBoss() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getMission(){
		return params[current][1];
	}
}
