package project.overworld;

import java.util.ArrayList;

public interface BattleInterface {//yifan use these to access the map 
	
	public ArrayList<Region> getRegion(int n);//use to travel to other places
	public ArrayList<MainMap> getMapSections(int n); //use to get mapSections now featuring: obstacles,boundaries, and could have enemies if you give me the type
}
