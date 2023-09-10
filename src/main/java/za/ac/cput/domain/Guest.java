package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Guest implements Serializable {
    @Id
    private String guestID;

    public static int nextGuestId = 1;
    public Guest() {
    }

    public Guest(Builder builder) {
        this.guestID = builder.guestID;
    }

    public String getGuestID() {
        return guestID;
    }

    public void setGuestID(String guestID) {
        this.guestID = guestID;
    }

    public static class Builder {
        private String guestID;

        public Builder setGuestID(String guestID) {
            this.guestID = guestID;
            return this;
        }

        public Builder copy(Guest guest) {
            this.guestID = guest.guestID;
            return this;
        }

        public Guest build() {
            return new Guest(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guest guest = (Guest) o;
        return Objects.equals(guestID, guest.guestID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guestID);
    }

    @Override
    public String toString() {
        return "Guest{" +
                "guestID='" + guestID + '\'' +
                '}';
    }
}
