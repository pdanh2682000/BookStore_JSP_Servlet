package com.danhuy.cart;

import java.util.Enumeration;
import java.util.Hashtable;

public class ShoppingCart {
	
	protected Hashtable<String, String[]> items = new Hashtable<String, String[]>();
	
	public void addItem(String item_id, String name, float price, int quantity) {
		String item[] = {item_id, name, Float.toString(price), Integer.toString(quantity)};
		if(items.containsKey(item_id)) {
			String tmpItem[] = (String[])items.get(item_id);
			int tmpQuant = Integer.parseInt(tmpItem[3]);
			quantity += tmpQuant;
			tmpItem[3] = Integer.toString(quantity);
		}else {
			items.put(item_id, item);
		}
	}
	
	public void removeItem(String item_id) {
		if(items.containsKey(item_id)) items.remove(item_id);
	}
	
	public void updateQuantity(String item_id, int quantity) {
		if(items.containsKey(item_id)) {
			String tmpItem[] = items.get(item_id);
			tmpItem[3] = Integer.toString(quantity);
		}
	}
	
	public Enumeration<String[]> getEnumeration() {
		return items.elements();
	}
	
	public float getCost() {
		Enumeration<String[]> e = items.elements();
		String tmpItem[];
		float totalCost = 0.00f;
		while(e.hasMoreElements()) {
			tmpItem = e.nextElement();
			totalCost += Float.parseFloat(tmpItem[2]) * Integer.parseInt(tmpItem[3]);
		}
		return totalCost;
	}
	
	public int getNumOfItems() {
		Enumeration<String[]> e = items.elements();
		String tmpItem[];
		int numOfItems = 0;
		while(e.hasMoreElements()) {
			tmpItem = e.nextElement();
			numOfItems += Integer.parseInt(tmpItem[3]);
		}
		return numOfItems;
	}
	
	public void clearItems() {
		items.clear();
	}
	
	public boolean isEmpty() {
		return items.isEmpty();
	}

}
