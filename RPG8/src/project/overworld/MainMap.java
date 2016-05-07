package project.overworld;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class MainMap {
	int region;
	BufferedImage map;
	ArrayList<Obstacle> obstacles;
	ArrayList<Boundaries> boundaries;
	//ArrayList<> enemies;
	public MainMap(int region,String image,ArrayList<Obstacle> o,ArrayList<Boundaries> b){
		this.region = region;
		obstacles = o;
		boundaries = b;
		try {
			URL url = getClass().getResource(image);
			this.map = ImageIO.read(url);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public int getRegion() {
		return region;
	}
	public BufferedImage getMap() {
		return map;
	}
	public ArrayList<Obstacle> getObstacles(){
		return obstacles;
	}
	public ArrayList<Boundaries> getBoundaries(){
		return boundaries;
	}
}
