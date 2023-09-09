package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Review;
import za.ac.cput.util.factory.ReviewFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class ReviewServiceImplTest {

    @Autowired
    private ReviewServiceImpl service;
    private static Review review = ReviewFactory.buildReview(5, "such an amazing experience.");

    @Test
    void a_create(){
        Review create = service.create(review);
        assertEquals(review.getReviewID(), create.getReviewID());
        System.out.println("created" + create);
    }

    @Test
    void b_read(){
        Review read = service.read(review.getReviewID());
        assertNotNull(read);
        System.out.println("read" + read);
    }

    @Test
    @Disabled
    void c_delete(){
        boolean success = service.delete(review.getReviewID());
        assertTrue(success);
        System.out.println("Deleted:" + success);
    }

    @Test
    void d_getAll(){
        System.out.println("Get All:");
        System.out.println(service.getAll());
    }

}
