package com.ait.jrb;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.ait.objects.User;

@ManagedBean(name = "registerBean")
@SessionScoped
public class RegisterBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private int type;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private String bio;
    private String image;
    double pricePerDay;

    String message;

    User newUser;

    /**
     * Initialise the register bean variables, and reset the form variables. The
     * form variables are reset using the resetFormVariables() method, which
     * sets the type to User.CUSTOMER, username, password, firstName, lastName,
     * address, phone, and bio to empty strings, image to "profile.jpg", and
     * pricePerDay to 0.0. The newUser variable is set to null, as it will be
     * created when the form is submitted. The message variable is also set to
     * an empty string, to be used for displaying messages to the user after
     * form submission.
     */
    public RegisterBean() {
        newUser = null;
        resetFormVariables();
    }

    /**
     * Reset the form variables to their default values. This method is called
     * in the constructor to initialize the form variables, and can also be
     * called after form submission to clear the form for the next input. The
     * type is set to User.CUSTOMER, which is the default user type. The
     * username, password, firstName, lastName, address, phone, and bio are all
     * set to empty strings, as they will be filled in by the user. The image is
     * set to "profile.jpg", which is a default profile image that can be
     * changed by the user. The pricePerDay is set to 0.0, which is a default
     * value for skippers, and can be updated by the user if they are
     * registering as a skipper. The message variable is also reset to an empty
     * string, to clear any previous messages.
     */
    public void resetFormVariables() {
        type = User.CUSTOMER; // Default, manager can change
        username = "";
        password = "";
        firstName = "";
        lastName = "";
        address = "";
        phone = "";

        // Skipper Only
        bio = "";
        pricePerDay = 0.0; // Skipper
        image = "profile.jpg"; // Change in user account
        message = "";
    }

    // public String userMessage() {
    // FacesContext context = FacesContext.getCurrentInstance();
    // context.addMessage(null, new FacesMessage("Successful", "Add user: " +
    // firstName + " " + lastName));
    // // context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
    //
    // return null;
    // }
    //
    /**
     * Handler for creating a new user. Calls the addUser() method of the
     * UserBean to create a new user based on the form variables. The result of
     * the addUser() method is stored in the message variable, which is used to
     * display messages to the user after form submission. If the message
     * indicates that the username is not unique or the user is invalid, an
     * error message is added to the FacesContext. If the message indicates that
     * the user was added successfully, a success message is added to the
     * FacesContext. After handling the form submission, the form variables are
     * reset using the resetFormVariables() method to clear the form for the
     * next input. Finally, null is returned to stay on the same page after form
     * submission.
     *
     * @return null to stay on the same page after form submission
     */
    public String createUser() {
        UserBean userBean = Helper.getBean("userBean", UserBean.class);
        FacesContext context = FacesContext.getCurrentInstance();
        //newUser = new User(type, username, password, firstName, lastName, address, phone, bio, image, pricePerDay);
        message = userBean.addUser(new User(type, username, password, firstName, lastName, address, phone, bio, image, pricePerDay));

        if (message.equals("USERNAME NOT UNIQUE") || message.equals("INVALID USER")) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", message));
        }

        if (message.equals("USER ADDED OK")) {
            context.addMessage(null, new FacesMessage("Successful", "Add user:\n " + firstName + " " + lastName));
        }

        resetFormVariables();

        return null;
    }

    public String getObscuredPassword() {
        return (firstLetter(password) + "..." + lastLetter(password));
    }

    public String register2() {
        return ("/customer/RegistrationVerify.xhtml");
    }

    private String firstLetter(String s) {
        return (s.substring(0, 1));
    }

    private String lastLetter(String s) {
        int length = s.length();
        return (s.substring(length - 1, length));
    }

    public String getFirstName() {
        return firstName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public User getNewUser() {
        return newUser;
    }

    public void setNewUser(User newUser) {
        this.newUser = newUser;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
