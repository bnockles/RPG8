package project.overworld;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import project.directors.Game;
import project.directors.Screen;
import project.directors.UtilityMethods;
/**
 * This is a "Demo" of how to display images stored in the directory
 * You probably don't want to use this class as your actual overworld, 
 * since – otherthan implenting required methods, no insight was given into how
 * this class should function with the rest of the game as a whole
 * 
 * IMPORTANT: In this class you wil see a BufferedImage[] for the character
 * You would NOT want to do this in the actual overworld class. The character's sprite should
 * probably be stored in a Character class, which I have not done for you
 * 
 * @author bnockles
 *
 */
public class DemoOverworld extends Screen implements KeyListener{

	/**You would not want these field in your actual Overworld class
	they should be fields in a Character class, but are here for demo purposes only
	*/
	BufferedImage[] spriteImages;
	int spriteX;
	int spriteY;
	public static final int SPRITE_WIDTH=100;
	public static final int SPRITE_HEIGHT=100;
	
	public DemoOverworld(Game game) {
		super(game);
		//demo purposes only:
		spriteImages=new BufferedImage[3];
		spriteX = 0;
		spriteY = 50;
		//try block must be used since files *might* not exist
		try {
			spriteImages[0] = ImageIO.read(new File("images/sprites/standing.png"));
			spriteImages[1] = ImageIO.read(new File("images/sprites/standing1.png"));
			spriteImages[2] = ImageIO.read(new File("images/sprites/standing2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public KeyListener getKeyListener() {
		return this;
	}

	@Override
	public void paintScreen(Graphics2D g2) {
		//shows the image exactly as it is:
		g2.drawImage(spriteImages[0], spriteX, spriteY, null);
		//scales the image to a specified size
		UtilityMethods.scaleImage(g2, spriteImages[0], 400, 400, SPRITE_WIDTH, SPRITE_HEIGHT);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
