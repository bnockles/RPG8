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

public class DemoControls2pointooooooo extends project.directors.Screen implements KeyListener,MenuInteraction,BattlesInteraction, MouseListener{
	private Message message;
	private Speed speed;
	boolean effect = false;
	ArrayList<Integer> moving;
	ArrayList<Status> status;
	private int x=300;
	private int y=300;
	BufferedImage landscape;
	double walking=15;
	private double running=1.5;
	private double ablazedS = 1.2;
	private double poisonedS = 0.6;
	private Status paralyzed = new Status("paralyzed");
	int statusCooldown = 9000;
	int[] paralyzedCooldown = {2000,1000};
	int pCount=0;
	Timer effectTimer;
	Boolean selection=false;
	Boolean game=false;
	Boolean menu=false;
	int [] ramStatus = {0,1,2};

	public DemoControls2pointooooooo(Game game) {
		super(game);
		message = new Message("Press 1 to select Game controls. Press 2 to select Menu Controls.");
		speed = new Speed(15,"walking");
		moving = new ArrayList<Integer>();
		status = new ArrayList<Status>();
	}
	
	public int ramdomStatus(){
		int  random = ramStatus[(int) (Math.random()*(ramStatus.length))];
		return random;
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
		if(keyCode == KeyEvent.VK_ESCAPE){
			selection=false;
			game=false;
			menu=false;
			message.setMessage("Press 1 to select Game controls. Press 2 to select Menu Controls.");
		}
		if(keyCode == KeyEvent.VK_1){
			if(!selection){
				selection=true;
				game=true;
				message.setMessage("You selected game controls");
				return;
			}
			message.setMessage("Swarm equipped his melee weapon");
		}
		if(keyCode == KeyEvent.VK_2){
			if(!selection){
				selection=true;
				menu=true;
				message.setMessage("You selected menu controls");
				return;
			}
			message.setMessage("Swarm equipped his pistol");
			
		}
		if(selection){
			if(keyCode == KeyEvent.VK_W||keyCode == KeyEvent.VK_A
					||keyCode==KeyEvent.VK_S||keyCode == KeyEvent.VK_D){
				if(keyCode == KeyEvent.VK_W){
					if(game){
						speed.setDirection(" up.");
						if(!moving.contains(keyCode)) moving.add(keyCode);
					}
					if(menu){
					}
					speed.setDirection("top.");
				}
				if(keyCode == KeyEvent.VK_A){
					speed.setDirection(" left.");
					if(!moving.contains(keyCode)) moving.add(keyCode);
				}
				if(keyCode == KeyEvent.VK_S){
					if(game){
						speed.setDirection(" down.");
						if(!moving.contains(keyCode)) moving.add(keyCode);
					}
					if(menu){
						message.setMessage("You selected the choice on the bottom");
					}
				}
				if(keyCode == KeyEvent.VK_D){
					speed.setDirection(" right.");
					if(!moving.contains(keyCode)) moving.add(keyCode);
				}
				if(game) message.setMessage("Swarm is "+speed.getSpeedName()+speed.getDirection());
				else message.setMessage("You selected the choice on the "+speed.getDirection());
			}
			if(keyCode == KeyEvent.VK_P){
				if(game&&!effect){
					int r = ramdomStatus();
					if(r == 0){
						message.setMessage("The current status of Swarm is paralyzed");
						if(!moving.contains(keyCode)) moving.add(keyCode);
						countdown(paralyzedCooldown[0]);
					}
					if(r == 1){
						status.add(new Status("ablazed"));
						message.setMessage("The current status of Swarm is "+status.get(0).getStatusName());
						if(!moving.contains(keyCode)) moving.add(keyCode);
						speed.setSpeed(speed.getSpeed()*ablazedS);
					}
					if(r == 2){
						status.add(new Status("poisoned"));
						message.setMessage("The current status of Swarm is "+status.get(0).getStatusName());
						if(!moving.contains(keyCode)) moving.add(keyCode);
						speed.setSpeed(speed.getSpeed()*poisonedS);;
					}
					effect=true;
					effectTimer = new Timer();
					countdown(statusCooldown);
				}
			}
		}
		if(game){
			if(keyCode == KeyEvent.VK_3){
				message.setMessage("Swarm equipped his SMG");
			}
			if(keyCode == KeyEvent.VK_4){
				message.setMessage("Swarm equipped his rifle");
			}
			if(keyCode == KeyEvent.VK_5){
				message.setMessage("Swarm equipped his heavy");
			}
			if(keyCode == KeyEvent.VK_6){
				message.setMessage("Swarm equipped his rocket launcher");
			}
			if(keyCode == KeyEvent.VK_G){
				message.setMessage("Swarm equipped his explosive");
			}
			if(keyCode == KeyEvent.VK_SHIFT&&(status.size()==0||(status.size()>0&&status.get(0).getStatusName()!="ablazed"))){
				if(!moving.contains(moving.indexOf(keyCode))){
					moving.add(keyCode);
					speed.setSpeedName("running");
					speed.setSpeed(speed.getSpeed()*running);
					message.setMessage("Swarm is "+speed.getSpeedName()+speed.getDirection());
				}
			}
			if(keyCode == KeyEvent.VK_E){
				message.setMessage("Swarm interacted with something on the map");
			}
			if(keyCode == KeyEvent.VK_R){
				message.setMessage("Swarm reloaded his weapon");
			}
			if(keyCode == KeyEvent.VK_F){
				message.setMessage("Swarm went on stealth mode");
			}
			if(keyCode == KeyEvent.VK_M){
				message.setMessage("The player opens a transparent outline of the map");
			}
			if(keyCode == KeyEvent.VK_ESCAPE){
				message.setMessage("The player opens the exit menu");
			}
		}
		if(menu){
			if(keyCode == 13){
				message.setMessage("You have pressed Enter");
			};
			if(keyCode == 16){
				message.setMessage("You have pressed Shift");
			};
			if(keyCode == 17){
				message.setMessage("You have pressed Ctrl");
			};
			if(keyCode == 18){
				message.setMessage("You have pressed Alt");
			};
			if(keyCode == 27){
				message.setMessage("You have pressed Escape");
			};
			if(keyCode == KeyEvent.VK_Z){
				message.setMessage("You confirmed a selection");
			};
			if(keyCode == KeyEvent.VK_X){
				message.setMessage("You exited a screen");
			};
		}
	}

	private void countdown(final int count) {
		final Timer t = new Timer();
		t.schedule(new TimerTask(){
			public void run(){
				if(count==statusCooldown){
					effect=false;
					t.cancel();
				}
				if(count==paralyzedCooldown[0]){
					status.add(paralyzed);
					pCount++;
					countdown(paralyzedCooldown[1]);
				}
				if(count==paralyzedCooldown[1]){
					if(pCount<3){
						status.remove(paralyzed);
						countdown(paralyzedCooldown[0]);
					}else{
						pCount=0;
						status.remove(paralyzed);
						effect=false;
						t.cancel();
					}
				}
			}
		}, count);
		speed.setSpeed(walking);
	}

	public void mousePressed(MouseEvent e){
		if(game){
			if(e.getButton()==MouseEvent.BUTTON1){
				message.setMessage("Swarm fired his gun");
			}
			if(e.getButton()==MouseEvent.BUTTON3){
				message.setMessage("Swarm fired his alternative shot");
			}
		}
		if(menu){
			if(e.getButton()==MouseEvent.BUTTON1){
				message.setMessage("You left clicked confirm");
			}
			if(e.getButton()==MouseEvent.BUTTON3){
				message.setMessage("You right clicked an exitted a menu");
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		if(game){
			if(keyCode==KeyEvent.VK_W||keyCode==KeyEvent.VK_A||keyCode==KeyEvent.VK_S||keyCode==KeyEvent.VK_D){
				moving.remove(moving.indexOf(keyCode));
			}
			if(keyCode==KeyEvent.VK_SHIFT&&moving.contains(keyCode)){
				moving.remove(moving.indexOf(keyCode));
				speed.setSpeed(walking);
				speed.setSpeedName("walking");
			}
			if(moving.size()==0){
				message.setMessage("Swam is idle");
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
		g2.drawString(message.getMessage(),x, y);
	}

	private void checkMotion() {
		// TODO Auto-generated method stub
		if(status.size()>0&&status.get(0).getStatusName()=="paralyzed"){
			message.setMessage("Swarm can't move!");
		}else{
			if(moving.contains(KeyEvent.VK_W)) y-=speed.getSpeed();
			if(moving.contains(KeyEvent.VK_A)) x-=speed.getSpeed();
			if(moving.contains(KeyEvent.VK_S)) y+=speed.getSpeed();
			if(moving.contains(KeyEvent.VK_D)) x+=speed.getSpeed();
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
