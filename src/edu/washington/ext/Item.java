package edu.washington.ext;

public final class Item {
	private final String description; // a discription of the item
	private final int price; // the item's prices (in cents)
	private final int sku; //Stock keeping unit - a numeric identifier for the item.
	Item(String description, int price, int sku){
		this.description = description;
		this.price = price;
		this.sku = sku;
	}
	public int getPrice() {
		return price;
	}
	public String getDescription() {
		return description;
	}
	public int getSku() {
		return sku;
	}

}
