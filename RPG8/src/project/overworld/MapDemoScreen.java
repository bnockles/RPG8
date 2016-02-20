package project.overworld;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import project.directors.Game;
import project.directors.Screen;
import project.directors.UtilityMethods;
import java.util.ArrayList;

public class MapDemoScreen extends Screen implements KeyListener {
	ArrayList<Obstacle> obstacles;
	ArrayList<MainMap> mapSections;
	ArrayList<Boundaries> boundaries;
	BufferedImage background;
	boolean touching;
	int xPos;
	int yPos;
	int xSize;
	int ySize;
	Rectangle hitbox;

	public MapDemoScreen(Game game) {
		super(game);
		obstacles = new ArrayList<Obstacle>();
		mapSections = new ArrayList<MainMap>();
		boundaries = new ArrayList<Boundaries>();
		touching = false;
		xPos = 300;
		yPos = 200;
		xSize = 30;
		ySize = 30;

		obstacles.add(new Obstacle("Barrel", 0, 0, 40, 70, "/images/Map/barrelblue.jpg"));
		obstacles.add(new Obstacle("Barrel", 400, 200, 40, 70, "/images/Map/barrelblue.jpg"));
		mapSections.add(new MainMap(0, "/images/Map/test.jpeg"));
		boundaries.add(new Boundaries(0, 0, 100, 890, false));
		boundaries.add(new Boundaries(0,580,920,140,false));
		boundaries.add(new Boundaries(0,450,200,140,false));
	}

	public void checkCollision() {
		hitbox = new Rectangle(xPos, yPos, xSize, ySize);
		for (int i = 0; i < boundaries.size(); i++) {
			if (boundaries.get(i).getBounds().intersects(hitbox)) {
				touching = true;
				return;
			} else {
				touching = false;
			}
		}
		for (int i = 0; i < obstacles.size(); i++) {
			if (obstacles.get(i).getBounds().intersects(hitbox)) {
				touching = true;
				System.out.println(boundaries.size());
				return;
			} else {
				touching = false;
			}
		}

	}

	@Override
	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public void paintScreen(Graphics2D g2) {
		BufferedImage backgrnd = mapSections.get(0).getMap();
		UtilityMethods.scaleImage(g2, backgrnd, 0, 0, width, height);
		for (int i = 0; i < obstacles.size(); i++) {
			BufferedImage test = obstacles.get(i).getImage();
			UtilityMethods.scaleImage(g2, test, obstacles.get(i).getxPos(), obstacles.get(i).getyPos(),
					obstacles.get(i).getSizeX(), obstacles.get(i).getSizeY());
		}
		g2.setColor(Color.red);
		g2.drawOval(xPos, yPos, 30, 30);
		g2.drawRect(0, 450, 200, 140);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		checkCollision();
		boolean used = false;
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_UP) {
			yPos--;
			if (touching && !used) {
				yPos = yPos + 4;
				used = true;
			}
		}
		if (keyCode == KeyEvent.VK_DOWN) {
			yPos++;
			if (touching & !used) {
				yPos = yPos - 4;
				used = true;
			}
		}
		if (keyCode == KeyEvent.VK_LEFT) {
			xPos--;
			if (touching & !used) {
				xPos = xPos + 4;
				used = true;
			}
		}
		if (keyCode == KeyEvent.VK_RIGHT) {
			xPos++;
			if (touching & !used) {
				xPos = xPos - 4;
				used = true;
			}
		}
		touching = false;
		used = false;
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}
