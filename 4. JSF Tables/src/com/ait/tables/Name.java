package com.ait.tables;

public class Name {
	private String first;
	private String last;
	boolean canEdit;
	
	public Boolean getCanEdit() {
		return canEdit;
	}
	
	public void setCanEdit(Boolean canEdit) {
		this.canEdit = canEdit;
	}
	
	public Name(String first, String last) {
		this.first = first;
		this.last = last;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}
}
