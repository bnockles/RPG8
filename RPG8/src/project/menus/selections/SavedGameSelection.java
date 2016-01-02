package project.menus.selections;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import project.directors.GameFile;
import project.menus.Selection;

public class SavedGameSelection extends Selection {

	GameFile gameFile;
	
	public SavedGameSelection(int w, int h, GameFile gf) {
		super(w, h);
		this.gameFile=gf;
	}

	@Override
	public void paintSelected(Graphics2D g2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void paintUnselected(Graphics2D g2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void confirm() {
		gameFile.load();
	}



}
