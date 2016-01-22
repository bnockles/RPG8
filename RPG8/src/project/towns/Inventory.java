package project.towns;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import project.directors.DescriptionBox;
import project.directors.Game;
import project.directors.Screen;
import project.directors.UtilityMethods;
import project.items.Item;
import project.menus.GridMenu;
import project.menus.Selectable;

/**
 * When an InventoryScren opens, 
 * @author bnockles
 *
 */

public abstract class Inventory extends Screen implements KeyListener{

	ArrayList<GridMenu> gridMenu;
	GridMenu openGrid;
	DescriptionBox aboutSelectedItem;
	int labelHeight;//space for label at top of Screen
	
	
	public Inventory(Game game, ArrayList<Item> items) {
		super(game);
		labelHeight=50;
		int rows = 6;
		int columns = 5;
		gridMenu=new ArrayList<GridMenu>();
		//we are going to take 30 items at a time and add them to the inventory
		int i = 0;
		int startSubList = (i)*rows*columns;
		int endSubList = (i+1)*rows*columns;
		if(endSubList>items.size())endSubList = items.size();
		while(startSubList < items.size()){
			List<Selectable> page = new ArrayList<Selectable>();
			//add all of the items in items from startSubList to endSubList to the page
			for(int j = startSubList; j<endSubList;j++)page.add(items.get(j));

			gridMenu.add(new GridMenu(width/2, height-labelHeight, 5, 6, new BufferedImage(30,30,BufferedImage.TYPE_INT_ARGB), page));
			
			
			//increase to next page of items
			i++;
			startSubList = (i)*rows*columns;
			endSubList = (i+1)*rows*columns;
			if(endSubList>items.size())endSubList = items.size();
			
		}
		openGrid = gridMenu.get(0);
		aboutSelectedItem=new StoreItemDescription("When an item is selected, text describing the item appears here",width/2,height-labelHeight);
		
	}
	@Override
	public KeyListener getKeyListener() {
		return this;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		/**
		 * GridMenu is also a keyListener that handles navigation through the menu,
		 * I want to have all the functionality of the GridMenu KeyListener
		 * AND some added functionality
		 * Since I can't edit the KeyListener in GridMenu, I can instead call the KeyPressed method 
		 * explicitly, then add my own additional functions 
		 */
		//first, call the keyPressed method in the GridMenu
		openGrid.keyPressed(e);
		//then, add additional Functionality
		int k = e.getKeyCode();
		if(k==KeyEvent.VK_D){
			increasePage(1);
		}
		if(k==KeyEvent.VK_A){
			increasePage(-1);
		}
		if(k==KeyEvent.VK_ESCAPE){
			exit();
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void paintScreen(Graphics2D g2){
		UtilityMethods.centerTextAtY(g2, "Press A and D to switch between pages, ESC to exit.", width, g2.getFontMetrics().getHeight()+5);
		g2.drawImage(openGrid.getImage(), 0, labelHeight, null);
		g2.drawImage(aboutSelectedItem.getImage(), 0, labelHeight, null);
	}
	
	public abstract void increasePage(int numberOfPagesTOIncreaseDecrease);
	
	public abstract void exit();
	
	
	
	
}
