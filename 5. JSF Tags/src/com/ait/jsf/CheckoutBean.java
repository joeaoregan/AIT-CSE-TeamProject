/*
 * Joe O'Regan
 * A00258304
 */
package com.ait.jsf;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "checkoutBean")
@SessionScoped
public class CheckoutBean implements Serializable {
	private static final long serialVersionUID = 1L;

	public String myCheckoutHandler() {
		// Get the CartBean instance.
		CartBean cart = Helper.getBean("cartBean", CartBean.class);

		if (cart.getItemCount() > 5) {
			return "CheckoutBulk";
		}
		return "Checkout";
	}
}
