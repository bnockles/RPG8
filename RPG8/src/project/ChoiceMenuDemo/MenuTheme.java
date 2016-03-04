package project.ChoiceMenuDemo;

import java.awt.Color;

public class MenuTheme {
	
	public static Color bR;
	public static Color boxColor;
	public static Color selectColor;
	public static Color textColor;
	public static String desc;
	public static Color subBr;
	
	//added custom colors
	public static Color selectBlue = new Color (30, 60, 100); //Selection color
	public static Color backgroundGreen = new Color (17, 180, 82);
	public static Color selectGreen = new Color (14, 142, 65);
	public static Color greenText = new Color (130, 161, 142);
	public static Color greenBR = new Color (62,116, 83);
	
	
	
	//public static final int DEFAULT_THEME = 0; //default dark grey, black , blue
	//public static final int GREEN_THEME = 1; //green green green
	//public static final int WATER_THEME = 2; //navy blue, aqua, teal
	//public static final int SUNNY_THEME = 3; //red, orange , yellow
	
	public static void setTheme(int theme){
		if (theme == 0){
			bR = Color.GRAY;
			boxColor = Color.black;
			selectColor = selectBlue;
			textColor = Color.white;
			subBr = Color.darkGray;
			desc = "Default Color Scheme";
		}
		if (theme == 1){
			bR = backgroundGreen;
			boxColor = selectGreen;
			selectColor = Color.GREEN;
			textColor = greenText;
			subBr = greenBR;
			desc = "A Green Theme";
		}
	}
}
