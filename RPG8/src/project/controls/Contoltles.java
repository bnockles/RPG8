package project.controls;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import project.battles.BattlesActions;

public class Contoltles implements ActionDeterminer{

	@Override
	public void determineMouseAction(int n, BattlesActions thing) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void determineKeyAction(int n, BattlesActions thing) {
		// TODO Auto-generated method stub
		if(n==KeyEvent.VK_W) thing.moveCharacterUp();
		if(n==KeyEvent.VK_A) thing.moveCharacterLeft();
		if(n==KeyEvent.VK_S) thing.moveCharacterDown();
		if(n==KeyEvent.VK_D) thing.moveCharacterRight();
	}

}
