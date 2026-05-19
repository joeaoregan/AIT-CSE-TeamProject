/*
 * Joe O'Regan
 * A00258304
 */
package com.ait.jsf;

public class Item {
	private int productID;
	private int quantity;

	public Item(int productID) {
		this.productID = productID;
		quantity = 0;
	}

	public Item(int productID, int quantity) {
		this.productID = productID;
		this.quantity = quantity;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setquantity(int quantity) {
		this.quantity = quantity;
	}

	public Boolean equals(Item item) {
		if (productID == item.getProductID()) {
			return true;
		}
		
		return false;
	}
}
