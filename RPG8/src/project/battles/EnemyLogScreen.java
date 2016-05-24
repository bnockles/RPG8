package project.battles;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import project.directors.Game;
import project.directors.Screen;
import project.mainmenudemo.MainMenuScreen;

public class EnemyLogScreen extends MainMenuScreen implements KeyListener {
	//going to open in the menu
	//encounter box? add enemy to list when there is a certain range, display info in menu (POINT2D)
	//save list 
	
	public static int enemySelected = 0;
	
	public EnemyLogScreen(Game game, EnemyLogEntry e) {
		super(4, game, new String[]{e.getEnemyName(), "Enemy Type: "+e.getEnemyType(), "Amount of Times Killed: "+ e.getTimesKilled(), "Amount of Kills: "+ e.getEnemyKills()}, new String[]{""}, new Color[]{Color.white, Color.black, Color.darkGray}, null);
	}

	/**
	 * @param args
	 */
	

	@Override
	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return (KeyListener) this;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()== KeyEvent.VK_RIGHT){
			
			enemySelected++;
			if(enemySelected>EnemyLogDemo.eLog.size()-1){
				enemySelected = 0; 
			}
			System.out.println(enemySelected);
			this.game.reset();
			
			
			
		}
		
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
