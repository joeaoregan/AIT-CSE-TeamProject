/*
 * Joe O'Regan
 * A00258304
 */
package com.ait.jsf;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 * ShopBean is a managed bean that handles the shopping cart operations. It
 * allows users to add items to the cart and remove items from the cart. The
 * bean is session-scoped, meaning that the cart will persist across multiple
 * requests within the same user session.
 */
@ManagedBean(name = "shopBean")
@SessionScoped
// @RequestScoped
public class ShopBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private int productID;
    private int quantity;

    /**
     * Default constructor initializes the productID and quantity to zero. This
     * ensures that the bean starts with a clean state when it is first created.
     */
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

    /**
     * Handles the "Add to Cart" button click event. It retrieves the CartBean
     * from the session, adds the specified product and quantity to the cart,
     * and then resets the quantity to zero. The method returns null to stay on
     * the same page after the operation.
     *
     * @return null to stay on the same page after adding the item to the cart
     */
    public String addHandler() {
        CartBean cart = Helper.getBean("cartBean", CartBean.class);
        cart.addItemToCart(productID, quantity);
        this.quantity = 0;
        return null;
    }

    // OK - Handle "Remove" button click event
    /**
     * Handles the "Remove" button click event. It retrieves the CartBean from
     * the session, removes the specified product from the cart, and then
     * returns null to stay on the same page after the operation.
     *
     * @return null to stay on the same page after removing the item from the
     * cart
     */
    public String removeHandler() {
        CartBean cart = Helper.getBean("cartBean", CartBean.class);
        cart.removeItemFromCart(productID);
        return null;
    }
}
