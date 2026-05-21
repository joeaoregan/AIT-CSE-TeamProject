package com.ait.jrb;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import com.ait.objects.Boat;
import com.ait.objects.Order;
import com.ait.objects.User;

@ManagedBean(name = "orderBean")
@SessionScoped
public class OrderBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Boat boatSelected;
	private User skipper;

	private String boatType;
	private ArrayList<Order> allOrders; // List of orders
	private Order currentOrder;

	private int formQuantity;
	private int formNumDays;
	private int formDayHired;
	private double formDeposit;
	private double formTotalCost;

	/**
	 * Initialise the order bean variables, and add a test order to the list of
	 * orders.
	 */
	public OrderBean() {
		boatSelected = null;
		skipper = null;

		boatType = "Cruiser"; // Selects the Cruiser as default radio button
		currentOrder = null;
		allOrders = new ArrayList<Order>();

		// addTestOrder(); // Affects code coverage, uses Helper
	}
	
	// Add orders to test forms

//	public void addTestOrder() {
//		InventoryBean inventoryBean = Helper.getBean("inventoryBean", InventoryBean.class);
//		UserBean userBean = Helper.getBean("userBean", UserBean.class);
//
//		allOrders.add(new Order("Order1", "elaine", inventoryBean.findBoat("Canoe"), 1, 5,
//				userBean.getUserByUsername("kiev"), 3, 50.0, 0.0, 65.0, 65.0, 120.0));
//		allOrders.add(new Order("Order2", "elaine", inventoryBean.findBoat("Canoe"), 1, 3,
//				userBean.getUserByUsername("kiev"), 2, 50.0, 0.0, 60.0, 60.0, 100.0));
//	}

	/**
	 * Calculate the total price of all orders.
	 *
	 * @return the total price of all orders
	 */
	public double orderTotal() {
		double total = 0.0;
		for (Order order : allOrders) {
			total += (order.getTotalPricePayNow() + order.getRemainingPrice());
		}
		return total;
	}

	/**
	 * Calculate the total deposits of all orders.
	 *
	 * @return the total deposits of all orders
	 */
	public double totalDeposits() {
		double total = 0.0;
		for (Order order : allOrders) {
			total += order.getTotalPricePayNow();
		}
		return total;
	}

	/**
	 * Calculate the total price of a specific order.
	 *
	 * @param order the order to calculate the total price for
	 * @return the total price of the order
	 */
	public String totalOrderPrice(Order order) {
		return Double.toString(order.getTotalPricePayNow() + order.getRemainingPrice());
	}

	/**
	 * Handler for selecting a boat in the order form. Calculates 
	 * the deposit to pay based on the selected boat, quantity, and number of days, and sets the
	 * formDeposit variable. Returns null to stay on the same page.
	 * @return null to stay on the same page
	 */
	public String selectBoat() {
		formDeposit = depositToPay();
		return null;
	}

	/**
	 * Calculate the deposit to pay based on the selected boat, quantity, and number of days. 
	 * The deposit is calculated as 10% of the total price of the order. 
	 * The total price is calculated as the price of the boat multiplied by the quantity and number of days. 
	 * The calculated deposit is returned.
	 */
	public double depositToPay() {
		formDeposit = (double) boatSelected.getPrice() * formQuantity * formNumDays * 0.1; // 10% deposit required for
																							// boats
		// return "�" + Double.toString(total);
		return formDeposit; // format as currency
	}

	/**
	 * Display the deposit to pay as a string.
	 *
	 * @return the deposit to pay as a string
	 */
	public String displayDeposit() {
		return Double.toString(depositToPay());
	}

	/**
	 * Handler for the order form submission. 
	 * 	 * Creates a new order based on the form variables, and adds it to the list of orders.
	 * @return Returns null to stay on the same page.
	 */
	public String pricePerDay() {
		// boatSelected = getSelectedBoat();
		// if (boatSelected != null) {
//		if ((boatSelected = getSelectedBoat()) != null) {
//			return Double.toString(boatSelected.getPrice());
//		}
//
//		return "BOAT NOT FOUND";

		return (boatSelected = getSelectedBoat()) != null ? Double.toString(boatSelected.getPrice()) : "BOAT NOT FOUND";
	}

	/**
	 * Get the selected boat based on the boat type selected in the order form.
	 * The boat is retrieved from the inventory bean, using the findBoat() method.
	 * If no boat with the selected type is found, null is returned.
	 * @return the selected boat, or null if no boat with the selected type is found
	 */
	public Boat getSelectedBoat() {
		InventoryBean inventoryBean = Helper.getBean("inventoryBean", InventoryBean.class);
		return inventoryBean.findBoat(boatType);
	}

	/**
	 * Get the quantity in stock for the selected boat. 
	 * The selected boat is retrieved using the getSelectedBoat() method. 
	 * If a boat is selected, the quantity in stock is returned as a string. 
	 * If no boat is selected, or the boat is not found, "BOAT NOT FOUND" is returned.
	 * @return the quantity in stock for the selected boat as a string, 
	 * or "BOAT NOT FOUND" if no boat is selected or the boat is not found
	 */
	public String quantityInStock() {
		// System.out.println("test");
		// boatSelected = getSelectedBoat();

//		if ((boatSelected = getSelectedBoat())!= null) {
//			return Integer.toString(boatSelected.getQuantity());
//		}
//
//		return "BOAT NOT FOUND";

		return (boatSelected = getSelectedBoat()) != null ? Integer.toString(boatSelected.getQuantity())
				: "BOAT NOT FOUND";
	}

	public ArrayList<Order> getAllOrders() {
		return allOrders;
	}

	public void setAllOrders(ArrayList<Order> allOrders) {
		this.allOrders = allOrders;
	}

	public Order getCurrentOrder() {
		return currentOrder;
	}

	public void setCurrentOrder(Order currentOrder) {
		this.currentOrder = currentOrder;
	}

	public String getBoatType() {
		return boatType;
	}

	public void setBoatType(String boatType) {
		this.boatType = boatType;
	}

	public Boat getBoatSelected() {
		return boatSelected;
	}

	public void setBoatSelected(Boat boatSelected) {
		this.boatSelected = boatSelected;
	}

	public int getFormQuantity() {
		return formQuantity;
	}

	public void setFormQuantity(int formQuantity) {
		this.formQuantity = formQuantity;
	}

	public int getFormNumDays() {
		return formNumDays;
	}

	public void setFormNumDays(int formNumDays) {
		this.formNumDays = formNumDays;
	}

	public int getFormDayHired() {
		return formDayHired;
	}

	public void setFormDayHired(int formDayHired) {
		this.formDayHired = formDayHired;
	}

	public double getFormDeposit() {
		return formDeposit;
	}

	public void setFormDeposit(double formDeposit) {
		this.formDeposit = formDeposit;
	}

	public double getFormTotalCost() {
		return formTotalCost;
	}

	public void setFormTotalCost(double formTotalCost) {
		this.formTotalCost = formTotalCost;
	}

	public User getSkipper() {
		return skipper;
	}

	public void setSkipper(User skipper) {
		this.skipper = skipper;
	}
}