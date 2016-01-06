package project.menus.selections;

import java.awt.Color;
import java.awt.Graphics2D;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import project.directors.Game;
import project.directors.UtilityMethods;
import project.menus.Selection;
import project.overworld.DemoOverworld;

public class GameSelection extends Selection{

	Game game;
	boolean newGame;
	long creationTime;
	String fileLocation;
	
	public GameSelection(int w, int h, Game game, boolean newGame, long creationTime, String fileLocation) {
		super(w, h);
		this.game=game;
		this.newGame=newGame;
		this.creationTime=creationTime;
		this.fileLocation=fileLocation;
	}

	@Override
	public void paintSelected(Graphics2D g2) {
		g2.setColor(Color.black);
		g2.fillRect(0, 0, width, height);
		g2.setColor(Color.white);
		if(newGame)UtilityMethods.centerText(g2, "New Game", width, height);
		else {
			Date date=new Date(creationTime);
			UtilityMethods.centerText(g2, "Save File created: "+date, width, height);
		}
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
		if(newGame)creationTime=System.currentTimeMillis();
		System.out.println(fileLocation);
		game.loadGame(fileLocation);
		game.setScreen(new DemoOverworld(game));
		
	}

	public String getFileLocation() {
		return fileLocation;
	}
	
	public long getCreationTime(){
		return creationTime;
	}
}
