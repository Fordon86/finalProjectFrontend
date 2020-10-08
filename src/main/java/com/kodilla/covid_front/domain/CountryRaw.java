package com.kodilla.covid_front.domain;

import com.kodilla.covid_front.CountryType;

public class CountryRaw {

    private CountryType countryType;
    private String date;
    private String covidGrow;

    public CountryRaw() {
    }

    public CountryRaw(CountryType countryType, String date, String covidGrow) {
        this.countryType = countryType;
        this.date = date;
        this.covidGrow = covidGrow;
    }

    public CountryType getCountryType() {
        return countryType;
    }

    public void setCountryType(CountryType countryType) {
        this.countryType = countryType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCovidGrow() {
        return covidGrow;
    }

    public void setCovidGrow(String covidGrow) {
        this.covidGrow = covidGrow;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CountryRaw)) return false;

        CountryRaw that = (CountryRaw) o;

        if (countryType != that.countryType) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (covidGrow != null ? !covidGrow.equals(that.covidGrow) : that.covidGrow != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = countryType != null ? countryType.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (covidGrow != null ? covidGrow.hashCode() : 0);
        return result;
    }
}
