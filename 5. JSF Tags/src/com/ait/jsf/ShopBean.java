/*
 * Joe O'Regan
 * A00258304
 */
package com.ait.jsf;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "shopBean")
@SessionScoped
// @RequestScoped
public class ShopBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int productID;
	private int quantity;

	public ShopBean() {
		this.productID = 0;
		this.quantity = 0;
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

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	// OK - Handle "Add to Cart" button click event
	public String addHandler() {
		CartBean cart = Helper.getBean("cartBean", CartBean.class);
		cart.addItemToCart(productID, quantity);
		this.quantity = 0;
		return null;
	}

	// OK - Handle "Remove" button click event
	public String removeHandler() {
		CartBean cart = Helper.getBean("cartBean", CartBean.class);
		cart.removeItemFromCart(productID);
		return null;
	}
}
