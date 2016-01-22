package project.menus;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;


public abstract class VerticalMenu extends ListMenu{


	public VerticalMenu(int width, int height) {
		super(width, height);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		 int keyCode = e.getKeyCode();
		    switch( keyCode ) { 
		        case KeyEvent.VK_UP:
		            selectPrevious();
		            update();//updates appearance of menu(i.e. selections change)
		            break;
		        case KeyEvent.VK_DOWN:
		            selectNext();
		            update();//updates appearance of menu(i.e. selections change)
		            break;
		        case KeyEvent.VK_SPACE: 
		        case KeyEvent.VK_ENTER:
		        	confirmSelection();//defined in superclass Menu
		        	break;
		     }
	}
	
	@Override
	public void paintScreen(Graphics2D g2){
		int y=0;
		for(Selectable s: selections){
			g2.drawImage(s.getImage(),0, y, null);
			y+=s.getImage().getHeight();
		}
	}



}
