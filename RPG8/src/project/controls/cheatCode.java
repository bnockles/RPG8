package project.controls;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.Timer;

import javax.sound.midi.Sequence;

import project.battles.CheatCodeDeterminer;

public class cheatCode implements KeyListener, CheatCodeDeterminer {

	boolean cheatLevel = false; 
	boolean cheatDamage = false;
	boolean cheatSpeed = false;
	boolean cheatAmmo = false;
	Timer effectTimer; 
	boolean battle = false;
	ArrayList<Integer> sequence = new ArrayList<Integer>();
	String input = "";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		Integer keyCode = e.getKeyCode();
	
	}
	private void increment() {
		input ="";
		
	}
	ActionListener taskPerformer = new ActionListener(){
		public void actionPerformed(ActionEvent evt){
			input="";
		}
	};
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void determineValidCheatCode(KeyEvent e, cheatCodeInterface battles) {
		int keyCode = e.getKeyCode();
		new Timer(2000,taskPerformer).start();
		input += KeyEvent.getKeyText((Integer)(keyCode));
		if(input.contains("C")){
			if(input.contains("CHEATLEVEL")){
				battles.cheatLevel();
				input = "";
			}
			if(input.contains("CHEATDAMAGE")){
				battles.cheatDamage();
				input = "";
			}
			if(input.contains("CHEATSPEED")){
				battles.cheatSpeed();
				input = "";
			}
			if(input.contains("XCHEATAMMOX")){
				battles.cheatAmmo();
				input = "";
			}
		}else{
			input = null;
		}
	}

}
