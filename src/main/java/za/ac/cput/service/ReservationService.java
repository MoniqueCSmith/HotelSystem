
/*
IReservationService.java
IReservationService class
Author : Kyra Petersen (219474559)
Date : 5 June 2023
*/


package za.ac.cput.service;
import za.ac.cput.domain.Reservation;

import java.util.Set;

public interface ReservationService extends IService <Reservation ,String> {
     Set<Reservation> getAll();
}
