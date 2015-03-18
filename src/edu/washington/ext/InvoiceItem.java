package edu.washington.ext;

/**
 * The Class InvoiceItem.
 */
public final class InvoiceItem {
	
	/** The item. */
	private final Item item; // the item
	
	/** The quantity. */
	private final int quantity; // the quantity of the item being purchased
	
	/** The discount. */
	private final int discount; // the discount (percentage) given on this particular item
	
	/**
	 * Instantiates a new invoice item.
	 *
	 * @param item the item
	 * @param quantity the quantity
	 * @param discount the discount
	 */
	InvoiceItem(Item item, int quantity, int discount){
		this.item = item;
		this.quantity = quantity;
		this.discount = discount;
	}
	
	/**
	 * Gets the item.
	 *
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}
	
	/**
	 * Gets the quantity.
	 *
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * Gets the discount.
	 *
	 * @return the discount
	 */
	public int getDiscount() {
		return discount;
	}
	
	/**
	 * Gets the total value of item.
	 *
	 * @return the total value of item
	 */
	public int getTotalValueOfItem(){
		return this.getQuantity() * this.item.getPrice();
	}
	
	/**
	 * Gets the total discount.
	 *
	 * @return the total discount
	 */
	public int getTotalDiscount(){
		return this.getQuantity() * this.item.getPrice() * (this.getDiscount()/100);
	}
	
	/**
	 * Gets the net value of item.
	 *
	 * @return the net value of item
	 */
	public int getNetValueOfItem(){
		return this.getTotalValueOfItem() - this.getTotalDiscount();
	}
}