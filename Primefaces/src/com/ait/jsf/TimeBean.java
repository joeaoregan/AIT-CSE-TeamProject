package com.ait.jsf;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class TimeBean {

	private Date sampleDate;

	public Date getSampleDate() {
		return sampleDate;
	}

	public void setSampleDate(Date sampleDate) {
		this.sampleDate = sampleDate;
	}

	public String getSampleTime() {
		if (sampleDate == null) {
			return "No date/time selected.";
		} else {
			String message = String.format("you chose '%s'.",
					DateUtils.formatTime(sampleDate));
			return message;
		}
	}

}
