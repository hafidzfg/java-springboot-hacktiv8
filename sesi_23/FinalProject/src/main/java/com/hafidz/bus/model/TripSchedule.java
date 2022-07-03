package com.hafidz.bus.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="trip_schedule")
public class TripSchedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String tripDate;
	
	private int availableSeats;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_id", referencedColumnName = "id")
	private Trip trip;
	
	@OneToMany(mappedBy = "tripSchedule", cascade = CascadeType.ALL)
	private Set<Ticket> ticket;
	
	public TripSchedule() {
		
	}

	public TripSchedule(String tripDate, int availableSeats, Trip trip) {
		super();
		this.tripDate = tripDate;
		this.availableSeats = availableSeats;
		this.trip = trip;
	}

	@Override
	public String toString() {
		return "TripSchedule [id=" + id + ", tripDate=" + tripDate + ", availableSeats=" + availableSeats + ", trip="
				+ trip + ", ticket=" + ticket + ", hashCode()=" + hashCode() + ", getId()=" + getId()
				+ ", getTripDate()=" + getTripDate() + ", getAvailableSeats()=" + getAvailableSeats() + ", getTrip()="
				+ getTrip() + ", getTicket()=" + getTicket() + ", getClass()=" + getClass() + ", toString()="
				+ super.toString() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(availableSeats, id, ticket, trip, tripDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TripSchedule other = (TripSchedule) obj;
		return availableSeats == other.availableSeats && id == other.id && Objects.equals(ticket, other.ticket)
				&& Objects.equals(trip, other.trip) && Objects.equals(tripDate, other.tripDate);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTripDate() {
		return tripDate;
	}

	public void setTripDate(String tripDate) {
		this.tripDate = tripDate;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public Set<Ticket> getTicket() {
		return ticket;
	}

	public void setTicket(Set<Ticket> ticket) {
		this.ticket = ticket;
	}
	
	

}
