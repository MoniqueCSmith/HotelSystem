package za.ac.cput.domain;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Guest implements Serializable {
    @Id
    private String guestID;
    @Embedded
    private User user;

    @OneToOne(mappedBy = "guest")
    private Reservation reservation;

    public static int nextGuestId = 1;
    public Guest() {
    }

    public Guest(Builder builder) {
        this.guestID = builder.guestID;
        this.user = builder.user;
    }

    public String getGuestID() {
        return guestID;
    }

    public void setGuestID(String guestID) {
        this.guestID = guestID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static class Builder {
        private String guestID;
        private User user;

        public Builder setGuestID(String guestID) {
            this.guestID = guestID;
            return this;
        }

        public Builder setUser(User user){
            this.user = user;
            return this;
        }

        public Builder copy(Guest guest) {
            this.guestID = guest.guestID;
            this.user = guest.user;
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
        return Objects.equals(guestID, guest.guestID) && Objects.equals(user, guest.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guestID, user);
    }

    @Override
    public String toString() {
        return "Guest{" +
                "guestID='" + guestID + '\'' +
                ", user=" + user +
                '}';
    }
}
