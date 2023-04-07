package za.ac.cput.domain;

public class CustomerContact {
    private String guestAddressID;
    private String guestStreetAddress;
    private String guestCity;
    private String guestZipCode;
    private String guestProvince;
    private String guestCountry;

    public CustomerContact() {
    }

    public String getGuestAddressID() {
        return guestAddressID;
    }

    public String getGuestStreetAddress() {
        return guestStreetAddress;
    }

    public String getGuestCity() {
        return guestCity;
    }

    public String getGuestZipCode() {
        return guestZipCode;
    }

    public String getGuestProvince() {
        return guestProvince;
    }

    public String getGuestCountry() {
        return guestCountry;
    }

    @Override
    public String toString() {
        return "GuestAddress{" +
                "guestAddressID='" + guestAddressID + '\'' +
                ", guestStreetAddress='" + guestStreetAddress + '\'' +
                ", guestCity='" + guestCity + '\'' +
                ", guestZipCode='" + guestZipCode + '\'' +
                ", guestProvince='" + guestProvince + '\'' +
                ", guestCountry='" + guestCountry + '\'' +
                '}';
    }
}
