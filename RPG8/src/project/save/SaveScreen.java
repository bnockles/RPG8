package project.save;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import project.directors.Game;
import project.directors.Screen;

public class SaveScreen extends Screen implements KeyListener {

	public SaveScreen(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void paintScreen(Graphics2D g2) {
		// Header
		Font sansSerif = new Font("Helvetica", Font.PLAIN, 60);
		Font serif = new Font("Times", Font.PLAIN, 46);
		
		g2.setColor(new Color(44, 62, 80));
		g2.fillRect(0, 0, width, height);
		
		g2.setColor(new Color(149, 165, 166));
		g2.fillRect(100, 100, 100, 100);
		
		g2.setFont(sansSerif);
		g2.drawString("Save Selection", 220, 200);
		g2.setFont(serif);
		
		// Option Boxes
		for (int i = 1; i< 4; i++) {
			g2.fillRect(100, 175 * i + 75, width - 200, 100);
			g2.fillRect(100, 175 * i + 72 + 2, width - 200, 100);
			g2.drawString("Save File " + 1, 120, 175 * i + 75);
		}
	}

	@Override
	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			// Enter save or something like that
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
