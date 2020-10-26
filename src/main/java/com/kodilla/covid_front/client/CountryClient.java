package com.kodilla.covid_front.client;

import com.kodilla.covid_front.dto.CountryDto;
import com.kodilla.covid_front.dto.UserDto;
import com.kodilla.covid_front.dto.UserFullViewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class CountryClient {

    @Autowired
    private RestTemplate restTemplate;


    public List<CountryDto> getCountrys () {
        ResponseEntity<List<CountryDto>> countryList = restTemplate.exchange(
                "http://localhost:8081/getCountryList",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<CountryDto>>(){});
        if (countryList != null) {
            return countryList.getBody();
        }
        return null;
    }

}
