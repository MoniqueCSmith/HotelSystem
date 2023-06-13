/**
 * ReviewServiceImplTest.java
 * Service Test class for the Review
 * Author: Shanlynn Courtney Thomas (218053762)
 * Date: 10 June 2023
 */

package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Review;
import za.ac.cput.factory.ReviewFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class ReviewServiceImplTest {
    private static ReviewServiceImpl service = ReviewServiceImpl.getService();
    private static Review review = ReviewFactory.buildReview(4,"Was the best experience ever!");

    @Test
    void a_create() {
        Review created = service.create(review);
        assertEquals(review.getReviewID(), created.getReviewID());
        System.out.println("Create:" + created);
    }

    @Test
    void b_read() {
        Review read = service.read(review.getReviewID());
        assertNotNull(read);
        System.out.println("Read:" + read);
    }

    @Test
    void c_delete() {
        boolean success = service.delete(review.getReviewID());
        assertTrue(success);
        System.out.println("Deleted:" + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all:");
        System.out.println(service.getAll());
    }
}
