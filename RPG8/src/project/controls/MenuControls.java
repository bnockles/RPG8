package project.controls;

/** author Jacky */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import project.directors.Game;
import project.directors.Screen;

public class MenuControls extends project.directors.Screen implements KeyListener,MenuInteraction{

	BufferedImage landscape;
	int width=500;
	int height=500;
	String string1 = "";

	public MenuControls(Game game) {
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
		if(keyCode == 13){
			string1 = "You have pressed Enter";
			update();
		};
		if(keyCode == 16){
			string1 = "You have pressed Shift";
			update();
		};
		if(keyCode == 17){
			string1 = "You have pressed Ctrl";
			update();
		};
		if(keyCode == 18){
			string1 = "You have pressed Alt";
			update();
		};
		if(keyCode == 27){
			string1 = "You have pressed Escape";
			update();
		};

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		char keyTy = e.getKeyChar();
		if(keyTy == 'w'){
			string1 = "You have pressed W";
			update();
		}
		if(keyTy == 's'){
			string1 = "You have pressed S";
			update();
		}
		if(keyTy == 'a'){
			string1 = "You have pressed A";
			update();
		}
		if(keyTy == 'd'){
			string1 = "You have pressed D";
			update();
		}

	}

	@Override
	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public void paintScreen(Graphics2D g2) {
		g2.setColor(Color.blue);
		g2.drawString(string1,100, 100);
	}

}
