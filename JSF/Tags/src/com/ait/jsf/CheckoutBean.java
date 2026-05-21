/*
 * Joe O'Regan
 * A00258304
 */
package com.ait.jsf;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * CheckoutBean is a managed bean that handles the checkout process. It contains
 * a method myCheckoutHandler that determines which checkout page to navigate to
 * based on the number of items in the cart. If the cart contains more than 5
 * items, it navigates to a bulk checkout page; otherwise, it navigates to the
 * regular checkout page. The bean is session-scoped, meaning that it will
 * persist across multiple requests within the same user session.
 */
@ManagedBean(name = "checkoutBean")
@SessionScoped
public class CheckoutBean implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Handles the checkout process by determining which checkout page to
     * navigate to based on the number of items in the cart. It retrieves the
     * CartBean from the JSF context using the Helper class. If the cart
     * contains more than 5 items, it returns "CheckoutBulk" to navigate to the
     * bulk checkout page; otherwise, it returns "Checkout" to navigate to the
     * regular checkout page. This method allows for dynamic navigation based on
     * the contents of the cart, providing a better user experience for
     * customers with larger orders.
     *
     * @return "CheckoutBulk" if the cart contains more than 5 items, otherwise
     * "Checkout"
     */
    public String myCheckoutHandler() {
        // Get the CartBean instance.
        CartBean cart = Helper.getBean("cartBean", CartBean.class);

        if (cart.getItemCount() > 5) {
            return "CheckoutBulk";
        }
        return "Checkout";
    }
}
