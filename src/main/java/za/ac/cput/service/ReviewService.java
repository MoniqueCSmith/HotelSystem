/**
 * ReviewService.java
 * Service interface for the Review
 * Author: Shanlynn Courtney Thomas (218053762)
 * Date: 10 June 2023
 */
package za.ac.cput.service;

import za.ac.cput.domain.CustomerQuery;
import za.ac.cput.domain.Review;

import java.util.Set;

public interface ReviewService {
    Review create(Review review);
    Review read(Review id);
    boolean delete(Review id);
    Set<Review>getAll();
}