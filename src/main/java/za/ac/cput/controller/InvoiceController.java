/* InvoiceController.java
 Controller for the Invoice class
 Author: Ashton Williams (220468478)
 Date: 15 June 2023
*/
package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Invoice;
import za.ac.cput.util.factory.InvoiceFactory;
import za.ac.cput.service.InvoiceService;
import java.util.Set;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @PostMapping("/create")
    public Invoice create(@RequestBody Invoice invoice){
        Invoice invoiceCreated= InvoiceFactory.createInvoice(invoice.getTypeOfRoomBooked(),invoice.getNumRoomsBooked(),
                invoice.getNumAdults(), invoice.getNumChildren(), invoice.getUnitPrice(),invoice.getVAT(), invoice.getTotalPrice());
        return invoiceService.create(invoiceCreated);
    }

    @GetMapping("/read/{id}")
    public Invoice read(@PathVariable String id){
        return invoiceService.read(id);
    }

    @PostMapping("/update")
    public Invoice update(@RequestBody Invoice invoice){
        return invoiceService.update(invoice);
    }

    @RequestMapping("/getall")
    public Set<Invoice> getall(){
        return invoiceService.getAll();
    }
}