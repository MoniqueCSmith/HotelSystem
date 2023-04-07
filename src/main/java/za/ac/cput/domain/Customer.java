package za.ac.cput.domain;

public class Customer {
    private String guestID;
    private String guestTitle;
    private String firstName;
    private String lastName;
    private String gender;
    private String phoneNo;
    private String email;
    private String password;

    public Customer() {
    }

    public Customer(String guestID, String guestTitle, String firstName, String lastName, String gender, String phoneNo, String email, String password) {
        this.guestID = guestID;
        this.guestTitle = guestTitle;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phoneNo = phoneNo;
        this.email = email;
        this.password = password;
    }

    public String getGuestID() {
        return guestID;
    }

    public String getGuestTitle() {
        return guestTitle;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    @Override
    public String toString() {
        return "Guest{" +
                "guestID='" + guestID + '\'' +
                ", guestTitle='" + guestTitle + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
