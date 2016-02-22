package ChoiceMenuDemo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;

import project.directors.Game;
import project.directors.Screen;



public class GridToSee extends Screen implements KeyListener{

	public static int highl = 0;
	ArrayList<ChoiceDesc> choice;
	Color selectBlue = new Color (30, 60, 100);
	
	public GridToSee(Game game) {
		super(game);

		this.choice = new ArrayList<ChoiceDesc>();
		choice.add(new ChoiceDesc("Box 1", new File("resources/image1.jpg"), "Go left to go to end"));
		choice.add(new ChoiceDesc("Box 2", new File("resources/image1.jpg"), "Desc"));
		choice.add(new ChoiceDesc("Box 3", new File("resources/image1.jpg"), "Desc"));
		choice.add(new ChoiceDesc("Box 4", new File("resources/image1.jpg"), "Desc"));
		choice.add(new ChoiceDesc("Box 5", new File("resources/image1.jpg"), "Desc"));
		choice.add(new ChoiceDesc("Box 6", new File("resources/image1.jpg"), "Go right to go to start"));

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			highl++;
			if(highl > 6) highl = 0;
			update();
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			highl--;
			if(highl < 0)highl = 6;
			update();
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			highl += 3;
			if (highl > 5) highl = (highl - 6) ;
		}
			update();
		if(e.getKeyCode() == KeyEvent.VK_UP){
			highl-= 3;
			if(highl < 0){
				highl = (highl + 6);
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
		
		g2.setColor(Color.GRAY);
		g2.fillRect(0, 0, width, height);
		
		g2.setColor(Color.black);
		
		//The 6 grid boxes
		g2.fillRect(125, 130, 230, 230);
		g2.fillRect(385, 130, 230, 230);
		g2.fillRect(645, 130, 230, 230);
		g2.fillRect(125, 440, 230, 230);
		g2.fillRect(385, 440, 230, 230);
		g2.fillRect(645, 440, 230, 230);
		
		
		int x = 123;
		int y = 128;
		int h = 234;
		int w = 234;
		
		if (highl == 0){
			x = 123;
			y = 128;
		}
		if (highl == 1){
			x = 383;
			y = 128;
		}
		if (highl == 2){
			x = 643;
			y = 128;
		}
		if (highl == 3){
			x = 123;
			y = 438;
		}
		if (highl == 4){
			x = 383;
			y = 438;
		}
		if (highl == 5){
			x = 643;
			y = 438;
		}
		
		
		g2.setColor(selectBlue);
		g2.fillRect(x,y,w,h);

		
		Font times = new Font ("TimesRoman", Font.CENTER_BASELINE, 60);
		Font subTimes = new Font ("TimesRoman", Font.ROMAN_BASELINE, 50);
		g2.setFont(times);
		g2.setColor(Color.white);
		//g2.drawString(choice.get(0).des, 395, 350);
		//g2.drawString(choice.get(1).name, 390, 470);
		//g2.drawString(choice.get(2).name, 500, 590);
		//g2.drawString(choice.get(3).name, 450, 710);
	}
}
