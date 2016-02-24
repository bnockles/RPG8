package project.towns;

import java.util.ArrayList;

import project.directors.Game;

public class WeaponStore extends Store implements StoreInterface{

	
	int money;
	static ArrayList<String> items = new ArrayList<String>();
	static ArrayList<Integer> price = new ArrayList<Integer>();
	
	
	public WeaponStore(Game game, ArrayList<String> item, int money) {
		super(game, item);
		// TODO Auto-generated constructor stub
		this.money = money;
		for(int i = 0; i < item.size(); i++){
			items.add(i, item.get(i));
		}
	}


	@Override
	public void moneyInteraction(int money) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemInteraction(int amount) {
		// TODO Auto-generated method stub
		
	}

	
}
