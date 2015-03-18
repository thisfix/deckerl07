package edu.washington.ext;

/**
 * The Class Item.
 */
public final class Item {
	
	/** The description. */
	private final String description; // a description of the item
	
	/** The price. */
	private final int price; // the item's prices (in cents)
	
	/** The sku. */
	private final int sku; //Stock keeping unit - a numeric identifier for the item.
	
	/**
	 * Instantiates a new item.
	 *
	 * @param description the description
	 * @param price the price
	 * @param sku the sku
	 */
	Item(String description, int price, int sku){
		this.description = description;
		this.price = price;
		this.sku = sku;
	}
	
	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	
	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Gets the sku.
	 *
	 * @return the sku
	 */
	public int getSku() {
		return sku;
	}

}
