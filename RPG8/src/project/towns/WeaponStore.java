package project.towns;

import java.awt.Graphics2D;
import java.util.ArrayList;

import project.directors.Game;
import project.items.ItemResources;

/**
 * 
 * @author Jingwen Li 2-24
 *
 */
public class WeaponStore implements StoreInterface{

	double money;
	ArrayList<Integer> itemNuW = new ArrayList<Integer>();
	ArrayList<ShopItems> itemListW = new ArrayList<ShopItems>();
	ArrayList<String> itemListWDes = new ArrayList<String>();
	ArrayList<String> itemListWPics = new ArrayList<String>();
	int count = ItemResources.Melee.length + ItemResources.Rifles.length + ItemResources.Pistol.length + ItemResources.Heavy.length + ItemResources.SMG.length;
	
	public void setItemListW(ArrayList<ShopItems> itemListW) {
		this.itemListW = itemListW;
	}
	
	public ArrayList<ShopItems> getItemListW() {
		return itemListW;
	}

	public WeaponStore(ArrayList<Integer> itemN, double d) {
		// TODO Auto-generated constructor stub
		this.money = d;
		for(int i = 0; i  < itemListW.size(); i++){
			itemNuW.add(i, 0);
			itemListWDes.add(i, itemListW.get(i).getDescription());
			//itemListWPics.add(i, itemListW.get(i));
		}
		//for(int i = 0; i < 3; i++){
		//	itemN.add(i, itemNu.get(i));
		//}
	}

	@Override
	public void moneyInteraction(int itemx) {
		// TODO Auto-generated method stub
		//to be simplified
		if(itemx == 92)
		if(money >= 450){
				itemNuW.set(0, itemNuW.get(0) + 1);
				TownScreen.playable.setMoney(TownScreen.playable.getMoney() - itemListW.get(0).getPrice());
			}
		if(itemx == 192)
			if(money >= 350){
				itemNuW.set(1,itemNuW.get(1) + 1);
				TownScreen.playable.setMoney(TownScreen.playable.getMoney() - itemListW.get(1).getPrice());
			}
		if(itemx == 292)
			if(money >= 250){
				itemNuW.set(2, itemNuW.get(2) + 1);
				TownScreen.playable.setMoney(TownScreen.playable.getMoney() - itemListW.get(2).getPrice());
			}
		if(itemx == 392)
			if(money >= 250){
				itemNuW.set(3, itemNuW.get(3) + 1);
				TownScreen.playable.setMoney(TownScreen.playable.getMoney() - itemListW.get(3).getPrice());
			}
		}
	
	
	public double getMoney() {
		return money;
	}

	public void setMoney(double d) {
		this.money = d;
	}

	@Override
	public void moneySellingInteraction(int itemx) {
		// TODO Auto-generated method stub
		if(itemx == 92){
			if(itemNuW.get(0) > 0){
				itemNuW.set(0, itemNuW.get(0) - 1);
				TownScreen.playable.setMoney(TownScreen.playable.getMoney() + itemListW.get(0).getPrice());
			}
		}
		if(itemx == 192){
			if(itemNuW.get(1) > 0){
				itemNuW.set(1, itemNuW.get(1) - 1);
				TownScreen.playable.setMoney(TownScreen.playable.getMoney() + itemListW.get(1).getPrice());
			}
		}
		if(itemx == 292){
			if(itemNuW.get(2) > 0){
				itemNuW.set(2, itemNuW.get(2) - 1);
				TownScreen.playable.setMoney(TownScreen.playable.getMoney() + itemListW.get(2).getPrice());
			}
		}
		if(itemx == 392){
			if(itemNuW.get(3) > 0){
				itemNuW.set(3, itemNuW.get(3) - 1);
				TownScreen.playable.setMoney(TownScreen.playable.getMoney() - itemListW.get(3).getPrice());
			}
		}
	}



	
}
