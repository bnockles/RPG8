package project.tooltipdemo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import project.ChoiceMenuDemo.MenuTheme;
import project.directors.Game;
import project.directors.Screen;

public class DialogueDemo extends Screen implements KeyListener {

	public DialogueDemo(Game game) {
		super(game);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void paintScreen(Graphics2D g2) {
		g2.setColor(MenuTheme.greenBR);
		g2.fillRect(0, 0, width, height);
		
		//Text To Appear
		g2.setColor(Color.BLACK);
		g2.drawString("THIS IS A BAD TEST", 100, 100);
		
	}
	
	

}
