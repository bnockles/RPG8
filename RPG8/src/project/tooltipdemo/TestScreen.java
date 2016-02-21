package project.tooltipdemo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import project.directors.Game;
import project.directors.Screen;
import project.mainmenudemo.MainMenuSelectables;

public class TestScreen extends Screen implements KeyListener {

	public static int selection = 0;
	ArrayList<TooltipOption> options;
	
	public TestScreen(Game game) {
		super(game);
		new OptionList();
		options.add(new TooltipOption("Option 1"));
		options.add(new TooltipOption("Option 2"));
		options.add(new TooltipOption("Option 3"));
		options.add(new TooltipOption("Option 4"));
	}

	/**
	 * @param args
	 */

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			selection++;
			if(selection > 3){
				selection = 0;
			}
			update();
		}
		if(e.getKeyCode() == KeyEvent.VK_UP){
			selection--;
			if(selection < 0){
				selection = 3;
			}
			update();
		}
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
		// TODO Auto-generated method stub
		g2.setColor(Color.white);
		g2.fillRect(0, 0, width, height);
	}

}
