/**
 * DietaryRequirementImpl.java
 * Service class for Dietary Requirement entity.
 * Author : Monique Casey Smith
 * Student Number: 217041701
 * Date : 10 June 2023
 */

package za.ac.cput.service.impl;

import za.ac.cput.domain.DietaryRequirement;
import za.ac.cput.repository.DietaryRequirementRepository;
import za.ac.cput.service.DietaryRequirementService;

import java.util.Set;

public class DietaryRequirementImpl implements DietaryRequirementService {

    private static DietaryRequirementImpl service = null;
    private static DietaryRequirementRepository repository = null;

    private DietaryRequirementImpl() {
        if(repository == null) {
            repository = DietaryRequirementRepository.getRepository();
        }
    }

    public static DietaryRequirementImpl getService() {
        if (service == null) {
            service = new DietaryRequirementImpl();
        }
        return service;
    }

    @Override
    public DietaryRequirement create(DietaryRequirement dietaryRequirement) {
        return repository.create(dietaryRequirement);
    }

    @Override
    public DietaryRequirement read(String name) {
        return repository.read(name);
    }

    @Override
    public DietaryRequirement update(DietaryRequirement specialRequirements) {
        return repository.update(specialRequirements);
    }


    @Override
    public Set<DietaryRequirement> getAll() {
        return repository.getAll();
    }
}
