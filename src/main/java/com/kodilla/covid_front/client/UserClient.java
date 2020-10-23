package com.kodilla.covid_front.client;

import com.kodilla.covid_front.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserClient {

    @Autowired
    private RestTemplate restTemplate;

    public UserDto addUser (String userName, String userPassword) {
        UserDto user = restTemplate.getForObject(
                "http://localhost:8081/createUser?userName=" + userName + "&userPassword=" + userPassword,
                UserDto.class);
        return user;
    }

    public Boolean validateUser (String userName, String userPassword) {
        UserDto userValidate = restTemplate.getForObject(
                "http://localhost:8081/checkUser?userName=" + userName + "&userPassword=" + userPassword,
                UserDto.class);
        if (userValidate != null) {
            return true;
        }
        return false;
    }

}
