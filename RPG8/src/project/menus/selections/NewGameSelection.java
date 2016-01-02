package project.menus.selections;

import java.awt.Color;
import java.awt.Graphics2D;

import project.directors.Game;
import project.directors.UtilityMethods;
import project.menus.Selection;
import project.overworld.DemoOverworld;

public class NewGameSelection extends Selection{

	Game game;
	
	public NewGameSelection(int w, int h, Game game) {
		super(w, h);
		this.game=game;
	}

	@Override
	public void paintSelected(Graphics2D g2) {
		g2.setColor(Color.black);
		g2.fillRect(0, 0, width, height);
		g2.setColor(Color.white);
		UtilityMethods.centerText(g2, "New Game", width, height);
	}

	@Override
	public void paintUnselected(Graphics2D g2) {
		g2.setColor(Color.white);
		g2.fillRect(0, 0, width, height);
		g2.setColor(Color.black);
		UtilityMethods.centerText(g2, "New Game", width, height);
	}

	@Override
	public void confirm() {
		/**Note: this method was written for demo purposes only.
		Currently, it simply sets the game screen to the DemoOverworld.
		This method does NOT create a new save file or load anything information
		*/
		game.setScreen(new DemoOverworld(game));
	}

	
	
}
