/**
 * Amenity.java
 * Entity for the Amenity
 * Author: Alison Shirlene Williams (219140987)
 * Date: 04 April 2023
 */
package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


import java.io.Serializable;
import java.util.Objects;


@Entity
public class Amenity implements Serializable {
    @Id
    private String amenityID;
    private String name;
    private String description;
    private Boolean isAmenityAvailable;
    private Double price;

    protected Amenity(){}
    private Amenity(Builder builder){
        this.amenityID = builder.amenityID;
        this.name = builder.name;
        this.description = builder.description;
        this.isAmenityAvailable = builder.isAmenityAvailable;
        this.price = builder.price;

    }

    public String getAmenityID() {
        return amenityID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getAmenityAvailable() {
        return isAmenityAvailable;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amenity amenity = (Amenity) o;
        return Objects.equals(amenityID, amenity.amenityID) && Objects.equals(name, amenity.name) && Objects.equals(description, amenity.description) && Objects.equals(isAmenityAvailable, amenity.isAmenityAvailable) && Objects.equals(price, amenity.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amenityID, name, description, isAmenityAvailable, price);
    }

    @Override
    public String toString() {
        return "Amenity{" +
                "amenityID='" + amenityID + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", isAmenityAvailable=" + isAmenityAvailable +
                ", price=" + price +
                '}';
    }

    public static class Builder{
        private String amenityID;
        private String name;
        private String description;
        private  Boolean isAmenityAvailable;
        private Double price;

        public Builder setAmenityID(String amenityID) {
            this.amenityID = amenityID;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setAmenityAvailable(Boolean isAmenityAvailable) {
            this.isAmenityAvailable = isAmenityAvailable;
            return this;
        }

        public Builder setPrice(Double price) {
            this.price = price;
            return this;
        }
        public Builder copy(Amenity amenities){
            this.amenityID = amenities.amenityID;
            this.name = amenities.name;
            this.description = amenities.description;
            this.isAmenityAvailable = amenities.isAmenityAvailable;
            this.price = amenities.price;
            return this;
        }
        public Amenity build(){
            return new Amenity(this);
        }
    }
}
