
/*
ReservationDate.java
ReservationDate POJO class
Author : Kyra Petersen (219474559)
Date : 5 April 2023
*/

package za.ac.cput.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class ReservationDate implements Serializable {
    private String reservationID;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private LocalDateTime estCheckInTime;

    public ReservationDate() {
    }
    public String getReservationID() {
        return reservationID;
    }
    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public LocalDateTime getEstCheckInTime() {
        return estCheckInTime;
    }

    public ReservationDate(ReservationDate.Builder builder) {
        this.reservationID = builder.reservationID;
        this.checkInDate = builder.checkInDate;
        this.checkOutDate = builder.checkOutDate;
        this.estCheckInTime = builder.estCheckInTime;
    }

    public static class Builder {
        private String reservationID;
        private LocalDate checkInDate;
        private LocalDate checkOutDate;
        private LocalDateTime estCheckInTime;

        public Builder setReservationID(String reservationID) {
            this.reservationID = reservationID;
            return this;
        }

        public Builder setCheckInDate(LocalDate checkInDate) {
            this.checkInDate = checkInDate;
            return this;
        }

        public Builder setCheckOutDate(LocalDate checkOutDate) {
            this.checkOutDate = checkOutDate;
            return this;
        }

        public Builder setEstCheckInTime(LocalDateTime estCheckInTime) {
            this.estCheckInTime = estCheckInTime;
            return this;
        }


        @Override
        public String toString() {
            return "ReservationDate{" +
                    "reservationID='" + reservationID + '\'' +
                    ", checkInDate=" + checkInDate +
                    ", checkOutDate=" + checkOutDate +
                    ", estCheckInTime=" + estCheckInTime +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ReservationDate that = (ReservationDate) o;
            return Objects.equals(reservationID, that.reservationID) && Objects.equals(checkInDate, that.checkInDate) && Objects.equals(checkOutDate, that.checkOutDate) && Objects.equals(estCheckInTime, that.estCheckInTime);
        }

        @Override
        public int hashCode() {
            return Objects.hash(reservationID, checkInDate, checkOutDate, estCheckInTime);
        }
        public Builder copy(ReservationDate reservationDate) {

            this.reservationID = reservationDate.reservationID;
            this.checkInDate = reservationDate.checkInDate;
            this.checkOutDate = reservationDate.checkOutDate;
            this.estCheckInTime = reservationDate.estCheckInTime;
            return this;
        }

        public ReservationDate build() {
            return new ReservationDate(this);

        }
    }

}


