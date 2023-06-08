package za.ac.cput.repository;

import za.ac.cput.domain.ReservationDate;
import za.ac.cput.domain.Room;

import java.util.Set;

public interface IReservationDateRepository extends IRepository<ReservationDate, String>{
    public Set<ReservationDate> getAll();
}
