package com.ait.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class TemperatureBean {
	private int fahr=32;
	public int getFahr() {
	return (fahr);
	}
	public void setFahr(int fahr) {
	this.fahr = Math.max(fahr, -460); // -459.67 is absolute zero
	}
	public int getCel() {
	return((int)((fahr - 32)*(5.0/9.0)));
	}
}
