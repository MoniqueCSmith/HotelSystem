package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Invoice;
import za.ac.cput.factory.InvoiceFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class InvoiceServiceImplTest {

    @Autowired
    private InvoiceServiceImpl service;

    private static Invoice invoice= InvoiceFactory.createInvoice("Single",1,
            2,0,1000,140,1140);

    @Test
    void a_create() {
        Invoice created = service.create(invoice);
        assertEquals(invoice.getInvoiceID(), created.getInvoiceID());
        System.out.println("This has been created: " + created);
    }

    @Test
    void b_read() {
        Invoice read= service.read(invoice.getInvoiceID());
        assertNotNull(read);
        System.out.println("This has been read: " + read);
    }

    @Test
    void c_update() {
        Invoice newInvoice= new Invoice.Builder().copy(invoice)
                .setNumAdults(1)
                .build();
        Invoice updated= service.update(newInvoice);
        assertEquals(newInvoice.getNumAdults(), updated.getNumAdults());
        System.out.println("This has been updated" + updated);
    }

    @Test
    void d_getAll() {
        System.out.println("This is what has been fetched:");
        System.out.println(service.getAll());
    }
}