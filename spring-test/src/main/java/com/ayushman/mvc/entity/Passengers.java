package com.ayushman.mvc.entity;

public class Passengers {
    private int passengerId;
    private String first_name;
    private String last_name;
    private long mobile;
    private String email;

    public Passengers(){}

    public Passengers(int passengerId, String first_name, String last_name, long mobile, String email) {
        this.passengerId = passengerId;
        this.first_name = first_name;
        this.last_name = last_name;
        this.mobile = mobile;
        this.email = email;
    }

    public Passengers(String string, String string1, String string2, long aLong, String string3) {
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Passengers{" +
                "passengerId=" + passengerId +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", mobile=" + mobile +
                ", email='" + email + '\'' +
                '}';
    }
}
