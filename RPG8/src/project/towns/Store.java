package project.towns;

import java.util.ArrayList;

import project.directors.Game;
import project.directors.Screen;
import project.items.Item;

public abstract class Store extends Inventory{

	public Store(Game game, ArrayList<Item> items) {
		super(game, items);
		// TODO Auto-generated constructor stub
	}

	Screen inventory;
	
	int id;
	
}
