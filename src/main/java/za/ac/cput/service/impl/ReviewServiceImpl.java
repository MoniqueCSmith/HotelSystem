/**
 * ReviewServiceImpl.java
 * Service class for the Review
 * Author: Shanlynn Courtney Thomas (218053762)
 * Date: 10 June 2023
 */

package za.ac.cput.service.impl;

import za.ac.cput.domain.Review;
import za.ac.cput.repository.impl.ReviewRepositoryImpl;
import za.ac.cput.service.ReviewService;
import java.util.Set;

public class ReviewServiceImpl implements ReviewService {

    private static ReviewServiceImpl service = null;
    private ReviewRepositoryImpl repository = null;

    private ReviewServiceImpl(){
        if(repository == null) {
            repository = ReviewRepositoryImpl.getRepository();
        }
    }
    public static ReviewServiceImpl getService() {
        if (service == null) {
            service = new ReviewServiceImpl();
        }
        return service;
    }


    @Override
    public Review create(Review review) {return repository.create(review);
    }
    @Override
    public Review read(String id) {
        return repository.read(id);
    }
    @Override
    public boolean delete(String id) {
        return repository.delete(id);
    }
    @Override
    public Set<Review> getAll() {return repository.getAll();
    }

}
