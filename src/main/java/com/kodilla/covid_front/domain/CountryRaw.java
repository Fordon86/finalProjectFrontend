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
    private String date_1;
    private String date_2;
    private String date_3;
    private String date_4;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CountryRaw)) return false;

        CountryRaw that = (CountryRaw) o;

        if (countryType != that.countryType) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (date_1 != null ? !date_1.equals(that.date_1) : that.date_1 != null) return false;
        if (date_2 != null ? !date_2.equals(that.date_2) : that.date_2 != null) return false;
        if (date_3 != null ? !date_3.equals(that.date_3) : that.date_3 != null) return false;
        return date_4 != null ? date_4.equals(that.date_4) : that.date_4 == null;
    }

    @Override
    public int hashCode() {
        int result = countryType != null ? countryType.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (date_1 != null ? date_1.hashCode() : 0);
        result = 31 * result + (date_2 != null ? date_2.hashCode() : 0);
        result = 31 * result + (date_3 != null ? date_3.hashCode() : 0);
        result = 31 * result + (date_4 != null ? date_4.hashCode() : 0);
        return result;
    }
}
