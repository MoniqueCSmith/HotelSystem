/* InvoiceRepositoryImpl.java
 Repository for the Invoice class
 Author: Ashton Williams (220468478)
 Date: 08 April 2023
*/
package za.ac.cput.repository.impl;

import za.ac.cput.domain.Invoice;
import za.ac.cput.repository.IInvoiceRepository;

import java.util.HashSet;
import java.util.Set;

public class InvoiceRepositoryImpl implements IInvoiceRepository {

    private static InvoiceRepositoryImpl repository = null;
    private Set<Invoice> invoiceDB= null;

    private InvoiceRepositoryImpl() {
        invoiceDB = new HashSet<Invoice>();
    }

    public static InvoiceRepositoryImpl getRepository() {
        if (repository == null) {
                repository = new InvoiceRepositoryImpl();
            }
            return repository;
        }

    @Override
    public Invoice create(Invoice invoice) {
        boolean success = invoiceDB.add(invoice);
            if(!success)
                return null;

                return invoice;
        }

    @Override
    public Invoice read(String invoiceID) {
        for (Invoice i : invoiceDB) {
            if (i.getInvoiceID().equals(invoiceID))
                return i;
            }
                return null;
        }

    @Override
    public Invoice update(Invoice invoice) {

        Invoice oldInvoice = read(invoice.getInvoiceID());
        if (oldInvoice != null) {
            invoiceDB.remove(oldInvoice);
            invoiceDB.add(invoice);
            return invoice;
        }
            return null;
    }

    @Override
    public boolean delete(String invoiceID) {
        Invoice invoiceToDelete = read(invoiceID);
            if(invoiceToDelete == null)
                return false;
            invoiceDB.remove(invoiceToDelete);
            return true;
    }

    @Override
    public Set<Invoice> getAll() {
        return invoiceDB;
        }

    }