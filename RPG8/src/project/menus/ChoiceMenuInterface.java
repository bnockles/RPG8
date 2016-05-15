package project.menus;

import java.util.ArrayList;

public interface ChoiceMenuInterface {
	
	//Set every text that you display into an ArrayList but add 
	//the name of the character with ":" so the message "I am a 
	//test." from "Max" would look like "Max: I am a test" in the ArrayList
	void supplyText(ArrayList<String> text);
	
	
}
