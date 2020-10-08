package com.kodilla.covid_front.service;

import com.kodilla.covid_front.domain.CountryRaw;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

public class CountryRawService {

    private Set<CountryRaw> countryRawSet = new HashSet<>();
    private static CountryRawService countryRawService;

    private CountryRawService() {
    }

    public static CountryRawService getInstance() {
        if (countryRawService == null) {
            countryRawService = new CountryRawService();
        }
        return countryRawService;
    }



    public void save(CountryRaw countryRaw) {
        this.countryRawSet.add(countryRaw);
    }

    public void delete(CountryRaw countryRaw) {
        this.countryRawSet.remove(countryRaw);
    }

    public Set<CountryRaw> getCountryRawSet() {
        return countryRawSet;
    }

}
