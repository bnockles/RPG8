package project.save;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveFile {
	
	private ItemState itemState;//saves collected and uncollected items
	private int overWorldX;//saves location of sprite in overworld
	private int overWorldY;
	private long creationTime;
	
	public static final String NEW_TAG = "newFile";
	public static final String CREATION_TAG = "creationTime";
	public static final String X_TAG = "overWorldX";
	public static final String Y_TAG = "overWorldY";
	public static final String POTION_TAG = "potionCollected";
	
	public SaveFile(ItemState itemState, int overworldX, int overWorldY, long creationTime) {
		this.itemState=itemState;
		this.overWorldX=overworldX;
		this.overWorldY=overWorldY;
		this.creationTime = creationTime;
	}

	public SaveFile(String rawSaveText) {
		if(SaveUtility.getBooleanFromTag(rawSaveText, SaveFile.NEW_TAG))creationTime=System.currentTimeMillis();
		else creationTime=SaveUtility.getLongFromTag(rawSaveText, CREATION_TAG);
		itemState = new ItemState(SaveUtility.getBooleanFromTag(rawSaveText, POTION_TAG));
		overWorldX=SaveUtility.getIntFromTag(rawSaveText, X_TAG);
		overWorldY=SaveUtility.getIntFromTag(rawSaveText, Y_TAG);
	}

	public ItemState getItemState() {
		return itemState;
	}

	public void setItemState(ItemState itemState) {
		this.itemState = itemState;
	}

	public int getOverWorldX() {
		return overWorldX;
	}

	public void setOverWorldX(int overWorldX) {
		this.overWorldX = overWorldX;
	}

	public int getOverWorldY() {
		return overWorldY;
	}

	public void setOverWorldY(int overWorldY) {
		this.overWorldY = overWorldY;
	}

	public void save() {
		String fileName = System.getProperty("user.home")+File.separator+"saveFiles"+File.separator+"save2.txt";

/**
        <newFile>true</newFile>
        <creationTime>0</creationTime>
        <overWorldX>400</overWorldX>
        <overWorldY>400</overWorldY>
        <potionCollected>false</potionCollected>
        */
        
        try {
            // Assume default encoding.
            FileWriter fileWriter = new FileWriter(fileName);
            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =                new BufferedWriter(fileWriter);

            // Note that write() does not automatically
            // append a newline character.
            bufferedWriter.write(dataWithTag(NEW_TAG,""+false));
            bufferedWriter.write(dataWithTag(CREATION_TAG,""+creationTime));
            bufferedWriter.write(dataWithTag(X_TAG,""+overWorldX));
            bufferedWriter.write(dataWithTag(Y_TAG,""+overWorldY));


            // Always close files.
            bufferedWriter.close();
        }
        catch(IOException ex) {

            ex.printStackTrace();
        }
	}

	private String dataWithTag(String tag, String string) {
		return "<"+tag+">"+string+"</"+tag+">";
	}
	
	

}
