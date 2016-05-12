package project.towns;

import java.util.ArrayList;

import project.directors.Game;

/**
 * 
 * @author Jingwen Li 2-24
 *
 */
public class WeaponStore implements StoreInterface{

	
	int money;
	ArrayList<Integer> itemNu = new ArrayList<Integer>();
	ArrayList<String> itemList = new ArrayList<String>();
	
	public ArrayList<String> getItemList() {
		return itemList;
	}


	public void setItemList(ArrayList<String> itemList) {
		this.itemList = itemList;
	}


	public WeaponStore(ArrayList<Integer> itemN, int money, ArrayList<String> itemLists) {
		// TODO Auto-generated constructor stub
		this.money = money;
		for(int i = 0; i  < itemLists.size(); i++){
			itemNu.add(i, 0);
		}
		for(int i = 0; i  < itemLists.size(); i++){
			itemList.add(itemLists.get(i));
		}
		//for(int i = 0; i < 3; i++){
		//	itemN.add(i, itemNu.get(i));
		//}
	}


	@Override
	public void moneyInteraction(int itemx) {
		// TODO Auto-generated method stub
		if(itemx == 92)
		if(money >= 450){
				itemNu.set(0, itemNu.get(0) + 1);
				money = money - 450;
			}
		if(itemx == 192)
			if(money >= 350){
				itemNu.set(1,itemNu.get(1) + 1);
				money -= 350;
			}
		if(itemx == 292)
			if(money >= 250){
				itemNu.set(2, itemNu.get(2) + 1);
				money -= 250;
			}
		if(itemx == 392)
			if(money >= 250){
				itemNu.set(3, itemNu.get(3) + 1);
				money -= 150;
			}
		}
	
	public int getMoney() {
		return money;
	}


	public void setMoney(int money) {
		this.money = money;
	}



	@Override
	public void moneySellingInteraction(int itemx) {
		// TODO Auto-generated method stub
		if(itemx == 92){
			if(itemNu.get(0) > 0){
				itemNu.set(0, itemNu.get(0) - 1);
				money = money + 450;
			}
		}
		if(itemx == 192){
			if(itemNu.get(1) > 0){
				itemNu.set(1, itemNu.get(1) - 1);
				money = money + 350;
			}
		}
		if(itemx == 292){
			if(itemNu.get(2) > 0){
				itemNu.set(2, itemNu.get(2) - 1);
				money = money + 250;
			}
		}
		if(itemx == 392){
			if(itemNu.get(2) > 0){
				itemNu.set(3, itemNu.get(3) - 1);
				money = money + 150;
			}
		}
	}


	public void AllSellingInteraction(int itemx) {
		// TODO Auto-generated method stub
		if(itemx == 92){
			if(itemNu.get(0) > 0){
				money = money + 450;
			}
		}
		if(itemx == 192){
			if(itemNu.get(1) > 0){
				money = money + 350;
			}
		}
		if(itemx == 292){
			if(itemNu.get(2) > 0){
				money = money + 250;
			}
		}
		if(itemx == 392){
			if(itemNu.get(2) > 0){
				money = money + 150;
			}
		}
	}
	public void AllInteraction(int itemx) {
		// TODO Auto-generated method stub
		if(itemx == 92)
		if(money >= 450){
				money = money - 450;
			}
		if(itemx == 192)
			if(money >= 350){
				money -= 350;
			}
		if(itemx == 292)
			if(money >= 250){
				money -= 250;
			}
		if(itemx == 392)
			if(money >= 250){
				money -= 150;
			}
		}

	@Override
	public void itemInteraction() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void itemSellingInteraction() {
		// TODO Auto-generated method stub
		
	}

	
}
