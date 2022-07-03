package com.hafidz.bus.repository;

import java.util.List;
import java.util.Set;

import com.hafidz.bus.model.Agency;
import com.hafidz.bus.model.Bus;
import com.hafidz.bus.model.Stop;
import com.hafidz.bus.model.Ticket;
import com.hafidz.bus.model.Trip;
import com.hafidz.bus.model.TripSchedule;
import com.hafidz.bus.model.User;

public interface ReservationRepository {
	//Stop related methods
    Set<Stop> getAllStops();

    Stop getStopByCode(String stopCode);

    //Agency related methods
    Agency getAgency(User user);

    Agency addAgency(Agency agency);

    Agency updateAgency(Agency agency, Bus bus);

    //Trip related methods
    Trip getTripById(Long tripID);

    List<Trip> addTrip(Trip trip);

    List<Trip> getAgencyTrips(String agencyCode);

    List<Trip> getAvailableTripsBetweenStops(String sourceStopCode, String destinationStopCode);

    //Trips Schedule related methods
    List<TripSchedule> getAvailableTripSchedules(String sourceStopCode, String destinationStopCode, String tripDate);

    TripSchedule getTripSchedule(Trip trip, String tripDate, boolean createSchedForTrip);

    //Ticket related method
    Ticket bookTicket(TripSchedule tripSchedule, User passenger);

}
