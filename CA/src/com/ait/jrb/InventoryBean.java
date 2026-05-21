package com.ait.jrb;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.ait.objects.Boat;
import com.ait.objects.User;

@ManagedBean(name = "inventoryBean")
@SessionScoped
public class InventoryBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private ArrayList<Boat> boats;

    private String type;
    private double price;
    private String image;
    private int quantity;
    private String description;
    private String link;

    Boat newBoat;

    private String message;

    /**
     * Initialise the inventory with some boats, and reset the variables used
     * for creating a new boat.
     */
    public InventoryBean() {
        boats = new ArrayList<Boat>();

        resetInventoryVariables();

        Boat cruiser = new Boat("Cruiser", 250.0, "boat3.jpg", 10, "Cruiser description", "/details.xhtml");
        Boat canalBarge = new Boat("Canal Barge", 200.0, "boat1.jpg", 15, "Canal Barge description", "/details.xhtml");
        Boat sailingBoat = new Boat("Sailing Boat", 100.0, "boat4.jpg", 20, "Sailing Boat description",
                "/details.xhtml");
        Boat canoe = new Boat("Canoe", 50.0, "boat2.jpg", 25, "Canoe description", "/details.xhtml");

        boats.add(cruiser);
        boats.add(canalBarge);
        boats.add(sailingBoat);
        boats.add(canoe);
    }

    /**
     * Find a boat in the inventory, by type. Returns null if no boat is found.
     *
     * @param type
     * @return the boat with the specified type, or null if not found
     */
    public Boat findBoat(String type) {
        for (Boat aBoat : boats) {
            if (aBoat.getType().equalsIgnoreCase(type)) {
                return aBoat;
            }
        }

        return null;
    }

    /**
     * Set the canEdit property of all boats to false, to disable editing in the
     * view.
     *
     * @return null to stay on the same page
     */
    public String saveAction() {
        for (Boat boat : boats) {
            boat.setCanEdit(false);
        }
        return null;
    }

    /**
     * Delete a boat from the inventory.
     *
     * @param boat the boat to be deleted
     * @return null to stay on the same page
     */
    public String deleteBoat(Boat boat) {
        if (boat != null) {
            boats.remove(boat);
        }
        return null;
    }

    /**
     * Enable editing for a specific boat.
     *
     * @param boat the boat to be edited
     * @return null to stay on the same page
     */
    public String editBoat(Boat boat) {
        boat.setCanEdit(true);
        return null;
    }

    /**
     * Reset the variables used for creating a new boat, to their default
     * values.
     */
    public void resetInventoryVariables() {
        type = "";
        price = 0.0;
        image = "";
        quantity = 0;
        description = "";
        link = "";
        message = "Add A New Boat";
    }

    /**
     * Handler for creating a new boat. Calls the createNewBoat() method, and
     * sets the message to be displayed in the view, based on the result.
     *
     * @return null to stay on the same page
     */
    public String createBoatHandler() {
        message = createNewBoat();
        return null;
    }

    /**
     * Create a new boat, based on the values of the inventory variables. If a
     * boat with the same type already exists, an error message is returned.
     * Otherwise, the new boat is added to the inventory, and a success message
     * is returned. If the quantity or price is zero, an informational message
     * is also added to the context.
     *
     * @return null to stay on the same page
     */
    public String createNewBoat() {
        FacesContext context = FacesContext.getCurrentInstance();

        for (Boat boat : boats) {
            if (boat.getType().equalsIgnoreCase(type)) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "BOAT TYPE EXISTS"));
                return "BOAT TYPE EXISTS";
            }
        }

        //newBoat = new Boat(type, price, image, quantity, description, link);
        boats.add(new Boat(type, price, image, quantity, description, link));
        context.addMessage(null, new FacesMessage("Successful", "Added Type: " + type));
        if (quantity == 0) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "FYI!", "QUANTITY = ZERO"));
        }
        if (price == 0.0) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "FYI!", "PRICE = FREE"));
        }
        resetInventoryVariables();

        return "BOAT ADDED";
    }

    //public void message(String message) {
    //}
    /**
     * Getters and setters for the inventory variables, and the list of boats.
     *
     * @return the type of the boat
     */
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Boat getNewBoat() {
        return newBoat;
    }

    public void setNewBoat(Boat newBoat) {
        this.newBoat = newBoat;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<Boat> getBoats() {
        return boats;
    }

    public void setBoats(ArrayList<Boat> boats) {
        this.boats = boats;
    }

}
