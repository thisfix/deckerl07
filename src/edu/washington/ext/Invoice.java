package edu.washington.ext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * The Class Invoice.
 */
public class Invoice {
	
	/** The invoice items. */
	List<InvoiceItem> invoiceItems = new ArrayList<InvoiceItem>();
	
	/** The invoice discount. */
	int invoiceDiscount = 0;
	
	/**
	 * Instantiates a new invoice.
	 */
	Invoice(){
		
	}
	
	/**
	 * Adds the invoice items.
	 *
	 * @param c the c
	 * @throws IllegalArgumentException the illegal argument exception
	 */
	public void addInvoiceItems(Collection<? extends InvoiceItem> c) throws IllegalArgumentException{
		if (c == null){
			throw new IllegalArgumentException("Arguement must not be null");
		}
		invoiceItems.addAll(c);
	}
	
	/**
	 * Removes the invoice items.
	 *
	 * @param c the c
	 * @throws IllegalArgumentException the illegal argument exception
	 */
	public void removeInvoiceItems(Collection<? extends InvoiceItem> c) throws IllegalArgumentException{
		if (c == null){
			throw new IllegalArgumentException("Arguement must not be null");
		}
		invoiceItems.removeAll(c);
	}
	
	/**
	 * Sets the invoice discount.
	 *
	 * @param discount the new invoice discount
	 * @throws IllegalArgumentException the illegal argument exception
	 */
	public void setInvoiceDiscount(int discount) throws IllegalArgumentException{
		if (discount < 0){
			throw new IllegalArgumentException("Arguement must not be a negative number");
		} else {
			this.invoiceDiscount = discount;
		}
	}
	
	/**
	 * Gets the invoice discount.
	 *
	 * @return the invoice discount
	 */
	public int getInvoiceDiscount(){
		return this.invoiceDiscount;
	}
	
	/**
	 * Process the invoice.
	 *
	 * @throws DiscountException the discount exception
	 */
	public void processTheInvoice() throws DiscountException{
		for (int i=0; i<invoiceItems.size(); i++){
			if (invoiceDiscount>0 && invoiceItems.get(i).getDiscount()>0){
				throw new DiscountException(invoiceItems.get(i));
			} else {
				System.out.println("Invoice Item ["+invoiceItems.get(i)+"] valid");
				System.out.println("Item description : "+invoiceItems.get(i).getItemDescription());
				System.out.println("Item quantity : "+invoiceItems.get(i).getQuantity());
				System.out.println("Item discount : "+invoiceItems.get(i).getDiscount());
			}
		}
	}
}
