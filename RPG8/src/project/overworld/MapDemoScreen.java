package project.overworld;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import project.battles.EnemyDifficulty;
import project.directors.Game;
import project.directors.Screen;
import project.directors.UtilityMethods;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class MapDemoScreen extends Screen implements KeyListener,EnemyDifficulty {
	static ArrayList<Region> regions; // use these to change areas
	static ArrayList<MainMap> mapSections;
	BufferedImage background;
	static boolean touching;
	static boolean playing;
	static int xPos;
	static int yPos;
	public static final String BOUNDARY = "B";
	public static final String OBSTACLE = "O";
	public static final int xSize = 30;
	public static final int ySize = 30;
	public static final int ZONE1 = 0;
	public static final int ZONE2 = 1;
	public static final int ALLZONES = -1;
	public static final int TOWN = 2;
	public static final int[] LANDINGZ1 = new int[] { 870, 228 };
	public static final int[] LANDINGZ2L = new int[] { 94, 250 };
	public static final int[] LANDINGZ2R = new int[] { 362, 294 };
	public static final int[] LANDINGTL = new int[] { 76, 400 };
	public static final boolean DESTR = true;
	public static final boolean INDES = false;
	public static final boolean LETHAL = true;
	public static final boolean NONLETH = false;
	static int playerRegion;
	static Rectangle hitbox;
	static int obstacleNum;
	static String type;
	static int zone;
	static ArrayList<BufferedImage> i1;
	static int[] nums;
	// hello
	public MapDemoScreen(Game game) {
		super(game);
		ArrayList<Obstacle> o1 = new ArrayList<Obstacle>();
		ArrayList<Obstacle> o2 = new ArrayList<Obstacle>();
		ArrayList<Boundaries> b1 = new ArrayList<Boundaries>();
		ArrayList<Boundaries> b2 = new ArrayList<Boundaries>();
		ArrayList<Obstacle> o3 = new ArrayList<Obstacle>();
		ArrayList<Boundaries> b3 = new ArrayList<Boundaries>();
		i1 = new ArrayList<BufferedImage>();
		mapSections = new ArrayList<MainMap>();
		regions = new ArrayList<Region>();
		touching = false;
		obstacleNum = -1;
		zone = -1;
		playing = true;
		xPos = 500;
		yPos = 200;
		playerRegion = 0;
		o1.add(new Obstacle("Barrel", 400, 200, 40, 70, "/images/Map/barrelblue.jpg", ZONE1, DESTR, true));
		o2.add(new Obstacle("Barrel2", 300, 200, 40, 70, "/images/Map/barrelblue.jpg", ZONE2, INDES, true));
		o2.add(new Obstacle("Crate", 100, 300, 120, 70, "/images/Map/crate.png", ZONE2, DESTR, true));
		o2.add(new Obstacle("Town", 400, 200, 120, 120, "/images/Map/town.png", ZONE2, INDES, true));
		b1.add(new Boundaries(0, 0, 100, 890, LETHAL, ZONE1));
		b1.add(new Boundaries(0, 580, 920, 140, LETHAL, ZONE1));
		b1.add(new Boundaries(0, 450, 200, 140, LETHAL, ZONE1));
		b1.add(new Boundaries(0, 0, 900, 65, LETHAL, ZONE1));
		b1.add(new Boundaries(690, 10, 230, 215, NONLETH, ZONE1));
		b1.add(new Boundaries(690, 270, 230, 400, NONLETH, ZONE1));
		b1.add(new Boundaries(550, 450, 150, 150, LETHAL, ZONE1));
		b1.add(new Boundaries(600, 400, 100, 50, LETHAL, ZONE1));
		b2.add(new Boundaries(180, 0, 900, 100, LETHAL, ZONE2));
		b2.add(new Boundaries(560, 0, 230, 700, LETHAL, ZONE2));
		b1.add(new Boundaries(180, 500, 230, 300, LETHAL, ZONE1));
		b1.add(new Boundaries(410, 400, 200, 500, LETHAL, ZONE1));
		b1.add(new Boundaries(0, 0, width, 1, NONLETH, ALLZONES));
		b1.add(new Boundaries(width, 0, 1, height, NONLETH, ALLZONES));
		b1.add(new Boundaries(0, 0, 1, height, NONLETH, ALLZONES));
		b1.add(new Boundaries(0, height, width, 1, NONLETH, ALLZONES));
		b2.add(new Boundaries(0, 0, width, 1, NONLETH, ALLZONES));
		b2.add(new Boundaries(width, 0, 1, height, NONLETH, ALLZONES));
		b2.add(new Boundaries(0, 0, 1, height, NONLETH, ALLZONES));
		b2.add(new Boundaries(0, height, width, 1, NONLETH, ALLZONES));
		regions.add(new Region(920, 200, 68, 500, ZONE2, LANDINGZ2L[0], LANDINGZ2L[1], ZONE1));
		regions.add(new Region(0, 200, 50, 400, ZONE1, LANDINGZ1[0], LANDINGZ1[1], ZONE2));
		regions.add(new Region(400, 200, 120, 120, TOWN, LANDINGTL[0], LANDINGTL[1], ZONE2));
		regions.add(new Region(30, 400, 20, 100, ZONE2, LANDINGZ2R[0], LANDINGZ2R[1], TOWN));
		mapSections.add(new MainMap(0, "/images/Map/test.jpeg", o1, b1));
		mapSections.add(new MainMap(1, "/images/Map/test2.jpeg", o2, b2));
		mapSections.add(new MainMap(2, "/images/Map/testTown.png", o3, b3));
		String[] testingColors = {"/images/Map/blue.jpg","/images/Map/green.jpg","/images/Map/grey.jpg"};
		for(int i = 0;i<3;i++){
			try{
				URL url = getClass().getResource(testingColors[i]);
				i1.add(ImageIO.read(url));
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	public static void teleportToZone(int zone,int[] coors){
		playerRegion = zone;
		xPos = coors[0];
		yPos = coors[1];
	}
	public void checkCollision() {
		hitbox = new Rectangle(xPos, yPos, xSize, ySize);
		for (int i = 0; i < mapSections.size(); i++) {
			if (mapSections.get(i).getRegion() == playerRegion) {
				for (int j = 0; j < mapSections.get(i).getBoundaries().size(); j++) {
					if (mapSections.get(i).getBoundaries().get(j).isColliding(hitbox)) {
						touching = true;
						type = BOUNDARY;
						obstacleNum = j;
						zone = i;
						checkPlayerState(mapSections.get(i).getBoundaries().get(j));
						return;
					} else {
						touching = false;
					}
				}
				for (int j = 0; j < mapSections.get(i).getObstacles().size(); j++) {
					if (mapSections.get(i).getObstacles().get(j).isColliding(hitbox)
							&& mapSections.get(i).getObstacles().get(j).getState()) {
						touching = true;
						type = OBSTACLE;
						obstacleNum = j;
						zone = i;
						return;
					} else {
						touching = false;
					}
				}
			}
		}
	}

	public void checkPlayerState(Boundaries bound) {
		if (bound.isLethal()) {
			playing = false;
		}
	}

	@Override
	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return this;
	}

	public boolean isSameRegion(Frame f, int r) {
		return f.isSameZone(r);
	}

	public static void changeRegion() {
		hitbox = new Rectangle(xPos, yPos, xSize, ySize);
		for (int i = 0; i < regions.size(); i++) {
			if (regions.get(i).getBounds().intersects(hitbox) && regions.get(i).getRegion() == playerRegion) {
				playerRegion = regions.get(i).getGoTo();
				xPos = regions.get(i).getStartX();
				yPos = regions.get(i).getStartY();
				return;
			}
		}
	}

	@Override
	public void paintScreen(Graphics2D g2) {
		if (playing) {
			for (int i = 0; i < mapSections.size(); i++) {
				if (i == playerRegion) {
					BufferedImage backgrnd = mapSections.get(i).getMap();
					UtilityMethods.scaleImage(g2, backgrnd, 0, 0, width, height);
					for (Obstacle j: mapSections.get(i).getObstacles()) {
						if (j.getState()) {
							BufferedImage test = j.getImage();
							UtilityMethods.scaleImage(g2, test, j.getxPos(), j.getyPos(),
									j.getSizeX(), j.getSizeY());
						}
					}
				}
			}
			g2.setColor(Color.red);
			g2.drawOval(xPos, yPos, 30, 30);
		} else {
			g2.drawString("You Died", 500, 500);
		}
	}

	public static int[] checkType(String type) {
		int[] num = new int[4];
		if (type.equals(BOUNDARY)) {
			num[0] = mapSections.get(zone).getBoundaries().get(obstacleNum).getxPos();
			num[1] = mapSections.get(zone).getBoundaries().get(obstacleNum).getyPos();
			num[2] = mapSections.get(zone).getBoundaries().get(obstacleNum).getSizeX();
			num[3] = mapSections.get(zone).getBoundaries().get(obstacleNum).getSizeY();
		}
		if (type.equals(OBSTACLE)) {
			num[0] = mapSections.get(zone).getObstacles().get(obstacleNum).getxPos();
			num[1] = mapSections.get(zone).getObstacles().get(obstacleNum).getyPos();
			num[2] = mapSections.get(zone).getObstacles().get(obstacleNum).getSizeX();
			num[3] = mapSections.get(zone).getObstacles().get(obstacleNum).getSizeY();
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
			yPos = yPos - 2;
			if (touching && !used) {
				test = checkType(type);
				yPos = test[1] + test[3] + 3;
				used = true;
			}
		} else if (keyCode == KeyEvent.VK_DOWN) {
			yPos = yPos + 2;
			if (touching & !used) {
				test = checkType(type);
				yPos = test[1] - ySize - 2;
				used = true;
			}
		} else if (keyCode == KeyEvent.VK_LEFT) {
			xPos = xPos - 2;
			if (touching & !used) {
				test = checkType(type);
				xPos = test[0] + test[2] + 3;
				used = true;
			}
		} else if (keyCode == KeyEvent.VK_RIGHT) {
			xPos = xPos + 2;
			if (touching & !used) {
				test = checkType(type);
				xPos = test[0] - xSize - 2;
				used = true;
			}
		}
		if (keyCode == KeyEvent.VK_DELETE) {
			System.out.println(xPos + " " + yPos);
			if (touching && type.equals(OBSTACLE)) {
				mapSections.get(zone).getObstacles().get(obstacleNum).removeObstacle();
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
	@Override
	public int getCharacterLevel() {
		// TODO Auto-generated method stub
		return playerRegion;
	}
	@Override
	public int getMapLevel() {
		
		return playerRegion;
	}
	@Override
	public int getProgress() {
		return 1;
	}
	@Override
	public String getBoss() {
		// TODO Auto-generated method stub
		return null;
	}

}
