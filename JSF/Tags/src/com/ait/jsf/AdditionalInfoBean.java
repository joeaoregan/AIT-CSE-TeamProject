/*
 * Joe O'Regan
 * A00258304
 */
package com.ait.jsf;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 * AdditionalInfoBean is a managed bean that handles the additional information
 * page. It contains a method back() that retrieves the original page URL from
 * the HTTP request and returns the navigation outcome to navigate back to the
 * additional information page. The bean is session-scoped, meaning that it will
 * persist across multiple requests within the same user session. This bean
 * allows users to navigate to the additional information page and then return
 * to the original page they were on before accessing the additional information
 * page.
 */
@ManagedBean(name = "additionalInfoBean")
@SessionScoped
public class AdditionalInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    // private String previousPage;
    private String originalPage;

    /**
     * Handles the navigation back to the additional information page. It
     * retrieves the original page URL from the HTTP request using the
     * ExternalContext and stores it in the originalPage field. The method then
     * returns "AdditionalInfo" to navigate to the additional information page.
     * This allows users to access the additional information page and then
     * return to the original page they were on before accessing the additional
     * information page.
     *
     * @return "AdditionalInfo" to navigate to the additional information page
     */
    public String back() {

        FacesContext ctx = FacesContext.getCurrentInstance();

        ExternalContext extCtx = ctx.getExternalContext();

        HttpServletRequest req = (HttpServletRequest) extCtx.getRequest();

        originalPage = req.getRequestURI();

        return "AdditionalInfo";
    }

    /**
     * Gets the original page URL that was stored when the back() method was
     * called. This method allows other parts of the application to access the
     * original page URL, which can be used for navigation purposes or to
     * display information about the user's previous location in the
     * application.
     *
     * @return the original page URL that was stored when the back() method was
     * called
     */
    public String getOriginalPage() {
        return originalPage;
    }

    /**
     * Sets the original page URL. This method allows other parts of the
     * application to set the original page URL, which can be used for
     * navigation purposes or to display information about the user's previous
     * location in the application. The original page URL is typically set when
     * the back() method is called, but it can also be set manually if needed
     * for other navigation scenarios.
     *
     * @param originalPage the original page URL to be set, which can be used
     * for navigation purposes or to display information about the user's
     * previous location in the application
     */
    public void setOriginalPage(String originalPage) {
        this.originalPage = originalPage;
    }
}
