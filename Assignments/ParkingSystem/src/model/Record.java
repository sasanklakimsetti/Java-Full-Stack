package model;

import java.time.LocalDateTime;

public class Record {
    String parkingId;
    int floor;
    String registrationNo;
    LocalDateTime parkingTime, exitTime;
    double parkingFee;

    @Override
    public String toString() {
        return "model.Record{" +
                "parkingId='" + parkingId + '\'' +
                ", floor=" + floor +
                ", registrationNo='" + registrationNo + '\'' +
                ", parkingTime=" + parkingTime +
                ", exitTime=" + exitTime +
                ", parkingFee=" + parkingFee +
                '}';
    }

    public String getParkingId() {
        return parkingId;
    }

    public void setParkingId(String parkingId) {
        this.parkingId = parkingId;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public LocalDateTime getParkingTime() {
        return parkingTime;
    }

    public void setParkingTime(LocalDateTime parkingTime) {
        this.parkingTime = parkingTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public double getParkingFee() {
        return parkingFee;
    }

    public void setParkingFee(double parkingFee) {
        this.parkingFee = parkingFee;
    }
}
