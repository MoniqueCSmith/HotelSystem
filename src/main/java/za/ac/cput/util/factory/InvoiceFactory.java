/* InvoiceFactory.java
 Factory for Invoice class
 Author: Ashton Williams (220468478)
 Date: 08 April 2023
*/

package za.ac.cput.util.factory;

import za.ac.cput.domain.Invoice;
import za.ac.cput.util.Helper;

public class InvoiceFactory {


    public static Invoice createInvoice(String typeOfRoomBooked, int numRoomsBooked,
                                        int numAdults, int numChildren, double unitPrice, double VAT, double totalPrice) {

        if(Helper.isNullOrEmpty(typeOfRoomBooked)){
            return null;
        }
        if(Helper.isValidInt(numAdults)|| Helper.isValidInt(numChildren)){
            return null;
        }
        if(Helper.isValidDouble(unitPrice)|| Helper.isValidDouble(VAT)||Helper.isValidDouble(totalPrice)){
           return null;
        }

        String invoiceID = Helper.generateID();

        return new Invoice.Builder()

                .setInvoiceID(invoiceID)
                .setTypeOfRoomBooked(typeOfRoomBooked)
                .setNumRoomsBooked(numRoomsBooked)
                .setNumAdults(numAdults)
                .setNumChildren(numChildren)
                .setUnitPrice(unitPrice)
                .setVAT(VAT)
                .setTotalPrice(totalPrice)
                .build();
    }

}
