/* Invoice.java
  POJO for Invoice class
 Author: Ashton Williams (220468478)
 Date: 08 April 2023
*/

package za.ac.cput.domain;
public class Invoice {

   private String invoiceID;
   private String typeOfRoomBooked;
   private int numRoomsBooked;
   private int numAdults;
   private int numChildren;
   private double unitPrice;
   private double VAT;
   private double totalPrice;



   private Invoice(Builder builder){
      this.invoiceID= builder.invoiceID;
      this.typeOfRoomBooked= builder.typeOfRoomBooked;
      this.numRoomsBooked= builder.numRoomsBooked;
      this.numAdults= builder.numAdults;
      this.numChildren= builder.numChildren;
      this.unitPrice= builder.unitPrice;
      this.VAT= builder.VAT;
      this.totalPrice= builder.totalPrice;
   }

   public String getInvoiceID() {
      return invoiceID;
   }

   public void setInvoiceID(String invoiceID) {
      this.invoiceID = invoiceID;
   }

   public String getTypeOfRoomBooked() {
      return typeOfRoomBooked;
   }

   public void setTypeOfRoomBooked(String typeOfRoomBooked) {
      this.typeOfRoomBooked = typeOfRoomBooked;
   }

   public int getNumRoomsBooked() {
      return numRoomsBooked;
   }

   public void setNumRoomsBooked(int numRoomsBooked) {
      this.numRoomsBooked = numRoomsBooked;
   }

   public int getNumAdults() {
      return numAdults;
   }

   public void setNumAdults(int numAdults) {
      this.numAdults = numAdults;
   }

   public int getNumChildren() {
      return numChildren;
   }

   public void setNumChildren(int numChildren) {
      this.numChildren = numChildren;
   }

   public double getUnitPrice() {
      return unitPrice;
   }

   public void setUnitPrice(double unitPrice) {
      this.unitPrice = unitPrice;
   }

   public double getVAT() {
      return VAT;
   }

   public void setVAT(double VAT) {
      this.VAT = VAT;
   }
   public double getTotalPrice() {
      return totalPrice;
   }

   public void setTotalPrice(double totalPrice) {
      this.totalPrice = totalPrice;
   }

   @Override
   public String toString() {
      return "Invoice{" +
              "invoiceID='" + invoiceID + '\'' +
              ", typeOfRoomBooked='" + typeOfRoomBooked + '\'' +
              ", numRoomsBooked=" + numRoomsBooked + '\'' +
              ", numAdults=" + numAdults + '\'' +
              ", numChildren=" + numChildren + '\'' +
              ", unitPrice=" + unitPrice + '\'' +
              ", VAT=" + VAT +  '\'' +
              ", totalPrice=" + totalPrice +
              '}';
   }

   public static class Builder{

      private String invoiceID;
      private String typeOfRoomBooked;
      private int numRoomsBooked;
      private int numAdults;
      private int numChildren;
      private double unitPrice;
      private double VAT;
      private double totalPrice;

      public Builder setInvoiceID(String invoiceID) {
         this.invoiceID = invoiceID;
         return this;
      }

      public Builder setTypeOfRoomBooked(String typeOfRoomBooked) {
         this.typeOfRoomBooked = typeOfRoomBooked;
         return this;
      }

      public Builder setNumRoomsBooked(int numRoomsBooked) {
         this.numRoomsBooked = numRoomsBooked;
         return this;
      }

      public Builder setNumAdults(int numAdults) {
         this.numAdults = numAdults;
         return this;
      }

      public Builder setNumChildren(int numChildren) {
         this.numChildren = numChildren;
         return this;
      }

      public Builder setUnitPrice(double unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public Builder setVAT(double VAT) {
         this.VAT = VAT;
         return this;
      }

      public Builder setTotalPrice(double totalPrice) {
         this.totalPrice = totalPrice;
         return this;
      }

      public Builder copy(Invoice invoice){
         this.invoiceID= invoice.invoiceID;
         this.typeOfRoomBooked= invoice.typeOfRoomBooked;
         this.numRoomsBooked= invoice.numRoomsBooked;
         this.numAdults= invoice.numAdults;
         this.numChildren= invoice.numChildren;
         this.unitPrice= invoice.unitPrice;
         this.VAT= invoice.VAT;
         this.totalPrice= invoice.totalPrice;

         return this;
      }

      public Invoice build(){
         return new Invoice(this);
      }
   }
}
