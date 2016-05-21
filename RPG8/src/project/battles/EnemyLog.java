//Pelham Van Cooten III

package project.battles;
import java.util.ArrayList;

public class EnemyLog {
		private ArrayList<EnemyLogEntry> eLog;
		
		public ArrayList<EnemyLogEntry> geteLog() {
			return eLog;
		}

		public EnemyLog(){
			eLog = new ArrayList<EnemyLogEntry>();
			eLog.add(new EnemyLogEntry("Shahid","guy",5,5,5));
			eLog.add(new EnemyLogEntry("Dog","guy",5,5,5));
		}
		
		public void addEnemy(GEnemy enemy){
			for(EnemyLogEntry e: eLog){
				if(e.getEnemyName() == enemy.getName()){
					//increment enemykills or enemykilled by 1
					break;
				}
				
				eLog.add(new EnemyLogEntry(enemy.getName(), "Guard Enemy", enemy.getLevel(), enemy.getDeaths(), enemy.getKills()));
				
				}
			
		}
		
		public void addEnemy(KEnemy enemy){
			for(EnemyLogEntry e: eLog){
				if(e.getEnemyName() == enemy.getName()){
					//increment enemykills or enemykilled by 1
					break;
				}
			
				eLog.add(new EnemyLogEntry(enemy.getName(), "Killer Enemy", enemy.getLevel(), enemy.getDeaths(), enemy.getKills()));
			
			}
			
		}
		
}
