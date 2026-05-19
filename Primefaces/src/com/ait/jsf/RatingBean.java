package com.ait.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class RatingBean {
	private int roomRating, restaurantRating;
	public int getRoomRating() {
	return(roomRating);
	}
	public void setRoomRating(int roomRating) {
	this.roomRating = roomRating;
	}
	public int getRestaurantRating() {
	return(restaurantRating);
	}
	public void setRestaurantRating(int restaurantRating) {
	this.restaurantRating = restaurantRating;
	}
	public String processRatings() {
	return("show-ratings");
	}
}
