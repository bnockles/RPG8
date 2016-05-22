package project.battles;
//Yifan He 
public interface overworldIntegration {
//	// get info from overworld. 
//		public ArrayList<Boundaries> getBoundaries();
//		public ArrayList<Obstacle> getObstacles();
//		public int getRegion();
//	//give info to overworld 
//	public void weaponProjectiles(); //already made enemy static
//	public int enemyNum(); //
//	public void characterMovements();
	public int getRegion(); //the region changes as the character moves 
	public String getEnemyType(); //the enemy type changes according to the region
	public int getBackgroundNumber(); //the battle back ground will change according to the background Number
}
