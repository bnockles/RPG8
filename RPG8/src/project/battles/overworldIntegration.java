package project.battles;

import java.awt.Color;

//Yifan He 
public interface overworldIntegration {
	public Color getRegionColor(int a); //the region changes as the character moves 
	public String getEnemyType(int a); //the enemy type changes according to the region
	public int getBackgroundNumber(); //the battle back ground will change according to the background Number
}
