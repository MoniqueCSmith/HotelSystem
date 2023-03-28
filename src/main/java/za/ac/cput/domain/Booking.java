package za.ac.cput.domain;

import java.util.Date;
import java.util.Objects;

public class Booking {
    private String bookingId;
    private Date bookingDate;
    private Date bookingTime;
    private Date departureDate;
    private Date estDepartureTime;
    private int numAdults;
    private int numChildren;

    private String specialRequests;

    public Booking() {
    }

    public Booking(String bookingId, Date bookingDate, Date bookingTime, Date departureDate, Date estDepartureTime, int numAdults, int numChildren, String specialRequests) {
        this.bookingId = bookingId;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.departureDate = departureDate;
        this.estDepartureTime = estDepartureTime;
        this.numAdults = numAdults;
        this.numChildren = numChildren;
        this.specialRequests = specialRequests;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Date bookingTime) {
        this.bookingTime = bookingTime;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getEstDepartureTime() {
        return estDepartureTime;
    }

    public void setEstDepartureTime(Date estDepartureTime) {
        this.estDepartureTime = estDepartureTime;
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

    public String getSpecialRequests() {
        return specialRequests;
    }

    public void setSpecialRequests(String specialRequests) {
        this.specialRequests = specialRequests;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return numAdults == booking.numAdults && numChildren == booking.numChildren && Objects.equals(bookingId, booking.bookingId) && Objects.equals(bookingDate, booking.bookingDate) && Objects.equals(bookingTime, booking.bookingTime) && Objects.equals(departureDate, booking.departureDate) && Objects.equals(estDepartureTime, booking.estDepartureTime) && Objects.equals(specialRequests, booking.specialRequests);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, bookingDate, bookingTime, departureDate, estDepartureTime, numAdults, numChildren, specialRequests);
    }


    @Override
    public String  toString() {
        return "Booking{" +
                "bookingId='" + bookingId + '\'' +
                ", bookingDate=" + bookingDate +
                ", bookingTime=" + bookingTime +
                ", departureDate=" + departureDate +
                ", estDepartureTime=" + estDepartureTime +
                ", numAdults=" + numAdults +
                ", numChildren=" + numChildren +
                ", specialRequests='" + specialRequests + '\'' +
                '}';
    }
}
