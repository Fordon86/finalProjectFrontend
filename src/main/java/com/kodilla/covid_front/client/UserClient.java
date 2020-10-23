package com.kodilla.covid_front.client;

import com.kodilla.covid_front.domain.User;
import com.kodilla.covid_front.dto.UserDto;
import com.vaadin.flow.data.binder.Binder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserClient {

    @Autowired
    private RestTemplate restTemplate;

//    private Binder <User> binder = new Binder<>(User.class);

    public UserDto addUser (String userName, String userPassword) {
        UserDto user = restTemplate.getForObject(
                "http://localhost:8081/createUser?userName=" + userName + "&userPassword=" + userPassword,
                UserDto.class);
        return user;
    }

}