/* HotelLocation.java
 POJO for Hotel Location class
 Author: Ashton Williams (220468478)
 Date: 08 April 2023
*/

package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "HotelLocation")
public class HotelLocation implements Serializable {
    @Id
    private String ID;
    private String Address;
    private String City;
    private String Province;
    private int ZipCode;

protected HotelLocation(){}
    private HotelLocation(Builder builder) {
        this.ID=builder.ID;
        this.Address= builder.Address;
        this.City= builder.City;
        this.Province= builder.Province;
        this.ZipCode=builder.ZipCode;
    }
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getProvince() {
        return Province;
    }

    public void setProvince(String province) {
        Province = province;
    }

    public int getZipCode() {
        return ZipCode;
    }

    public void setZipCode(int zipCode) {
        ZipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelLocation that = (HotelLocation) o;
        return ZipCode == that.ZipCode && Objects.equals(ID, that.ID) && Objects.equals(Address, that.Address) && Objects.equals(City, that.City) && Objects.equals(Province, that.Province);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, Address, City, Province, ZipCode);
    }

    @Override
    public String toString() {
        return "HotelLocation{" +
                "ID='" + ID + '\'' +
                ", Address='" + Address + '\'' +
                ", City='" + City + '\'' +
                ", Province='" + Province + '\'' +
                ", ZipCode='" + ZipCode + '\'' +
                '}';
    }

    public static class Builder{
        private String ID;
        private String Address;
        private String City;
        private String Province;
        private int ZipCode;

        public Builder setID(String ID) {
            this.ID = ID;
            return this;
        }

        public Builder setAddress(String address) {
            Address = address;
            return this;
        }

        public Builder setCity(String city) {
            City = city;
            return this;
        }
        public Builder setProvince(String province) {
            Province = province;
            return this;
        }

        public Builder setZipCode(int zipCode) {
            ZipCode = zipCode;
            return this;
        }

        public Builder copy(HotelLocation hotelLocation){
            this.ID= hotelLocation.ID;
            this.Address= hotelLocation.Address;
            this.City= hotelLocation.City;
            this.Province= hotelLocation.Province;
            this.ZipCode=hotelLocation.ZipCode;
            return this;
        }

        public HotelLocation build(){
            return new HotelLocation(this);
        }
    }

}
