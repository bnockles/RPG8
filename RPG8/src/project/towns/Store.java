package project.towns;

import java.util.ArrayList;

import project.directors.Game;
import project.directors.Screen;
import project.items.Item;

public abstract class Store{

	public Store(Game game, ArrayList<String> items) {
		
	}

	Screen inventory;
	
	int id;
	
}
