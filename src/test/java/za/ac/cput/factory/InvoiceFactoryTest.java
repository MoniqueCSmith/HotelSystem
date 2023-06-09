/* InvoiceFactoryTest.java
Factory test class for Invoice
 Author: Ashton Williams (220468478)
 Date: 08 April 2023
*/
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Invoice;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceFactoryTest {
    @Test
    public void createInvoice(){
        Invoice invoice = InvoiceFactory.createInvoice("Deluxe", 2, 2, 1, 100.00, 14.00, 224.00);
        assertNotNull(invoice);
        System.out.println(invoice);
    }
}
