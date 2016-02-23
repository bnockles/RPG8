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
	ArrayList<Region> regions;
	BufferedImage background;
	boolean touching;
	int xPos;
	int yPos;
	int xSize;
	int ySize;
	int playerRegion;
	Rectangle hitbox;

	public MapDemoScreen(Game game) {
		super(game);
		obstacles = new ArrayList<Obstacle>();
		mapSections = new ArrayList<MainMap>();
		boundaries = new ArrayList<Boundaries>();
		regions = new ArrayList<Region>();
		touching = false;
		xPos = 800;
		yPos = 200;
		xSize = 30;
		ySize = 30;
		playerRegion = 0;
		obstacles.add(new Obstacle("Barrel", 400, 200, 40, 70,
				"/images/Map/barrelblue.jpg", 0));
		mapSections.add(new MainMap(0, "/images/Map/test.jpeg"));
		mapSections.add(new MainMap(1, "/images/Map/test2.jpeg"));
		boundaries.add(new Boundaries(0, 0, 100, 890, false, 0));
		boundaries.add(new Boundaries(0, 580, 920, 140, false, 0));
		boundaries.add(new Boundaries(0, 450, 200, 140, false, 0));
		regions.add(new Region(920, 200, 68, 500, 1, 500, 500, 0));
		regions.add(new Region(0, 200, 50, 400, 0, 500, 500, 1));
	}

	public void checkCollision() {
		hitbox = new Rectangle(xPos, yPos, xSize, ySize);
		for (int i = 0; i < boundaries.size(); i++) {
			if (boundaries.get(i).getBounds().intersects(hitbox)
					&& playerRegion == boundaries.get(i).getRegion()) {
				touching = true;
				return;
			} else {
				touching = false;
			}
		}
		for (int i = 0; i < obstacles.size(); i++) {
			if (obstacles.get(i).getBounds().intersects(hitbox)
					&& playerRegion == obstacles.get(i).getRegion()) {
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

	public void changeRegion() {
		hitbox = new Rectangle(xPos, yPos, xSize, ySize);
		for (int i = 0; i < regions.size(); i++) {
			if (regions.get(i).getBounds().intersects(hitbox)
					&& regions.get(i).getRegion() == playerRegion) {
				playerRegion = regions.get(i).getGoTo();
				xPos = regions.get(i).getStartX();
				yPos = regions.get(i).getStartY();
				return;
			}
		}
	}

	@Override
	public void paintScreen(Graphics2D g2) {
		for (int i = 0; i < mapSections.size(); i++) {
			if (i == playerRegion) {
				BufferedImage backgrnd = mapSections.get(i).getMap();
				UtilityMethods.scaleImage(g2, backgrnd, 0, 0, width, height);
			}
		}
		for (int i = 0; i < obstacles.size(); i++) {
			if(playerRegion == obstacles.get(i).getRegion()){
				BufferedImage test = obstacles.get(i).getImage();
				UtilityMethods.scaleImage(g2, test, obstacles.get(i).getxPos(), obstacles.get(i).getyPos(),
						obstacles.get(i).getSizeX(), obstacles.get(i).getSizeY());
			}
		}
		g2.setColor(Color.red);
		g2.drawOval(xPos, yPos, 30, 30);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		changeRegion();
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
