/**
 * Review.java
 * Entity class for the Review
 * Author: Shanlynn Courtney Thomas (218053762)
 * Date: 08 April 2023
 */
package za.ac.cput.domain;

import java.io.Serializable;

public class Review implements Serializable {
    private String reviewID;
    private int rating;
    private String reviewComment;

    private Review(){}

    private Review(Builder builder){
        this.reviewID = builder.reviewID;
        this.rating = builder.rating;
        this.reviewComment = builder.reviewComment;
    }

    public String getReviewID() {
        return reviewID;
    }

    public void setReviewID(String reviewID) {
        this.reviewID = reviewID;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReviewComment() {
        return reviewComment;
    }

    public void setReviewComment(String reviewComment) {
        this.reviewComment = reviewComment;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewID='" + reviewID + '\'' +
                ", rating=" + rating +
                ", reviewComment='" + reviewComment + '\'' +
                '}';
    }

    public static class Builder {
        private String reviewID;
        private int rating;
        private String reviewComment;

        public Builder setReviewID(String reviewID){
            this.reviewID = reviewID;
            return this;
        }
        public Builder setRating(int rating){
            this.rating = rating;
            return this;
        }
        public Builder setReviewComment(String reviewComment){
            this.reviewComment = reviewComment;
            return this;
        }
        public Builder copy(Review review){
            this.reviewID = review.reviewID;
            this.rating = review.rating;
            this.reviewComment = review.reviewComment;
            return this;
        }
        public Review build(){
            return new Review(this);
        }

    }
}
