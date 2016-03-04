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
import project.mainmenudemo.MainMenuScreen;
import project.ChoiceMenuDemo.MenuTheme;

/**
 * 
 * @author Maxwell Sulavko
 *
 */

public class GridToSee extends Screen implements KeyListener{

	boolean choices = false; //controls if control over main or sub menu
	public int highl = 0;
	
	ArrayList<ChoiceDesc> choice;
	
	

	Font def = new Font ("Helvetica", Font.BOLD, 30);
	Font smallerDef = new Font("Helvetica", Font.BOLD, 20);
	int x = 123;
	int y = 128;
	int w = 234;
	int x2 = 0;
	int y2 = 0;
	int numberOfBoxes = 0;
	
	
	public GridToSee(Game game) {
		super(game);

		this.choice = new ArrayList<ChoiceDesc>();
		choice.add(new ChoiceDesc("Box 1", new File("resources/samusr.jpg"), "Go left to go to end", ""));
		choice.add(new ChoiceDesc("Box 2", new File("resources/image1.jpg"), "PROPERTY OF MAX", ""));
		choice.add(new ChoiceDesc("Box 3", new File("resources/samusl.jpg"), "DO", ""));
		choice.add(new ChoiceDesc("Box 4", new File("resources/image2.gif"), "NOT", ""));
		choice.add(new ChoiceDesc("Box 5", new File("resources/image3.png"), "STEAL", ""));
		choice.add(new ChoiceDesc("Box 6", new File("resources/image4.png"), "Go right to go to start", ""));
	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			highl++;
			highl = highl % numberOfBoxes;
			update();
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			highl--;
			if (highl < 0) highl = (highl + numberOfBoxes);
			update();
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			highl += (numberOfBoxes/2);
			highl = highl % numberOfBoxes;
			update();
		}
		
		if(e.getKeyCode() == KeyEvent.VK_UP){
			highl -= (numberOfBoxes/2);
			if (highl < 0) highl = (highl + numberOfBoxes);
			update();
		}
		
		if(e.getKeyCode()== KeyEvent.VK_SPACE){
			choices = true;
			highl = 0;
			update();
		}	
		if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
			this.game.setScreen(new MainMenuScreen(this.game));
		}
	
	}
	
	public void paintScreen(Graphics2D g2) {
		if (choices == false) {
			numberOfBoxes = 6;
		}
		else {
			numberOfBoxes = 4;
		}
		
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
		
		
		
		if (highl == 0){
			x = 123;
			y = 128;
			x2 = 85;
			y2 = 115;
		}
		if (highl == 1){
			x = 383;
			y = 128;
			x2 = 585;
			y2 = 115;
		}
		if (highl == 2){
			x = 643;
			y = 128;
			x2 = 85;
			y2 = 515;
		}	
		if (highl == 3){
			x = 123;
			y = 438;
			x2 = 585;
			y2 = 515;
		}
		if (highl == 4){
			x = 383;
			y = 438;
		}
		if (highl == 5){
			x = 643;
			y = 438;
		}
		
	
		if (choices  == false){
			g2.setColor(selectBlue); 
			g2.fillRect(x, y, w, w); //its a square anyway
		}
		
		g2.setFont(def);
		g2.setColor(Color.white);
		g2.drawString(choice.get(0).name, 128, 160);
		g2.drawString(choice.get(1).name, 388, 160);
		g2.drawString(choice.get(2).name, 648, 160);
		g2.drawString(choice.get(3).name, 128, 470);
		g2.drawString(choice.get(4).name, 388, 470);
		g2.drawString(choice.get(5).name, 648, 470);
		
		if (choices == false){
			//only selected box shows image
			BufferedImage boxImg = null;
			try {
				boxImg = ImageIO.read(choice.get(highl).pic);
			} catch (IOException e) {
			}
			g2.drawImage(boxImg, (x + 6), (y + 50), 120, 120, null);
			g2.drawString(choice.get(highl).sel, (x + 195), (y+33)); //this is choice selected if I do that
			g2.setFont(smallerDef);
			g2.drawString(choice.get(highl).des, (x + 3), (y+200));
			
		}
		
		if (choices == true){
			int w2 = 50;
			
			g2.setColor(Color.darkGray); //background of submenu
			g2.fillRect(10, 40, 750, 600);
			
			g2.setColor(selectBlue); //Selection color
			g2.fillRect(x2, y2, w2, w2);
			
			
			g2.setColor(Color.white);
			g2.drawString("Y", 100, 150);
			g2.drawString("N", 600, 150);
			g2.drawString("D", 100, 550);
			g2.drawString("C", 600, 550);
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

}

