package project.directors;


import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StartScreen extends Screen implements KeyListener{


	public StartScreen(Game game) {
		super(game);
	}

	@Override
	public void paintScreen(Graphics2D g2) {
		String startText = "Press Space Bar to start";
		UtilityMethods.centerText(g2, startText, width, height);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode==KeyEvent.VK_SPACE){
			Screen mainMenu = new MainMenu(game);
			game.setScreen(mainMenu);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public KeyListener getKeyListener() {
		return this;
	}

}
