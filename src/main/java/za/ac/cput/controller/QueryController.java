/**
 * QueryController.java
 * Controller class for Query
 * Author: Brandon Wise - 220049173
 * Date: 14 June 2023
 */
package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Query;
import za.ac.cput.factory.QueryFactory;
import za.ac.cput.service.impl.QueryServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/query")
public class QueryController {
    @Autowired
    private QueryServiceImpl queryService;

    //@RequestMapping(value = "/create", method = RequestMethod.POST)
    @PostMapping("/create")
    public Query create(@RequestBody Query query){
        Query queryCreated = QueryFactory.buildQuery(query.getTitle(), query.getEmail(), query.getDescription());
        return queryService.create(queryCreated);
    }
    @GetMapping("/read/{id}")
    public Query read(@PathVariable String id){
        return queryService.read(id);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return queryService.delete(id);
    }

    @RequestMapping("/getall")
    public List<Query> getall(){
        return queryService.getAll();
    }
}
