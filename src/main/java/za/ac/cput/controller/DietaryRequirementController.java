package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.DietaryRequirement;
import za.ac.cput.util.factory.DietaryRequirementFactory;
import za.ac.cput.service.impl.DietaryRequirementServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/dietaryRequirement")
public class DietaryRequirementController {

    @Autowired
    private DietaryRequirementServiceImpl dietaryRequirementService;

    @PostMapping("/create")
    public DietaryRequirement create(@RequestBody DietaryRequirement dietaryRequirement) {
        DietaryRequirement created = DietaryRequirementFactory.createDietaryRequirement(dietaryRequirement.getName(), dietaryRequirement.getSpecialRequirements());
        return dietaryRequirementService.create(created);
    }

    @GetMapping("/read/{id}")
    public DietaryRequirement read(@PathVariable String id) {
        return dietaryRequirementService.read(id);
    }

    @PostMapping("/update")
    public DietaryRequirement update(@RequestBody DietaryRequirement dietaryRequirement) {
        return dietaryRequirementService.update(dietaryRequirement);
    }

    @RequestMapping({"/getAll"})
    public List<DietaryRequirement> getAll() {
        return dietaryRequirementService.getAll();
    }
}
