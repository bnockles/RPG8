package project.menus.selections;

import java.awt.Color;
import java.awt.Graphics2D;

import project.directors.UtilityMethods;
import project.menus.Selection;

public class NewGameSelection extends Selection{

	public NewGameSelection(int w, int h) {
		super(w, h);
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

	}

	
	
}
