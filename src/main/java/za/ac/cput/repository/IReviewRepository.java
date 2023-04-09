/**
 * IReviewRepository.java
 * Interface Repository class for the Review
 * Author: Shanlynn Courtney Thomas (218053762)
 * Date: 08 April 2023
 */
package za.ac.cput.repository;

import za.ac.cput.domain.Review;

import java.util.Set;

public interface IReviewRepository extends IRepository<Review, String>{
    public Set<Review> getAll();
}
