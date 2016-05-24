//Pelham Van Cooten III

package project.battles;
import java.util.ArrayList;

import project.save.BattleSave;

public class EnemyLog {
		private ArrayList<EnemyLogEntry> eLog;
		
		public ArrayList<EnemyLogEntry> geteLog() {
			return eLog;
		}

		public EnemyLog(ArrayList<EnemyLogEntry> enemyLog){
			eLog = enemyLog;
		}
		
		public void addEnemy(GEnemy enemy){
			for(EnemyLogEntry e: eLog){
				if(e.getEnemyName() == enemy.getName()){
					//increment enemykills or enemykilled by 1
					BattleSave.saveEnemyLogData("100", eLog);
					break;
				}
				
				eLog.add(new EnemyLogEntry(enemy.getName(), "Guard Enemy", enemy.getLevel(), enemy.getDeaths(), enemy.getKills()));
				BattleSave.saveEnemyLogData("100", eLog);
				}
			
		}
		
		public void addEnemy(KEnemy enemy){
			for(EnemyLogEntry e: eLog){
				if(e.getEnemyName() == enemy.getName()){
					//increment enemykills or enemykilled by 1
					BattleSave.saveEnemyLogData("100", eLog);
					break;
				}
			
				eLog.add(new EnemyLogEntry(enemy.getName(), "Killer Enemy", enemy.getLevel(), enemy.getDeaths(), enemy.getKills()));
				BattleSave.saveEnemyLogData("100", eLog);
			}
			
		}
		
}
