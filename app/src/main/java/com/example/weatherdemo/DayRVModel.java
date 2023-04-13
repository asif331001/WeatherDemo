package com.example.weatherdemo;

public class DayRVModel {

    private String date;
    private String avgtemp;
    private String maxwind;
    private String text;

    public DayRVModel(String date, String avgtemp, String maxwind, String text) {
        this.date = date;
        this.avgtemp = avgtemp;
        this.maxwind = maxwind;
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAvgtemp() {
        return avgtemp;
    }

    public void setAvgtemp(String avgtemp) {
        this.avgtemp = avgtemp;
    }

    public String getMaxwind() {
        return maxwind;
    }

    public void setMaxwind(String maxwind) {
        this.maxwind = maxwind;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
