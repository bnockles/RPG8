package project.menus;//test comment 2


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import project.directors.Game;
import project.menus.selections.GameSelection;
import project.oldsave.SaveFile;
import project.save.SaveUtility;

public class GameMenu extends VerticalMenu{


	public static final int SELECTION_HEIGHT = 200;
	List<GameSelection> saveFiles;
	Game game;


	public GameMenu(int width, int height, Game game) {
		super(width, height);
		this.game=game;
		for(int i=1; i<4;i++){
			try{
				loadGameFromFile(SaveFile.SAVE_FILE_DIRECTORY+"save"+i+".txt");
			}catch(Exception e){
//				e.printStackTrace();
				loadNewGame(i);	
			}
		}
		selections.get(selectIndex).setSelect(true);
	}


	private void loadNewGame(int number){
		File createdFile = new File(SaveFile.SAVE_FILE_DIRECTORY);
		createdFile.mkdirs();
		SaveFile newSaveFile = new SaveFile(number);
		newSaveFile.save();
		System.out.print("Made a new file");
		selections.add(new GameSelection(width, 200, game, true, System.currentTimeMillis(),SaveFile.SAVE_FILE_DIRECTORY+"save"+number+".txt"));
	}

	private void loadGameFromFile(String string) throws NumberFormatException, IOException {
		//must use importStreamReader to export to JAR
		String line = null;
		boolean isNew=false;
		boolean foundIsNew=false;
		long creationDate = 0L;

			BufferedReader txtReader = new BufferedReader(new FileReader(string));
			//reads only identifying information about file
			while((line = txtReader.readLine()) != null) {
				isNew = SaveUtility.getBooleanFromTag(line, SaveFile.NEW_TAG);
				creationDate=Long.parseLong(SaveUtility.getTextFromTags(line, SaveFile.CREATION_TAG));
				if(creationDate!=0L && foundIsNew)break;
			}
			txtReader.close();
			selections.add(new GameSelection(width, 200, game, isNew, creationDate,string));
 
	}

	@Override
	public void addSelections() {
		//this method is required by the interface, but selections are added as each saveFile is read
	}

}
