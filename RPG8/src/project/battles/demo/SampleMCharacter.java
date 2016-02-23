package project.battles.demo;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import project.controls.OverworldSpriteControl;
import project.save.ItemState;

public class SampleMCharacter extends SampleCharacter implements KeyListener,MouseListener{
	private int level;
	private int recovery;
	private int hpValue;
	private int armorValue;
	private int sneakValue;
	private SampleWeapon equippedWeapon;
	private ArrayList<SampleWeapon> loadout;
	public SampleMCharacter(String imgsrc,int recovery, int hpValue, int armorValue, int sneakValue){
		this.imgsrc = imgsrc;
		this.recovery= recovery;
		this.hpValue=  hpValue;
		this.armorValue = armorValue;
		this.sneakValue = sneakValue;
		sprite = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
		URL url = getClass().getResource(imgsrc);
		try{
			BufferedImage original = ImageIO.read(url);
			Graphics2D g = (Graphics2D) sprite.getGraphics();
			int w = original.getWidth();
			int h = original.getHeight();
			g.drawImage(original, 0, 0, width, height, 0, 0, w, h, null);
		}
		catch (IOException e){
			e.printStackTrace();
		}
		
	}
		public int getLevel() {
		return level;
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
	
	public BufferedImage getImage(){
		return sprite;
	}
	public void firePistol(){
		SampleProjectiles bullet = new SampleProjectiles(armorValue, armorValue, armorValue, armorValue, armorValue, armorValue, imgsrc);
		BattlesScreen.player.add(bullet);
		equippedWeapon.reduceAmmoByOne();
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
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

}
