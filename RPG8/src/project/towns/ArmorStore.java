package project.towns;

import java.awt.Component;
import java.util.ArrayList;

import project.items.ItemResources;

public class ArmorStore implements StoreInterface{

	double money;
	ArrayList<ShopItems> itemListA = new ArrayList<ShopItems>(){{add(ItemResources.yourarmor);};};
	ArrayList<Integer> itemNA = new ArrayList<Integer>();
	ArrayList<String> itemListADes = new ArrayList<String>();
	public ArmorStore(ArrayList<Integer> itemN, double d) {
		this.money = d;
		for(int i = 0; i  < itemListA.size(); i++){
			itemNA.add(i, 0);
			itemListADes.add(i, itemListA.get(i).getDescription());
		}
		// TODO Auto-generated constructor stub
	}

	@Override
	public void moneyInteraction(int itemx) {
		// TODO Auto-generated method stub
		int x = 92;
		for(int i = 0; i < 1; i++){
			if(itemx == x){
				itemNA.set(i, itemNA.get(i) + 1);
				TownScreen.playable.setMoney(TownScreen.playable.getMoney() - itemListA.get(i).getPrice());
			}
			x+=100;
		}
	}

	@Override
	public void moneySellingInteraction(int itemx) {
		// TODO Auto-generated method stub
		int x = 92;
		for(int i = 0; i < 1; i++){
			if(itemx == x){
				itemNA.set(i, itemNA.get(i) - 1);
				TownScreen.playable.setMoney(TownScreen.playable.getMoney() + itemListA.get(i).getPrice());
			}
			x+=100;
		}
	}
	 
	public void setMoney(double d) {
		this.money = d;
	}

	public double getMoney() {
		// TODO Auto-generated method stub
		return money;
	}

	public ArrayList<ShopItems> getItemListA() {
		return itemListA;
	}

	public ArrayList<Integer> getItemNA() {
		return itemNA;
	}



}
