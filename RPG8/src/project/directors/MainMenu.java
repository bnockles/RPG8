package project.directors;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import project.menus.GameMenu;

public class MainMenu extends Screen {

	GameMenu gameFilesMenu;
	
	public MainMenu(Game game) {
		super(game);
		gameFilesMenu=new GameMenu(this.width, this.height, game);
	}

	@Override
	public void paintScreen(Graphics2D g2) {
		gameFilesMenu.update();//in every paintScreen method, update children components
		g2.drawImage(gameFilesMenu.getImage(), 0, 0,null);
	}

	@Override
	public KeyListener getKeyListener() {
		return gameFilesMenu;//KeyListener is implemented in superclass VerticalMenu
	}


}
