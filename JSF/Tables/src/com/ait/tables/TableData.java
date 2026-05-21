package com.ait.tables;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * A simple class to hold a list of names. This is used in the tables example.
 */
@ManagedBean
@SessionScoped
public class TableData {

    private ArrayList<Name> names;
    private String firstName;
    private String lastName;

    @PostConstruct
    public void init() {
        names = new ArrayList<Name>();
        Name firstName = new Name("William", "Dupont");
        names.add(firstName);
        Name secondName = new Name("Harry", "Styles");
        names.add(secondName);
        Name thirdName = new Name("Jon", "BonJovi");
        names.add(thirdName);
    }

    public ArrayList<Name> getNames() {
        return names;
    }

    /**
     * Set the canEdit property to true for the name passed in. This will cause
     * the name to be rendered as an input field in the table.
     *
     * @param name The name to edit
     * @return null to stay on the same page
     */
    public String editName(Name name) {
        name.setCanEdit(true);
        return null;
    }

    /**
     * Set the canEdit property to false for all names in the list. This will
     * cause all names to be rendered as plain text in the table.
     *
     * @return null to stay on the same page
     */
    public String saveAction() {
        for (Name name : names) {
            name.setCanEdit(false);
        }
        return null;
    }

    /**
     * Remove the name passed in from the list of names.
     *
     * @param name The name to delete
     * @return null to stay on the same page
     */
    public String deleteName(Name name) {
        names.remove(name);
        return null;
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

    /**
     * Add a new name to the list of names.
     *
     * @return null to stay on the same page
     */
    public String addName() {
        final Name name = new Name(this.firstName, this.lastName);

        names.add(name);
        firstName = null;
        lastName = null;
        return null;
    }
}
