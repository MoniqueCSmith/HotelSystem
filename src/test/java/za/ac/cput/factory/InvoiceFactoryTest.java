/* InvoiceFactoryTest.java
Factory test class for Invoice
 Author: Ashton Williams (220468478)
 Date: 08 April 2023
*/
package za.ac.cput.factory;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Invoice;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class InvoiceFactoryTest {
    @Test
    public void createInvoice(){

        Invoice invoice = InvoiceFactory.createInvoice("Deluxe", 2, 2, 1, 100.00, 14.00, 224.00);
        assertNotNull(invoice);
        assertNotNull(invoice.getInvoiceID());
        assertEquals("Deluxe", invoice.getTypeOfRoomBooked());
        assertEquals(2, invoice.getNumRoomsBooked());
        assertEquals(2, invoice.getNumAdults());
        assertEquals(1, invoice.getNumChildren());
        assertEquals(100.00, invoice.getUnitPrice());
        assertEquals(14.00, invoice.getVAT());
        assertEquals(224.00, invoice.getTotalPrice());
    }

}
