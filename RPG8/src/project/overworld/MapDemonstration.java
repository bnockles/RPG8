package project.overworld;

import javax.swing.*;
import project.overworld.Obstacle;
import java.awt.Graphics;

public class MapDemonstration {
//almost there
	public static void main(String[] args) {
		 	JFrame window = new JFrame();
		    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    window.setBounds(30, 30, 900, 900);
		    window.setVisible(true);
		    Obstacle barrel = new Boundaries("B",10,10,0,0,"/image/Map/barrelblue.jpg", false);
		    System.out.println(barrel.getName());
		    
		    
		    
		    
	}
	

}
