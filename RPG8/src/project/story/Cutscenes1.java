package project.story;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
@SuppressWarnings("serial")
public abstract class Cutscenes1 {
	static int acceptableX;
	static int acceptableY;	
	public static void setLocation(int xval, int yval){
		storyDemo.Swarm.setX(xval);
		storyDemo.Swarm.setY(yval);
		
	}
	public static void possibles(){
		
		acceptableX = storyDemo.Swarm.getX();
		acceptableY = storyDemo.Swarm.getY();

		if(acceptableX >= 0 && acceptableX <= 100 && acceptableY >= 0 && acceptableY <= 100){ 
			//code to make cutscene here
			
			
			
			
			storyDemo.setCutscene(true);
			System.out.println("cutscene true");
			setLocation(56565630, 565630);
		}		
	}

	public void paint(Graphics g){
		//sets image to current windowWidth/height
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.black);
		g2.drawString("You have entered a new area.", 50, 50);
	}
}
