package com.kodilla.covid_front.domain;

import com.kodilla.covid_front.CountryType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CountryRaw {

    private CountryType countryType;
    private String date;
    private String covidGrow;

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
