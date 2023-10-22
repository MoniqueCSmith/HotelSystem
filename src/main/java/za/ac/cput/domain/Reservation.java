package za.ac.cput.domain;

import jakarta.persistence.*;
import za.ac.cput.factory.GuestFactory;
import za.ac.cput.factory.HotelLocationFactory;
import za.ac.cput.factory.ReservationDateFactory;
import za.ac.cput.factory.ReviewFactory;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Reservation")
public class Reservation {
    @Id
    private String reservationID;
    private LocalDateTime reservationTimeCreated;
    private String reservationStatus;
    private Boolean termsAndConditions;
    private Boolean isChild;

    public static int nextReservationId = 1;

    // Default values for guest, hotelLocation, and review
    private static Guest defaultGuest = GuestFactory.createGuest();
    private static HotelLocation defaultHotelLocation = HotelLocationFactory.createHotelLocation("51 Miltion Street Tygervalley", "Cape Town", "Western Cape", 7411, "0213109070");
    private static Review defaultReview = ReviewFactory.buildReview(5, "The best experience I've ever had!");

    public static ReservationDate defaultReservationDate = ReservationDateFactory.buildReservationDate(
            LocalDate.of(2023, 9, 1), LocalDate.of(2023, 9, 4), LocalTime.of(15, 30));

    @Embedded
    private ReservationDate reservationDate;

    @OneToOne
    @JoinColumn(name = "guest_id")
    private Guest guest;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID", referencedColumnName = "ID")
    private HotelLocation hotelLocation;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reviewID", referencedColumnName = "reviewID")
    private Review review;

    /*@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "memberID", referencedColumnName = "memberID")
    private Member member;*/

    /*@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "reservation_review", joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "review_id"))
    protected Set<Review> reviews = new HashSet<>();*/


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "reservation_room",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "room_no")
    )
    private Set<Room> rooms = new HashSet<>();

    // Add methods to manage the rooms in the reservation
  /*  public void addRoom(Room room) {
        rooms.add(room);
        room.getReservations().add(this);
    }*/

/*public void removeRoom(Room room) {
        rooms.remove(room);
        room.getReservations().remove(this);
    }*/

    protected Reservation() {
    }

    private Reservation(Builder builder) {
        this.reservationID = builder.reservationID;
        this.reservationTimeCreated = builder.reservationTimeCreated;
        this.reservationStatus = builder.reservationStatus;
        this.termsAndConditions = builder.termsAndConditions;
        this.isChild = builder.isChild;
        this.reservationDate = builder.reservationDate;
        this.guest = builder.guest != null ? builder.guest : defaultGuest;
        this.hotelLocation = builder.hotelLocation != null ? builder.hotelLocation : defaultHotelLocation;
        this.review = builder.review != null ? builder.review : defaultReview;
    }

    public String getReservationID() {
        return reservationID;
    }

    public LocalDateTime getReservationTimeCreated() {
        return reservationTimeCreated;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    public Boolean getTermsAndConditions() {
        return termsAndConditions;
    }

    public Boolean getIsChild() {
        return isChild;
    }

    public ReservationDate getReservationDate() {
        return reservationDate;
    }

    public Guest getGuest() {
        return guest;
    }

    public HotelLocation getHotelLocation() {
        return hotelLocation;
    }

    /*public Member getMember() {
        return member;
    }*/

    public Review getReview() {
        return review;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(reservationID, that.reservationID) && Objects.equals(reservationTimeCreated, that.reservationTimeCreated) && Objects.equals(reservationStatus, that.reservationStatus) && Objects.equals(termsAndConditions, that.termsAndConditions) && Objects.equals(isChild, that.isChild) && Objects.equals(reservationDate, that.reservationDate) && Objects.equals(guest, that.guest) && Objects.equals(hotelLocation, that.hotelLocation) && Objects.equals(review, that.review);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservationID, reservationTimeCreated, reservationStatus, termsAndConditions, isChild, reservationDate, guest, hotelLocation);
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationID='" + reservationID + '\'' +
                ", reservationTimeCreated=" + reservationTimeCreated +
                ", reservationStatus='" + reservationStatus + '\'' +
                ", termsAndConditions=" + termsAndConditions +
                ", isChild=" + isChild +
                ", reservationDate=" + reservationDate +
                ", guest=" + guest +
                ", hotelLocation=" + hotelLocation +
                /*  ", member=" + member +*/
                ", review=" + review +
                '}';
    }

    public static class Builder {
        private String reservationID;
        private LocalDateTime reservationTimeCreated;
        private String reservationStatus;
        private Boolean termsAndConditions;
        private Boolean isChild;
        private ReservationDate reservationDate;
        private Guest guest;
        private HotelLocation hotelLocation;
        /*private Member member;*/

        private Review review;

        public Builder setReservationID(String reservationID) {
            this.reservationID = reservationID;
            return this;
        }

        public Builder setReservationTimeCreated(LocalDateTime reservationTimeCreated) {
            this.reservationTimeCreated = reservationTimeCreated;
            return this;
        }

        public Builder setReservationStatus(String reservationStatus) {
            this.reservationStatus = reservationStatus;
            return this;
        }

        public Builder setTermsAndConditions(Boolean termsAndConditions) {
            this.termsAndConditions = termsAndConditions;
            return this;
        }

        public Builder setIsChild(Boolean isChild) {
            this.isChild = isChild;
            return this;
        }

        public Builder setReservationDate(ReservationDate reservationDate) {
            this.reservationDate = reservationDate;
            return this;
        }

        public Builder setGuest(Guest guest) {
            this.guest = guest;
            return this;
        }

        public Builder setHotelLocation(HotelLocation hotelLocation) {
            this.hotelLocation = hotelLocation;
            return this;
        }

        /*public Builder setMember(Member member) {
            this.member = member;
            return this;
        }*/

        public Builder setReview(Review review) {
            this.review = review;
            return this;
        }

        public Builder copy(Reservation reservation) {
            this.reservationID = reservation.getReservationID();
            this.reservationTimeCreated = reservation.getReservationTimeCreated();
            this.reservationStatus = reservation.getReservationStatus();
            this.termsAndConditions = reservation.getTermsAndConditions();
            this.isChild = reservation.getIsChild();
            this.reservationDate = reservation.reservationDate;
            this.guest = reservation.guest;
            this.hotelLocation = reservation.getHotelLocation();
            this.review = reservation.getReview();
            return this;
        }

        public Reservation build() {
            return new Reservation(this);
        }
    }
}


