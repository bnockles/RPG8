package project.controls;

/** author Vincent */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.SwingUtilities;

import project.directors.Game;
import project.directors.Screen;

public class DemoControls extends project.directors.Screen implements KeyListener,MenuInteraction,BattlesInteraction{

	BufferedImage landscape;
	int x=300;
	int y=300;
	String s = "Press 1 to select Game controls. Press 2 to select Menu Controls.";
	String idle="Swarm is idle";
	Boolean selection=false;
	Boolean game=false;
	Boolean menu=false;

	public DemoControls(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void moveUp() {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveDown() {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveRight() {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_1){
			if(!selection){
				selection=true;
				game=true;
				s="You selected game controls";
				return;
			}
			s = "Swarm equipped his melee weapon";
			update();
		}
		if(keyCode == KeyEvent.VK_2){
			if(!selection){
				selection=true;
				menu=true;
				s="You selected menu controls";
				return;
			}
			s = "Swarm equipped his pistol";
			update();
		}
		if(selection){
			if(keyCode == KeyEvent.VK_W){
				if(game){
					s = "Swarm walked up";
					y-=5;
				}
				if(menu){
					s = "You selected the choice on the top";
				}
				update();
			}
			if(keyCode == KeyEvent.VK_A){
				if(game){
					s = "Swarm walked left";
					x-=5;
				}
				if(menu){
					s = "You selected the choice on the left";
				}
				update();
			}
			if(keyCode == KeyEvent.VK_S){
				if(game){
					s = "Swarm walked down";
					y+=5;
				}
				if(menu){
					s = "You selected the choice on the bottom";
				}
				update();
			}
			if(keyCode == KeyEvent.VK_D){
				if(game){
					s = "Swarm walked right";
					x+=5;
				}
				if(menu){
					s = "You selected the choice on the right";
				}
				update();
			}
		}
		if(game){
			if(keyCode == KeyEvent.VK_3){
				s = "Swarm equipped his SMG";
				update();
			}
			if(keyCode == KeyEvent.VK_4){
				s = "Swarm equipped his rifle";
				update();
			}
			if(keyCode == KeyEvent.VK_5){
				s = "Swarm equipped his heavy";
				update();
			}
			if(keyCode == KeyEvent.VK_6){
				s = "Swarm equipped his rocket launcher";
				update();
			}
			if(keyCode == KeyEvent.VK_G){
				s = "Swarm equipped his explosive";
				update();
			}
			if(keyCode == KeyEvent.VK_SHIFT){
				s = "Swarm started to sprint";
				update();
			}
			if(keyCode == KeyEvent.VK_E){
				s = "Swarm interacted with something on the map";
				update();
			}
			if(keyCode == KeyEvent.VK_R){
				s = "Swarm reloaded his weapon";
				update();
			}
			if(keyCode == KeyEvent.VK_F){
				s = "Swarm went on stealth mode";
				update();
			}
			if(keyCode == KeyEvent.VK_M){
				s = "The player opens a transparent outline of the map";
				update();
			}
			if(keyCode == KeyEvent.VK_ESCAPE){
				s = "The player opens the exit menu";
				update();
			}
		}
		if(menu){
			if(keyCode == 13){
				s = "You have pressed Enter";
				update();
			};
			if(keyCode == 16){
				s = "You have pressed Shift";
				update();
			};
			if(keyCode == 17){
				s = "You have pressed Ctrl";
				update();
			};
			if(keyCode == 18){
				s = "You have pressed Alt";
				update();
			};
			if(keyCode == 27){
				s = "You have pressed Escape";
				update();
			};
			if(keyCode == KeyEvent.VK_Z){
				s = "You confirmed a selection";
				update();
			};
			if(keyCode == KeyEvent.VK_X){
				s = "You exited a screen";
				update();
			};
		}
	}
	public void mouseClicked(MouseEvent e){
		if(SwingUtilities.isLeftMouseButton(e)){
			s = "Swarm fired his gun";
			update();
		}
		else if(SwingUtilities.isRightMouseButton(e)){
			s = "Swarm fired his alternative shot";
			update();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		if(game){
			if(keyCode == KeyEvent.VK_W){
				s = idle;
				update();
			}
			if(keyCode == KeyEvent.VK_A){
				s = idle;
				update();
			}
			if(keyCode == KeyEvent.VK_S){
				s = idle;
				update();
			}
			if(keyCode == KeyEvent.VK_D){
				s = idle;
				update();
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public void paintScreen(Graphics2D g2) {
		g2.setColor(Color.blue);
		g2.drawString(s,x, y);
	}

}
