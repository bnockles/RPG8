package project.overworld;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import project.directors.Game;
import project.directors.Screen;
import project.directors.UtilityMethods;
import java.util.ArrayList;

public class MapDemoScreen extends Screen implements KeyListener {
	ArrayList<Obstacle> obstacles;
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
		touching = false;
		xPos = 300;
		yPos = 200;
		xSize = 30;
		ySize = 30;

		obstacles.add(new Obstacle("Barrel", 200, 200, 40, 70, "/images/Map/barrelblue.jpg"));
		try {
			URL map = getClass().getResource("/images/Map/test.jpeg");
			background = ImageIO.read(map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated constructor stub
	}

	public void checkCollision() {
		hitbox = new Rectangle(xPos, yPos, xSize, ySize);
		for (int i = 0; i < obstacles.size(); i++) {
			if (obstacles.get(i).getBounds().intersects(hitbox)) {
				touching = true;
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
		BufferedImage backgrnd = background;
		UtilityMethods.scaleImage(g2, backgrnd, 0, 0, width, height);
		BufferedImage test = obstacles.get(0).getImage();
		UtilityMethods.scaleImage(g2, test, obstacles.get(0).getxPos(), obstacles.get(0).getyPos(),
				obstacles.get(0).getSizeX(), obstacles.get(0).getSizeY());
		g2.setColor(Color.red);
		g2.drawOval(xPos, yPos, 30, 30);
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
