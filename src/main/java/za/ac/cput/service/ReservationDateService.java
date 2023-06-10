
/*
IReservationService.java
IReservationService class
Author : Kyra Petersen (219474559)
Date : 5 June 2023
*/

package za.ac.cput.service;

import za.ac.cput.domain.ReservationDate;

import java.util.Set;

public interface ReservationDateService extends IService<ReservationDate,String> {
     Set<ReservationDate> getAll();
}
