package project.overworld;

import java.util.ArrayList;

public interface BattleInterface {//yifan use this in battlescreen -->psintscrene--> 4 var --> for loop--> access these objects: x.get(0).printBushes(); 
	public ArrayList<Boundaries> getBoundaries(int n);
	public ArrayList<Obstacle> getObstacles(int n);
	public ArrayList<Region> getRegion(int n);
	public ArrayList<MainMap> getMapSections(int n);
}
