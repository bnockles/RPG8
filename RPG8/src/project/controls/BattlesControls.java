package project.controls;

/** author Vincent */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.SwingUtilities;

import project.directors.Game;
import project.directors.Screen;

public class BattlesControls extends project.directors.Screen implements KeyListener,MenuInteraction{

	BufferedImage landscape;
	int x=300;
	int y=300;
	String s = "Swarm is idle";
	String idle=s;

	public BattlesControls(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void moveUp() {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveDown() {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveRight() {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_W){
			s = "Swarm walked up";
			y-=5;
			update();
		}
		if(keyCode == KeyEvent.VK_A){
			s = "Swarm walked left";
			x-=5;
			update();
		}
		if(keyCode == KeyEvent.VK_S){
			s = "Swarm walked down";
			y+=5;
			update();
		}
		if(keyCode == KeyEvent.VK_D){
			s = "Swarm walked right";
			x+=5;
			update();
		}
		if(keyCode == KeyEvent.VK_1){
			s = "Swarm equipped his melee weapon";
			update();
		}
		if(keyCode == KeyEvent.VK_2){
			s = "Swarm equipped his pistol";
			update();
		}
		if(keyCode == KeyEvent.VK_3){
			s = "Swarm equipped his SMG";
			update();
		}
		if(keyCode == KeyEvent.VK_4){
			s = "Swarm equipped his rifle";
			update();
		}
		if(keyCode == KeyEvent.VK_5){
			s = "Swarm equipped his heavy";
			update();
		}
		if(keyCode == KeyEvent.VK_6){
			s = "Swarm equipped his rocket launcher";
			update();
		}
		if(keyCode == KeyEvent.VK_G){
			s = "Swarm equipped his explosive";
			update();
		}
		if(keyCode == KeyEvent.VK_SHIFT){
			s = "Swarm started to sprint";
			update();
		}
		if(keyCode == KeyEvent.VK_E){
			s = "Swarm interacted with something on the map";
			update();
		}
		if(keyCode == KeyEvent.VK_R){
			s = "Swarm reloaded his weapon";
			update();
		}
		if(keyCode == KeyEvent.VK_F){
			s = "Swarm went on stealth mode";
			update();
		}
		if(keyCode == KeyEvent.VK_M){
			s = "The player opens a transparent outline of the map";
			update();
		}
		if(keyCode == KeyEvent.VK_ESCAPE){
			s = "The player opens the exit menu";
			update();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_W){
			s = idle;
			update();
		}
		if(keyCode == KeyEvent.VK_A){
			s = idle;
			update();
		}
		if(keyCode == KeyEvent.VK_S){
			s = idle;
			update();
		}
		if(keyCode == KeyEvent.VK_D){
			s = idle;
			update();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public void paintScreen(Graphics2D g2) {
		g2.setColor(Color.blue);
		g2.drawString(s,x, y);
	}

}
