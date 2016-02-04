package project.menus;

import java.util.ArrayList;

public class MainMenu extends VerticalMenu{
	
	 ArrayList<Selectable> selections = new ArrayList<Selectable>();

	public MainMenu(int width, int height) {
		super(width, height);
		//this.selections.add(null);
		//Will add 4 parts of the selection
	}

	@Override
	public void addSelections() {
		//The 4 Selections: Start New Game, Load Game, Settings, and Help will be added here
	}
}
