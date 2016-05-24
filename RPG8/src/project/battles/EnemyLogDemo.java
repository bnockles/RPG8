package project.battles;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import project.battles.demo.BattlesScreen;
import project.directors.Game;
import project.directors.Screen;
import project.save.*;

public class EnemyLogDemo extends Game implements KeyListener {

	/**
	 * @param args
	 */
	
	public static ArrayList<EnemyLogEntry> eLog = new ArrayList<EnemyLogEntry>(); //example purposes
	
	public EnemyLogDemo(){
		super(); 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//KEnemy Pel = new KEnemy(100, 100);
		//MCharacter Dude = new MCharacter(100,100); 
		
		
		eLog.add(new EnemyLogEntry("Shahid","Boss",5,5,15));
		eLog.add(new EnemyLogEntry("Mercenary","Killer Enemy",2,7,5));
		BattleSave.saveEnemyLogData("100", eLog); 
		//Created enemy log and saved before creating new game
		
		EnemyLogDemo pelhamDemo = new EnemyLogDemo();
		
	}
	
	public void reset() {
		
		EnemyLog enlog = new EnemyLog(BattleSave.getEnemyLogData("100"));  //loads enemy log from before
		//Pel.findRange(Dude, enLog)
		EnemyLogScreen pelScreen = new EnemyLogScreen(this, enlog.geteLog().get(EnemyLogScreen.enemySelected));
		System.out.println(EnemyLogScreen.enemySelected);
		setScreen(pelScreen);
		repaint();
	}
	

	public KeyListener getKeyListener() {
		return this;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

			
			//if enemySelected == length of eLog-1, it goes back to 0
		
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
