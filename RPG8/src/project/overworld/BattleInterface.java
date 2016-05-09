package project.overworld;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public interface BattleInterface {//use to convert your battle to a map screen
	public int getRegion();//returns region number assigned(used to move around maps)
	public BufferedImage getMap(); //use to get map image
	public ArrayList<Obstacle> getObstacles();//use to get obstacles
	public ArrayList<Boundaries> getBoundaries();//use to get boundaries
}
