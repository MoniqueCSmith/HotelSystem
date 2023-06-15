/* InvoiceRepositoryImplTest.java
 Reposiitory Test for the Invoice class
 Author: Ashton Williams (220468478)
 Date: 08 April 2023
*/
package za.ac.cput.repository;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Invoice;
import za.ac.cput.factory.InvoiceFactory;
import za.ac.cput.repository.impl.InvoiceRepositoryImpl;

@TestMethodOrder(MethodOrderer.MethodName.class)
class InvoiceRepositoryImplTest {

    private static InvoiceRepositoryImpl repository= InvoiceRepositoryImpl.getRepository();
    private static Invoice invoice= InvoiceFactory.createInvoice("Double Bed",1,2,0,800,112,800);

    @Test
    void a_create(){
        Invoice created= repository.create(invoice);
        assertEquals(invoice.getInvoiceID(), created.getInvoiceID());
        System.out.println("The object created: " + created);
    }

    @Test
    void b_read(){
        Invoice read= repository.read(invoice.getInvoiceID());
        assertNotNull(read);
        System.out.println("This has been read:" + read);
    }

    @Test
    void c_update(){
        Invoice updated= new Invoice.Builder().copy(invoice)
                .setTypeOfRoomBooked("Penthouse")
                .setNumRoomsBooked(2)
                .setNumAdults(8)
                .setNumChildren(5)
                .setUnitPrice(90000)
                .setVAT(12600)
                .setTotalPrice(180000)
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("The new invoice is: " + updated);
    }

    @Test
    void d_delete(){
        boolean success = repository.delete(invoice.getInvoiceID());
                assertTrue(success);
                System.out.println("Deleted: " + success);
    }

    @Test
    void e_getAll(){
        System.out.println("Display all information: ");
        System.out.println(repository.getAll());
    }
}
