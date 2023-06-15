/* InvoiceServiceImplTest.java
 Service Test for the InvoiceService class
 Author: Ashton Williams (220468478)
 Date: 10 June 2023
*/
package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Invoice;
import za.ac.cput.factory.InvoiceFactory;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class InvoiceServiceImplTest {
    private static InvoiceServiceImpl service= InvoiceServiceImpl.getService();
    private static Invoice invoice= InvoiceFactory.createInvoice("Family Suite",3,8,3,1000,140,3000);

    @Test
    void a_create(){
        Invoice created= service.create(invoice);
        assertEquals(invoice.getInvoiceID(), created.getInvoiceID());
        System.out.println("This object has been created: " + created);
    }

    @Test
    void b_read(){
        Invoice read= service.read(invoice.getInvoiceID());
        assertNotNull(read);
        System.out.println("This has been read: " + read);
    }

    @Test
    void c_update(){
        Invoice updated= new Invoice.Builder().copy(invoice)
                .setTypeOfRoomBooked("Single Room")
                .setNumRoomsBooked(1)
                .setNumAdults(2)
                .setNumChildren(0)
                .setUnitPrice(600)
                .setVAT(124)
                .setTotalPrice(724)
                .build();
        assertNotNull(service.update(updated));
        System.out.println("The new invoice is: " + updated);
    }

    @Test
    void d_getAll(){
        System.out.println("Display all information: ");
        System.out.println(service.getAll());
    }
}