/* InvoiceServiceImpl.java
 Service implementation for the Invoice class
 Author: Ashton Williams (220468478)
 Date: 10 June 2023
*/
package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Invoice;
import za.ac.cput.repository.IInvoiceRepository;
import za.ac.cput.service.InvoiceService;

import java.util.List;
@Service
public class InvoiceServiceImpl implements InvoiceService {
    private IInvoiceRepository repository;

    @Autowired
    private InvoiceServiceImpl(IInvoiceRepository repository){
        this.repository= repository;
    }

    @Override
    public Invoice create(Invoice invoice) {
        return this.repository.save(invoice);
    }

    @Override
    public Invoice read(String invoiceID) {
        return this.repository.findById(invoiceID).orElse(null);
    }

    @Override
    public Invoice update(Invoice invoice) {
        if(this.repository.existsById(invoice.getInvoiceID())){
            return this.repository.save(invoice);
        }
        return null;
    }

    @Override
    public List<Invoice> getAll() {
        return this.repository.findAll();
    }
}
