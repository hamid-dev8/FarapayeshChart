package com.dimache.farapayeshchart.main.data.model;

import com.google.gson.annotations.SerializedName;

public class CountriesInfected {

    public CountriesInfected()
    {

    }

    @SerializedName("title")
    protected String countrycode;

    @SerializedName("total_deaths")
    protected String deaths;

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }
}
