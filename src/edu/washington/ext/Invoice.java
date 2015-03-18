package edu.washington.ext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Invoice {
	List<InvoiceItem> invoiceItems = new ArrayList<InvoiceItem>();
	int invoiceDiscount = 0;
	Invoice(){
		
	}
	public void addInvoiceItems(Collection<? extends InvoiceItem> c) throws IllegalArgumentException{
		if (c == null){
			throw new IllegalArgumentException("Arguement must not be null");
		}
		invoiceItems.addAll(c);
	}
	public void removeInvoiceItems(Collection<? extends InvoiceItem> c) throws IllegalArgumentException{
		if (c == null){
			throw new IllegalArgumentException("Arguement must not be null");
		}
		invoiceItems.removeAll(c);
	}
	public void setInvoiceDiscount(int discount) throws IllegalArgumentException{
		if (discount < 0){
			throw new IllegalArgumentException("Arguement must not be a negative number");
		} else {
			this.invoiceDiscount = discount;
		}
	}
	public int getInvoiceDiscount(){
		return this.invoiceDiscount;
	}
	public void processTheInvoice() throws DiscountException{
		for (int i=0; i<invoiceItems.size(); i++){
			if (invoiceDiscount>0 && invoiceItems.get(i).getDiscount()>0){
				throw new DiscountException();
			} else {
				System.out.println(invoiceItems.get(i));
			}
		}
	}
}
