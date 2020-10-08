package com.kodilla.covid_front.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CovidDto {
    private String country;
    private String date;
    private int cases;
}
