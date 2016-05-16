package project.save;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import project.directors.Game;
import project.directors.Screen;
import project.directors.UtilityMethods;

public class SaveScreen extends Screen implements KeyListener {

	public SaveScreen(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}
	
	public void paintScreen(Graphics2D g2) {
		// TODO Auto-generated method stub
		g2.setColor(Color.LIGHT_GRAY);
		g2.fillRect(0, 0, width, height);
		
		String startText = "Testing texts";
		UtilityMethods.centerText(g2, startText, width, height);
	}

	@Override
	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
