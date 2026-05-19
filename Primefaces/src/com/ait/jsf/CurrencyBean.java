package com.ait.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CurrencyBean {
	private double dollars=100;
	public double getDollars() {
	return(dollars);
	}
	public void setDollars(double dollars) {
	this.dollars = dollars;
	}
	/** Dollar to Yen conversion taken from xe.com 9/2013. */
	public double getYen() {
	return(dollars * 97.13);
	}
}
