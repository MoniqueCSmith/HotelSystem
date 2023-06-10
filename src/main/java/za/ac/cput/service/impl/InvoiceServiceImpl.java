/* InvoiceServiceImpl.java
 Service implementation for the Invoice class
 Author: Ashton Williams (220468478)
 Date: 10 June 2023
*/
package za.ac.cput.service.impl;

import za.ac.cput.domain.Invoice;
import za.ac.cput.repository.InvoiceRepository;
import za.ac.cput.service.InvoiceService;

import java.util.Set;

public class InvoiceServiceImpl implements InvoiceService {
    private static InvoiceServiceImpl service= null;
    private InvoiceRepository repository= null;
    private InvoiceServiceImpl(){
        if(repository== null){
                repository= InvoiceRepository.getRepository();
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
    public Invoice read(Invoice id) {
        return repository.read(id.getInvoiceID());
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