package project.battles;

import java.awt.event.MouseEvent;

public interface BattlesActions {
	public void fireWeapon(MouseEvent e);
	public void moveCharacterLeft();
	public void moveCharacterRight();
	public void moveCharacterUp();
	public void moveCharacterDown();
	public void reloadWeapon();
}
