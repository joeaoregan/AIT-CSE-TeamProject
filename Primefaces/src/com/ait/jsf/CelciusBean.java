package com.ait.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CelciusBean {
	private double cel;
	public double getCel() {
	return(cel);
	}
	public void setCel(double cel) {
	this.cel = Math.max(cel, -273.15); // -273.15 is abs. zero
	}
	public double getFahr() {
	return(cel*9.0/5.0 + 32);
	}
}
