package project.controls;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import project.battles.BattlesActions;
import project.battles.MCharacter;

public class Contoltles implements ActionDeterminer{
	ArrayList<Integer> moving = new ArrayList<Integer>();

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
	public void checkEmpty(MCharacter c) {
		// TODO Auto-generated method stub
		if(moving.isEmpty()){
			c.setWalking(false);
		}
	}
	
	@Override
	public void determineMovement(BattlesActions thing) {
		if(moving.contains(KeyEvent.VK_W)) thing.moveCharacterUp();
		if(moving.contains(KeyEvent.VK_A)) thing.moveCharacterLeft();
		if(moving.contains(KeyEvent.VK_S)) thing.moveCharacterDown();
		if(moving.contains(KeyEvent.VK_D)) thing.moveCharacterRight();	
		if(moving.contains(KeyEvent.VK_1)) thing.setFireType(true);
		if(moving.contains(KeyEvent.VK_2)) thing.setFireType(false);
		if(moving.contains(KeyEvent.VK_R)) thing.reloadWeapon(); 
	}
	
	//if left mouse click isn't the only mousebutton used
	@Override
	public void determineMouseAction(MouseEvent e, BattlesActions thing) {
		// TODO Auto-generated method stub
		if(e.getButton()==MouseEvent.BUTTON1)thing.fireWeapon(e);
	}
	@Override
	public ArrayList<Integer> getList() {
		// TODO Auto-generated method stub
		return moving;
	}
}
