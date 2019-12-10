package com.example.downtime;

public class Events {
    public String eventName;
    public String descrip;//event description
    public String location;

    int duration;

    public Events(String eventName, String descrip, String location, int duration) {
        this.eventName = eventName;
        this.descrip = descrip;
        this.location = location;
        this.duration = duration;
    }//constructor

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

public Events(){}

/*
    //calculate duration

    public int calcDuration(int totalDayDuration) {
        int leisure = 0;
        int sleepHrs = 7;
        int totalHours = 0;

        if (totalDayDuration > 0)
            totalHours = totalDayDuration + sleepHrs;

        if (totalHours <= 24) {
            leisure = 24 - totalHours;
        }
        return leisure;
    }*/

}

