/* InvoiceServiceImpl.java
 Service implementation for the Invoice class
 Author: Ashton Williams (220468478)
 Date: 10 June 2023
*/
package za.ac.cput.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Invoice;
import za.ac.cput.repository.impl.InvoiceRepositoryImpl;
import za.ac.cput.service.InvoiceService;

import java.util.Set;
@Service
public class InvoiceServiceImpl implements InvoiceService {
    private static InvoiceServiceImpl service= null;
    private InvoiceRepositoryImpl repository= null;
    private InvoiceServiceImpl(){
        if(repository== null){
                repository= InvoiceRepositoryImpl.getRepository();
        }
    }
    public static InvoiceServiceImpl getService(){
        if(service== null){
            service= new InvoiceServiceImpl();
        }
        return service;
    }

    @Override
    public Invoice create(Invoice invoice) {
        return repository.create(invoice);
    }

    @Override
    public Invoice read(String id) {
        return repository.read(id);
    }

    @Override
    public Invoice update(Invoice invoice) {
        return repository.update(invoice);
    }

    @Override
    public Set<Invoice> getAll() {
        return repository.getAll();
    }
}