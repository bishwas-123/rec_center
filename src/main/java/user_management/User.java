package user_management;

import java.time.LocalDate;
import java.util.Objects;

public class User {
    Integer userId;
    LocalDate memberSince;
    String userName;
    String password;
    String fullName;
    String occupation;
    String address;
    String contact;
    String email;
    LocalDate dob;
    String gender;

    public User() {
        this.userId=(int)Math.random()*1000+100;
        this.memberSince=LocalDate.now();
    }

    public User(String userName, String password) {
        this();
        this.userName = userName;
        this.password = password;
    }

    public User(String userName, String password, String fullName, String occupation, String address, String contact, String email, LocalDate dob, String gender) {
        this(userName,password);
        this.fullName = fullName;
        this.occupation = occupation;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.dob = dob;
        this.gender = gender;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userName.equals(user.userName) &&
                password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password);
    }
}
