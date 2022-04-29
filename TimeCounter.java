package com.example.whitelistapp;

public class TimeCounter implements Runnable {
    private int hours;
    private int minutes;
    private int seconds;


    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public String getTime() {
        return getHours() + ":" + getMinutes() + ":" + getSeconds();
    }

    public void setHours(int hours) {
        this.hours += hours;
    }

    public void setMinutes(int minutes) {
        this.minutes += minutes;
        if (minutes == 0) {
            this.minutes = minutes;
        }
    }

    public void setSeconds(int seconds) {
        this.seconds += seconds;
        if (seconds == 0) {
            this.seconds = seconds;
        }
    }


    @Override
    public void run() {
                setSeconds(1);
                changeTime(getSeconds(), getMinutes(), getHours());
//                System.out.println(getTime());
    }


    public void changeTime(int seconds, int minutes, int hours) {
        if (seconds == 60) {
            setMinutes(1);
            setSeconds(0);
        }
        if (minutes == 60) {
            setHours(1);
            setMinutes(0);
        }
        if (hours == 24) {
            setHours(0);
        }
    }


}

