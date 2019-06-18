package model;
import java.time.LocalDate;
import java.time.LocalTime;

public class CheckInUser {
    private int userId;
    private LocalDate checkInDate;
    private LocalTime checkInTime;

    public CheckInUser(int userId, LocalDate checkInDate, LocalTime checkInTime) {
        this.userId = userId;
        this.checkInDate = checkInDate;
        this.checkInTime = checkInTime;
    }
    public CheckInUser(){

    }
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalTime getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(LocalTime checkInTime) {
        this.checkInTime = checkInTime;
    }
}
