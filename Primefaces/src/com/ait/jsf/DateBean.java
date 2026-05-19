package com.ait.jsf;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class DateBean {

	private Date startDate, endDate;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public String getStartDay(){
		return (DateUtils.formatDate(startDate));
	}
	public String getEndDay(){
		return (DateUtils.formatDate(endDate));
	}
	
	public String register(){
		FacesContext context=FacesContext.getCurrentInstance();
		if (!startDate.before(endDate)){
			endDate=null;
			FacesMessage errorMessage=
					new FacesMessage ("End data must be after start date");
			errorMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null,  errorMessage);
			return (null);
		}else{
			return("booking.jsf");
		}
	}


}
