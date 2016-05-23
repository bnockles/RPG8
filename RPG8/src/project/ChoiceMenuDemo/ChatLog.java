package project.ChoiceMenuDemo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;

import project.directors.Game;
import project.directors.Screen;
import project.storyV2.Choices;
import project.tooltipdemo.DialogueDemo;

public class ChatLog{

	/**
	 * author Maxwell Sulavko
	 */
	
	public static String[][] chatLogged(String[][] arr, Graphics2D g2) {
	
		for (int r = 0; r < DialogueDemo.getBranchNone().length - DialogueDemo.getName(); r++) {
			for (int c = 0; c < DialogueDemo.getBranchNone()[0].length; c++) {
				arr[r][c] = DialogueDemo.getBranchNone()[r][c];
				int row = r;
				int col = c;
			}
		}
		if (DialogueDemo.isnChosen() == true){}
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
