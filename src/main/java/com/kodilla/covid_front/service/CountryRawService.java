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

    private static CountryRawService countryRawService;

    private CountryRawService() {
    }

    public static CountryRawService getInstance() {
        if (countryRawService == null) {
            countryRawService = new CountryRawService();
        }
        return countryRawService;
    }

    public Set<CountryRaw> getCountryRawSet(String userId, UserClient userClient) {
        Set<CountryRaw> countryRaws = new HashSet<>();
        UserFullViewDto userFullView = userClient.getUserFullView(userId);
        Map<String, List<CovidDto>> countryCovidGrow = userFullView.getMapCountryCovidGrow();
        for (String key:countryCovidGrow.keySet()) {
            List<CovidDto> covidDtoList = countryCovidGrow.get(key);
            CountryRaw countryRaw = new CountryRaw();
            countryRaw.setCountryName(key);
            countryRaw.setTotal_cases(covidDtoList.get(0).getCases());
            countryRaw.setTomorrow_grow(covidDtoList.get(1).getCases() - covidDtoList.get(0).getCases());
            countryRaw.setDay_after_tomorrow_grow(covidDtoList.get(2).getCases() - covidDtoList.get(1).getCases());
            countryRaw.setDate_3(covidDtoList.get(3).getCases() - covidDtoList.get(2).getCases());
            countryRaw.setDate_4(covidDtoList.get(4).getCases() - covidDtoList.get(3).getCases());
            countryRaws.add(countryRaw);
        }
        return countryRaws;
    }

}
