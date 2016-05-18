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
	ArrayList<ShopItems> itemListW = new ArrayList<ShopItems>(){{add((ShopItems) ItemResources.rifles1GradeC1); add((ShopItems) ItemResources.rifles3GradeA2); add((ShopItems) ItemResources.rifles4GradeA3); add((ShopItems) ItemResources.pistol2GradeB1);}};
	
	
	public void setItemListW(ArrayList<ShopItems> itemListW) {
		this.itemListW = itemListW;
	}
	
	public ArrayList<ShopItems> getItemListW() {
		return itemListW;
	}

	public WeaponStore(ArrayList<Integer> itemN, int money) {
		// TODO Auto-generated constructor stub
		this.money = money;
		for(int i = 0; i  < itemListW.size(); i++){
			itemNuW.add(i, 0);
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
				itemNuW.set(0, itemNuW.get(0) + 1);
				money = money - itemListW.get(0).getPrice();
			}
		if(itemx == 192)
			if(money >= 350){
				itemNuW.set(1,itemNuW.get(1) + 1);
				money = money - itemListW.get(1).getPrice();
			}
		if(itemx == 292)
			if(money >= 250){
				itemNuW.set(2, itemNuW.get(2) + 1);
				money = money - itemListW.get(2).getPrice();
			}
		if(itemx == 392)
			if(money >= 250){
				itemNuW.set(3, itemNuW.get(3) + 1);
				money = money - itemListW.get(3).getPrice();
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
				money = money + 450;
			}
		}
		if(itemx == 192){
			if(itemNuW.get(1) > 0){
				itemNuW.set(1, itemNuW.get(1) - 1);
				money = money + 350;
			}
		}
		if(itemx == 292){
			if(itemNuW.get(2) > 0){
				itemNuW.set(2, itemNuW.get(2) - 1);
				money = money + 250;
			}
		}
		if(itemx == 392){
			System.out.print("test");
			if(itemNuW.get(3) > 0){
				itemNuW.set(3, itemNuW.get(3) - 1);
				money = money + 150;
				System.out.print("test");
			}
		}
	}

	public void AllSellingInteraction(int itemx) {
		// TODO Auto-generated method stub
		if(itemx == 92){
			if(itemNuW.get(0) > 0){
				money = money + 450;
			}
		}
		if(itemx == 192){
			if(itemNuW.get(1) > 0){
				money = money + 350;
			}
		}
		if(itemx == 292){
			if(itemNuW.get(2) > 0){
				money = money + 250;
			}
		}
		if(itemx == 392){
			if(itemNuW.get(2) > 0){
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
