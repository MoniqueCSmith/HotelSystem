/*
Reservation.java
Reservation POJO class
Author : Kyra Petersen (219474559)
Date : 5 April 2023
*/

package za.ac.cput.domain;


import java.time.LocalDateTime;
import java.util.Objects;

public class Reservation {

    private String reservationID;
    private LocalDateTime reservationTimeCreated;
    private String reservationStatus;
    private Boolean termsAndConditions;
    private ReservationDate reservationDate;


    private Reservation(Builder builder) {

        this.reservationID = builder.reservationID;
        this.reservationTimeCreated = builder.reservationTimeCreated;
        this.reservationStatus = builder.reservationStatus;
        this.termsAndConditions = builder.termsAndConditions;
        this.reservationDate = builder.reservationDate;
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

    public ReservationDate getReservationDate() {
        return reservationDate;
    }

    public static class Builder {
        private String reservationID;
        private LocalDateTime reservationTimeCreated;
        private String reservationStatus;
        private Boolean termsAndConditions;
        private ReservationDate reservationDate;

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

        public Builder setReservationDate(ReservationDate reservationDate) {
            this.reservationDate = reservationDate;
            return this;
        }

        public Builder copy(Reservation reservation) {
            this.reservationID = reservation.getReservationID();
            this.reservationTimeCreated = reservation.getReservationTimeCreated();
            this.reservationStatus = reservation.getReservationStatus();
            this.termsAndConditions = reservation.getTermsAndConditions();
            this.reservationDate = reservation.reservationDate;
            return this;
        }


        public Reservation build() {
            return new Reservation(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(reservationID, that.reservationID) && Objects.equals(reservationTimeCreated, that.reservationTimeCreated) && Objects.equals(reservationStatus, that.reservationStatus) && Objects.equals(termsAndConditions, that.termsAndConditions) && Objects.equals(reservationDate, that.reservationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservationID, reservationTimeCreated, reservationStatus, termsAndConditions, reservationDate);
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationID='" + reservationID + '\'' +
                ", reservationTimeCreated=" + reservationTimeCreated +
                ", reservationStatus='" + reservationStatus + '\'' +
                ", termsAndConditions=" + termsAndConditions +
                ", reservationDate=" + reservationDate +
                '}';
    }
}