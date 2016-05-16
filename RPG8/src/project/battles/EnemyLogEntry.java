//Pelham Van Cooten III

package project.battles;

public class EnemyLogEntry {
	private String enemyName;
	private String enemyType;
	private int enemyLevel;
	private int timesKilled;
	private int enemyKills; 
	//picture of enemy
	
	//go through array list of enemies on screen; check against enemies in list, add if not there
	//interface for andy called LoggableEnemy(getName, getLevel)
	
	public EnemyLogEntry(String name, String type, int level, int killed, int kills){
		enemyName = name;
		enemyType = type;
		enemyLevel = level;
		timesKilled = killed;
		enemyKills = kills;
	}

	public String getEnemyName() {
		return enemyName;
	}

	public void setEnemyName(String enemyName) {
		this.enemyName = enemyName;
	}

	public String getEnemyType() {
		return enemyType;
	}

	public void setEnemyType(String enemyType) {
		this.enemyType = enemyType;
	}
	
	
	
	
	
}
