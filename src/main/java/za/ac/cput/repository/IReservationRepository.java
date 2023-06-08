package za.ac.cput.repository;

import za.ac.cput.domain.Reservation;
import za.ac.cput.domain.Room;

import java.util.Set;

public interface IReservationRepository extends IRepository<Reservation, String>{
    public Set<Reservation> getAll();
}
