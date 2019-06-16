package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Check {
    private LocalDate checkInDate;
    private LocalDateTime inTime;
    private LocalDateTime outTime;

    public Check(){
        setCheckInDate(LocalDate.now());
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }
    public LocalDateTime getInTime() {
        return inTime;
    }
    public LocalDateTime getOutTime() {
        return outTime;
    }

    public void setCheckInDate(LocalDate date) {
        if(checkInDate ==null || (checkInDate.getYear()!=date.getYear() && checkInDate.getMonthValue()!=date.getMonthValue() && checkInDate.getDayOfMonth()!=date.getDayOfMonth())) {
            this.checkInDate = date;
            setInTime(LocalDateTime.now());
        }
        else
            setOutTime(LocalDateTime.now());

    }

    public void setInTime(LocalDateTime inTime) {
        this.inTime = inTime;
    }

    public void setOutTime(LocalDateTime outTime) {
        this.outTime = outTime;
    }
}
