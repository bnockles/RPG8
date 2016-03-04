package project.ChoiceMenuDemo;

import java.awt.Color;

public class MenuTheme {
	
	private String bR;
	private String boxColor;
	private String selectColor;
	private String textColor;
	private String desc;
	private String subBr;
	
	public Color selectBlue = new Color (30, 60, 100); //Selection color
	
	public MenuTheme(String bR, String boxColor, String selectColor, String textColor, String subBr, String desc){
		this.bR = bR;
		this.boxColor = boxColor;
		this.selectColor = selectColor;
		this.subBr = subBr;
		this.textColor = textColor;
		this.desc = desc;
	}
	public static final int DEFAULT_THEME = 0; //default dark grey, black , blue
	public static final int GREEN_THEME = 1; //green green green
	public static final int WATER_THEME = 2; //navy blue, aqua, teal
	public static final int SUNNY_THEME = 3; //red, orange , yellow
	
	public void getTheme(int theme){
		if (theme == DEFAULT_THEME){
			bR = "GRAY";
			boxColor = "black";
			selectColor = "selectBlue";
			textColor = "white";
			subBr = "darkGray";
			desc = "Default Color Scheme";
		
		}
		
	}
}
