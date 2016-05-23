package project.ChoiceMenuDemo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;

import project.directors.Game;
import project.directors.Screen;
import project.storyV2.Choices;

public class ChatLog extends Screen {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ChatLog(Game game) {
		super(game);
	}	
	
	public void paintScreen(Graphics2D g2) {
		g2.setColor(MenuTheme.greenBR);
		g2.fillRect(0, 0, width, height);
		
		//Text To Appear
		g2.setColor(Color.BLACK);
		g2.drawString("THIS IS A TEST", 100, 100);
	}

	public static void choiceMenu(String string, String string2, Graphics2D g2) {
		g2.setColor(Color.black);
		g2.fillRect(600, 400, 300, 200); //x,y,w,h
		//Make options appear
		g2.setColor(Color.WHITE);
		g2.drawString(string, 660, 470);
		g2.drawString(string2, 660, 550);
	}
	@Override
	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return null;
	}
}
