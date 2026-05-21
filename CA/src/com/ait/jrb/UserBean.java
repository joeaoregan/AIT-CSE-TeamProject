package com.ait.jrb;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.ait.objects.User;

@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private ArrayList<User> userList;

    // Removed extra and duplicate variables
    private int type; // Default = User.CUSTOMER
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private String bio;
    private String image;
    Double pricePerDay; // Set the price to hire a Skipper for the day

    /**
     * Initialise the user bean variables, and add some test users to the list
     * of users. The form variables are initialized using the resetBeanVars()
     * method, which sets the type to User.CUSTOMER, username, password,
     * firstName, lastName, address, phone, and bio to empty strings, image to
     * an empty string, and pricePerDay to 0.0. The userList variable is
     * initialized as an empty ArrayList of User objects. Some test users are
     * added to the userList using the addUser() method, which takes a User
     * object as a parameter and adds it to the list of users. The test users
     * include a manager, a customer, a skipper, and a front desk staff member,
     * each with different usernames and details. The manager user has the
     * username "root" and is added with the type User.MANAGER, while the
     * customer user has the username "elaine" and is added with the type
     * User.CUSTOMER. The skipper user has the username "kiev" and is added with
     * the type User.SKIPPER, and the front desk staff member has the username
     * "sorcha" and is added with the type User.FRONT_DESK_STAFF. These test
     * users are added to the userList to provide initial data for testing and
     * demonstration purposes.
     */
    public UserBean() {
        userList = new ArrayList<User>();

        resetBeanVars(); // Initialise / clear variables

        User root = new User(User.MANAGER, "root", "admin", "MasterUser", "Administrator", "Athlone", "1234567", "",
                "profile.jpg", 0.0);
        User joe = new User(User.MANAGER, "joe1", "asdf", "Joe", "O'Regan", "Thurles", "0871234567", "", "profile.jpg",
                0.0);
        User ademola = new User(User.MANAGER, "ademola", "asdf", "Ademola", "Alade", "Athlone", "1234567", "",
                "profile.jpg", 0.0);
        User elaine = new User(User.CUSTOMER, "elaine", "asdf", "Elaine", "Santos", "Athlone", "0870246810", "",
                "profile.jpg", 0.0);
        User kiev = new User(User.SKIPPER, "kiev", "asdf", "Kiev", "Reynolds", "Athlone", "0873691215", "",
                "profile.jpg", 0.0);
        User sorcha = new User(User.FRONT_DESK_STAFF, "sorcha", "asdf", "Sorcha", "Bruton", "Athlone", "0870481216", "",
                "profile.jpg", 0.0);

        addUser(root);
        addUser(joe);
        addUser(ademola);
        addUser(elaine);
        addUser(kiev);
        addUser(sorcha);
    }

    /**
     * Handler for resetting the login information. Clears the username,
     * firstName, lastName, and address variables by setting them to empty
     * strings. Returns a string message indicating that the login details have
     * been reset. This method can be used to clear the login information from
     * the form after a user logs out or when resetting the form for a new user.
     *
     * @return a string message indicating that the login details have been
     * reset
     */
    public String resetLoginInfo() {
        username = "";
        firstName = "";
        lastName = "";
        address = "";

        return "LOGIN DETAILS RESET";
    }

    /**
     * Reset the form variables to their default values. This method is called
     * in the constructor to initialize the form variables, and can also be
     * called after form submission to clear the form for the next input. The
     * type is set to User.CUSTOMER, which is the default user type. The
     * username, password, firstName, lastName, address, phone, and bio are all
     * set to empty strings, as they will be filled in by the user. The image is
     * set to an empty string, which can be updated by the user. The pricePerDay
     * is set to 0.0, which is a default value for skippers, and can be updated
     * by the user if they are registering as a skipper. The	message variable is
     * also reset to an empty string, to clear any previous messages.
     */
    public void resetBeanVars() {
        this.type = User.CUSTOMER; // default type (Manager can change from their view)
        username = "";
        password = "";
        firstName = "";
        lastName = "";
        address = "";
        phone = "";
        image = "";
        bio = "";
        pricePerDay = 0.0;
    }

    /*
	 * Displays a string instead of using the integer user type
     */
    public String displayType(int type) {
        switch (type) {
            case User.MANAGER:
                return "Manager";
            case User.CUSTOMER:
                return "Customer";
            case User.FRONT_DESK_STAFF:
                return "Front Desk Staff";
            case User.SKIPPER:
                return "Skipper";
            default:
                return null;
        }
    }

    /*
	 * XXXXXXX HELPER XXXXXXXXXXX Save form update / edit details
     */
    public String saveAction() {
        //FacesContext context = FacesContext.getCurrentInstance();
        //context.addMessage(null, new FacesMessage("Successful", "Details Saved"));

        //UserBean userBean = Helper.getBean("userBean", UserBean.class);
        //for (User user : userBean.getUserList()) {
        for (User user : userList) {
            user.setCanEdit(false);
        }

        return null;
    }

    /**
     * Displays a success message in the view using the provided message string.
     * The message is added to the FacesContext with a severity level of
     * "Successful". This method can be used to display success messages to the
     * user after performing actions such as creating a new user, updating user
     * details, or performing other successful operations. The message parameter
     * is the string message to be displayed in the view, which can be
     * customized based on the specific action performed by the user.
     *
     * @param message the string message to be displayed in the view, indicating
     * the success of an operation performed by the user
     */
    public void successMessage(String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful", message));
    }

    /**
     * Adds a new user to the list of users. The method takes a User object as a
     * parameter and adds it to the userList. If the user object is null, an
     * "INVALID USER" message is returned. If the username of the user is not
     * unique (i.e., a user with the same username already exists in the
     * userList), a "USERNAME NOT UNIQUE" message is returned. If the user is
     * added successfully to the userList, a "USER ADDED OK" message is
     * returned. This method can be used to handle the creation of new users in
     * the application, ensuring that the user data is valid and that usernames
     * are unique to prevent conflicts.
     *
     * @param user the User object to be added to the userList, containing the
     * details of the user to be created
     * @return a string message indicating the result of the addUser operation,
     * which can be "INVALID USER", "USERNAME NOT UNIQUE", or "USER ADDED OK"
     * based on the validity of the user data and the uniqueness of the username
     */
    public String addUser(User user) {
        if (user == null) {
            return "INVALID USER";
        }

        if (!checkUniqueUsername(user.getUsername())) {
            userList.add(user);
            return "USER ADDED OK";
        }

        return "USERNAME NOT UNIQUE";
    }

    /**
     * Handler for removing a user. Calls the deleteUser() method to remove the
     * specified user from the userList. Returns null to stay on the same page
     * after removing the user. The user parameter is the User object to be
     * removed from the userList, and the deleteUser() method is responsible for
     * performing the actual removal of the user from the list. This handler can
     * be used in the view to allow users to remove other users from the system,
     * such as by clicking a "Delete" button next to a user's details in a user
     * management interface.
     *
     * @param user the User object to be removed from the userList, representing
     * the user
     * @return null to stay on the same page after removing the user from the
     * userList
     */
    public String removeUserHandler(User user) {
        deleteUser(user);
        return null;
    }

    /**
     * Deletes a user from the userList. If the user is not null, it is removed
     * from the list and a "USER REMOVED" message is returned. If the user is
     * null, the method returns null. This method can be used to handle the
     * removal of users from the system, ensuring that the user data is valid
     * before performing the deletion.
     *
     * @param user the User object to be removed from the userList, representing
     * the user
     * @return a string message indicating the result of the deleteUser
     * operation, which can be "USER REMOVED" if the user is successfully
     * removed, or null if the user is null
     */
    public String deleteUser(User user) {
        if (user != null) {
            userList.remove(user);
            return "USER REMOVED";
        }
        return null;
    }

    /*
	public String deleteUserByUsername(String username) {
		for (User user : userList) {
			if (username.equalsIgnoreCase(user.getUsername())) {
				userList.remove(user);
				return "USER REMOVED";
			}
		}
		return null;
	}
     */
    /**
     * Handler for editing a user. Sets the canEdit property of the specified
     * user to true, to enable editing in the view. Returns null to stay on the
     * same page after enabling editing for the user. The user parameter is the
     * User object to be edited, and the canEdit property is used in the view to
     * enable or disable editing of the user's details based on whether it is
     * set to true or false. This handler can be used in the view to allow users
     * to edit the details of other users in the system, such as by clicking an
     * "Edit" button next to a user's details in a user management interface,
     * which would enable editing of that user's information in the view.
     *
     * @param user the User object to be edited, representing the user whose
     * details are
     * @return null to stay on the same page after enabling editing for the user
     * in the
     */
    public String editUser(User user) {
        user.setCanEdit(true);
        return null;
    }

    /*
	 * Find a user in the list of users using a username If a user is not found
	 * return null
     */
    public User getUserByUsername(String username) {
        for (User findUser : userList) {
            if (findUser.getUsername().equals(username)) {
                return findUser;
            }
        }

        return null;
    }

    /**
     * Check whether a username is unique in the userList. The method iterates
     * through the userList and compares the username of each user with the
     * provided username. If a user with the same username is found, the method
     * returns true, indicating that the username is not unique. If no user with
     * the same username is found after iterating through the entire list, the
     * method returns false, indicating that the username is unique. This method
     * can be used to validate the uniqueness of usernames when creating new
     * users, ensuring that each user has a unique identifier in the system to
     * prevent conflicts and maintain data integrity.
     *
     * @param username the username to be checked for uniqueness in the userList
     * @return true if a user with the same username is found in the userList
     * (indicating that the username is not unique), false if no user with the
     * same username is found (indicating that the username is unique)
     */
    public boolean checkUniqueUsername(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Get the number of users in the userList.
     *
     * @return the number of users in the userList
     */
    public int userCount() {
        return userList.size();
    }

    /* GETTERS AND SETTERS */
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }
}
