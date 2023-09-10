/**
 * ReviewFactory.java
 * Factory class for the Review
 * Author: Shanlynn Courtney Thomas (218053762)
 * Date: 08 April 2023
 */
package za.ac.cput.factory;

import za.ac.cput.domain.Review;
import za.ac.cput.util.Helper;

public class ReviewFactory {
    public static Review buildReview(int rating, String reviewComment){
        if(Helper.isNullOrEmpty(String.valueOf(rating)) || Helper.isNullOrEmpty(reviewComment)){
            return null;
        }
        String reviewID = Helper.generateReviewID();
        return new Review.Builder()
                .setReviewID(reviewID)
                .setRating(rating)
                .setReviewComment(reviewComment)
                .build();

    }
}
