package project.battles.demo;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import project.battles.Projectiles;
import project.controls.OverworldSpriteControl;
import project.save.ItemState;
/**
 * 
 * 	FINISHED TRANSFERRING CLASS TO SAMPLEMCHARACTER
 * 	DO NOT WORK ON THIS CLASS
 * 	GO TO CLASS MCHARACTER TO DO YOUR WORK
 *
 */
public class SampleMCharacter extends SampleCharacter implements KeyListener,MouseListener{
	private int level;
	private int exp;
	private int recovery;
	private int hpValue;
	private int armorValue;
	private int sneakValue;
	private SampleWeapon equippedWeapon;
	private ArrayList<SampleWeapon> loadout;
	
	public SampleMCharacter(BufferedImage[][] images,int recovery, int maxHP, int armorValue, int sneakValue, int x, int y){
		super(images,maxHP,x,y);
		this.recovery= recovery;
		this.armorValue = armorValue;
		this.sneakValue = sneakValue;
		this.x = x;
		this.y = y;
	}
	public int getLevel() {
		return level;
	}
	
	public void gainExp(int xp){
		exp+= xp;
		if (exp >= 100){
			level++;
			exp = exp%100;
		}
	}
	
	

	public int getRecovery() {
		return recovery;
	}

	public int getHpValue() {
		return hpValue;
	}

	public int getArmorValue() {
		return armorValue;
	}

	public int getSneakValue(){ 
		return sneakValue;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//equippedWeapon.fire(false);


	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	protected ItemState getItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected OverworldSpriteControl move() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		/*
		 * Animation, use pictures for animation 
		 * add picture of the weapon
		 * 
		 * */
		int key = e.getKeyCode();

		if(key == KeyEvent.VK_UP){

		}
		if(key == KeyEvent.VK_DOWN){

		}
		if(key == KeyEvent.VK_LEFT){

		}
		if(key == KeyEvent.VK_RIGHT){

		}
	}

	//leftclik
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	
	public void firePistol(int vx, int vy){//target location
		/**
		 * Yifan
		 */
		Projectiles bullet = new Projectiles(x, y, 0, vx, vy, 400, BattlesScreen.projectiledemo);
		BattlesScreen.pBullets.add(bullet);
	}
	public void useMelee(){
		//requires pelham's class
	}
	public void useExplovies(){
		//requires a new class
	}
	public void fireRifle(int vx, int vy){
		/**
		 * Yifan
		 */
		Projectiles bullet = new Projectiles(x, y, 0, vx, vy, 800, BattlesScreen.projectiledemo);
		BattlesScreen.pBullets.add(bullet);
		equippedWeapon.reduceAmmoByOne();
	}
	public void fireHeavy(int vx, int vy){
		/**
		 * Yifan
		 */
		Projectiles bullet = new Projectiles(x, y, 0, vx, vy, 800, BattlesScreen.projectiledemo);
		Projectiles bullet1 = new Projectiles(x, y, 0, vx, vy, 800, BattlesScreen.projectiledemo);
		BattlesScreen.pBullets.add(bullet);
		BattlesScreen.pBullets.add(bullet1);
		equippedWeapon.reduceAmmoByOne();
	}
	public void fireSMG(int vx, int vy){
		/**
		 * Yifan
		 */
		Projectiles bullet = new Projectiles(x, y, 0, vx, vy, 800, BattlesScreen.projectiledemo);
		BattlesScreen.pBullets.add(bullet);
		equippedWeapon.reduceAmmoByOne();
	}
	@Override
	public BufferedImage getImage() {
		/**
		 * Chieh-Huang Chen
		 */
		// TODO Auto-generated method stub
		increaseCount();
			if(moveUp == true){
				if((count >= 0 && count < 5) || (count >= 10 && count < 15))
					return bsprite[0];
				if(count >= 5 && count < 10)
					return bsprite[1];
				if(count >= 15 && count < 20)
				return bsprite[2];
			}
 
			if(moveDown == true){
				if((count >= 0 && count < 5) || (count >= 10 && count < 15))
					return fsprite[0];
				if(count >= 5 && count < 10)
					return fsprite[1];
				if(count >= 15 && count < 20)
				return fsprite[2];
			}
			if(moveLeft == true){
				if((count >= 0 && count < 5) || (count >= 10 && count < 15))
					return lsprite[0];
				if(count >= 5 && count < 10)
					return lsprite[1];
				if(count >= 15 && count < 20)
				return lsprite[2];
			}

			if(moveRight == true){
				if((count >= 0 && count < 5) || (count >= 10 && count < 15))
					return rsprite[0];
				if(count >= 5 && count < 10)
					return rsprite[1];
				if(count >= 15 && count < 20)
				return rsprite[2];
			}
		return fsprite[0];
	}

}
