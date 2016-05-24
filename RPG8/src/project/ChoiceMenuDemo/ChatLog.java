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
		int row = 0;
		for (int r = 0; r < DialogueDemo.getName(); r++) {
			for (int c = 0; c < DialogueDemo.getBranchNone()[0].length; c++) {
				arr[r][c] = DialogueDemo.getBranchNone()[r][c];
			}
			row++;
		}
		if (DialogueDemo.isnChosen() == false){
			for (int r = 0; r < DialogueDemo.getName(); r++) {
				row++;
				for (int c = 0; c < DialogueDemo.getBranchNone()[0].length; c++) {
					if (DialogueDemo.getC() == 0)
						arr[row - 1][c] = DialogueDemo.getBranch1()[r][c];
					else
						arr[row - 1][c] = DialogueDemo.getBranch2()[r][c];
				}
				
			}
		}
		//MAKE BR BLACK
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, 1000, 800);
		//MAKE THE TEXT APPEAR
		g2.setColor(Color.white);
		int x = 100;
		int y = 100;
		for (int i = 0; i < row; i++) {
			g2.drawString(arr[i][0] + ":", x, y);
			g2.drawString(arr[i][1], x + 150, y);
			y += 30;
		}
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
