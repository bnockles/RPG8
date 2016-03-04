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
import project.mainmenudemo.DynamicMenu;
import project.ChoiceMenuDemo.MenuTheme;

/**
 * 
 * @author Maxwell Sulavko
 *
 */

public class GridToSee extends Screen implements KeyListener{
	
	
	public static final int MAIN_GRID = 0;
	public static final int MINI_SUB = 1;
	public static final int THEME_MENU = 2;
	
	int choices = MAIN_GRID; //controls if control over main or sub menu
	
	public int highl = 0;
	
	ArrayList<ChoiceDesc> choice;
	
	Font def = new Font ("Helvetica", Font.BOLD, 30);
	Font smallerDef = new Font("Helvetica", Font.BOLD, 20);
	Font themeFont = new Font("Impact", Font.BOLD, 40);
	
	int x = 123;
	int y = 128;
	int w = 234;
	int x2 = 0;
	int y2 = 0;
	int x3 = 0;
	
	int numberOfBoxes = 0;
	int selectMem = 0;
	
	
	public GridToSee(Game game) {
		super(game);
		MenuTheme.setTheme(0);
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
			if (choices == MAIN_GRID){
				selectMem = highl;
				highl = 0;
			}
			if (choices == THEME_MENU){
				if (highl == 0){
					MenuTheme.setTheme(0);
				}
				if (highl == 1){
					MenuTheme.setTheme(1);
				}
				choices = MAIN_GRID;
				highl = selectMem;
				return;
			}
			if (choices == MINI_SUB){
				if (highl == 0){
					ChoiceDesc.setSel("Y");
				}
				if (highl == 1){
					ChoiceDesc.setSel("N");
				}
				if (highl == 2){
					ChoiceDesc.setSel("D");
				}
				if (highl == 3){
					ChoiceDesc.setSel("C");
				}
				choices = MAIN_GRID;
				highl = selectMem;
				return; 
			}
			choices = MINI_SUB;
			update();
		}	
		if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
			if (choices != MINI_SUB){
				this.game.setScreen(DynamicMenu.createMenu(DynamicMenu.MAIN_MENU, this.game));
			}
		}
		if(e.getKeyCode()== KeyEvent.VK_C){
			if (choices == MINI_SUB){
				choices = MAIN_GRID;
				highl = selectMem;
			}	
		}
		if(e.getKeyCode()== KeyEvent.VK_D){
			if (choices != MINI_SUB){
				choices = THEME_MENU;
				highl = 0;
			}
		}	
		
	}
	
	public void paintScreen(Graphics2D g2) {
		if (choices == MAIN_GRID) {
			numberOfBoxes = 6;
		}
		else if (choices == MINI_SUB) {
			numberOfBoxes = 4;
		}
		else if (choices == THEME_MENU) {
			numberOfBoxes = 2;
		}
		
		if (highl == 0){
			x = 123;
			y = 128;
			x2 = 125;
			y2 = 265;
			x3 = 100;
		}
		if (highl == 1){
			x = 383;
			y = 128;
			x2 = 265;
			y2 = 265;
			x3 = 500;
		}
		if (highl == 2){
			x = 643;
			y = 128;
			x2 = 125;
			y2 = 405;
		}	
		if (highl == 3){
			x = 123;
			y = 438;
			x2 = 265;
			y2 = 405;
		}
		if (highl == 4){
			x = 383;
			y = 438;
		}
		if (highl == 5){
			x = 643;
			y = 438;
		}
		

		if (choices  == MAIN_GRID){
			g2.setColor(MenuTheme.bR);
			g2.fillRect(0, 0, width, height);
			
			g2.setColor(MenuTheme.boxColor);
			
			//The 6 grid boxes
			g2.fillRect(125, 130, 230, 230);
			g2.fillRect(385, 130, 230, 230);
			g2.fillRect(645, 130, 230, 230);
			g2.fillRect(125, 440, 230, 230);
			g2.fillRect(385, 440, 230, 230);
			g2.fillRect(645, 440, 230, 230);
			
			//THE SELECTION BOX
			g2.setColor(MenuTheme.selectColor); 
			g2.fillRect(x, y, w, w); //its a square anyway
			
			//FILLING IN THE INFO ON BOXES
			g2.setFont(def);
			g2.setColor(MenuTheme.textColor);
			g2.drawString(choice.get(0).name, 128, 160);
			g2.drawString(choice.get(1).name, 388, 160);
			g2.drawString(choice.get(2).name, 648, 160);
			g2.drawString(choice.get(3).name, 128, 470);
			g2.drawString(choice.get(4).name, 388, 470);
			g2.drawString(choice.get(5).name, 648, 470);
			
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
		
		if (choices == MINI_SUB){
			g2.setFont(def);
			int w2 = 50;
			
			g2.setColor(MenuTheme.subBr); //background of submenu
			g2.fillRect(0, 0, width, height);
			
			g2.setColor(MenuTheme.selectColor); //Selection color
			g2.fillRect(x2, y2, w2, w2);
			
			g2.fillRect(500, 250, 230, 230); //SELECTED BOX FROM GRID
			g2.setColor(MenuTheme.textColor);
			g2.drawString(choice.get(selectMem).name, 503, 280);
			BufferedImage boxImg = null;
			try {
				boxImg = ImageIO.read(choice.get(selectMem).pic);
			} catch (IOException e) {
			}
			g2.drawImage(boxImg, 506, 300, 120, 120, null);
			g2.setFont(smallerDef);
			g2.drawString(choice.get(selectMem).des, 506, 450);
			
			g2.setColor(Color.white);
			g2.drawRect(105 , 240, 230, 230);
			g2.setFont(def);
			g2.drawString("Y", 140, 300);
			g2.drawString("N", 280, 300);
			g2.drawString("D", 140, 440);
			g2.drawString("C", 280, 440);
		}
		if (choices == THEME_MENU){
			g2.setColor(MenuTheme.bR);
			g2.fillRect(0, 0, width, height);
			
			//BR BLACK BOX
			g2.setColor(MenuTheme.boxColor);
			g2.fillRect(00, 130, 1000, 500);
			
			g2.setColor(MenuTheme.selectColor); //Selection color
			g2.fillRect(x3, 200, 380, 350);
			
			g2.setColor(Color.WHITE);
			//TWO BOXES WITH THEMES 
			g2.drawRect(100, 200, 380, 350);
			g2.drawRect(500, 200, 380, 350);
			
			g2.setFont(themeFont);
			g2.drawString("DEFAULT THEME", 110, 240);
			
			g2.setColor(Color.GREEN);
			g2.drawString("GREEN THEME", 510, 240);

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

