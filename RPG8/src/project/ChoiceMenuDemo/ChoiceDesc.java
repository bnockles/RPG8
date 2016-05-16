package project.ChoiceMenuDemo;

import java.awt.image.BufferedImage;
import java.io.File;

import project.menus.Selectable;

/**
 * 
 * @author Maxwell Sulavko
 *
 */
public class ChoiceDesc implements Selectable{

	public String name;
	
	public String des; //description
	public File pic; //picture
	public String sel; //selected
	
	public ChoiceDesc(String name, File pic, String des, String sel){
		this.name = name;
		this.des = des; 
		this.pic = pic;	
		this.sel = "N"; //after selected will change
	}

	@Override
	public BufferedImage getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void confirm() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSelect(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
