package project.tooltipdemo;

/**
 * Mark Mozgovoy
 */

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
import project.menus.Tooltip;

public class TestScreen extends Screen implements KeyListener {

	public static int selection = 0;
	ArrayList<TooltipOption> options;
	
	public TestScreen(Game game) {
		super(game);
		this.options = new ArrayList<TooltipOption>();
		options.add(new TooltipOption("Option 1", new File("resources/image1.jpg"), "Sample description"));
		options.add(new TooltipOption("Option 2", new File("resources/image2.gif"), "Another description"));
		options.add(new TooltipOption("Option 3", new File("resources/image3.png"), "Getting tired"));
		options.add(new TooltipOption("Option 4", new File("resources/image4.png"), "Another description again"));
	}

	/**
	 * @param args
	 */

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			selection++;
			if(selection > 3){
				selection = 0;
			}
			update();
		}
		if(e.getKeyCode() == KeyEvent.VK_UP){
			selection--;
			if(selection < 0){
				selection = 3;
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
		//Create button containers.
		g2.setColor(Color.white);
		g2.fillRect(0, 0, width, height);
		g2.setColor(Color.black);
		g2.fillRect(112, 220, 375, 100);
		g2.fillRect(112, 340, 375, 100);
		g2.fillRect(112, 460, 375, 100);
		g2.fillRect(112, 580, 375, 100);
		
		//Fonts created.
		Font font1 = new Font("Courier", Font.ROMAN_BASELINE, 50);
		Font font2 = new Font("Courier", Font.ROMAN_BASELINE, 25);
		g2.setFont(font1);
		
		//Selected Option drawn.
		int[] yOptions = {218, 338, 458, 578};
		int y = yOptions[selection];
		g2.setColor(Color.yellow);
		g2.fillRect(110, y, 379, 104);
		
		//Tooltip Drawn
		Tooltip testTool = new Tooltip(450, 230, 492, 220,
				options.get(selection).text, options.get(selection).file, options.get(selection).description,
				234, 120);
		testTool.drawTooltip(g2);
		
		//Option buttons' text drawn.
		g2.setFont(font1);
		g2.setColor(Color.white);
		g2.drawString(options.get(0).text, 180, 280);
		g2.drawString(options.get(1).text, 180, 400);
		g2.drawString(options.get(2).text, 180, 520);
		g2.drawString(options.get(3).text, 180, 640);
		
		
	}

}
