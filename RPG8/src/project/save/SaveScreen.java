package project.save;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import project.ChoiceMenuDemo.GridToSee;
import project.directors.Game;
import project.directors.Screen;
import project.mainmenudemo.MainMenuScreen;
import project.tooltipdemo.TestScreen;

public class SaveScreen extends Screen implements KeyListener {
	
	private int currSelection = 0;

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
		for (int i = 0; i < 3; i++) {
			// Print bigger rectangle for selected option
			if (i == currSelection) {
				g2.setColor(new Color(189, 195, 199));
				g2.fillRect(90, 175 * i + 250 - 10, width - 200 + 20, 100 + 20);
			}
			
			g2.setColor(new Color(149, 165, 166));
			g2.fillRect(100, 175 * i + 250, width - 200, 100);
			
			g2.setColor(new Color(44, 62, 80));
			g2.drawString("Save File " + (i + 1) , 120, 175 * i + 250 + 66);
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
			Save.chooseSave(currSelection);
			this.game.setScreen(new GridToSee(this.game));
		}
		if (e.getKeyCode()== KeyEvent.VK_DOWN) {
			currSelection = (currSelection + 1) % 3;
			update();
		}
		if (e.getKeyCode()== KeyEvent.VK_UP) {
			currSelection = currSelection - 1;
			if (currSelection < 0) currSelection = 2;
			update();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
