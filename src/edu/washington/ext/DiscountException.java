package edu.washington.ext;


/**
 * The Class DiscountException.
 */
public class DiscountException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2015;
	
	/** The invoice item. */
	private InvoiceItem invoiceItem = null;
	
	
	/**
	 * Instantiates a new discount exception.
	 *
	 * @param invoiceItem the invoice item
	 */
	DiscountException(InvoiceItem invoiceItem){
		this.invoiceItem = invoiceItem;
	}
	
	/**
	 * Gets the invoice item.
	 *
	 * @return the invoice item
	 */
	public InvoiceItem getInvoiceItem(){
		return this.invoiceItem;
	}

}
