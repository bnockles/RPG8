package project.towns;

import java.awt.Graphics2D;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import project.directors.Game;
import project.directors.Screen;

/**
 * 
 * @author Fei
 *
 */
public class TownScreen extends Screen {

	BufferedImage[][] backgroundGrid;
	BufferedImage[][] obstacleGrid;
	//BufferedImage[][] foregroundGrid;
	int gridColumns;
	int gridRows;
	
	
	int currentRow;//index of the cell currently showing
	int currentColumn;//index of the cell currently showing
	
	int entranceRow;//the index of the cell where a character always enters from
	int entraceColumn;
	int entranceX;//exact location on the cell where the entrance is
	int entranceY;
	
	TownWanderer sprite;
	
	public TownScreen(Game game, int gridWidth, int gridHeight) {
		super(game);
		this.gridColumns=gridWidth;
		this.gridRows=gridHeight;
		backgroundGrid = new BufferedImage[gridHeight][gridWidth];
		obstacleGrid = new BufferedImage[gridHeight][gridWidth];
		
		currentRow = 1;// starting postion when character enters town
		currentColumn = 0;
		
		
	}

	@Override
	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return null;
	}
	public int getEntranceX(){
		return entranceX;
	}
	
	
	public int getEntranceY(){
		return entranceY;
	}
	public int getcurrentRow(){
		return currentRow;
	}
	public int getCurrentColumn(){
		return currentColumn;
	}

	@Override
	public void paintScreen(Graphics2D g2) {
		g2.drawImage(backgroundGrid[currentRow][currentColumn], 0, 0, null);
		g2.drawImage(sprite.getImage(),sprite.getX(),sprite.getY(),null);
		
	}

}

