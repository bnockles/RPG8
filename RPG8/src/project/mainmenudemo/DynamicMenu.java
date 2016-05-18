package project.mainmenudemo;

import java.awt.Color;
import java.util.ArrayList;

import project.directors.Game;
import project.directors.Screen;
import project.items.Item;
import project.items.ItemResources;
import project.items.Misc;


/**
 * 
 * @author Kevin Ramos
 *
 */


public class DynamicMenu{
	
	public static final int MAIN_MENU =0;
	public static final int HELP_MENU =1;
	public static final int PAUSE_MENU=2;
	public static final int GAME_OVER_MENU=3;
	public static final int CREDITS_MENU=4;
	public static final int ITEM_DESCRIPTION_MENU = 5;
	public static final ArrayList<Item> arr = getItem();
	
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

	
	public static MainMenuScreen createMenu(int menuType, Game game, int selected){
		String[] names=null;
		String[] pictures=null;
		Color[] col=null;
		String backgroundmusic="";
		int type=menuType;

			names= new String[]{arr.get(selected).getDescription(), arr.get(selected).getName()};
			pictures=new String[]{"resources"+arr.get(selected).getItemImage()};
			col=new Color[]{Color.white, Color.black, Color.darkGray};
		
		return new MainMenuScreen(type,game, names, pictures ,col, backgroundmusic);
	}

	public static ArrayList<Item> getItem() {
		// TODO Auto-generated method stub
		ArrayList<Item> arr= new ArrayList<Item>();
		for(int i=0; i<ItemResources.AllWeapons.length;i++){
			for(int j=0; j<ItemResources.AllWeapons[i].length; j++){
				arr.add(ItemResources.AllWeapons[i][j]);
			}
		}
		
		return arr;
	}

}