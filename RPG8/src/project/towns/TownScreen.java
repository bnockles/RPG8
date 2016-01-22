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
	BufferedImage[][] foregroundGrid;
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
		backgroundGrid = new BufferedImage[gridHeight][gridWidth];
		backgroundGrid = new BufferedImage[gridHeight][gridWidth];
	}

	@Override
	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void paintScreen(Graphics2D g2) {
		g2.drawImage(backgroundGrid[currentRow][currentColumn], 0, 0, null);
		g2.drawImage(sprite.getImage(),sprite.getX(),sprite.getY(),null);
		g2.drawImage(foregroundGrid[currentRow][currentColumn], 0, 0, null);
	}

}
