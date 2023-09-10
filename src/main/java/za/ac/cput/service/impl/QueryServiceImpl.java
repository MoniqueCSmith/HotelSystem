/**
 * QueryServiceImpl.java
 * Service class for the QueryImpl
 * Author: Brandon Wise (220049173)
 * Date: 09 June 2023
 */
package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Query;
import za.ac.cput.repository.IQueryRepository;
import za.ac.cput.service.QueryService;

import java.util.List;

@Service
public class QueryServiceImpl implements QueryService {
    private IQueryRepository repository;
@Autowired
    private QueryServiceImpl(IQueryRepository repository) { this.repository = repository; }

    @Override
    public Query create(Query query) {
        return this.repository.save(query);
    }

    @Override
    public Query read(String refNo) {
        return this.repository.findById(refNo).orElse(null);
    }
    @Override
    public boolean delete(String refNo) {
        if (this.repository.existsById(refNo)) {
            this.repository.deleteById(refNo);
            return true;
        }
        return false;
    }
    @Override
    public List<Query> getAll() {
    return this.repository.findAll();
    }
}
