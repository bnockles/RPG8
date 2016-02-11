package project.overworld;

import javax.swing.*;
import project.overworld.Obstacle;
import java.awt.Toolkit;
import java.awt.Image;
import java.awt.Graphics;

public class MapDemonstration {

	public static void main(String[] args) {
		 	JFrame window = new JFrame();
		    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    window.setBounds(30, 30, 900, 900);
		    window.setVisible(true);
		    Image i = Toolkit.getDefaultToolkit().getImage("barrelblue.jpg");
		    Obstacle barrel = new Obstacle("B",10,10,0,0,i);
		    
		    
		    
		    
	}
	

}
