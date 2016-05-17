package project.battles;
//Yifan He 
public interface nonSpawnable {
	// get info from overworld. 
		public ArrayList<Boundaries> getBoundaries();
		public ArrayList<Obstacle> getObstacles();
		public int getRegion();
	//give info to overworld 
	public void weaponProjectiles(); //already made enemy static
	public int enemyNum(); //
	public void characterMovements();
}
