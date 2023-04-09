/* IInvoiceRepository.java
 Interface for the Invoice Repository class
 Author: Ashton Williams (220468478)
 Date: 08 April 2023
*/
package za.ac.cput.repository;

import za.ac.cput.domain.Invoice;
import java.util.Set;
public interface IInvoiceRepository extends IRepository<Invoice, String> {
    public Set<Invoice> getAll();
}
