/**
 * IRoomRepository.java
 * Interface Repository for the Room
 * Author: Alison Shirlene Williams (219140987)
 * Date: 07 April 2023
 */
package za.ac.cput.repository;

import za.ac.cput.domain.Room;

import java.util.Set;

public interface IRoomRepository extends IRepository<Room, String> {

    public Set<Room> getAll();
}
