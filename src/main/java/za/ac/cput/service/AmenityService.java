/**
 * AmenityService.java
 * Service interface for the Amenity
 * Author: Alison Shirlene Williams (219140987)
 * Date: 09 June 2023
 */
package za.ac.cput.service;

import za.ac.cput.domain.Amenity;

import java.util.Set;

public interface AmenityService extends IService <Amenity, String> {
    Set<Amenity>getAll();
}
