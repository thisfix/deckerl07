package edu.washington.ext;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class InvoiceTest {

	Item item1 = new Item("USB 3.0 to USB-C cable", 4500, 11451);
	Item item2 = new Item("USB 3.0 to Firewire", 3500, 11452);
	Item item3 = new Item("USB 3.0 to Thunderbolt", 4000, 11453);
	InvoiceItem invoiceItem1 = new InvoiceItem(item1, 7, 10);
	InvoiceItem invoiceItem2 = new InvoiceItem(item2, 1, 0);
	InvoiceItem invoiceItem3 = new InvoiceItem(item3, 1, 0);
	List<InvoiceItem> invoiceItems = new ArrayList<InvoiceItem>();
	
	@Before
	public void setUp() throws Exception {
		invoiceItems.add(invoiceItem1);
		invoiceItems.add(invoiceItem2);
		invoiceItems.add(invoiceItem3);
	}

	@Test
	public void testInvoice() {
		try {
			Invoice myInvoice = new Invoice();			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testAddInvoiceItems() {
		Invoice myInvoice = new Invoice();
		try {
			myInvoice.addInvoiceItems(invoiceItems);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testRemoveInvoiceItems() {
		Invoice myInvoice = new Invoice();
		myInvoice.addInvoiceItems(invoiceItems);
		try {
			myInvoice.removeInvoiceItems(invoiceItems);
		} catch (Exception e) {
			fail (e.getMessage());
		}
	}
	
	@Test
	public void testInvalidNullAddInvoiceItems() {
		Invoice myInvoice = new Invoice();
		try {
			myInvoice.addInvoiceItems(null);
		} catch (IllegalArgumentException e) {
			// success [we expect an IllegalArgumentException]
			return;
		}
		fail ("testInvalidNullAddInvoiceItems() should have thrown an IllegalArgumentException");
	}

	@Test
	public void testInvalidNullRemoveInvoiceItems() {
		Invoice myInvoice = new Invoice();
		myInvoice.addInvoiceItems(invoiceItems);
		try {
			myInvoice.removeInvoiceItems(null);
		} catch (IllegalArgumentException e) {
			// success [we expect an IllegalArgumentException]
			return;
		}
		fail ("testInvalidNullRemoveInvoiceItems() should have thrown an IllegalArgumentException");
		
	}

	@Test
	public void testSetInvoiceDiscount() {
		Invoice myInvoice = new Invoice();
		try {
			myInvoice.setInvoiceDiscount(10);
		} catch (Exception e) {
			fail (e.getMessage());
		}	
	}
	
	@Test
	public void testInvalidNegativeSetInvoiceDiscount() {
		Invoice myInvoice = new Invoice();
		try {
			myInvoice.setInvoiceDiscount(-10);
		} catch (IllegalArgumentException e) {
			// success [we expect an IllegalArgumentException]
			return;
		}
		fail ("testInvalidNegativeSetInvoiceDiscount() should have thrown an IllegalArgumentException");
	}

	@Test
	public void testGetInvoiceDiscount() {
		Invoice myInvoice = new Invoice();
		myInvoice.setInvoiceDiscount(10);
		try {
			myInvoice.getInvoiceDiscount();
		} catch (Exception e) {
			fail (e.getMessage());
		}
		assertEquals(myInvoice.getInvoiceDiscount(),10,0);		
	}

	@Test
	public void testItemDiscountProcessTheInvoice() throws DiscountException {
		Invoice myInvoice = new Invoice();
		InvoiceItem invoiceItem4 = new InvoiceItem(item1, 7, 0);
		InvoiceItem invoiceItem5 = new InvoiceItem(item2, 1, 0);
		InvoiceItem invoiceItem6 = new InvoiceItem(item3, 1, 0);
		List<InvoiceItem> invoiceItems2 = new ArrayList<InvoiceItem>();
		invoiceItems2.add(invoiceItem4);
		invoiceItems2.add(invoiceItem5);
		invoiceItems2.add(invoiceItem6);
		myInvoice.addInvoiceItems(invoiceItems2);
		myInvoice.setInvoiceDiscount(10);
		try {
			myInvoice.processTheInvoice();
		} catch (DiscountException e) {
			fail (e.getMessage());
		}
		
	}

	@Test
	public void testInvoiceDiscountProcessTheInvoice() throws DiscountException {
		Invoice myInvoice = new Invoice();
		myInvoice.addInvoiceItems(invoiceItems);
		myInvoice.setInvoiceDiscount(0);
		try {
			myInvoice.processTheInvoice();
		} catch (DiscountException e) {
			fail (e.getMessage());
		}
	}

	@Test
	public void testInvalidInvoiceDiscountProcessTheInvoice() throws DiscountException {
		Invoice myInvoice = new Invoice();
		myInvoice.addInvoiceItems(invoiceItems);
		myInvoice.setInvoiceDiscount(10);
		try {
			myInvoice.processTheInvoice();
		} catch (DiscountException e) {
			// success [we expect an DiscountException]
			return;
		}
		fail ("testInvalidInvoiceDiscountProcessTheInvoice() should have thrown an DiscountException");
	}
}
