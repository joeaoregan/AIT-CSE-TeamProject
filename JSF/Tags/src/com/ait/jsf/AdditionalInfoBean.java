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

@ManagedBean(name = "additionalInfoBean")
@SessionScoped
public class AdditionalInfoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	// private String previousPage;
	private String originalPage;

	public String back() {

		FacesContext ctx = FacesContext.getCurrentInstance();

		ExternalContext extCtx = ctx.getExternalContext();

		HttpServletRequest req = (HttpServletRequest) extCtx.getRequest();

		originalPage = req.getRequestURI();

		return "AdditionalInfo";
	}

	public String getOriginalPage() {
		return originalPage;
	}

	public void setOriginalPage(String originalPage) {
		this.originalPage = originalPage;
	}
}
