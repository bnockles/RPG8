package project.controls;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import project.battles.BattlesActions;
import project.battles.MCharacter;
public interface ActionDeterminer {
	public void determineMouseAction(MouseEvent e, BattlesActions thing);
	public void determineKeyAction(int n);
	public void removeKeys(Integer n);
	public void determineMovement(BattlesActions thing);
	public void checkEmpty(MCharacter c);
	ArrayList<Integer> getList();
}
