package za.ac.cput.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import org.junit.jupiter.api.Test;

import za.ac.cput.domain.Invoice;
import za.ac.cput.util.Helper;

public class InvoiceRepositoryTest {
    private InvoiceRepository repository;
    private Invoice invoice;
    @BeforeEach
    void setUp() {
        repository = InvoiceRepository.getRepository();
        invoice = new Invoice.Builder()
                .setInvoiceID(Helper.generateUniqueID())
                .setTypeOfRoomBooked("Double")
                .setNumRoomsBooked(1)
                .setNumAdults(2)
                .setNumChildren(1)
                .setUnitPrice(1500.00)
                .setVAT(225.00)
                .setTotalPrice(1725.00)
                .build();
    }

    @Test
    void create() {
        Invoice savedInvoice = repository.create(invoice);
        assertNotNull(savedInvoice);
        assertEquals(invoice.getInvoiceID(), savedInvoice.getInvoiceID());
    }

    @Test
    void read() {
        repository.create(invoice);
        Invoice foundInvoice = repository.read(invoice.getInvoiceID());
        assertNotNull(foundInvoice);
        assertEquals(invoice.getInvoiceID(), foundInvoice.getInvoiceID());
    }

    @Test
    void update() {
        repository.create(invoice);
        Invoice updatedInvoice = new Invoice.Builder()
                .copy(invoice)
                .setTypeOfRoomBooked("Single")
                .build();
        Invoice savedInvoice = repository.update(updatedInvoice);
        assertNotNull(savedInvoice);
        assertEquals(updatedInvoice.getTypeOfRoomBooked(), savedInvoice.getTypeOfRoomBooked());
    }

    @Test
    void delete() {
        repository.create(invoice);
        boolean deleted = repository.delete(invoice.getInvoiceID());
        assertTrue(deleted);
        assertNull(repository.read(invoice.getInvoiceID()));
    }

    @Test
    void getAll() {
        repository.create(invoice);
        assertEquals(2, repository.getAll().size());
    }

}
