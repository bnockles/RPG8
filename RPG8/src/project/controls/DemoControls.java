package project.controls;

/** author Vincent & Jacky*/

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

import project.directors.Game;
import project.directors.Screen;

public class DemoControls extends project.directors.Screen implements KeyListener,MenuInteraction,BattlesInteraction, MouseListener{

	BufferedImage landscape;
	int x=300;
	int y=300;
	double walking=15;
	int statusCooldown = 9000;
	int[] paralyzedCooldown = {2000,1000};
	boolean paralyzed=false;
	boolean blazed = false;
	boolean effect = false;
	double speed=walking;
	double running=2;
	double stealth=2;
	double ablazedS = 1.5;
	double poisonedS = 2.5;
	int pCount=0;
	Timer effectTimer;
	ArrayList<Integer> moving;
	String s = "Press 1 to select Game controls. Press 2 to select Menu Controls.";
	String idle="Swarm is idle";
	Boolean selection=false;
	Boolean game=false;
	Boolean menu=false;
	String [] ramStatus = {"paralyzed","ablazed","poisoned"};

	public DemoControls(Game game) {
		super(game);
		moving = new ArrayList<Integer>();
	}
	
	public String ramdomStatus(){
		int  rng = (int)new Random().nextInt(ramStatus.length);
		return ramdom;
	}
	
//	public static enum Mode{
//		ALPHA,ALPHA2,ALPHA3
//	}
//	
//	public static String generateRandomString(int length,Mode mode){
//		
//		StringBuffer buffer = new StringBuffer();
//		String characters = "";
//		switch(mode){
//		case ALPHA:
//			characters = "A";
//			break;
//		case ALPHA2:
//			characters = "E";
//			break;
//		case ALPHA3:
//			characters = "1";
//			break;
//		}
//		int charactersLength = characters.length();
//
//		for (int i = 0; i < length; i++) {
//			double index = Math.random() * charactersLength;
//			buffer.append(characters.charAt((int) index));
//		}
//		return buffer.toString();
//	}
		// TODO Auto-generated constructor stub

	
	
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
		if(keyCode == KeyEvent.VK_ESCAPE){
			selection=false;
			game=false;
			menu=false;
			paralyzed=false;
			blazed=false;
			s = "Press 1 to select Game controls. Press 2 to select Menu Controls.";
		}
		if(keyCode == KeyEvent.VK_1){
			if(!selection){
				selection=true;
				game=true;
				s="You selected game controls";
				return;
			}
			s = "Swarm equipped his melee weapon";
		}
		if(keyCode == KeyEvent.VK_2){
			if(!selection){
				selection=true;
				menu=true;
				s="You selected menu controls";
				return;
			}
			s = "Swarm equipped his pistol";
			
		}
		if(selection){
			if(keyCode == KeyEvent.VK_W){
				if(game){
					s = "Swarm walked up";
					if(!moving.contains(keyCode)) moving.add(keyCode);
				}
				if(menu){
					s = "You selected the choice on the top";
				}
			}
			if(keyCode == KeyEvent.VK_A){
				if(game){
					s = "Swarm walked left";
					if(!moving.contains(keyCode)) moving.add(keyCode);
				}
				if(menu){
					s = "You selected the choice on the left";
				}
			}
			if(keyCode == KeyEvent.VK_S){
				if(game){
					s = "Swarm walked down";
					if(!moving.contains(keyCode)) moving.add(keyCode);
				}
				if(menu){
					s = "You selected the choice on the bottom";
				}
			}
			if(keyCode == KeyEvent.VK_D){
				if(game){
					s = "Swarm walked right";
					if(!moving.contains(keyCode)) moving.add(keyCode);
				}
				if(menu){
					s = "You selected the choice on the right";
				}
			}
			if(keyCode == KeyEvent.VK_P){
				if(game&&!effect){
					s = ramdomStatus();
					if(s == "paralyzed"){
						s = "The current status of Swarm is paralyzed";
						if(!moving.contains(keyCode)) moving.add(keyCode);
						countdown(null, paralyzedCooldown[0]);
					}
					if(s == "ablazed"){
						s = "The current status of Swarm is ablazed";
						if(!moving.contains(keyCode)) moving.add(keyCode);
						blazed = true;
						speed *= ablazedS;
					}
					if(s == "poisoned"){
						s = "The current status of Swarm is poisoned";
						if(!moving.contains(keyCode)) moving.add(keyCode);
						speed /= poisonedS;
					}
					effect=true;
					effectTimer = new Timer();
					countdown(null, statusCooldown);
				}
			}
		}
		if(game){
			if(keyCode == KeyEvent.VK_3){
				s = "Swarm equipped his SMG";
			}
			if(keyCode == KeyEvent.VK_4){
				s = "Swarm equipped his rifle";
			}
			if(keyCode == KeyEvent.VK_5){
				s = "Swarm equipped his heavy";
			}
			if(keyCode == KeyEvent.VK_6){
				s = "Swarm equipped his rocket launcher";
			}
			if(keyCode == KeyEvent.VK_G){
				s = "Swarm equipped his explosive";
			}
			if(keyCode == KeyEvent.VK_SHIFT&&!blazed){
				if(!moving.contains(moving.indexOf(keyCode))){
					s = "Swarm started to sprint";
					moving.add(keyCode);
					speed*=running;
				}
			}
			if(keyCode == KeyEvent.VK_E){
				s = "Swarm interacted with something on the map";
			}
			if(keyCode == KeyEvent.VK_R){
				s = "Swarm reloaded his weapon";
			}
			if(keyCode == KeyEvent.VK_F){
				s = "Swarm went on stealth mode";
			}
			if(keyCode == KeyEvent.VK_M){
				s = "The player opens a transparent outline of the map";
			}
			if(keyCode == KeyEvent.VK_ESCAPE){
				s = "The player opens the exit menu";
			}
		}
		if(menu){
			if(keyCode == 13){
				s = "You have pressed Enter";
			};
			if(keyCode == 16){
				s = "You have pressed Shift";
			};
			if(keyCode == 17){
				s = "You have pressed Ctrl";
			};
			if(keyCode == 18){
				s = "You have pressed Alt";
			};
			if(keyCode == 27){
				s = "You have pressed Escape";
			};
			if(keyCode == KeyEvent.VK_Z){
				s = "You confirmed a selection";
			};
			if(keyCode == KeyEvent.VK_X){
				s = "You exited a screen";
			};
		}
	}

	private void countdown(Screen screen, final int count) {
		final Timer t = new Timer();
		t.schedule(new TimerTask(){
			public void run(){
				if(count==statusCooldown){
					effect=false;
					blazed=false;
					speed=walking;
					t.cancel();
				}
				if(count==paralyzedCooldown[0]){
					paralyzed=true;
					pCount++;
					countdown(null, paralyzedCooldown[1]);
				}
				if(count==paralyzedCooldown[1]){
					if(pCount<3){
						paralyzed=false;
						countdown(null, paralyzedCooldown[0]);
					}else{
						pCount=0;
						effect=false;
						paralyzed=false;
						t.cancel();
					}
				}
			}
		}, count);
		
	}

	public void mousePressed(MouseEvent e){
		if(game){
			if(e.getButton()==MouseEvent.BUTTON1){
				s = "Swarm fired his gun";
			}
			if(e.getButton()==MouseEvent.BUTTON3){
				s = "Swarm fired his alternative shot";
			}
		}
		if(menu){
			if(e.getButton()==MouseEvent.BUTTON1){
				s = "You left clicked confirm";
			}
			if(e.getButton()==MouseEvent.BUTTON3){
				s = "You right clicked an exitted a menu";
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		if(game){
			if(keyCode==KeyEvent.VK_W||keyCode==KeyEvent.VK_A||keyCode==KeyEvent.VK_S||keyCode==KeyEvent.VK_D){
				s = idle;
				moving.remove(moving.indexOf(keyCode));
			}
			if(keyCode==KeyEvent.VK_SHIFT&&moving.contains(keyCode)){
				moving.remove(moving.indexOf(keyCode));
				speed/=running;
				s="Swarm stopped sprinting";
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
		checkMotion();
		g2.setColor(Color.blue);
		g2.drawString(s,x, y);
	}

	private void checkMotion() {
		// TODO Auto-generated method stub
		if(!paralyzed){
			if(moving.contains(KeyEvent.VK_W)) y-=speed;
			if(moving.contains(KeyEvent.VK_A)) x-=speed;
			if(moving.contains(KeyEvent.VK_S)) y+=speed;
			if(moving.contains(KeyEvent.VK_D)) x+=speed;
		}else{
			s="Swarm can't move!";
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
