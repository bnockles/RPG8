package project.overworld;

import java.util.ArrayList;

public interface OverworldInterface {//yifan use this in battlescreen -->psintscrene--> 4 var --> for loop--> access these objects: x.get(0).printBushes(); 
	public ArrayList<Boundaries> getBoundaries();
	public ArrayList<Obstacle> getObstacles();
	public ArrayList<Region> getRegion();
	public ArrayList<MainMap> getMapSections();
}
