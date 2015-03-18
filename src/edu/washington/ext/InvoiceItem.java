package edu.washington.ext;

public final class InvoiceItem {
	private final Item item; // the item
	private final int quantity; // the quanity of the item being purchased
	private final int discount; // the discount (percentage) given on this particular item
	InvoiceItem(Item item, int quantity, int discount){
		this.item = item;
		this.quantity = quantity;
		this.discount = discount;
	}
	public Item getItem() {
		return item;
	}
	public int getQuantity() {
		return quantity;
	}
	public int getDiscount() {
		return discount;
	}
	public int getTotalValueOfItem(){
		return this.getQuantity() * this.item.getPrice();
	}
	public int getTotalDiscount(){
		return this.getQuantity() * this.item.getPrice() * (this.getDiscount()/100);
	}
	public int getNetValueOfItem(){
		return this.getTotalValueOfItem() - this.getTotalDiscount();
	}
}