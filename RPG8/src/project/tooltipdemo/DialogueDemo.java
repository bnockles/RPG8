package project.tooltipdemo;
/**
 * @author Mark Mozgovoy & Maxwell Sulavko
 */
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;

import project.ChoiceMenuDemo.ChatLog;
import project.ChoiceMenuDemo.MenuTheme;
import project.directors.Game;
import project.directors.Screen;
import project.menus.Tooltip;
import project.menus.TooltipOptions;


public class DialogueDemo extends Screen implements KeyListener {
	
	static String[][] branchNone = {{"Icefrog", "How do you feel about me ruining dota?"}, 
							{"Everyone", "Bad."}, 
							{"Icefrog", "Now that's what I like to hear!"},
							{"Everyone", "I hate you with a passion."},
							{"Icefrog", "Not like you can do anything about it."}};
	//Quit Playing game Option 1
	static String[][] branch1 = {{"Everyone", "We'll just all stop playing."},
						{"Icefrog", "Oh god I forgot its just a game!"},
						{"Everyone", "In the end we all lose."}};
	//Stay with the rage Option 2
	static String[][] branch2 = {{"Everyone", "There's nothing we can do"},
						{"Icefrog", "Good onya."},
						{"Everyone", "In the end we all lose."}};
	
	static int name = 0;
	boolean notAChoice = true;
	static boolean nChosen = true;
	boolean log = false;
	String[][] memory = new String[branchNone.length+branch1.length][branchNone[0].length+branch1[0].length];
	int x;
	int y;
	static int c = 0;
	
	Tooltip t = TooltipOptions.makeBoxStatic(branchNone[name][0], branchNone[name][1]);
	
	//Game itself
	public DialogueDemo(Game game) {
		super(game);
	}

	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE){
			if (notAChoice && nChosen){
				name++;
				if (name == 5) {
					notAChoice = !notAChoice;
				}
				else TooltipOptions.editBoxStatic(t, branchNone[name][0], branchNone[name][1]);
			}
			else if (c == 0){
				if (name == 3){
					delayTime();
					System.exit(0);
				}
				notAChoice = true;
				nChosen = false;
				if (name > branch1.length) name = 0;
				TooltipOptions.editBoxStatic(t, branch1[name][0], branch1[name][1]);
				name++;
			}
			else if (c == 1){
				if (name == 3){
					delayTime();
					System.exit(0);
				}
				notAChoice = true;
				nChosen = false;
				if (name > branch2.length) name = 0;
				TooltipOptions.editBoxStatic(t, branch2[name][0], branch2[name][1]);
				name++;	 
			}
			update();
		}
		if (e.getKeyCode() == KeyEvent.VK_UP){
			if (!notAChoice){
				c--;
				if (c < 0) c = 1;
			}
			update();
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN){
			if (!notAChoice){
				c++;
				c = c % 2;
			}
			update();
		}
		if(c == 0) {
			x = 653;
			y = 447;
		}
		else {
			x = 653;
			y = 527;
		}
		if (e.getKeyCode() == KeyEvent.VK_C){
			log = !log;
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
		g2.setColor(MenuTheme.greenBR);
		g2.fillRect(0, 0, width, height);
		
		//making memes appear
		BufferedImage boxImg = null;
		try {
			boxImg = ImageIO.read(new File("resources/image1.jpg"));
		} catch (IOException e) {
		}
		g2.drawImage(boxImg, 300, 130, 400, 400, null);
		
		//Text To Appear
		g2.setColor(Color.BLACK);
		TooltipOptions.drawBoxStatic(t, g2);
		
		//name = 5
		if (name == 5){
			ChatLog.choiceMenu("QUIT PLAYING", "KEEP PLAYING", g2);
			g2.setColor(Color.WHITE);
			g2.drawRect(x, y, 195, 30);
		}
		
		//THIS IS THE LOG BOYS
		if (log && notAChoice) {
			memory = ChatLog.chatLogged(memory, g2);
		}
	}
	
	public void delayTime(){
		try {
		    TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
		    //Handle exception
		}
	}


	public static String[][] getBranchNone() {
		return branchNone;
	}


	public static String[][] getBranch1() {
		return branch1;
	}


	public static String[][] getBranch2() {
		return branch2;
	}

	public static int getC() {
		return c;
	}
	
	public static int getName() {
		return name;
	}


	public static boolean isnChosen() {
		return nChosen;
	}


	public String[][] getMemory() {
		return memory;
	}

}
