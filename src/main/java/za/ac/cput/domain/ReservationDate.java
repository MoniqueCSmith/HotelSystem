/*
ReservationDate.java
ReservationDate POJO class
Author : Kyra Petersen (219474559)
Date : 5 April 2023
*/

package za.ac.cput.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable
public class ReservationDate implements Serializable {
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private LocalDateTime estCheckInTime;

    protected ReservationDate() {
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

        this.checkInDate = builder.checkInDate;
        this.checkOutDate = builder.checkOutDate;
        this.estCheckInTime = builder.estCheckInTime;

    }

    public static class Builder {

        private LocalDate checkInDate;
        private LocalDate checkOutDate;
        private LocalDateTime estCheckInTime;



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
                    '\'' +
                    ", checkInDate=" + checkInDate +
                    ", checkOutDate=" + checkOutDate +
                    ", estCheckInTime=" + estCheckInTime +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return Objects.equals(checkInDate, builder.checkInDate) && Objects.equals(checkOutDate, builder.checkOutDate) && Objects.equals(estCheckInTime, builder.estCheckInTime);
        }

        @Override
        public int hashCode() {
            return Objects.hash(checkInDate, checkOutDate, estCheckInTime);
        }

        public ReservationDate build() {
            return new ReservationDate(this);

        }
    }

}

