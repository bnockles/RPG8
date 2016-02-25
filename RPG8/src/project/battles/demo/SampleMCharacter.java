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

import project.controls.OverworldSpriteControl;
import project.save.ItemState;

public class SampleMCharacter extends SampleCharacter implements KeyListener,MouseListener{
	private int level;
	private int exp;
	private int recovery;
	private int hpValue;
	private int armorValue;
	private int sneakValue;
	private SampleWeapon equippedWeapon;
	private ArrayList<SampleWeapon> loadout;
	public SampleMCharacter(BufferedImage[][] images,int recovery, int hpValue, int armorValue, int sneakValue){
		this.bsprite = images[0];
		this.fsprite = images[1];
		this.lsprite = images[2];
		this.rsprite = images[3];
		this.imgsrc = imgsrc;
		this.recovery= recovery;
		this.hpValue=  hpValue;
		this.armorValue = armorValue;
		this.sneakValue = sneakValue;
//		sprite = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
//		URL url = getClass().getResource(imgsrc);
//		try{
//			BufferedImage original = ImageIO.read(url);
//			Graphics2D g = (Graphics2D) sprite.getGraphics();
//			int w = original.getWidth();
//			int h = original.getHeight();
//			g.drawImage(original, 0, 0, width, height, 0, 0, w, h, null);
//		}
//		catch (IOException e){
//			e.printStackTrace();
//		}

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
	
	public void firePistol(int tx, int ty){//target location
		SampleProjectiles bullet = new SampleProjectiles(positionX, positionY, 0, tx, ty, 100, imgsrc);
		BattlesScreen.player.add(bullet);
		equippedWeapon.reduceAmmoByOne();
	}
	public void useMelee(){
		//requires pelham's class
	}
	public void useExplovies(){
		//requires a new class
	}
	public void fireRifle(int tx, int ty){
		SampleProjectiles bullet = new SampleProjectiles(positionX, positionY, 0, tx, ty, 200, imgsrc);
		BattlesScreen.player.add(bullet);
		equippedWeapon.reduceAmmoByOne();
	}
	public void fireHeavy(int tx, int ty){
		SampleProjectiles bullet = new SampleProjectiles(positionX, positionY, 0, tx, ty, 200, imgsrc);
		SampleProjectiles bullet1 = new SampleProjectiles(positionX, positionY, 0, tx, ty, 200, imgsrc);
		BattlesScreen.player.add(bullet);
		BattlesScreen.player.add(bullet1);
		equippedWeapon.reduceAmmoByOne();
	}
	public void fireSMG(int tx, int ty){
		SampleProjectiles bullet = new SampleProjectiles(positionX, positionY, 0, tx, ty, 200, imgsrc);
		BattlesScreen.player.add(bullet);
		equippedWeapon.reduceAmmoByOne();
	}

}
