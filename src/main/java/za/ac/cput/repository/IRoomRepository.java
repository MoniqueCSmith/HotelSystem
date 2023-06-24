/**
 * IRoomRepository.java
 * Interface Repository for the Room
 * Author: Alison Shirlene Williams (219140987)
 * Date: 07 April 2023
 */
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Room;
import java.util.Set;

@Repository
public interface IRoomRepository extends JpaRepository<Room, String> {
}