package project.towns;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;

import project.directors.Game;
import project.directors.Screen;
import project.items.ItemResources;

/**
 * 
 * @author Fei and Jingwen
 *
 */
public class TownScreen extends Screen implements KeyListener{
	 //Jingwen Code
	static BufferedImage backGround;
	BufferedImage portalToTown;
	BufferedImage townPortalToArmor;
	BufferedImage townPortalToWeapon;
	BufferedImage townPortalToAmmo;
	
	StoreNPC putin;
	static TownWanderer playable;
	WeaponStore store;
	ArmorStore storeA;
	ConsumStore storeC;
	Building portalTooTown;
	Building townPortalTooArmor;
	Building townPortalTooWeapon;
	Building townPortalTooAmmo;
	int status2;
	int boxX = 50;
	int boxY =80;
	int x;
	int y;
	int itemx = 92;
	int itemy = 60;
	public static final int TOWN = 2;
	public static final int IN_SHOP_MENU = 1;
	public static final int WEAPON_STORE = 0;
	public static final int AMMO_STORE = 3;
	public static final int ARMOR_STORE = 4;
	public static final int ARMOR_STOREx = 10;
	public static final int AMMO_STOREx = 11;
	public static final int WEAPON_STOREx = 12;
	public static final int TOWNx = 13;
	public static final int R_SHOP = 5;
	ArrayList<Integer>itemN = new ArrayList<Integer>();
	Timer timer = new Timer();
	 int status = TOWN;

	//Fei code
	BufferedImage[][] backgroundGrid;
	BufferedImage[][] obstacleGrid;

	//BufferedImage[][] foregroundGrid;
	int gridColumns;
	int gridRows;
	
	
	int currentRow;//index of the cell currently showing
	int currentColumn;//index of the cell currently showing
	
	int entranceRow;//the index of the cell where a character always enters from
	int entraceColumn;
	int entranceX;//exact location on the cell where the entrance is
	int entranceY;
	StoreNPC trump;
	StoreNPC hillary;
	
	//s
	
	public TownScreen(Game game, int gridWidth, int gridHeight){
		super(game);
		
		this.gridColumns=gridWidth;
		this.gridRows=gridHeight;
		backgroundGrid = new BufferedImage[gridHeight][gridWidth];
		obstacleGrid = new BufferedImage[gridHeight][gridWidth];
		
		currentRow = 1;// starting position when the character enters town
		currentColumn = 0;
		//example of starting screen for town but not actual
		
			
			//JINGWEN CODE
			for(int i = 0; i < 3; i++) itemN.add(i, 0);
			// TODO Auto-generated constructor stub
			try{
				backGround = ImageIO.read(getClass().getResource("/images/shop/pic.png"));
				portalToTown = ImageIO.read(getClass().getResource("/images/maps/portaltown.png"));
				
				townPortalToWeapon = ImageIO.read(getClass().getResource("/images/maps/portalshop1.png"));
				townPortalToArmor = ImageIO.read(getClass().getResource("/images/maps/portalshop2.png"));
				townPortalToAmmo = ImageIO.read(getClass().getResource("/images/maps/portalshop3.png"));
				
				putin = new StoreNPC(450, 180, "Putin","/images/shop/hey.jpg");
				trump = new StoreNPC(450, 180, "Trump","/images/shop/trump.jpg");
				hillary = new StoreNPC(450, 180, "alien","/images/shop/hillary.jpg");
				playable = new TownWanderer(450, game.getHeight()-115, "hero", "/images/shop/obama.jpg", 10000);
				
				portalTooTown = new Building(portalToTown,450,50,true,"porttotown");
				townPortalTooWeapon = new Building(townPortalToWeapon,250 - 50, game.getHeight() -200,true,"porttotown");
				townPortalTooArmor = new Building(townPortalToArmor,450, 50,true,"porttotown");
				townPortalTooAmmo = new Building(townPortalToAmmo,700, game.getHeight() -180,true,"porttotown");
						//Building(BufferedImage image,int y, int x, boolean portal,String nameOfBuiliding){
				
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			store = new WeaponStore(itemN, playable.getMoney());
			storeA = new ArmorStore(itemN, playable.getMoney());
			storeC = new ConsumStore(itemN, playable.getMoney());
			getKeyListener();
		
		//qq
		
		
	}
	//Fei code

	@Override
	public KeyListener getKeyListener() {
		// TODO Auto-generated method stub
		return this;
	}	
	boolean yx= false;
	int lottry;
	public void delay( Graphics2D g2,String msg,int x , int y , final int statusx , final int statusxx, int delaytime ){
		
		
		
		Font myFont = new Font ("Courier New", 1, 27);
	
		g2.setFont (myFont);
	
		g2.drawString(msg  , x, y);
		
	    	Timer t = new Timer();
	    	t.schedule(new TimerTask() {

	    	            @Override
	    	            public void run() {
	    	               status = statusx;
	    	               status2 =statusxx;
	    	               update();	
	    	            }
	    	        }, delaytime);
		
		
		//hids
	}
	
    //Jingwen COde
	public void paintScreen(Graphics2D g2) {
	
				if(status == WEAPON_STORE){
					paintShop(g2);
					g2.drawImage(hillary.getNpc(), 420,150,250,180, null);
					
					g2.drawImage(portalTooTown.getImage(), 250 - 100, game.getHeight() -10 - 100, null);
					
					//portalTooTown = new Building(portalToTown,450,50,true,"porttotown");
			    	
			    	g2.drawImage(playable.getImage(), playable.getX(),playable.getY(),200,150, null);
				}
				if(status == AMMO_STORE){
					paintShop(g2);
					g2.drawImage(trump.getNpc(), 420,150,250,180, null);
					
					g2.drawImage(portalTooTown.getImage(), 750, game.getHeight() -110, null);
					
		//	    	g2.drawOval(750, game.getHeight() -110, 100, 100);
		//	    	g2.setColor(Color.WHITE);
		//	    	g2.fillOval(750, game.getHeight() -110, 100, 100);
			    	
			    	g2.drawImage(playable.getImage(), playable.getX(),playable.getY(),200,150, null);
				}
				if(status == ARMOR_STORE){
					paintShop(g2);
					g2.drawImage(putin.getNpc(), 390,game.getHeight() - 250,250,180, null);
					
			    	g2.drawImage(portalTooTown.getImage(), 450,50, null);
			    	
			    	g2.drawImage(playable.getImage(), playable.getX(),playable.getY(),200,150, null);
				}
				if(status == R_SHOP){

					g2.drawString("Press B to buy a lottry, 1000 each buy", 100, 50);

					g2.drawString("Player cash: " + store.getMoney(),100,150);

					g2.drawString("U won: " + lottry, 100, 250);

					}
				if (status == IN_SHOP_MENU){
					if(status2 == WEAPON_STORE){
						paintInShop(store, g2);
					}
					if(status2 == ARMOR_STORE){
						paintInShopA(storeA, g2);
					}
					if(status2 == AMMO_STORE){
						paintInShopC(storeC, g2);
					}
				}
				if (status == TOWN){
					//Fei code
					g2.drawImage(backgroundGrid[currentRow][currentColumn], 0, 0, null);
					
					g2.drawImage(townPortalTooWeapon.getImage(), townPortalTooWeapon.getxcoord(),townPortalTooWeapon.getycoord(),150,150, null);

					g2.drawImage(townPortalTooArmor.getImage(), townPortalTooArmor.getxcoord(),townPortalTooArmor.getycoord(),150,150, null);

					g2.drawImage(townPortalTooAmmo.getImage(), townPortalTooAmmo.getxcoord(),townPortalTooAmmo.getycoord(),150,150, null);

//					g2.drawOval(250 - 100, game.getHeight() -110, 100, 100);

//					g2.drawOval(450, 50, 100, 100);

//					g2.drawOval(750, game.getHeight() -110, 100, 100);

					g2.setColor(Color.GRAY);

					g2.fillRect(20, game.getHeight()/3, 100, 200);
					
					g2.drawString("USE T IN CIRCLE TO GO THROUGH CIRCLE, USE SPACE IN SHOP TO ACCESS SHOP ", 400, 500);
				
					g2.drawImage(playable.getImage(),playable.getX(),playable.getY(),200,150,null);
					
					yx = true;
				}
//			
				if(status ==ARMOR_STOREx  ){
					
					delay( g2,"Attempting To Enter Armor Store",200 , 500 ,  ARMOR_STORE ,  ARMOR_STORE,350 );

				}
				if(status ==AMMO_STOREx  ){
					delay( g2,"Attempting To Enter Ammo Store",200 , 500 ,  AMMO_STORE ,  AMMO_STORE,350 );

					
				}
				if(status ==WEAPON_STOREx  ){
					delay( g2,"Attempting To Enter Weapon Store",200 , 500 , WEAPON_STORE , WEAPON_STORE ,350 );

					
				}
				if(status ==TOWNx  ){
					delay( g2,"Attempting To Enter Town",200 , 500 , TOWN , TOWNx ,350 );

					
				}

	}
	private void paintInShopC(ConsumStore s, Graphics2D g2) {
		// TODO Auto-generated method stub
		g2.drawRect(boxX, boxY, 400, 30);
		g2.drawString("Press B to buy and press S to sale.", 100, 50);
		g2.drawString("Player cash: " + playable.getMoney(), 400, 50);
		
		int y=100;
		int count = 0;
		for(ShopItems x: s.itemListC){
			g2.drawString("U owned: " + s.itemNC.get(count), 300, y);
			g2.drawString(x.getName(), 100, y);
			g2.drawString("price: " + x.getPrice(), 200, y);
			y+=100;
		}

		g2.drawRect(60, itemx, 5, 5);
		g2.fillRect(60, itemx, 5, 5);
	}

	private void paintInShopA(ArmorStore s, Graphics2D g2) {
		// TODO Auto-generated method stub
		g2.drawRect(boxX, boxY, 400, 30);
		g2.drawString("Press B to buy and press S to sale.", 100, 50);
		g2.drawString("Player cash: " + playable.getMoney(), 400, 50);
		
		int y=100;
		int count = 0;
		for(ShopItems x: s.itemListA){
			g2.drawString("U owned: " + s.itemNA.get(count), 300, y);
			g2.drawString(x.getName(), 100, y);
			g2.drawString("price: " + x.getPrice(), 200, y);
			y+=100;
		}

		g2.drawRect(60, itemx, 5, 5);
		g2.fillRect(60, itemx, 5, 5);
	}

	public void paintInShop(WeaponStore s, Graphics2D g2){
		g2.drawRect(boxX, boxY, 400, 30);
		g2.drawString("Press B to buy and press S to sale.", 100, 50);
		g2.drawString("Player cash: " + playable.getMoney(), 400, 50);
		
		int y=100;
		int count = 0;
		for(ShopItems x: s.itemListW){
			g2.drawString("U owned: " + s.itemNuW.get(count), 300, y);
			g2.drawString(x.getName(), 100, y);
			g2.drawString("price: " + x.getPrice(), 200, y);
			y+=100;
		}

		g2.drawRect(60, itemx, 5, 5);
		g2.fillRect(60, itemx, 5, 5);
	}
	public static void paintShop(Graphics2D g2){
		g2.drawImage(backGround,0,0, null);
    	g2.drawImage(backGround,0,288, null);
    	g2.drawImage(backGround,0,576, null);
    	g2.drawImage(backGround,384,0, null);
    	g2.drawImage(backGround,384,288, null);
    	g2.drawImage(backGround,384,576, null);
    	g2.drawImage(backGround,768,0, null);
    	g2.drawImage(backGround,768,288, null);
    	g2.drawImage(backGround,768,576, null);
	}
	public int getEntranceX(){
		return entranceX;
	}
	
	
	public int getEntranceY(){
		return entranceY;
	}
	public int getcurrentRow(){
		return currentRow;
	}
	public int getCurrentColumn(){
		return currentColumn;
	}

	//JIngwen CODE
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		int key = arg0.getKeyCode();
		if(key == KeyEvent.VK_UP){
			if(status == IN_SHOP_MENU){
				if(itemx > 92){
					itemx-= 100;
					boxY-= 100;
				}
			}
			else
				playable.moveUp();
				
		}
		if(key == KeyEvent.VK_DOWN){
			if(status == IN_SHOP_MENU){
			if(itemx < 392){
				itemx+= 100;
				boxY+= 100;
				}
			}
			else
				playable.moveDown();
		}
		if(key == KeyEvent.VK_LEFT){
			playable.moveLeft();
		}
		if(key == KeyEvent.VK_RIGHT){
			playable.moveRight();
		}
		if(key == KeyEvent.VK_SPACE){
			
			if(status == WEAPON_STORE){
				if(Math.abs(450 - playable.getX()) <= 100 && Math.abs(180 - playable.getY()) <= 100){
					status = IN_SHOP_MENU;
				}
			}
			if(status == AMMO_STORE){
				
				if(Math.abs(420 - playable.getX()) <= 100 && Math.abs(150 - playable.getY()) <= 100){
					status = IN_SHOP_MENU;
					
				}
				System.out.print(status);
			}
			if(status == ARMOR_STORE){
				if(Math.abs(390 - playable.getX()) <= 100 && Math.abs(game.getHeight() - 250 - playable.getY()) <= 100){
					status = IN_SHOP_MENU;
				}
			}
			if(status == TOWN){

				if(Math.abs(20 - playable.getX()) <= 100 && Math.abs(game.getHeight()/3 - playable.getY()) <= 100){

				status = R_SHOP;

				}

			}
			
		}
		if(key == KeyEvent.VK_ESCAPE){
			if(status == IN_SHOP_MENU){
				status = status2;
			}
			if(status == R_SHOP){

				status = TOWN;

			 }
		}
		if(key == KeyEvent.VK_B){
			if(status == IN_SHOP_MENU){
				if(status2 == WEAPON_STORE)
				store.moneyInteraction(itemx);
				if(status2 == ARMOR_STORE)
				storeA.moneyInteraction(itemx);
				if(status2 == AMMO_STORE)
				storeC.moneyInteraction(itemx);
			}
				if(status == R_SHOP){

					if(store.getMoney() > 1000){

						double x = Math.random()*1001;
		
						System.out.println(x);

						if(x == 1){
		
							lottry = 1000000;
			
							directPayment(lottry, 1000);
			
							System.out.println(lottry);
		
						}

						if(x > 2 && x< 5){
		
							lottry = 50000;
			
							directPayment(lottry, 1000);
			
							System.out.println(lottry);
		
						}

						if(x > 5 && x< 100){
		
							lottry = 1000;
			
							directPayment(lottry, 1000);
			
							System.out.println(lottry);
		
						}

						if(x > 100 && x< 500){
		
							lottry = 500;
			
							directPayment(lottry, 1000);
			
							System.out.println(lottry);
		
						}
		
						if(x > 500){
		
							lottry = 100;
			
							directPayment(lottry, 1000);
			
							System.out.println(lottry);
		
						}

					}

				}

		}
		if(key == KeyEvent.VK_S){
			if(status == IN_SHOP_MENU){
				if(status2 == WEAPON_STORE)
					store.moneySellingInteraction(itemx);
					if(status2 == ARMOR_STORE)
					storeA.moneySellingInteraction(itemx);
					if(status2 == AMMO_STORE)
					storeC.moneySellingInteraction(itemx);
			}
		}
		if(key == KeyEvent.VK_T){
			if(status == TOWN){
				if(Math.abs(150 - playable.getX()) <= 100 && Math.abs(game.getHeight() -10 - 100 - playable.getY()) <= 100){
					status = WEAPON_STOREx;
					
				}
				if(Math.abs(450 - playable.getX()) <= 100 && Math.abs(50 - playable.getY()) <= 100){
					status = ARMOR_STOREx;
					
					
				}
				if(Math.abs(750 - playable.getX()) <= 100 && Math.abs(game.getHeight() -110 - playable.getY()) <= 100){
					status = AMMO_STOREx;
					//status2 = AMMO_STORE;
					System.out.print("cxzcxzczxcxz");
				}
			}
			else if(status == WEAPON_STORE){
				if(Math.abs(150 - playable.getX()) <= 100 && Math.abs(game.getHeight() -10 - 100 - playable.getY()) <= 100){
					status = TOWNx;
				}
			}
			else if(status == ARMOR_STORE){
				if(Math.abs(450 - playable.getX()) <= 100 && Math.abs(50 - playable.getY()) <= 100){
					status = TOWNx;
				}
			}
			else if(status == AMMO_STORE){
				System.out.print(status);
				if(Math.abs(750 - playable.getX()) <= 100 && Math.abs(game.getHeight() -110 - playable.getY()) <= 100){
					status = TOWNx;
					System.out.print(status);
				}
				System.out.print(status);
			}
		}
			update();
	}
	public void directPayment(int amount, int cost){

		store.setMoney(store.getMoney()+amount - cost);

		storeA.setMoney(store.getMoney()+amount - cost);

		storeC.setMoney(store.getMoney()+amount - cost);

	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}

