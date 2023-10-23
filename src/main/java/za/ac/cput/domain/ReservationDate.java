
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
import java.time.LocalTime;
import java.util.Objects;

@Embeddable
public class ReservationDate  {
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private LocalTime estCheckInTime;

    protected ReservationDate() {
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public LocalTime getEstCheckInTime() {
        return estCheckInTime;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public void setEstCheckInTime(LocalTime estCheckInTime) {
        this.estCheckInTime = estCheckInTime;
    }

    public ReservationDate(Builder builder) {

        this.checkInDate = builder.checkInDate;
        this.checkOutDate = builder.checkOutDate;
        this.estCheckInTime = builder.estCheckInTime;

    }

    @Override
    public String toString() {
        return "ReservationDate{" +
                "checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", estCheckInTime=" + estCheckInTime +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationDate that = (ReservationDate) o;
        return Objects.equals(checkInDate, that.checkInDate) && Objects.equals(checkOutDate, that.checkOutDate) && Objects.equals(estCheckInTime, that.estCheckInTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(checkInDate, checkOutDate, estCheckInTime);
    }

    public static class Builder {

        private LocalDate checkInDate;
        private LocalDate checkOutDate;
        private LocalTime estCheckInTime;



        public Builder setCheckInDate(LocalDate checkInDate) {
            this.checkInDate = checkInDate;
            return this;
        }

        public Builder setCheckOutDate(LocalDate checkOutDate) {
            this.checkOutDate = checkOutDate;
            return this;
        }

        public Builder setEstCheckInTime(LocalTime estCheckInTime) {
            this.estCheckInTime = estCheckInTime;
            return this;
        }

        public ReservationDate build() {
            return new ReservationDate(this);

        }
    }

}






