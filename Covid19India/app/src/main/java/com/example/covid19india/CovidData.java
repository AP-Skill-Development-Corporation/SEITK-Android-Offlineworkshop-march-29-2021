package com.example.covid19india;

public class CovidData {
    String date,activecases,recovered,detahs,confirmedcases;


    public CovidData(String date, String activecases, String recovered, String detahs, String confirmedcases) {
        this.date = date;
        this.activecases = activecases;
        this.recovered = recovered;
        this.detahs = detahs;
        this.confirmedcases = confirmedcases;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getActivecases() {
        return activecases;
    }

    public void setActivecases(String activecases) {
        this.activecases = activecases;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getDetahs() {
        return detahs;
    }

    public void setDetahs(String detahs) {
        this.detahs = detahs;
    }

    public String getConfirmedcases() {
        return confirmedcases;
    }

    public void setConfirmedcases(String confirmedcases) {
        this.confirmedcases = confirmedcases;
    }
}
