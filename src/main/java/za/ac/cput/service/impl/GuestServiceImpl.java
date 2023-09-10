package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Guest;
import za.ac.cput.repository.IGuestRepository;
import za.ac.cput.service.GuestService;

import java.util.List;

@Service
public class GuestServiceImpl implements GuestService {

    private IGuestRepository repository;

    @Autowired
    private GuestServiceImpl(IGuestRepository repository) {
        this.repository = repository;
    }

    @Override
    public Guest create(Guest guest) {
        return this.repository.save(guest);
    }

    @Override
    public Guest read(String guestID) {
        return this.repository.findById(guestID).orElse(null);
    }

    @Override
    public Guest update(Guest guest) {
        if (this.repository.existsById(guest.getGuestID())) {
            return this.repository.save(guest);
        }
        return null;
    }

    @Override
    public boolean delete(String guestID) {
        if (this.repository.existsById(guestID)) {
            this.repository.deleteById(guestID);
            return true;
        }
        return false;
    }

    @Override
    public List<Guest> getAll() {
        return this.repository.findAll();
    }
}
