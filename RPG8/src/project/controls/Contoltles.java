package project.controls;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import project.battles.BattlesActions;
import project.battles.MCharacter;

public class Contoltles implements ActionDeterminer{
	ArrayList<Integer> moving = new ArrayList<Integer>();
	@Override
	public void determineMouseAction(int n, BattlesActions thing) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void determineKeyAction(int n) {
		// TODO Auto-generated method stub
		if(!moving.contains(n))moving.add(n);
		//if(n==KeyEvent.VK_W) thing.moveCharacterUp();
		//if(n==KeyEvent.VK_A) thing.moveCharacterLeft();
		//if(n==KeyEvent.VK_S) thing.moveCharacterDown();
		//if(n==KeyEvent.VK_D) thing.moveCharacterRight();
	}
	public void removeKeys(Integer n){
		if(moving.contains(n))moving.remove(n);
	}

	@Override
	public void determineMovement(BattlesActions thing) {
		if(moving.contains(KeyEvent.VK_W)) thing.moveCharacterUp();
		if(moving.contains(KeyEvent.VK_A)) thing.moveCharacterLeft();
		if(moving.contains(KeyEvent.VK_S)) thing.moveCharacterDown();
		if(moving.contains(KeyEvent.VK_D)) thing.moveCharacterRight();
		
	}

	@Override
	public void checkEmpty(MCharacter c) {
		// TODO Auto-generated method stub
		if(moving.isEmpty()){
			c.setWalking(false);
		}
	}
}
