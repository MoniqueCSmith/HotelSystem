/**
 * DietaryRequirementImpl.java
 * Service class for Dietary Requirement entity.
 * Author : Monique Casey Smith
 * Student Number: 217041701
 * Date : 10 June 2023
 */

package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.DietaryRequirement;
import za.ac.cput.repository.IDietaryRequirementRepository;
import za.ac.cput.service.DietaryRequirementService;

import java.util.List;

@Service
public class DietaryRequirementServiceImpl implements DietaryRequirementService {

    private IDietaryRequirementRepository repository;

    @Autowired
    private DietaryRequirementServiceImpl(IDietaryRequirementRepository repository) {
        this.repository = repository;
    }


    @Override
    public DietaryRequirement create(DietaryRequirement dietaryRequirement) {
        return this.repository.save(dietaryRequirement);
    }

    @Override
    public DietaryRequirement read(String dietaryRequirementID) {
        return this.repository.findById(dietaryRequirementID).orElse(null);
    }

    @Override
    public DietaryRequirement update(DietaryRequirement dietaryRequirement) {
        if (this.repository.existsById(dietaryRequirement.getDietaryRequirementID())) {
            return this.repository.save(dietaryRequirement);
        }
        return null;
    }

    @Override
    public List<DietaryRequirement> getAll() {
        return this.repository.findAll();
    }
}
