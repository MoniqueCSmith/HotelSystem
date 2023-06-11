/**
 * ReviewServiceImpl.java
 * Service class for the Review
 * Author: Shanlynn Courtney Thomas (218053762)
 * Date: 10 June 2023
 */

package za.ac.cput.service.impl;

import za.ac.cput.domain.Review;
import za.ac.cput.repository.ReviewRepository;
import za.ac.cput.service.ReviewService;
import java.util.Set;

public class ReviewServiceImpl implements ReviewService {

    private static ReviewServiceImpl service = null;
    private ReviewRepository repository = null;

    private ReviewServiceImpl(){
        if(repository == null) {
            repository = ReviewRepository.getRepository();
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
    public Review read(Review id) {
        return repository.read(id.getReviewID());
    }
    @Override
    public boolean delete(Review id) {
        return repository.delete(id.getReviewID());
    }
    @Override
    public Set<Review> getAll() {return repository.getAll();
    }

}
