package com.kodilla.covid_front;

import com.kodilla.covid_front.client.CovidClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CovidFrontApplication {

    @Autowired
    private CovidClient covidClient;

    public static void main(String[] args) {
        SpringApplication.run(CovidFrontApplication.class, args);
    }

}
