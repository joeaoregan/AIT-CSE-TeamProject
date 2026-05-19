package com.ait.jrb;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ait.objects.Boat;

@ManagedBean(name = "searchBoatBean")
@SessionScoped
public class SearchBoatBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Boat boat;

    private String typeSearched;
    private String message;
    private String rendered;

    /**
     * Initialise the search boat bean variables. The boat variable is set to
     * null, as it will be assigned when a search is performed. The typeSearched
     * variable is initialized to an empty string, as it will be filled in by
     * the user when they enter a boat type to search for. The message variable
     * is also initialized to an empty string, to be used for displaying
     * messages to the user after a search is
     */
    public SearchBoatBean() {
        boat = null;
        typeSearched = "";
        message = "";
        rendered = "false";
    }

    /**
     * Handler for the search action. Calls the searchBoat() method with the
     * typeSearched variable to perform the search. If the searchBoat() method
     * returns "BOAT FOUND", the user is navigated to the SearchVerify.xhtml
     * page. If the searchBoat() method returns "BOAT NOT FOUND", the user stays
     * on the same page and a message is displayed indicating that the boat was
     * not found.
     *
     * @return the navigation outcome based on the result of the searchBoat()
     * method
     */
    public String searchHandler() {
//		if (searchBoat(typeSearched).equals("BOAT FOUND")) {
//			//typeSearched = "";
//			return "/customer/SearchVerify.xhtml";
//		}
//		//typeSearched = "";
//		return null;

        return (searchBoat(typeSearched).equals("BOAT FOUND")) ? "/customer/SearchVerify.xhtml" : null;
    }

    /**
     * Get the price of the selected boat. The selected boat is retrieved using
     * the getSelectedBoat() method. If a boat is selected, the price is
     * returned as a string. If no boat is selected, or the boat is not found,
     * "BOAT NOT FOUND" is returned.
     */
    public String searchBoat(String type) {
        InventoryBean inventoryBean = Helper.getBean("inventoryBean", InventoryBean.class);
        return boatFound(inventoryBean.findBoat(type));
    }

    /**
     * Determine whether a boat was found based on the result of the search. If
     * a boat is found, the boat variable is set to the found boat, the rendered
     * variable is set to "true" to enable rendering of the boat details in the
     * view, and the message variable is set to "BOAT FOUND". If no boat is
     * found, the boat variable is set to null, the rendered variable is set to
     * "false" to disable rendering of the boat details in the view, and the
     * message variable is set to "BOAT NOT FOUND". The message variable is
     * returned to indicate the result of the search, which can be used in the
     * view to display appropriate messages to the user.
     *
     * @param boat the boat found by the search, or null if no boat is found
     * @return the message indicating whether the boat was found or not, which
     * can be used in the view to display appropriate messages to the user
     */
    public String boatFound(Boat boat) {
        typeSearched = "";
        rendered = "false";
        message = "BOAT NOT FOUND";

        if (boat != null) {
            this.boat = boat;
            rendered = "true";
            message = "BOAT FOUND";
        }

        return message;
    }

    public Boat getBoat() {
        return boat;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }

    public String getTypeSearched() {
        return typeSearched;
    }

    public void setTypeSearched(String typeSearched) {
        this.typeSearched = typeSearched;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRendered() {
        return rendered;
    }

    public void setRendered(String rendered) {
        this.rendered = rendered;
    }
}
