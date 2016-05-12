package project.items;

import java.util.Timer;
import java.util.TimerTask;

public interface Target {

	public void attack(final TargetDemo target);
	
	public void reload();
	
	public int getHealth();
}
