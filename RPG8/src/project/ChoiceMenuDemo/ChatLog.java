package project.ChoiceMenuDemo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;

import project.directors.Game;
import project.directors.Screen;
import project.storyV2.Choices;

public class ChatLog{

	/**
	 * author Maxwell Sulavko
	 */
	
	public static String[][] chatLogged(String[][] arr, Graphics2D g2) {
		
		return arr;
	}

	public static void choiceMenu(String string, String string2, Graphics2D g2) {
		g2.setColor(Color.black);
		g2.fillRect(600, 400, 300, 200); //x,y,w,h
		//Make options appear
		g2.setColor(Color.WHITE);
		g2.drawString(string, 660, 470);
		g2.drawString(string2, 660, 550);
	}

}
