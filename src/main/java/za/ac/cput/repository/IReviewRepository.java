package za.ac.cput.repository;

import za.ac.cput.domain.Review;

import java.util.Set;

public interface IReviewRepository extends IRepository<Review, String>{
    public Set<Review> getAll();
}
