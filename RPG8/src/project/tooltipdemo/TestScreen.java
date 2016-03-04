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
import project.mainmenudemo.DynamicMenu;
import project.mainmenudemo.MainMenuScreen;
import project.menus.Tooltip;
import project.menus.TooltipOptions;

public class TestScreen extends Screen implements KeyListener {

	public static int selection = 0;
	ArrayList<TooltipOption> options;
	
	public TestScreen(Game game) {
		super(game);
		this.options = new ArrayList<TooltipOption>();
		options.add(new TooltipOption("Option 1", new File("resources/image1.jpg"), "Sample description", 200));
		options.add(new TooltipOption("Option 2", new File("resources/image2.gif"), "Another description", 300));
		options.add(new TooltipOption("Option 3", new File("resources/image3.png"), "Getting tired", 600));
		options.add(new TooltipOption("Option 4", new File("resources/image4.png"), "Another description again", 1000));
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
		if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
			this.game.setScreen(DynamicMenu.createMenu(DynamicMenu.MAIN_MENU, this.game));
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
		g2.fillRect(112, 130, 375, 100);
		g2.fillRect(112, 250, 375, 100);
		g2.fillRect(112, 370, 375, 100);
		g2.fillRect(112, 490, 375, 100);
		
		//Fonts created.
		Font font1 = new Font("Courier", Font.ROMAN_BASELINE, 50);
		Font font2 = new Font("Courier", Font.ROMAN_BASELINE, 25);
		g2.setFont(font1);
		
		//Selected Option drawn.
		int[] yOptions = {128, 248, 368, 488};
		int y = yOptions[selection];
		g2.setColor(Color.yellow);
		g2.fillRect(110, y, 379, 104);
		
		//Tooltip Drawn
//		Tooltip testTool = new Tooltip(450, 230, 492, 220,
//				options.get(selection).text, options.get(selection).file, options.get(selection).description,
//				234, 120);
		
		
		//Tooltip drawn using instances.
		Tooltip testTool = TooltipOptions.getTooltip(TooltipOptions.TOOLTIP_INVENTORY);
		testTool.setTitle(options.get(selection).text);
		testTool.setFile(options.get(selection).file);
		testTool.setDescription(options.get(selection).description);
		
		testTool.drawTooltipInventory(g2);
		
		Tooltip testTool2 = TooltipOptions.getTooltip(TooltipOptions.TOOLTIP_STORE);
		testTool2.setTitle(options.get(selection).text);
		testTool2.setFile(options.get(selection).file);
		testTool2.setDescription(options.get(selection).description);
		testTool2.setBuyPrice(options.get(selection).buyPrice);
		testTool2.setSellPrice(options.get(selection).sellPrice);
		
		testTool2.drawTooltipStore(g2);
		
		Tooltip testTool3 = TooltipOptions.getTooltip(TooltipOptions.TOOLTIP_DIALOGUE);
		testTool3.setTitle(options.get(selection).text);
		testTool3.setDescription(options.get(selection).description);
		
		testTool3.drawTooltipDialogue(g2);
		
		//Option buttons' text drawn.
		g2.setFont(font1);
		g2.setColor(Color.white);
		g2.drawString(options.get(0).text, 180, 190);
		g2.drawString(options.get(1).text, 180, 310);
		g2.drawString(options.get(2).text, 180, 430);
		g2.drawString(options.get(3).text, 180, 550);
		
		//System.out.println("Test " + TooltipOptions.getTooltip(TooltipOptions.TOOLTIP_INVENTORY).getDescription());
	}

}
