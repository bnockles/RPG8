package project.ChoiceMenuDemo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import project.directors.Game;
import project.directors.Screen;



public class GridToSee extends Screen implements KeyListener{

	public static int highl = 0;
	ArrayList<ChoiceDesc> choice;
	Color selectBlue = new Color (30, 60, 100);
	
	public GridToSee(Game game) {
		super(game);

		this.choice = new ArrayList<ChoiceDesc>();
		choice.add(new ChoiceDesc("Box 1", new File("resources/samusr.jpg"), "Go left to go to end"));
		choice.add(new ChoiceDesc("Box 2", new File("resources/image1.jpg"), "Desc"));
		choice.add(new ChoiceDesc("Box 3", new File("resources/samusl.jpg"), "Desc"));
		choice.add(new ChoiceDesc("Box 4", new File("resources/image2.gif"), "PROPERTY OF MAX"));
		choice.add(new ChoiceDesc("Box 5", new File("resources/image3.png"), "DO NOT STEAL"));
		choice.add(new ChoiceDesc("Box 6", new File("resources/image4.png"), "Go right to go to start"));

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			highl++;
			System.out.println("move pls");
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
		return this;
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

		
		Font def = new Font ("Helvetica", Font.BOLD, 30);
		g2.setFont(def);
		g2.setColor(Color.white);
		g2.drawString(choice.get(0).name, 128, 160);
		g2.drawString(choice.get(1).name, 388, 160);
		g2.drawString(choice.get(2).name, 648, 160);
		g2.drawString(choice.get(3).name, 128, 470);
		g2.drawString(choice.get(4).name, 388, 470);
		g2.drawString(choice.get(5).name, 648, 470);
		
		//only selected box shows image
		BufferedImage boxImg = null;
		try {
			int x1 = highl;
			if(x1 > 5) x1 = 0;
			if(x1 < 0) x1 = 5;
			boxImg = ImageIO.read(choice.get(x1).pic);
		} catch (IOException e) {
		}
		g2.drawImage(boxImg, (x + 6), (y + 57), 120, 120, null);
	}
}

