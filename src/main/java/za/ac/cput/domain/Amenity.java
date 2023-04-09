/**
 * Amenity.java
 * Entity for the Amenity
 * Author: Alison Shirlene Williams (219140987)
 * Date: 04 April 2023
 */
package za.ac.cput.domain;

public class Amenity {
    private String amenityID;
    private String amenityName;
    private String amenityDesc;
    private Boolean isAmenityAvailable;
    private Double amenityPrice;

    private Amenity(Builder builder){
        this.amenityID = builder.amenityID;
        this.amenityName = builder.amenityName;
        this.amenityDesc = builder.amenityDesc;
        this.isAmenityAvailable = builder.isAmenityAvailable;
        this.amenityPrice = builder.amenityPrice;

    }

    public String getAmenityID() {
        return amenityID;
    }

    public String getAmenityName() {
        return amenityName;
    }

    public String getAmenityDesc() {
        return amenityDesc;
    }

    public Boolean getAmenityAvailable() {
        return isAmenityAvailable;
    }

    public Double getAmenityPrice() {
        return amenityPrice;
    }

    @Override
    public String toString() {
        return "Amenity{" +
                "amenityID='" + amenityID + '\'' +
                ", amenityName='" + amenityName + '\'' +
                ", amenityDesc='" + amenityDesc + '\'' +
                ", isAmenityAvailable=" + isAmenityAvailable +
                ", amenityPrice=" + amenityPrice +
                '}';
    }

    public static class Builder{
        private String amenityID;
        private String amenityName;
        private String amenityDesc;
        private  Boolean isAmenityAvailable;
        private Double amenityPrice;

        public Builder setAmenityID(String amenityID) {
            this.amenityID = amenityID;
            return this;
        }

        public Builder setAmenityName(String amenityName) {
            this.amenityName = amenityName;
            return this;
        }

        public Builder setAmenityDesc(String amenityDesc) {
            this.amenityDesc = amenityDesc;
            return this;
        }

        public Builder setAmenityAvailable(Boolean isAmenityAvailable) {
            this.isAmenityAvailable = isAmenityAvailable;
            return this;
        }

        public Builder setAmenityPrice(Double amenityPrice) {
            this.amenityPrice = amenityPrice;
            return this;
        }
        public Builder copy(Amenity amenities){
            this.amenityID = amenities.amenityID;
            this.amenityName = amenities.amenityName;
            this.amenityDesc = amenities.amenityDesc;
            this.isAmenityAvailable = amenities.isAmenityAvailable;
            this.amenityPrice = amenities.amenityPrice;
            return this;
        }
        public Amenity build(){
            return new Amenity(this);
        }
    }
}
