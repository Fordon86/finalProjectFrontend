package com.kodilla.covid_front.domain;

import lombok.*;

@Data
public class CountryRaw {

    private String countryName;
    private int total_cases;
    private int tomorrow_grow;
    private int day_after_tomorrow_grow;
    private int date_3;
    private int date_4;

}
