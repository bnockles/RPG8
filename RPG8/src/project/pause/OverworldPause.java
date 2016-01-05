package project.pause;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import project.directors.Game;
import project.directors.Screen;
import project.overworld.DemoOverworld;

public class OverworldPause extends Screen implements KeyListener{

	//saves game state of over world so can resume play after pause is ended
	DemoOverworld gameState;
	int menuWidth = 800;
	int menuHeight = 400;
	
	public OverworldPause(Game game, DemoOverworld overworld) {
		super(game);
		gameState = overworld;
	}

	@Override
	public KeyListener getKeyListener() {
		return this;
	}

	@Override
	public void paintScreen(Graphics2D g2) {
		//paints the overworld in the background
		g2.drawImage(gameState.getScreenImage(), 0, 0, width, height, 0, 0, gameState.getScreenImage().getWidth(), gameState.getScreenImage().getHeight(), null);
		g2.fillRect((width-menuWidth)/2, (height-menuHeight)/2, menuWidth, menuHeight);
		g2.setColor(Color.WHITE);
		int margin = (width-menuWidth)/2+10;
		int y = (height-menuHeight)/2+20;
		g2.drawString("Press \'S\' to save", margin, y);
		y+=20;
		g2.drawString("Press \'SPACE\' to return to game", margin, y);
		y+=20;
		g2.drawString("Press \'Q\' to quit", margin, y);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int kc = e.getKeyCode();
		if(kc==KeyEvent.VK_SPACE){
			game.setScreen(gameState);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
	
	}

}
