package com.hafidz.bus.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ticket")
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int seatNumber;
	
	private boolean cancellable;
	
	private String journeyDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "passenger_id", referencedColumnName = "id")
    private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_schedule_id", referencedColumnName = "id")
    private TripSchedule tripSchedule;

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", seatNumber=" + seatNumber + ", cancellable=" + cancellable + ", journeyDate="
				+ journeyDate + ", user=" + user + ", tripSchedule=" + tripSchedule + ", hashCode()=" + hashCode()
				+ ", getId()=" + getId() + ", getSeatNumber()=" + getSeatNumber() + ", isCancellable()="
				+ isCancellable() + ", getJourneyDate()=" + getJourneyDate() + ", getUser()=" + getUser()
				+ ", getTripSchedule()=" + getTripSchedule() + ", getClass()=" + getClass() + ", toString()="
				+ super.toString() + "]";
	}

	public Ticket(int seatNumber, boolean cancellable, String journeyDate, User user,
			TripSchedule tripSchedule) {
		super();
		this.seatNumber = seatNumber;
		this.cancellable = cancellable;
		this.journeyDate = journeyDate;
		this.user = user;
		this.tripSchedule = tripSchedule;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cancellable, id, journeyDate, seatNumber, tripSchedule, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		return cancellable == other.cancellable && id == other.id && Objects.equals(journeyDate, other.journeyDate)
				&& seatNumber == other.seatNumber && Objects.equals(tripSchedule, other.tripSchedule)
				&& Objects.equals(user, other.user);
	}

	public Ticket() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public boolean isCancellable() {
		return cancellable;
	}

	public void setCancellable(boolean cancellable) {
		this.cancellable = cancellable;
	}

	public String getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public TripSchedule getTripSchedule() {
		return tripSchedule;
	}

	public void setTripSchedule(TripSchedule tripSchedule) {
		this.tripSchedule = tripSchedule;
	}
	
	

}
