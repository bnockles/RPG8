package project.menus;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import project.directors.Visible;
import project.items.Item;

public class GridMenu implements KeyListener, Visible{

	int width;
	int height;
	int across;
	int down;
	final int MARGIN = 2;
	BufferedImage image;
	BufferedImage nullGridItemImage;
	int selectedRow;
	int selectedColumn;
	
	Selectable[][] selections;
	
	/**
	 * 
	 * @param width
	 * @param height
	 * @param itemsAcross
	 * @param itemsDown
	 * @param nullImage
	 * @param page  the list of selections, note that a GridMenu will only display the first (itemsAcross*itemsDown) from the selection. If there are more than that, you must create multiple GridMenus (pages)
	 */
	public GridMenu(int width, int height, int itemsAcross, int itemsDown, BufferedImage nullImage, List<Selectable> page) {
		this.width=width;
		this.height=height;
		across=itemsAcross;
		down = itemsDown;
		nullGridItemImage=nullImage;
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		selections = new Selectable[itemsDown][itemsAcross];
		selectedColumn=0;
		selectedRow=0;
		for(int i = 0; i< itemsAcross*itemsDown; i++){
			if(i<page.size()){
				selections[selectedRow][selectedColumn]=page.get(i);
				selectedColumn++;
				if(selectedColumn >= selections[selectedRow].length){
					selectedColumn=0;
					selectedRow++;
				}
			}else{
				selections[selectedRow][selectedColumn]=null;//redundant, but illustrates that null items can exist
			}
		}
		selectedColumn=0;
		selectedRow=0;
		update();
	}


	@Override
	public void keyPressed(KeyEvent e) {
		 int keyCode = e.getKeyCode();
		    switch( keyCode ) { 
		        case KeyEvent.VK_UP:
		        	selectedRow=selectedRow--%selections.length;
		            update();//updates appearance of menu(i.e. selections change)
		            break;
		        case KeyEvent.VK_DOWN:
		        	selectedRow=selectedRow++%selections.length;
		            update();//updates appearance of menu(i.e. selections change)
		            break;
		        case KeyEvent.VK_RIGHT:
		        	selectedColumn=selectedColumn++%selections[0].length;
		            update();//updates appearance of menu(i.e. selections change)
		            break;
		        case KeyEvent.VK_LEFT:
		        	selectedColumn=selectedColumn--%selections[0].length;
		            update();//updates appearance of menu(i.e. selections change)
		            break;
		        case KeyEvent.VK_SPACE: 
		        case KeyEvent.VK_ENTER:
		        	confirmSelection();
		        	break;
		     }
	}



	private void confirmSelection() {
		selections[selectedRow][selectedColumn].confirm();
	}



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public BufferedImage getImage() {
		return image;
	}

	

	@Override
	public void update() {
		//un-selects previous entry and updates all items
		Graphics2D g2 = (Graphics2D) image.getGraphics();
		int x = 0;
		int y = 0;
		
		for(int r=0; r<selections.length;r++){
			for(int c=0; c<selections.length; c++){
				if(selections[r][c]!=null){
					selections[r][c].update();
					g2.drawImage(selections[r][c].getImage(), x, y,x+width/across,y+height/down,0,0,selections[r][c].getImage().getWidth(),selections[r][c].getImage().getHeight(), null);
					x+=width/across+MARGIN;
					y+=height/down+MARGIN;
					if(r!=selectedRow && c!=selectedColumn){
						selections[r][c].setSelect(false);
					}else{
						selections[r][c].setSelect(false);
					}
				}else{
					g2.drawImage(nullGridItemImage, x, y,x+width/across,y+height/down,0,0,selections[r][c].getImage().getWidth(),selections[r][c].getImage().getHeight(), null);
					x+=width/across+MARGIN;
					y+=height/down+MARGIN;
				}
			}
		}
		
	}

}
