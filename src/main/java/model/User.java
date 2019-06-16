package model;

import dao.UserDAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class User {
    private Integer userId;
    private LocalDate memberSince;
    private String userName;
    private String password;
    private String fullName;
    private String occupation;
    private String address;
    private String contact;
    private String email;
    private String dob;
    private String gender;
    private String image;
    private ArrayList<Check> checkList;


    public User() {
        this.userId= (int)(Math.random()*10000)+1000;
        this.memberSince=LocalDate.now();
        checkList=new ArrayList<>();
    }

    public User(String email, String password) {
        this();
        this.email = email;
        this.password = password;
    }

    public User(String userName, String password, String fullName, String occupation,
                String address, String contact, String email, String dob, String gender) {
        this(email,password);
        this.fullName = fullName;
        this.occupation = occupation;
        this.address = address;
        this.contact = contact;
        this.userName = userName;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDate getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(LocalDate memberSince) {
        this.memberSince = memberSince;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ArrayList<Check> getCheckList() {
        return checkList;
    }

    public void setCheckList(ArrayList<Check> checkList) {
        this.checkList = checkList;
    }


    public void check(){
        checkList.add(new Check());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return email.equals(user.email) &&
                password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password);
    }

    @Override
    public String toString(){
        return "UserName"+userName;
    }
}
