package project.overworld;

import java.awt.Color;
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

public class MapDemoScreen extends Screen implements KeyListener {
	BufferedImage[] Obstacles;

	public MapDemoScreen(Game game) {
		super(game);
		Obstacles = new BufferedImage[1];
		try {
			URL url0 = getClass().getResource("/images/Map/barrelblue.jpg");
			Obstacles[0] = ImageIO.read(url0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated constructor stub
	}

	@Override
	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void paintScreen(Graphics2D g2) {
		g2.setColor(Color.green);
		g2.fillRect(0, 0, width, height);
		BufferedImage sample = Obstacles[0];
		UtilityMethods.scaleImage(g2, sample, 30,100 ,250, 350);

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

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
