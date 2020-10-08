package com.kodilla.covid_front.controller;

import com.kodilla.covid_front.client.CovidClient;
import com.kodilla.covid_front.domain.CovidDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CovidController {

    @Autowired
    private CovidClient covidClient;

    @RequestMapping(method = RequestMethod.GET, value = "getCovidGrow")
    public List<CovidDto> getCovidGrow () {
        return covidClient.getCovidGrow();
    }

}
