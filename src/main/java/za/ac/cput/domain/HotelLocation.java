/* HotelLocation.java
 POJO for Hotel Location class
 Author: Ashton Williams (220468478)
 Date: 08 April 2023
*/

package za.ac.cput.domain;

import java.util.Objects;

public class HotelLocation {
    private static String hotelCode;
    private String hotelAddress;
    private String hotelCity;
    private String hotelProvince;
    private int hotelZipCode;

    public HotelLocation(Builder builder){
        this.hotelCode= builder.hotelCode;
        this.hotelAddress= builder.hotelAddress;
        this.hotelCity= builder.hotelCity;
        this.hotelProvince= builder.hotelProvince;
       this.hotelZipCode= builder.hotelZipCode;
    }

    public static String getHotelCode() {
        return hotelCode;
    }

    public void setHotelCode(String hotelCode) {
        this.hotelCode = hotelCode;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getHotelCity() {
        return hotelCity;
    }

    public void setHotelCity(String hotelCity) {
        this.hotelCity = hotelCity;
    }

    public String getHotelProvince() {
        return hotelProvince;
    }

    public void setHotelProvince(String hotelProvince) {
        this.hotelProvince = hotelProvince;
    }

    public int getHotelZipCode() {
        return hotelZipCode;
    }

    public void setHotelZipCode(int hotelZipCode) {
        this.hotelZipCode = hotelZipCode;
    }

    @Override
    public String toString() {
        return "HotelLocation{" +
                "hotelCode='" + hotelCode + '\'' +
                ", hotelAddress='" + hotelAddress + '\'' +
                ", hotelCity='" + hotelCity + '\'' +
                ", hotelProvince='" + hotelProvince + '\'' +
                ", hotelZipCode=" + hotelZipCode +
                '}';
    }

    public static class Builder{

        private String hotelCode;
        private String hotelAddress;
        private String hotelCity;
        private String hotelProvince;
        private int hotelZipCode;

        public Builder setHotelCode(String hotelCode) {
            this.hotelCode = hotelCode;
            return this;
        }

        public Builder setHotelAddress(String hotelAddress) {
            this.hotelAddress = hotelAddress;
            return this;
        }

        public Builder setHotelCity(String hotelCity) {
            this.hotelCity = hotelCity;
            return this;
        }

        public Builder setHotelProvince(String hotelProvince) {
            this.hotelProvince = hotelProvince;
            return this;
        }

        public Builder setHotelZipCode(int hotelZipCode) {
            this.hotelZipCode = hotelZipCode;
            return this;
        }

        public Builder copy(HotelLocation HotelLocation){
            this.hotelCode= HotelLocation.hotelCode;
            this.hotelAddress= HotelLocation.hotelAddress;
            this.hotelCity= HotelLocation.hotelCity;
            this.hotelProvince= HotelLocation.hotelProvince;
            this.hotelZipCode= HotelLocation.hotelZipCode;

            return this;
        }

        public HotelLocation build(){
            return new HotelLocation(this);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HotelLocation)) {
            return false;
        }
        HotelLocation hotelLocation = (HotelLocation) obj;

        return Objects.equals(hotelCode, hotelLocation.hotelCode) &&
                Objects.equals(hotelAddress, hotelLocation.hotelAddress) &&
                Objects.equals(hotelCity, hotelLocation.hotelCity) &&
                Objects.equals(hotelProvince, hotelLocation.hotelProvince) &&
                Objects.equals(hotelZipCode, hotelLocation.hotelZipCode);
    }

}
