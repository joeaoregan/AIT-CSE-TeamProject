/*
 * Joe O'Regan
 * A00258304
 */
package com.ait.jsf;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * CartBean is a managed bean that handles the shopping cart operations. It
 * allows users to add items to the cart and remove items from the cart. The
 * bean is session-scoped, meaning that the cart will persist across multiple
 * requests within the same user session. It contains an ArrayList of Item
 * objects to represent the items in the cart, as well as fields for the
 * customer's name and address. The CartBean provides methods to add items to
 * the cart, remove items from the cart, and retrieve the total number of items
 * in the cart.
 */
@ManagedBean(name = "cartBean")
@SessionScoped
public class CartBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private ArrayList<Item> items;
    private String name;
    private String address;

    public CartBean() {
        items = new ArrayList<Item>();
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    /**
     * Adds an item to the cart with the specified product ID and quantity. It
     * creates a new Item object with the given product ID and quantity and adds
     * it to the items list.
     *
     * @param productID the ID of the product to be added to the cart
     * @param quantity the quantity of the product to be added to the cart
     */
    public void addItemToCart(int productID, int quantity) {
        Item item = new Item(productID, quantity);
        items.add(item);
    }

    /**
     * Removes an item from the cart based on the specified product ID. It
     * creates an Item object with the given product ID and searches for it in
     * the items list. If a matching item is found, it is removed from the list.
     *
     * @param productID the ID of the product to be removed from the cart item
     * is found, it is removed from the list.
     */
    public void removeItemFromCart(int productID) {
        Item item = new Item(productID);

        for (Item searchItem : items) {
            if (searchItem.equals(item)) {
                items.remove(searchItem);
                break;
            }
        }
    }

    public int getItemCount() {
        return items.size();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
