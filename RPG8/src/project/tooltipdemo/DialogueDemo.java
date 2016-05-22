package project.tooltipdemo;
/**
 * @author Mark Mozgovoy & Maxwell Sulavko
 */
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import project.ChoiceMenuDemo.MenuTheme;
import project.directors.Game;
import project.directors.Screen;
import project.menus.Tooltip;
import project.menus.TooltipOptions;

public class DialogueDemo extends Screen implements KeyListener {
	Tooltip t = TooltipOptions.makeBoxStatic("Icefrog", "How do you feel about me ruining dota?");
	public DialogueDemo(Game game) {
		super(game);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_SPACE){
			TooltipOptions.editBoxStatic(t, "Icefrog", "LMAO");
			update();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public void paintScreen(Graphics2D g2) {
		g2.setColor(MenuTheme.greenBR);
		g2.fillRect(0, 0, width, height);
		
		//making memes appear
		BufferedImage boxImg = null;
		try {
			boxImg = ImageIO.read(new File("resources/image1.jpg"));
		} catch (IOException e) {
		}
		g2.drawImage(boxImg, 300, 130, 400, 400, null);
		
		//Text To Appear
		g2.setColor(Color.BLACK);
		g2.drawString("THIS IS A BAD TEST", 100, 100);
		
		//g2.drawString("THIS IS A GOOD TEST", 200, 100);
		
		TooltipOptions.drawBoxStatic(t, g2);
	}
	
	public void delayTime(){
		try {
		    TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
		    //Handle exception
		}
	}
	

}
