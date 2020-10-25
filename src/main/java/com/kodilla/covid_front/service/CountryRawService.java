package com.kodilla.covid_front.service;

import com.kodilla.covid_front.client.UserClient;
import com.kodilla.covid_front.domain.CountryRaw;
import com.kodilla.covid_front.dto.CovidDto;
import com.kodilla.covid_front.dto.UserFullViewDto;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
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

    public Set<CountryRaw> getCountryRawSet(String userId, UserClient userClient) {
        Set<CountryRaw> countryRaws = new HashSet<>();
        UserFullViewDto userFullView = userClient.getUserFullView(userId);
        Map<String, List<CovidDto>> countryCovidGrow = userFullView.getMapCountryCovidGrow();
        for (String key:countryCovidGrow.keySet()) {
            List<CovidDto> covidDtoList = countryCovidGrow.get(key);
            CountryRaw countryRaw = new CountryRaw();
            countryRaw.setCountryName(key);
            countryRaw.setDate(covidDtoList.get(0).getCases());
            countryRaw.setDate_1(covidDtoList.get(1).getCases());
            countryRaw.setDate_2(covidDtoList.get(2).getCases());
            countryRaw.setDate_3(covidDtoList.get(3).getCases());
            countryRaw.setDate_4(covidDtoList.get(4).getCases());
            countryRaws.add(countryRaw);
        }
        return countryRaws;
    }

}
