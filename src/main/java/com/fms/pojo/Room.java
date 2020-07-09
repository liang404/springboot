package com.fms.pojo;

public class Room {
    int id;
    int location;
    int stauts;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getStauts() {
        return stauts;
    }

    public void setStauts(int stauts) {
        this.stauts = stauts;
    }

    @Override
    public String toString() {
        return "room{" +
                "id=" + id +
                ", location=" + location +
                ", stauts=" + stauts +
                '}';
    }
}
