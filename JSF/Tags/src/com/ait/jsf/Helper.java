package com.ait.jsf;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;

/**
 * Helper is a utility class that provides a method to retrieve managed beans
 * from the JSF context. The getBean method takes the name of the bean and its
 * class type as parameters and returns an instance of the specified bean. This
 * method is useful for accessing managed beans from other beans or from the JSF
 * pages without having to directly reference them in the page. It uses the
 * FacesContext to access the current JSF context and the Application object to
 * evaluate the EL expression to retrieve the bean instance.
 */
public class Helper {

    /**
     * Retrieves a managed bean from the JSF context based on the provided bean
     * name and type. It uses the FacesContext to access the current JSF context
     * and the Application object to evaluate the EL expression to get the bean
     * instance. This method is generic and can be used to retrieve any managed
     * bean by specifying the appropriate bean name and class type.
     *
     * @param <T> the type of the bean to be retrieved
     * @param beanName the name of the bean to be retrieved
     * @param type the class type of the bean to be retrieved
     * @return an instance of the specified bean type, or null if the bean
     * cannot be found
     */
    public static <T> T getBean(String beanName, Class<T> type) {

        // Get the FacesContext object.
        FacesContext context = FacesContext.getCurrentInstance();

        // Get the Application object for the current context.
        Application application = context.getApplication();

        // Evaluate an EL expression, to get the bean with the specified name.
        return application.evaluateExpressionGet(
                context,
                "#{" + beanName + "}",
                type);
    }
}
