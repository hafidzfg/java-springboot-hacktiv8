package com.hafidz.bus.payload.request;

import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

public class TicketRequest {
	@ApiModelProperty(hidden = true)
	private Long id;
	
	private int seatNumber;
	
	private Boolean cancellable;
	
	private String journeyDate;
	
	private Long passengerId;
	
	private Long tripScheduleId;

	@Override
	public int hashCode() {
		return Objects.hash(cancellable, id, journeyDate, passengerId, seatNumber, tripScheduleId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TicketRequest other = (TicketRequest) obj;
		return Objects.equals(cancellable, other.cancellable) && Objects.equals(id, other.id)
				&& Objects.equals(journeyDate, other.journeyDate) && Objects.equals(passengerId, other.passengerId)
				&& seatNumber == other.seatNumber && Objects.equals(tripScheduleId, other.tripScheduleId);
	}

	@Override
	public String toString() {
		return "TicketRequest [id=" + id + ", seatNumber=" + seatNumber + ", cancellable=" + cancellable
				+ ", journeyDate=" + journeyDate + ", passengerId=" + passengerId + ", tripScheduleId=" + tripScheduleId
				+ ", hashCode()=" + hashCode() + ", getId()=" + getId() + ", getSeatNumber()=" + getSeatNumber()
				+ ", getCancellable()=" + getCancellable() + ", getJourneyDate()=" + getJourneyDate()
				+ ", getPassengerId()=" + getPassengerId() + ", getTripScheduleId()=" + getTripScheduleId()
				+ ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}

	public TicketRequest(Long id, int seatNumber, Boolean cancellable, String journeyDate, Long passengerId,
			Long tripScheduleId) {
		super();
		this.id = id;
		this.seatNumber = seatNumber;
		this.cancellable = cancellable;
		this.journeyDate = journeyDate;
		this.passengerId = passengerId;
		this.tripScheduleId = tripScheduleId;
	}

	public TicketRequest() {
		super();
		// TODO Auto-generated constructor stub
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

	public Boolean getCancellable() {
		return cancellable;
	}

	public void setCancellable(Boolean cancellable) {
		this.cancellable = cancellable;
	}

	public String getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}

	public Long getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(Long passengerId) {
		this.passengerId = passengerId;
	}

	public Long getTripScheduleId() {
		return tripScheduleId;
	}

	public void setTripScheduleId(Long tripScheduleId) {
		this.tripScheduleId = tripScheduleId;
	}
	
	
}
