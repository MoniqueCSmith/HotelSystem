/* InvoiceService.java
 Service interface for the InvoiceServiceImpl class
 Author: Ashton Williams (220468478)
 Date: 10 June 2023
*/

package za.ac.cput.service;

import za.ac.cput.domain.Invoice;

import java.util.Set;

public interface InvoiceService {

    Invoice create(Invoice invoice);
    Invoice read(Invoice id);
    Invoice update(Invoice invoice);
    Set<Invoice> getAll();
}
