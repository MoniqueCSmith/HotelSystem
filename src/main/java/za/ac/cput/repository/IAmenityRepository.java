/**
 * IAmenityRepository.java
 * Interface Repository for the Amenity
 * Author: Alison Shirlene Williams (219140987)
 * Date: 07 April 2023
 */
package za.ac.cput.repository;

import za.ac.cput.domain.Amenity;

import java.util.Set;
public interface IAmenityRepository extends IRepository<Amenity, String> {


    public Set<Amenity> getAll();
}
