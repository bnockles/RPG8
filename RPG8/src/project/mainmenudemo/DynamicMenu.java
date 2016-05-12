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
	
	public static int selected =4; 
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
		
		if(menuType == ITEM_DESCRIPTION_MENU){
			//
			names= new String[]{arr.get(selected).getDescription(), arr.get(selected).getName()};
			pictures=new String[]{arr.get(selected).getItemImage()};
			col=new Color[]{Color.white, Color.black, Color.darkGray};
		}
		
		
		return new MainMenuScreen(type,game, names, pictures ,col, backgroundmusic);
	}


	public static ArrayList<Item> getItem() {
		// TODO Auto-generated method stub
		ArrayList<Item> arr= new ArrayList<Item>();
		for(int i=0; i<ItemResources.Melee.length;i++)
			arr.add(ItemResources.Melee[i]);
		for(int i=0; i<ItemResources.Pistol.length;i++)
			arr.add(ItemResources.Pistol[i]);
		for(int i=0; i<ItemResources.Rifles.length;i++)
			arr.add(ItemResources.Rifles[i]);
		for(int i=0; i<ItemResources.Heavy.length;i++)
			arr.add(ItemResources.Heavy[i]);
		for(int i=0; i<ItemResources.SMG.length;i++)
			arr.add(ItemResources.SMG[i]);
		for(int i=0; i<ItemResources.Explosives.length;i++)
			arr.add(ItemResources.Explosives[i]);
		
		
		return arr;
	}

}