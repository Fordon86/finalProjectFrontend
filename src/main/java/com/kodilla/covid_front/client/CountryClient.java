package com.kodilla.covid_front.client;

import com.kodilla.covid_front.dto.CountryDto;
import com.kodilla.covid_front.dto.UserDto;
import com.kodilla.covid_front.dto.UserFullViewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class CountryClient {

    @Autowired
    private RestTemplate restTemplate;


    public List<CountryDto> getCountrys () {
        CountryDto countryList = restTemplate.getForObject(
                "http://localhost:8081/getCountryList",
                CountryDto.class);
        if (countryList != null) {
            List<CountryDto>  countryDtoList = new ArrayList<>();
            countryDtoList.add(countryList);
            return countryDtoList;
        }
        return null;
    }
}
