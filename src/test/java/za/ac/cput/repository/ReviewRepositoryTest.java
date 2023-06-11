/**
 * ReviewRepositoryTest.java
 * Repository Test class for the Review
 * Author: Shanlynn Courtney Thomas (218053762)
 * Date: 08 April 2023
 */
package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Review;
import za.ac.cput.factory.ReviewFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class ReviewRepositoryTest {
    private static ReviewRepository repository = ReviewRepository.getRepository();
    private static Review review = ReviewFactory.buildReview(4, "Was a blissful experience!");

    @Test
    void a_create() {
        Review created = repository.create(review);
        assertEquals(review.getReviewID(), created.getReviewID());
        System.out.println("Create:" + created);
    }

    @Test
    void b_read() {
        Review read = repository.read(review.getReviewID());
        assertNotNull(read);
        System.out.println("Read:" + read);
    }

    @Test
    void c_update() {
        Review updated = new Review.Builder().copy(review).setRating(5)
                .setReviewComment("Great experience. If I could give it a higher rating, I would. 10/10 service.")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated:" + updated);
    }

        @Test
    void d_delete() {
        boolean success = repository.delete(review.getReviewID());
        assertTrue(success);
        System.out.println("Deleted" + success);
    }

    @Test
    void e_getAll() {
        System.out.println("Show all:");
        System.out.println(repository.getAll());
    }
}