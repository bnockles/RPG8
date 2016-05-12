package project.controls;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Timer;

import javax.sound.midi.Sequence;

public class cheatCode implements KeyListener {

	boolean cheatLevel = false; 
	boolean cheatDamage = false;
	boolean cheatSpeed = false;
	boolean cheatAmmo = false;
	Timer effectTimer; 
	boolean battle = false;
	ArrayList<Integer> sequence = new ArrayList<Integer>();
	String input = "";
	//cheatCodeInterface c = cheatCodeInterface.getCCI(this); 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		Integer keyCode = e.getKeyCode();
	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		input += KeyEvent.getKeyText((Integer)(keyCode));
			if(input.contains("CHEATLEVEL")){
				cheatLevel();
				input = "";
			}
			if(input.contains("CHEATDAMAGE")){
				cheatDamage();
				input = "";
			}
			if(input.contains("CHEATSPEED")){
				cheatSpeed();
				input = "";
			}
			if(input.contains("CHEATAMMO")){
				cheatAmmo();
				input = "";
			}
	}

	private void cheatAmmo() {
		// TODO Auto-generated method stub
		
	}

	private void cheatSpeed() {
		// TODO Auto-generated method stub
		
	}

	private void cheatDamage() {
		// TODO Auto-generated method stub
		
	}

	private void cheatLevel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
