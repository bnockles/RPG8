package project.controls;
import java.util.ArrayList;
import project.battles.BattlesActions;
public interface ActionDeterminer {
		public void determineMouseAction(int n, BattlesActions thing);
		public void determineKeyAction(int n, BattlesActions thing);
}
