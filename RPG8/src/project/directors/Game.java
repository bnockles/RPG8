
package project.directors;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * 
 * @author bnockles
 * @date January 2016
 */

public class Game extends JFrame{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1357293344654297721L;

	public static void main(String[] args) {
		new Game();
	}

	/**
	 * creates an instance of the Game and displays the screen
	 */
	private Game() {
		applySettings();
		setVisible(true);
	}

	private void applySettings() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int monitorWidth = (int) screenSize.getWidth();
		int monitorHeight = (int) screenSize.getHeight();
		int windowWidth = 1000;
		int windowHeight = 800;
		setSize(windowWidth,windowHeight);
		setLocation((monitorWidth-windowWidth)/2, (monitorHeight-windowHeight)/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(false);//windowBar
		
	}


}
