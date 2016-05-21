package project.battles;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import project.battles.demo.BattlesScreen;
import project.directors.Game;
import project.directors.Screen;

public class EnemyLogDemo extends Game implements KeyListener {

	/**
	 * @param args
	 */
	
	public int enemySelected = 0;
	
	public EnemyLogDemo(){
		super(); 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EnemyLogDemo pelhamDemo = new EnemyLogDemo();
	}
	
	public void reset() {
		EnemyLog enlog = new EnemyLog(); 
		EnemyLogScreen pelScreen = new EnemyLogScreen(this, enlog.geteLog().get(enemySelected));
		setScreen(pelScreen);
		repaint();
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyCode()== KeyEvent.VK_RIGHT){
			enemySelected++;
			System.out.println(enemySelected);
			reset();
		}
			
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
