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
	static boolean touching;
	static int xPos;
	static int yPos;
	static int xSize;
	static int ySize;
	static int playerRegion;
	static Rectangle hitbox;
	int obstacleNum;
	String type;

	public MapDemoScreen(Game game) {
		super(game);
		obstacles = new ArrayList<Obstacle>();
		mapSections = new ArrayList<MainMap>();
		boundaries = new ArrayList<Boundaries>();
		regions = new ArrayList<Region>();
		touching = false;
		obstacleNum = -1;
		xPos = 500;
		yPos = 200;
		xSize = 30;
		ySize = 30;
		playerRegion = 0;
		obstacles.add(new Obstacle("Barrel", 400, 200, 40, 70,
				"/images/Map/barrelblue.jpg", 0,true,true));
		mapSections.add(new MainMap(0, "/images/Map/test.jpeg"));
		mapSections.add(new MainMap(1, "/images/Map/test2.jpeg"));
		boundaries.add(new Boundaries(0, 0, 100, 890, false, 0));
		boundaries.add(new Boundaries(0, 580, 920, 140, false, 0));
		boundaries.add(new Boundaries(0, 450, 200, 140, false, 0));
		boundaries.add(new Boundaries(0, 0, 900, 65, false, 0));
		boundaries.add(new Boundaries(690, 10, 230, 215, false, 0));
		boundaries.add(new Boundaries(690, 270, 230, 400, false, 0));
		boundaries.add(new Boundaries(550, 450, 150, 150, false, 0));
		boundaries.add(new Boundaries(600, 400, 100, 50, false, 0));
		boundaries.add(new Boundaries(180, 0, 900, 100, false, 1));
		boundaries.add(new Boundaries(560, 0, 230, 700, false, 1));
		boundaries.add(new Boundaries(180, 500, 230, 300, false, 1));
		boundaries.add(new Boundaries(410, 400, 200, 500, false, 1));
		regions.add(new Region(920, 200, 68, 500, 1, 300, 300, 0));
		regions.add(new Region(0, 200, 50, 400, 0, 300, 300, 1));
	}

	public void checkCollision() {
		hitbox = new Rectangle(xPos, yPos, xSize, ySize);
		for (int i = 0; i < boundaries.size(); i++) {
			if (boundaries.get(i).getBounds().intersects(hitbox)
					&& playerRegion == boundaries.get(i).getRegion()) {
				touching = true;
				type = "B";
				obstacleNum = i;
				return;
			} else {
				touching = false;
			}
		}
		for (int i = 0; i < obstacles.size(); i++) {
			if (obstacles.get(i).getBounds().intersects(hitbox)
					&& playerRegion == obstacles.get(i).getRegion() && obstacles.get(i).getState()) {
				touching = true;
				type = "O";
				obstacleNum = i;
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
			if (playerRegion == obstacles.get(i).getRegion() && obstacles.get(i).getState()) {
				BufferedImage test = obstacles.get(i).getImage();
				UtilityMethods.scaleImage(g2, test, obstacles.get(i).getxPos(),
						obstacles.get(i).getyPos(),
						obstacles.get(i).getSizeX(), obstacles.get(i)
								.getSizeY());
			}
		}
		g2.setColor(Color.red);
		g2.drawOval(xPos, yPos, 30, 30);

	}
	public void removeObstacle(){
		if(obstacles.get(obstacleNum).getDest()){
			obstacles.get(obstacleNum).setState(false);
		}
	}
	public int[] checkType(String type) {
		int[] num = new int[4];
		if (type.equals("B")) {
			for (int i = 0; i < boundaries.size(); i++) {
				if (obstacleNum == i) {
					num[0] = boundaries.get(i).getxPos();
					num[1] = boundaries.get(i).getyPos();
					num[2] = boundaries.get(i).getSizeX();
					num[3] = boundaries.get(i).getSizeY();
				}
			}
		}
		if (type.equals("O")) {
			for (int i = 0; i < obstacles.size(); i++) {
				if (obstacleNum == i) {
					num[0] = obstacles.get(i).getxPos();
					num[1] = obstacles.get(i).getyPos();
					num[2] = obstacles.get(i).getSizeX();
					num[3] = obstacles.get(i).getSizeY();
				}
			}
		}
		return num;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		changeRegion();
		checkCollision();
		int[] test;
		boolean used = false;
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_UP) {
			yPos--;
			if (touching && !used) {
				test = checkType(type);
				yPos = test[1] + test[3]+3;
				used = true;
			}
		}else if (keyCode == KeyEvent.VK_DOWN) {
			yPos++;
			if (touching & !used) {
				test = checkType(type);
				yPos = test[1] - ySize-2;
				used = true;
			}
		}else if (keyCode == KeyEvent.VK_LEFT) {
			xPos--;
			if (touching & !used) {
				test = checkType(type);
				xPos = test[0] + test[2]+3;
				used = true;
			}
		}else if (keyCode == KeyEvent.VK_RIGHT) {
			xPos++;
			if (touching & !used) {
				test = checkType(type);
				xPos = test[0] - xSize-2;
				used = true;
			}
		}
		if(keyCode == KeyEvent.VK_DELETE){
			if(touching && type.equals("O")){
				removeObstacle();
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

	public ArrayList<Region> getRegions() {
		return regions;
	}

	public static boolean isTouching() {
		return touching;
	}

	public static int getxPos() {
		return xPos;
	}

	public static int getyPos() {
		return yPos;
	}

	public static int getxSize() {
		return xSize;
	}

	public int getySize() {
		return ySize;
	}

	public int getPlayerRegion() {
		return playerRegion;
	}

}
