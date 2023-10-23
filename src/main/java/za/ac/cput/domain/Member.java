/**
 * Member.java
 * Entity class for the Membership
 * Author: Shanlynn Courtney Thomas (218053762)
 * Date: 09 September 2023
 */
package za.ac.cput.domain;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Member implements Serializable {
    @Id
    private String memberID;
    @Embedded
    private User user;
    private String username;
    private String password;

    public static int nextMemberId = 1;

    protected Member(){}
    private Member(Builder builder){
        this.memberID = builder.memberID;
        this.user = builder.user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(memberID, member.memberID) && Objects.equals(user, member.user) && Objects.equals(username, member.username) && Objects.equals(password, member.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberID, user, username, password);
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberID='" + memberID + '\'' +
                ", user=" + user +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static class Builder{
        private String memberID;
        private User user;
        private String username;
        private String password;


        public Builder setMemberID(String memberID){
            this.memberID = memberID;
            return this;
        }

        public Builder setUser(User user){
            this.user = user;
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
            this.user = member.user;
            this.username = member.username;
            this.password = member.password;
            return this;
        }

        public Member build(){
            return new Member(this);
        }
    }

}
