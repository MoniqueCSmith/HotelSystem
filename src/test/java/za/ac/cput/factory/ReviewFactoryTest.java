package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Review;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ReviewFactoryTest {
    @Test
    void buildReview() {
        Review review = ReviewFactory.buildReview(4, "This was a very pleasant stay. Would recommend");
        assertNotNull(review);
        System.out.println(review);
    }
}

