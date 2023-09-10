/**
 * Member.java
 * Entity class for the Membership
 * Author: Shanlynn Courtney Thomas (218053762)
 * Date: 09 September 2023
 */
package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Member implements Serializable {
    @Id
    private String memberID;
    private String username;
    private String password;


    protected Member(){}
    private Member(Builder builder){
        this.memberID = builder.memberID;
        this.username = builder.username;
        this.password = builder.password;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getUsername() {
        return username;
    }

    public void setEmail(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "Member{" +
                "memberID='" + memberID + '\'' +
                ", email='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static class Builder{
        private String memberID;
        private String username;
        private String password;


        public Builder setMemberID(String memberID){
            this.memberID = memberID;
            return this;
        }
        public Builder setUsername(String username){
            this.username = username;
            return this;
        }
        public Builder setPassword(String password){
            this.password = password;
            return this;
        }


        public Builder copy(Member member){
            this.memberID = member.memberID;
            this.username = member.username;
            this.password = member.password;
            return this;
        }

        public Member build(){
            return new Member(this);
        }
    }

}
