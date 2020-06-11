package com.dimache.farapayeshchart.main.data.model;


import com.google.gson.annotations.SerializedName;


public class TotalInfected {

    public TotalInfected(){

    }

    @SerializedName("total_cases")
    protected int confirmed;

    @SerializedName("total_recovered")
    protected int recovered;

    @SerializedName("total_serious_cases")
    protected int critical;

    @SerializedName("total_deaths")
    protected int deaths;

    protected int total_active_cases;


/* protected String lastChange;
    protected String lastUpdate;*/

    public int getTotal_active_cases() {
        return total_active_cases;
    }

    public void setTotal_active_cases(int total_active_cases) {
        this.total_active_cases = total_active_cases;
    }

    public int getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public int getCritical() {
        return critical;
    }

    public void setCritical(int critical) {
        this.critical = critical;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }
}
