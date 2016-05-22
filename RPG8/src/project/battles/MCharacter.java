package project.battles;

import java.awt.event.KeyEvent;
import java.awt.geom.Arc2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import project.battles.demo.BattlesScreen;
import project.directors.Character;
import project.items.Item;
import project.items.MedKit;
import project.items.UsableItem;
import project.items.Weapon;
//import project.save.ItemState;

public class MCharacter extends Character implements CanUseItems{
	private int level;
	private boolean rifle = true;
	private UsableItem item;

	ArrayList<Integer> pressedKeys = new ArrayList<Integer>();
	//	private String[] setLoadOut;

	public MCharacter(BufferedImage[][] images, int[] stats,int[] stats2, Weapon weapon){
		//this is where we change stats for characters
		super(images,stats,false,weapon);
		this.level = stats[9];
		this.visionrange = stats2[0];
		this.visiondegree = stats2[1];
//		this.awareRange = stats2[2];
//		this.bulletpersec = stats2[3];
	}
	public int getLevel() {
		return level;
	}
	public void gainExp(int xp){
		//CHANGE STATS HERE
		exp+= xp;
		if (exp >= 100){
			level++;
			exp = exp%100;
		}
	}
	@Override
	public BufferedImage getImage() {
		// TODO Auto-generated method stub
		increaseCount();
		if(walking){
			if(BattlesScreen.pressedKeys.contains(KeyEvent.VK_UP) && BattlesScreen.pressedKeys.contains(KeyEvent.VK_DOWN)){
				if(facingUp)
					return bsprite[0];
				else
					return fsprite[0];
			}
			else{
				if(moveUp){
					facingUp = true;
					if((count >= 0 && count < 5) || (count >= 10 && count < 15))
						return bsprite[0];
					if(count >= 5 && count < 10)
						return bsprite[1];
					if(count >= 15 && count < 20)
						return bsprite[2];
				}
				if(moveDown){
					facingDown = true;
					if((count >= 0 && count < 5) || (count >= 10 && count < 15))
						return fsprite[0];
					if(count >= 5 && count < 10)
						return fsprite[1];
					if(count >= 15 && count < 20)
						return fsprite[2];
				}
			}
			if(BattlesScreen.pressedKeys.contains(KeyEvent.VK_RIGHT) && BattlesScreen.pressedKeys.contains(KeyEvent.VK_LEFT)){
				if(facingLeft)
					return lsprite[0];
				else
					return rsprite[0];
			}
			else{
				if(!moveRight&&moveLeft){
					facingLeft = true;
					if((count >= 0 && count < 5) || (count >= 10 && count < 15))
						return lsprite[0];
					if(count >= 5 && count < 10)
						return lsprite[1];
					if(count >= 15 && count < 20)
						return lsprite[2];
				}

				if(moveRight&&!moveLeft){
					facingRight = true;
					if((count >= 0 && count < 5) || (count >= 10 && count < 15))
						return rsprite[0];
					if(count >= 5 && count < 10)
						return rsprite[1];
					if(count >= 15 && count < 20)
						return rsprite[2];
				}
			}
		}
		return stopImage;
	}
	public void setFacingDirection(){
	if(!moveUp){
		facingUp = false;
	}
	if(!moveDown){
		facingDown = false;
	}
	if(!moveLeft){
		facingLeft = false;
	}
	if(!moveRight){
		facingRight = false;
	}
}
@Override
public void fire(int x, int y, int vx, int vy) {
	// TODO Auto-generated method stub
	//useMelee();
	if(checkAmmo()){
		//if(weapon instanceof Pistol) // this may be the way to check weapons
		firePistol(hostile,x,y,vx,vy);
		weapon.reduceAmmoByOne();
	}
}
public void fire(int x, int y, int vx, int vy, int direction) {
	//rife is demo purpose only
	useMelee(direction);
	if(checkAmmo()){
		//if(weapon instanceof Pistol) // this may be the way to check weapons
		if(rifle)
			fireRifle(hostile,x,y,vx,vy);
		else
			fireExplosive(hostile, x, y, vx, vy);
		weapon.reduceAmmoByOne();
		//				fireExplosive(hostile, x, y, vx, vy);
		//UNCOMMENT METHOD ABOVE TO TEST EXPLOSIVES
	}
}
public static Arc2D.Double checkForMedKit(MCharacter c,MedKit medkit){
	//System.out.println("hello");
	int arcX = c.getX()+(c.getWidth()/2)-c.getVisionrange()/2;
	int arcY = c.getY()+(c.getHeight()/2)-c.getVisionrange()/2;
	int begindegree = 45;
	if(c.isMoveLeft())
		begindegree+=90;
	if(c.isMoveDown())
		begindegree+=180;
	if(c.isMoveRight())
		begindegree+=270;
	Arc2D.Double visioncone = new Arc2D.Double(arcX,arcY, c.getVisionrange(), c.getVisionrange(), begindegree, 90, Arc2D.PIE);
	//90, 225 change it to line of sight degree - 45 degree + 45
	
	if(visioncone.intersects(medkit.getRectitem())){
		medkit.setVisible(true);
	}
	return visioncone;
}
public void useMedkit(){
	item.useItem(this);
}
public boolean isRifle() {
	return rifle;
}
public void setRifle(boolean rifle) {
	this.rifle = rifle;
}
@Override
public boolean isRegen() {
	// TODO Auto-generated method stub
	return false;
}
@Override
public void setRegen(boolean regen) {
	// TODO Auto-generated method stub
	
}

}

		//	@Override
		//	public ItemState getItems() {
		//		// TODO Auto-generated method stub
		//		return null;
		//	}
		//
		//	@Override
		//	public OverworldSpriteControl move() {
		//		// TODO Auto-generated method stub
		//		return null;
		//	}

	

