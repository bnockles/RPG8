package project.menus;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import project.directors.Game;
import project.menus.selections.GameSelection;
import project.save.SaveFile;
import project.save.SaveUtility;

public class GameMenu extends VerticalMenu{


	public static final int SELECTION_HEIGHT = 200;
	List<GameSelection> saveFiles;
	Game game;
	
	
	public GameMenu(int width, int height, Game game) {
		super(width, height);
		this.game=game;
		try{
			loadGameFromFile(SaveFile.SAVE_FILE_DIRECTORY+"save2.txt");
		}catch(Exception e){
			e.printStackTrace();
			loadGameFromFile("/saveFiles/save1.txt");
			
		}
		selections.get(selectIndex).setSelect(true);
	}

	private void loadGameFromFile(String string) {
		//must use importStreamReader to export to JAR
		String line = null;
		System.out.println(string);
		BufferedReader txtReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(string)));
		boolean newFile = false;
		long creationDate = 0L;
		try {
			while((line = txtReader.readLine()) != null) {
				if(line.startsWith("<newFile>")){
			    	newFile=SaveUtility.getBooleanFromTag(line, SaveFile.NEW_TAG);
			    }
				if(line.startsWith("<creationTime>")){
			    	creationDate=Long.parseLong(SaveUtility.getTextFromTags(line, SaveFile.CREATION_TAG));
			    }
				if(newFile)break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}   
		selections.add(new GameSelection(width, 200, game, newFile, creationDate,string));
	}

	@Override
	public void addSelections() {
		//this method is required by the interface, but selections are added as each saveFile is read
	}



}
