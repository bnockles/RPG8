package project.storyV2;
<<<<<<< HEAD

import java.awt.Graphics2D;

import project.menus.Tooltip;

public interface DisplayBox {
	public Tooltip makeBox(String charName, String msg);
	public void editBox(Tooltip box, String charName, String msg);
    public void drawBox(Graphics2D g2);
=======
/**
 * @author Muhammad Shahid
 */
import java.awt.Graphics2D;

import project.menus.Tooltip;

public interface DisplayBox {
	public Tooltip makeBox(String charName, String msg);
	public void editBox(Tooltip box, String charName, String msg);
    public void drawBox(Tooltip t, Graphics2D g2);
>>>>>>> refs/heads/develop

}
