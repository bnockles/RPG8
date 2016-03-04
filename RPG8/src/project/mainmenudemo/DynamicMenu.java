package project.mainmenudemo;

import java.awt.Color;

import project.directors.Game;
import project.directors.Screen;

public class DynamicMenu {
	
	public static final int MAIN_MENU =0;
	public static final int HELP_MENU =1;
	public static final int PAUSE_MENU=2;
	public static final int GAME_OVER_MENU=3;
	public static final int CREDITS_MENU=4;
	
	public static MainMenuScreen createMenu(int menuType, Game game){
		String[] names=null;
		String[] pictures=null;
		Color[] col=null;
		String backgroundmusic="";
		int type=menuType;
		
		if(menuType == MAIN_MENU){
			names= new String[]{"Cyborg Exodus", "New Game","Load Game","Settings","Help"};
			pictures=new String[]{"resources/samusr.jpg", "resources/samusl.jpg"};
			col=new Color[]{Color.white, Color.black, Color.darkGray};
			backgroundmusic="resources/mainmenu.wav";
		}
		
		if(menuType == HELP_MENU){
			names= new String[]{"Help Menu", "Controls","Items","Weapons","Story"};
			pictures=new String[]{"", ""};
			col=new Color[]{Color.white, Color.black, Color.darkGray};
			backgroundmusic="resources/mainmenu.wav";
		}
		
		if(menuType == CREDITS_MENU){
			names= new String[]{"Credits", "Kevin","Maxwell", "Bane", "4U", "Cia Guy(Everytime)","Mark", "wlsn","Storyline Team", "Hbrday Ivann"};
			pictures=new String[]{"resources/samusr.jpg", "resources/samusl.jpg"};
			col=new Color[]{Color.white, Color.black, Color.darkGray};
			backgroundmusic="resources/mainmenu.wav";
		}
		return new MainMenuScreen(type,game, names, pictures ,col, backgroundmusic);
	}

}