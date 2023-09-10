package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Guest;
import za.ac.cput.factory.GuestFactory;
import za.ac.cput.service.impl.GuestServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/guest")
public class GuestController {

    @Autowired
    private GuestServiceImpl guestService;

    @PostMapping("/create")
    public Guest create(@RequestBody Guest guest) {
        Guest created = GuestFactory.createGuest();
        return guestService.create(created);
    }

    @GetMapping("/read/{id}")
    public Guest read(@PathVariable String id) {
        return guestService.read(id);
    }

    @PostMapping("/update")
    public Guest update(@RequestBody Guest guest) {
        return guestService.update(guest);
    }

    @DeleteMapping("delete/{id}")
    public boolean delete(@PathVariable String id) {
        return guestService.delete(id);
    }

    @RequestMapping({"/getAll"})
    public List<Guest> getAll() {
        return guestService.getAll();
    }

}
