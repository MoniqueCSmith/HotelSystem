package za.ac.cput.domain;

public class Membership {
    private String memberID;
    private String email;
    private String password;
    private String membFirstName;
    private String membLastName;
    private String dateOfBirth;
    private String phoneNumber;
    private String gender;

    private Membership(Builder builder){
        this.memberID = builder.memberID;
        this.email = builder.email;
        this.password = builder.password;
        this.membFirstName = builder.membFirstName;
        this.membLastName = builder.membLastName;
        this.dateOfBirth = builder.build().dateOfBirth;
        this.phoneNumber = builder.phoneNumber;
        this.gender = builder.gender;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMembFirstName() {
        return membFirstName;
    }

    public void setMembFirstName(String membFirstName) {
        this.membFirstName = membFirstName;
    }

    public String getMembLastName() {
        return membLastName;
    }

    public void setMembLastName(String membLastName) {
        this.membLastName = membLastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Membership{" +
                "memberID='" + memberID + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", membFirstName='" + membFirstName + '\'' +
                ", membLastName='" + membLastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public static class Builder{
        private String memberID;
        private String email;
        private String password;
        private String membFirstName;
        private String membLastName;
        private String dateOfBirth;
        private String phoneNumber;
        private String gender;



        public Builder setMemberID(String memberID){
            this.memberID = memberID;
            return this;
        }
        public Builder setEmail(String email){
            this.email = email;
            return this;
        }
        public Builder setPassword(String password){
            this.password = password;
            return this;
        }
        public Builder setMembFirstName(String membFirstName){
            this.membFirstName = membFirstName;
            return this;
        }
        public Builder setMembLastName(String membLastName){
            this.membLastName = membLastName;
            return this;
        }
        public Builder setDateOfBirth(String dateOfBirth){
            this.dateOfBirth = dateOfBirth;
            return this;
        }
        public Builder setPhoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }
        public Builder setGender(String gender){
            this.gender = gender;
            return this;
        }

        public Builder copy(Membership memberships){
            this.memberID = memberships.memberID;
            this.email = memberships.email;
            this.password = memberships.password;
            this.membFirstName = memberships.membFirstName;
            this.membLastName = memberships.membLastName;
            this.dateOfBirth = memberships.dateOfBirth;
            this.phoneNumber = memberships.phoneNumber;
            this.gender = memberships.gender;
            return this;
        }

        public Membership build(){
            return new Membership(this);
        }
    }

}
