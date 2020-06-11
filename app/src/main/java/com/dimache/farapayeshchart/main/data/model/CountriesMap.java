package com.dimache.farapayeshchart.main.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

public class CountriesMap
{
    @SerializedName("countryitems")
    public HashMap<Integer,CountriesInfected> countryHash;

    public HashMap<Integer, CountriesInfected> getCountryitems() {
        return countryHash;
    }

    public void setCountryitems(HashMap<Integer, CountriesInfected> countryitems) {
        this.countryHash = countryitems;
    }
}
