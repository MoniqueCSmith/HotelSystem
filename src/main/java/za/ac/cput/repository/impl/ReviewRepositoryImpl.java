/**
 * ReviewRepository.java
 * Repository class for the Review
 * Author: Shanlynn Courtney Thomas (218053762)
 * Date: 08 April 2023
 */
package za.ac.cput.repository.impl;

import za.ac.cput.domain.Review;
import za.ac.cput.repository.IReviewRepository;

import java.util.HashSet;
import java.util.Set;

public class ReviewRepositoryImpl implements IReviewRepository {
    public static ReviewRepositoryImpl repository = null;
    private Set<Review> reviewDB = null;
    private ReviewRepositoryImpl(){
        reviewDB = new HashSet<Review>();
    }
    public static ReviewRepositoryImpl getRepository(){
        if (repository == null){
            repository = new ReviewRepositoryImpl();
        }
        return repository;
    }

    @Override
    public Review create(Review review) {
        boolean success = reviewDB.add(review);
        if(!success)
            return null;
        return review;
    }

    @Override
    public Review read(String reviewID) {
        for (Review a : reviewDB){
            if (a.getReviewID().equals(reviewID))
                return a;
        }
        return null;
    }

    @Override
    public Review update(Review review) {
        Review oldReview = read(review.getReviewID());
        if(oldReview != null){
            reviewDB.remove(oldReview);
            reviewDB.add(review);
            return review;
        }
        return null;
    }

    @Override
    public boolean delete(String reviewID) {
        Review reviewToDelete = read(reviewID);
        if(reviewToDelete == null)
            return false;
        reviewDB.remove(reviewToDelete);
        return true;
    }

    @Override
    public Set<Review> getAll() {
        return reviewDB;
    }
}
