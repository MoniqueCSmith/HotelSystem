/**
 * ReviewServiceImpl.java
 * Service class for the Review
 * Author: Shanlynn Courtney Thomas (218053762)
 * Date: 10 June 2023
 */

package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Review;
import za.ac.cput.repository.IReviewRepository;
import za.ac.cput.service.ReviewService;

import java.util.List;
import java.util.Set;

@Service
public class ReviewServiceImpl implements ReviewService {

    private IReviewRepository repository;


    @Autowired
    private ReviewServiceImpl(IReviewRepository repository) {
        this.repository = repository;
    }



    @Override
    public Review create(Review review) {
        return this.repository.save(review);
    }

    @Override
    public Review read(String reviewId) {

        return this.repository.findById(reviewId).orElse(null);
    }

    @Override
    public boolean delete(String reviewId) {
        if (this.repository.existsById(reviewId)){
            this.repository.deleteById(reviewId);
        }
        return false;
    }

    @Override
    public List<Review> getAll() {
        return this.repository.findAll();
    }

}
