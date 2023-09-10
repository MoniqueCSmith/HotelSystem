package za.ac.cput.service;


import za.ac.cput.domain.Guest;

import java.util.List;

public interface GuestService extends IService <Guest, String>{
    List<Guest> getAll();
}
