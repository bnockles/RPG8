package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class MyWindow extends JFrame implements KeyListener{

	int width=500;
	int height=500;
	private Hero ph;
	private Hero vic;
	BufferedImage landscape;
	boolean itemPickedUp;
	public static void main(String[] args){
		new MyWindow();
	}
	public MyWindow(){
		//JFrame methods
		//
		ph = new Hero ("Pheonix", "/Images/yarg/objection.png",0,0);
		vic = new Hero ("Victim","/Images/yarg/deadwomen.png",20,300);
		itemPickedUp = false;
		landscape=new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D)landscape.getGraphics();
		paintLandscape(g2);
		setVisible(true);
		setSize(width,height);
		setLocation(200,150);//200 over, 150 down
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//static constant reference for special close operation
		addKeyListener(this);
	}
	public void paint(Graphics g){
		//Graphics is a crayon box
		//Graphics 2d is like an art kit
		BufferedImage image= new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D)image.getGraphics();
		g2.setColor(new Color(50,100,200));
		g2.fillRect(0, 0, width, height);
		g2.drawImage(landscape, 0, 0, null);
		//paintLandscape(g2);
		g2.drawImage(ph.getImage(), ph.getX(), ph.getY(), null);
		if(Math.abs(ph.getX()-vic.getX())+Math.abs(ph.getY()-vic.getY())<10)
				itemPickedUp=true;
		if(!itemPickedUp)
				g2.drawImage(vic.getImage(), vic.getX(), vic.getY(), null);
//		g2.fillRect(0, 0, width, height);
//		g2.setColor(Color.red);
//		g2.drawOval(50, 100, 200, 200);
//		g2.setColor(Color.blue);
//		g2.fillOval(50, 100, 200, 100);
//		g2.drawArc(50,300,200,100, 0, 180);
//		g2.drawLine(50, 350, 50, 450);
//		g2.drawLine(250, 350, 250, 450);
//		g2.drawLine(50, 450, 250, 450);
//		for(int x=0;x<width;x++){
//			for(int y=0;y<height;y+=50){
//				g2.drawLine(x, y, width-100, height-100);
//			}
//		}
//		int squareD = 2;
//		int margin = 1;
//		for(int x=0;x<width;x+=squareD+margin){
//			for(int y=0;y<height;y+=squareD+margin){
//					g2.setColor(new Color(x%5,x*y%255,y%51));
//					g2.fillRect(x, y, squareD, squareD);
//				}
//			}
			g.drawImage(image, 0, 0, null);
		}
	@Override
		public void keyPressed(KeyEvent arg0) {
			int key=arg0.getKeyCode();
			if(key==KeyEvent.VK_UP){
				ph.moveUp();
			}else if(key==KeyEvent.VK_DOWN){
				ph.moveDown();
			}else if(key==KeyEvent.VK_RIGHT){
				ph.moveRight();
			}else if(key==KeyEvent.VK_LEFT){
				ph.moveLeft();
			}
			repaint();
		}
		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		public void paintLandscape (Graphics2D g2){
			int squareD = 2;
			int margin = 1;
			for(int x=0;x<width;x+=squareD+margin){
				for(int y=0;y<height;y+=squareD+margin){
						g2.setColor(new Color(x%5,x*y%255,y%51));
						g2.fillRect(x, y, squareD, squareD);
					}
				}
			}
}
