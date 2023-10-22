package za.ac.cput.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class ReservationInput {
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private LocalTime estCheckInTime;
    private Boolean termsAndConditions;
    private Boolean isChild;

    public ReservationInput() {
        this.checkInDate = LocalDate.parse("2023-10-05");
        this.checkOutDate = LocalDate.parse("2023-10-06");
        this.estCheckInTime = LocalTime.parse("00:00");
        this.termsAndConditions = false;
        this.isChild = false
        ;
    }
    public ReservationInput(Builder builder) {
        this.checkInDate = builder.checkInDate;
        this.checkOutDate = builder.checkOutDate;
        this.estCheckInTime = builder.estCheckInTime;
        this.termsAndConditions = builder.termsAndConditions;
        this.isChild = builder.isChild;
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

    public Boolean getTermsAndConditions() {
        return termsAndConditions;
    }

    public Boolean getChild() {
        return isChild;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationInput that = (ReservationInput) o;
        return Objects.equals(checkInDate, that.checkInDate) && Objects.equals(checkOutDate, that.checkOutDate) && Objects.equals(estCheckInTime, that.estCheckInTime) && Objects.equals(termsAndConditions, that.termsAndConditions) && Objects.equals(isChild, that.isChild);
    }

    @Override
    public int hashCode() {
        return Objects.hash(checkInDate, checkOutDate, estCheckInTime, termsAndConditions, isChild);
    }


    @Override
    public String toString() {
        return "ReservationInput{" +
                "checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", estCheckInTime=" + estCheckInTime +
                ", termsAndConditions=" + termsAndConditions +
                ", isChild=" + isChild +
                '}';
    }

    public static class Builder {
        private LocalDate checkInDate;
        private LocalDate checkOutDate;
        private LocalTime estCheckInTime;
        private Boolean termsAndConditions;
        private Boolean isChild;

        public Builder() {}

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

        public Builder setTermsAndConditions(Boolean termsAndConditions) {
            this.termsAndConditions = termsAndConditions;
            return this;
        }

        public Builder setIsChild(Boolean isChild) {
            this.isChild = isChild;
            return this;
        }

        public ReservationInput copy() {
            return new ReservationInput(this);
        }

        public ReservationInput build() {
            return new ReservationInput(this);
        }
    }
}

