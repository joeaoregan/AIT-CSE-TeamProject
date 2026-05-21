package com.ait.jrb;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.ait.objects.User;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    public static final int PASSWORD_FIELD_LENGTH = 4;
    public static final String PASSWORD_LENGTH_MESSAGE = "Password must be " + PASSWORD_FIELD_LENGTH
            + " or more characters";

    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private String message;

    private User loggedUser;

    private Boolean userLoggedIn;

    private Boolean loggedInCustomer;
    private Boolean loggedInManager;
    private Boolean loggedInFDS;
    private Boolean loggedInSkipper;

    /**
     * Initialise the login bean, by resetting the variables used for login, and
     * setting the logged user to null. Also initialise the users logged in, to
     * set all logged in variables to false.
     */
    public LoginBean() {
        resetVars();
        loggedUser = null;

        initUsersLoggedIn();
    }

    /**
     * Reset the variables used for login, to their default values. This is
     * called when the user logs out, to clear the login form, and reset the
     * message.
     */
    public void resetVars() {
        username = "";
        password = "";
        message = "";
    }

    /**
     * Getters and setters for the login variables, and the message to be
     * displayed in the view.
     *
     * @return the message to be displayed in the view
     */
    public String passwordLengthMessage() {
        return PASSWORD_LENGTH_MESSAGE;
    }

    /**
     * Get the length of the password field, to be used in the view for
     * validation.
     *
     * @return the length of the password field
     */
    public int passwordLength() {
        return PASSWORD_FIELD_LENGTH;
    }

    /**
     * Get the type of the logged in user, to be displayed in the view. If no
     * user is logged in, or the user type is invalid, null is returned.
     *
     * @return the type of the logged in user, or null if no user is logged in
     * or the user type is invalid
     */
    public String displayType() {
        if (loggedUser != null) {
            switch (loggedUser.getType()) {
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
        return null;
    }

    /**
     * Set the logged in variables based on the type of the user. Only the
     * variable corresponding to the user type is set to true, and the rest are
     * set to false. If the user type is invalid, all variables are set to
     * false, and an error message is returned.
     *
     * @param type the type of the user that has logged in
     * @return a message indicating the user type that has been logged in, or an
     * error message if the user type is invalid
     */
    public String setUserLoggedIn(int type) {
        String message = null;

        switch (type) {
            case User.CUSTOMER:
                loggedInCustomer = true;
                loggedInManager = false;
                loggedInFDS = false;
                loggedInSkipper = false;
                message = "CUSTOMER LOGGED IN";
                break;
            case User.FRONT_DESK_STAFF:
                loggedInCustomer = false;
                loggedInManager = false;
                loggedInFDS = true;
                loggedInSkipper = false;
                message = "FRONT_DESK_STAFF LOGGED IN";
                break;
            case User.MANAGER:
                loggedInCustomer = false;
                loggedInManager = true;
                loggedInFDS = false;
                loggedInSkipper = false;
                message = "MANAGER LOGGED IN";
                break;
            case User.SKIPPER:
                loggedInCustomer = false;
                loggedInManager = false;
                loggedInFDS = false;
                loggedInSkipper = true;
                message = "SKIPPER LOGGED IN";
                break;
            default:
                message = "INVALID USER TYPE";
                break;
        }

        return message;
    }

    /**
     * Initialise the users logged in, to set all logged in variables to false.
     * This is called in the constructor, and when the user logs out, to reset
     * the logged in variables.
     */
    public void initUsersLoggedIn() {
        resetVars();

        userLoggedIn = false;
        loggedInCustomer = false;
        loggedInManager = false;
        loggedInFDS = false;
        loggedInSkipper = false;
    }

    /**
     * Get the user that is trying to log in, based on the username entered in
     * the login form. If no user with the entered username is found, null is
     * returned.
     *
     * @return the user that is trying to log in, or null if no user with the
     * entered username is found
     */
    public User getUser() {
        UserBean userBean = Helper.getBean("userBean", UserBean.class);
//		for (User user : userBean.getUserList()) {
//			if (user.equals(username)) {
//				return user;
//			}
//		}
        return userBean.getUserByUsername(username);
    }

    /**
     * Handler for the login action. Gets the user that is trying to log in, and
     * checks if the user exists. If the user exists, the loggedUser variable is
     * set to the user, and the redirectUser() method is called to determine the
     * page to redirect to, based on the user's password and type. If the user
     * does not exist, or the password is incorrect, an error message is added
     * to the context, and the login page is returned to stay on the same page.
     * If the login is successful, the page to redirect to is returned, based on
     * the user's type.
     *
     * @return the page to redirect to, or null to stay on the same page if the
     * login fails
     */
    public String loginHandler() {
        FacesContext context = FacesContext.getCurrentInstance();

        UserBean userBean = Helper.getBean("userBean", UserBean.class);
        User user = userBean.getUserByUsername(username); // get the user

        message = "USER NOT FOUND";

        if (user != null) {
            loggedUser = user;
            message = redirectUser(user.getPassword(), user.getType()); // go to page, or password invalid
        }

        if (message.equals("USER NOT FOUND") || message.equals("login")) {
            message = "/login.xhtml";
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "USERNAME OR PASSWORD INCORRECT"));
        }

        return message;
    }

    /**
     * Determine the page to redirect to, based on the user's password and type.
     * If the password is correct, the userLoggedIn variable is set to true, and
     * the page to redirect to is returned, based on the user's type. If the
     * password	is incorrect, the login page is returned to stay on the same
     * page. If the user type is invalid, the login page is also returned to
     * stay on the same page.
     *
     * @param password the password entered in the login form
     * @param type the type of the user that has logged in
     * @return the page to redirect to, or null to stay on the same page if the
     * password is incorrect or the user type is invalid
     */
    public String redirectUser(String password, int type) {
        userLoggedIn = true;

        if (this.password.equals(password)) {
            if (type == User.MANAGER) {
                setUserLoggedIn(User.MANAGER);
                return "/manager/manager-home.xhtml";
            } else if (type == User.CUSTOMER) {
                setUserLoggedIn(User.CUSTOMER);
                return "/index";
            } else if (type == User.FRONT_DESK_STAFF) {
                setUserLoggedIn(User.FRONT_DESK_STAFF);
                return "/index";
            } else if (type == User.SKIPPER) {
                setUserLoggedIn(User.SKIPPER);
                return "/skipper/SkipperBookings";
            }
        }

        return "login";
    }

    /**
     * Handler for the logout action. Resets the users logged in, to set all
     * logged in variables to false. Also resets the login variables, and sets
     * the logged user to null. Finally, the login page is returned to redirect
     * the user to the login page.
     *
     * @return the login page to redirect to after logging out
     */
    public String logoutHandler() {
        initUsersLoggedIn();

        UserBean userBean = Helper.getBean("userBean", UserBean.class);

        if (userBean != null) {
            userBean.resetLoginInfo();

            loggedUser = null;
            return "/index.xhtml";
        }

        return null;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getLoggedInCustomer() {
        return loggedInCustomer;
    }

    public void setLoggedInCustomer(Boolean loggedInCustomer) {
        this.loggedInCustomer = loggedInCustomer;
    }

    public Boolean getLoggedInManager() {
        return loggedInManager;
    }

    public void setLoggedInManager(Boolean loggedInManager) {
        this.loggedInManager = loggedInManager;
    }

    public Boolean getLoggedInFDS() {
        return loggedInFDS;
    }

    public void setLoggedInFDS(Boolean loggedInFDS) {
        this.loggedInFDS = loggedInFDS;
    }

    public Boolean getLoggedInSkipper() {
        return loggedInSkipper;
    }

    public void setLoggedInSkipper(Boolean loggedInSkipper) {
        this.loggedInSkipper = loggedInSkipper;
    }

    public Boolean getUserLoggedIn() {
        return userLoggedIn;
    }

    public void setUserLoggedIn(Boolean userLoggedIn) {
        this.userLoggedIn = userLoggedIn;
    }

    public static String getPasswordLengthMessage() {
        return PASSWORD_LENGTH_MESSAGE;
    }
}
