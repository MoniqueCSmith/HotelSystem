/**
 * ReviewController.java
 * Controller class for the Review
 * Author: Shanlynn Courtney Thomas (218053762)
 * Date: 14 June 2023
 */

package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Review;
import za.ac.cput.factory.ReviewFactory;
import za.ac.cput.service.impl.ReviewServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private ReviewServiceImpl reviewService;

    @PostMapping("/create")
    public Review create(@RequestBody Review review){
        Review reviewCreated = ReviewFactory.buildReview(review.getRating(), review.getReviewComment());
        return reviewService.create(reviewCreated);
    }

    @GetMapping("/read/{id}")
    public Review read(@PathVariable String id){
        return reviewService.read(id);
    }


    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return reviewService.delete(id);
    }

    @RequestMapping("/getall")
    public Set<Review> getall(){
        return reviewService.getAll();
    }


}