package com.ait.jrb;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

//import com.ait.objects.Boat;
import com.ait.objects.PricingStructure;

@ManagedBean(name = "pricingBean")
@SessionScoped
public class PricingBean implements Serializable {

    private static final long serialVersionUID = 1L;
    // private Item item;
    // private int id;
    private String type;
    private String name;
    private int amount;
    private Double price;
    private int percent;

    ArrayList<PricingStructure> prices;

    /**
     * Initialise the pricing bean variables, and add a test pricing structure
     * to the list of prices. The test pricing structure is added using the
     * addPricing() method, which takes the type, amount, and percent as
     * parameters. The form variables are initialised using the
     * resetFormVariables() method, which sets the type to "Cruiser", amount to
     * 1, price to 0.0, and percent to 1. The list of prices is initialised as
     * an empty ArrayList of PricingStructure objects. The test pricing
     * structure is added with type "Cruiser", amount 1, and percent 10.
     */
    public PricingBean() {
        resetFormVariables(); // initialise/reset the form data

        prices = new ArrayList<PricingStructure>();
    }

    /**
     * Handler for adding a pricing structure. Calls the addPricing() method
     * with the current form variables (type, amount, percent) to add a new
     * pricing structure to the list of prices. After adding the pricing
     * structure, the form variables are reset using the resetFormVariables()
     * method to clear the form for the next input. Finally, null is returned to
     * stay on the same page.
     *
     * @return null to stay on the same page after adding the pricing structure
     */
    public String addPricingHandler() {
        addPricing(type, amount, percent);

        resetFormVariables();

        return null;
    }

    /*
	 * Reset the data in the input text fields of the form by clearing variables
     */
    public void resetFormVariables() {
        this.type = "Cruiser";
        this.amount = 1;
        this.price = 0.0;
        this.percent = 1;
    }

    /**
     * Add a pricing structure to the list of prices. Creates a new
     * PricingStructure object with the specified type, amount, and percent, and
     * adds it to the prices list.
     *
     * @param type the type of the pricing structure (e.g. boat type)
     * @param amount the amount for the pricing structure (e.g. number of boats,
     * number of days)
     * @param percent the percentage for the pricing structure (e.g. discount
     * percentage)
     */
    public void addPricing(String type, int amount, int percent) {
        prices.add(new PricingStructure(type, amount, percent));
    }

    /**
     * Handler for saving the pricing structures. Sets the canEdit property of
     * all pricing structures in the prices list to false, to disable editing in
     * the view. Returns null to stay on the same page after saving.
     *
     * @return null to stay on the same page after saving the pricing structures
     */
    public String saveAction() {
        for (PricingStructure price : prices) {
            price.setCanEdit(false);
        }
        return null;
    }

    /**
     * Handler for editing a pricing structure. Sets the canEdit property of the
     * specified pricing structure to true, to enable editing in the view.
     * Returns null to stay on the same page after enabling editing for the
     * pricing structure.
     *
     * @param pricingStructure the pricing structure to enable editing for
     * @return null to stay on the same page after enabling editing for the
     * pricing structure
     */
    public String editPricingStructure(PricingStructure pricingStructure) {
        pricingStructure.setCanEdit(true);
        return null;
    }

    /**
     * Handler for deleting a pricing structure. Removes the specified pricing
     * structure from the prices list. Returns null to stay on the same page
     * after deleting the pricing structure.
     *
     * @param pricingStructure the pricing structure to be deleted
     * @return null to stay on the same page after deleting the pricing
     * structure
     */
    public String deletePricingStructure(PricingStructure pricingStructure) {
        prices.remove(pricingStructure);
        return null;
    }

    /**
     * Determine whether to render the pricing structures table in the view. The
     * table is rendered if there is at least one pricing structure in the
     * prices list. If the prices list is empty, the table is not rendered. This
     * method is used in the view to conditionally display the table of pricing
     * structures based on whether there are any pricing structures to display.
     *
     * @return true if there is at least one pricing structure in the prices
     * list, false otherwise
     */
    public Boolean renderTable() {
        if (prices.size() > 0) {
            return true;
        }

        return false;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public ArrayList<PricingStructure> getPrices() {
        return prices;
    }

    public void setPrices(ArrayList<PricingStructure> prices) {
        this.prices = prices;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
