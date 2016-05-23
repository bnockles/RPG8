package project.items;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import project.directors.Game;
import project.directors.Screen;
import project.mainmenudemo.DynamicMenu;

public class ItemScreen extends Screen implements KeyListener,ItemResources{
	TargetDemo you = new TargetDemo(100, Rifles[0],rifleAmmo,0,0,"You",yourarmor);
	TargetDemo enemy = new TargetDemo(100, Rifles[1],rifleAmmo,0,0,"Enemy",enemyarmor);
	
	BufferedImage weaponEquiped;
	int color=1;
	BufferedImage melee;
	BufferedImage pistol;
	BufferedImage rifle;
	BufferedImage heavy;
	BufferedImage smg;
	BufferedImage explosive;
	static Boolean isStun = false;
	public static int selected=0;
	
	public ItemScreen(Game game) {	
		super(game);
		createImages();
//		createMenuForItem(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return this;
	}
	

	//Qing Ning 
	public void createImages() {
		URL meleeurl = getClass().getResource(Melee[0].getItemImage());
		URL pistolurl = getClass().getResource(Pistol[2].getItemImage());
		URL rifleurl = getClass().getResource(Rifles[0].getItemImage());
		URL heavyurl = getClass().getResource(Heavy[0].getItemImage());
		URL smgurl = getClass().getResource(SMG[0].getItemImage());
		URL explosiveurl = getClass().getResource(Explosives[0].getItemImage());

		try {
			melee = ImageIO.read(meleeurl);
			pistol = ImageIO.read(pistolurl);
			rifle = ImageIO.read(rifleurl);
			heavy = ImageIO.read(heavyurl);
			smg = ImageIO.read(smgurl);
			explosive = ImageIO.read(explosiveurl);
			weaponEquiped = rifle;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	public void drawWeapon(BufferedImage pic, Graphics2D g2, int color){
//
//		if(color==1)g2.setColor(Color.blue);
//		if(color==2)g2.setColor(Color.green);
//		if(color==3)g2.setColor(Color.yellow);
//		if(color==4)g2.setColor(Color.pink);
//		if(color==5)g2.setColor(Color.orange);
//		if(color==6)g2.setColor(Color.red);
//		System.out.println(pic.getWidth());
//		g2.drawRect(265, 495, pic.getWidth()+60, pic.getHeight()+60);
//		g2.fillRect(265, 495, pic.getWidth()+60, pic.getHeight()+60);
//	
//		g2.drawImage(pic, 295, 525, pic.getWidth(), pic.getHeight(), null);			
//	}
	
	//Stanley 
	@Override
	public void paintScreen(Graphics2D g2) {
		Font tr=new Font("TimesRoman", Font.PLAIN, 22);
		g2.setFont(tr);
		g2.setColor(Color.white);
		g2.fillRect(0, 0, width, height);
		g2.setColor(Color.black);
		g2.drawString("Press E to heal", 425, 145);
		g2.drawString("Press S to do damage", 425, 170);
		g2.drawString("Press R to reload", 425, 195);
		g2.drawString("Press 1-6 to switch weapons", 425, 220);
		g2.drawString("Press 7-0 to switch", 425, 245);
		g2.drawString("different types of ammo", 445, 270);
		drawStats(g2,30,70,you);
		drawStats(g2,700,70,enemy);
		drawStickMan(g2, 20, 385);
		drawStickMan(g2,770,385);
		g2.drawImage(weaponEquiped, 295, 525, weaponEquiped.getWidth(), weaponEquiped.getHeight(), null);	
		
	}
	public void drawOutline(Graphics2D g2,int x1, int y1,int x2,int y2, Color c,int size){
		//x-1,y+29,101,21
		g2.setColor(c);
		for(int i=0;i<size;i++){
			g2.drawRect(x1+i,y1+i,x2-(2*i),y2-(2*i));
		}
	}
	public void drawStats(Graphics2D g2,int x,int y,TargetDemo target){
		g2.drawString("Status:", x, y+225);
		if(target.isBurned){
			g2.setColor(new Color(227,92,48));
			g2.drawString("[BURNED]", x+65, y+250);
		}
		else{
			g2.setColor(Color.green);
			g2.drawString("[----------]",x+65, y+250);
		}
		g2.fillRect(x, y+30, target.health, 20);
		if(target.isRegen){
			drawOutline(g2,x-1,y+29,101,21,new Color(255,153,255),5);
			g2.drawString("[REGENERATING]", x+65, y+300);
		}
		else{
			g2.setColor(Color.green);
			g2.drawString("[----------]",x+65, y+300);
		}
		if(target.isCorrosive){
			g2.setColor(new Color(53,107,34));
			g2.drawString("[CORRODED]", x+65, y+275);
		}
		else{
			g2.setColor(new Color(33,187,237));
			g2.drawString("[----------]", x+65, y+275);
		}
		g2.fillRect(x+105, y+30, target.armor, 20);
		if(target.isStunned){
			g2.setColor(new Color(255,215,0));
			g2.drawString("[STUNNED]",x+65, y+225);
		}
		else{
			g2.setColor(Color.DARK_GRAY);
			g2.drawString("[----------]",x+65, y+225);
		}
		g2.setColor(Color.black);
		g2.drawString(target.name, x, y);
		g2.drawRect(x-1,y+29,101,21);
		g2.drawRect(x+104,y+29,101,21);
		g2.drawString("Health: "+target.health, x, y+25);
		g2.drawString("Armor: "+target.armor, x+105, y+25);
		g2.drawString("Clips: "+target.weapon.getAmmoCapacity(), x, y+75);
		g2.drawString("Ammo in Clip: "+target.weapon.getAmmoTotal(), x, y+100);
		g2.drawString("Current Weapon: "+target.weapon.getName(), x, y+125);
		if(target.weapon.getGunNum()/10!=1){
			g2.drawString("Current Ammo: "+target.ammo.getName(), x, y+150);			
		}
		else g2.drawString("Melee",x,y+150);
		g2.drawString("Coins: "+target.coins, x, y+175);
		g2.drawString("Scrap: "+target.scrap, x, y+200);
	}
	public void drawStickMan(Graphics2D g2,int x,int y){
		g2.drawOval(x,y, 40, 40);
		g2.drawLine(x+20,y+40,x+20,y+80);
		g2.drawLine(x+20,y+40,x,y+60);
		g2.drawLine(x+20,y+40,x+40,y+60);
		g2.drawLine(x+20,y+80,x,y+100);
		g2.drawLine(x+20,y+80,x+40,y+100);
	}


	@Override
	public void keyPressed(KeyEvent e) {
		//Still Stanley
		if(!you.isStunned){
			if(e.getKeyCode()==KeyEvent.VK_E){
				System.out.println(you.health);
				smallkit.giveHealth(you);
				System.out.println(you.health);
			}
			if(e.getKeyCode()==KeyEvent.VK_1){
				you.weapon = Melee[0];
				weaponEquiped = melee;
				color=1;
			}
			if(e.getKeyCode()==KeyEvent.VK_2){
				you.weapon = Pistol[2];
				weaponEquiped = pistol;
				you.ammo = pistolAmmo;
				color=2;
			}
			if(e.getKeyCode()==KeyEvent.VK_3){
				you.weapon = Rifles[0];
				weaponEquiped = rifle;
				you.ammo = rifleAmmo;
				color=3;
			}
			if(e.getKeyCode()==KeyEvent.VK_4){
				you.weapon = Heavy[0];
				weaponEquiped = heavy;
				you.ammo = heavyAmmo;
				color=4;
			}
			if(e.getKeyCode()==KeyEvent.VK_5){
				you.weapon = SMG[0];
				weaponEquiped = smg;
				you.ammo = SMGAmmo;
				color=5;
			}
			if(e.getKeyCode()==KeyEvent.VK_6){
				you.weapon = Explosives[0];
				weaponEquiped = explosive;
				you.ammo = explosiveAmmo;
				color=6;
			}
			if(e.getKeyCode() == KeyEvent.VK_R){ 
				you.reload();
			}
			
			//Qing Ning 
			if(e.getKeyCode()==KeyEvent.VK_S){
				if(you.health>0){
					you.attack(enemy);
					if(!enemy.isStunned){
						int retaliate = (int)(Math.random()*101);
						if(retaliate<50 && enemy.health>0){
							enemy.attack(you);
							if(retaliate<40){
								enemy.reload();
							}
							if(retaliate<30){
								smallkit.giveHealth(enemy);
							}
							if(retaliate<20){
								if(enemy.weapon.getName().equals("RIA-10S")){
									enemy.weapon =Pistol[1];
								}else{
									enemy.weapon =Rifles[1];
								}
							}
						}
					}
					
					if((you.weapon.getAmmoTotal()>0 ||you.weapon.getGunNum()/10!=1)&&enemy.getCurrentHP()>0){
						you.coins+=10;
						you.scrap+=1;
						
					}
				}
//			if((int)(Math.random()*100+1)<45){
//				target.attack(you);
//			}
			}
			if(e.getKeyCode()==KeyEvent.VK_8){
				if(you.ammo.getEffect()!=ItemResources.FIRE){
					if(you.weapon.getGunNum()/10==2){
						you.ammo = firePistolAmmo;
					}
					if(you.weapon.getGunNum()/10==3){
						you.ammo = fireRifleAmmo;
					}
					if(you.weapon.getGunNum()/10==4){
						you.ammo = fireHeavyAmmo;
					}
					if(you.weapon.getGunNum()/10==5){
						you.ammo = fireSMGAmmo;
					}
					if(you.weapon.getGunNum()/10==6){
						you.ammo = fireExplosiveAmmo;
					}
				}
			}
			if(e.getKeyCode()==KeyEvent.VK_7){
				if(you.ammo.getEffect()!=ItemResources.NO_EFFECT){
					if(you.weapon.getGunNum()/10==2){
						you.ammo = pistolAmmo;
					}
					if(you.weapon.getGunNum()/10==3){
						you.ammo = rifleAmmo;
					}
					if(you.weapon.getGunNum()/10==4){
						you.ammo = heavyAmmo;
					}
					if(you.weapon.getGunNum()/10==5){
						you.ammo = SMGAmmo;
					}
					if(you.weapon.getGunNum()/10==6){
						you.ammo = explosiveAmmo;
					}
				}
			}
			if(e.getKeyCode()==KeyEvent.VK_9){
				if(you.ammo.getEffect()!=ItemResources.STUN){
					if(you.weapon.getGunNum()/10==2){
						you.ammo = stunPistolAmmo;
					}
					if(you.weapon.getGunNum()/10==3){
						you.ammo = stunRifleAmmo;
					}
					if(you.weapon.getGunNum()/10==4){
						you.ammo = stunHeavyAmmo;
					}
					if(you.weapon.getGunNum()/10==5){
						you.ammo = stunSMGAmmo;
					}
					if(you.weapon.getGunNum()/10==6){
						you.ammo = stunExplosiveAmmo;
					}
				}
			}
			if(e.getKeyCode()==KeyEvent.VK_0){
				if(you.ammo.getEffect()!=ItemResources.CORROSIVE){
					if(you.weapon.getGunNum()/10==2){
						you.ammo = corrosivePistolAmmo;
					}
					if(you.weapon.getGunNum()/10==3){
						you.ammo = corrosiveRifleAmmo;
					}
					if(you.weapon.getGunNum()/10==4){
						you.ammo = corrosiveHeavyAmmo;
					}
					if(you.weapon.getGunNum()/10==5){
						you.ammo = corrosiveSMGAmmo;
					}
					if(you.weapon.getGunNum()/10==6){
						you.ammo = corrosiveExplosiveAmmo;
					}
				}
			}
			if(e.getKeyCode()==KeyEvent.VK_P){
				createMenuForItem(game, selected);
			}
			update();
			game.repaint();
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
	public int buy(Misc gold) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int sell(Misc gold, Misc scrap) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String printStats(double[] stats) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item[] getItem() {
		// TODO Auto-generated method stub
		return null;
	}
	public static void createMenuForItem(Game game, int itemNumber){
		Screen demoScreen = DynamicMenu.createMenu(DynamicMenu.ITEM_DESCRIPTION_MENU, game, itemNumber);
		game.setScreen(demoScreen);
	}

}
