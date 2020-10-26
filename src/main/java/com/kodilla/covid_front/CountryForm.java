package com.kodilla.covid_front;

import com.kodilla.covid_front.client.CountryClient;
import com.kodilla.covid_front.domain.CountryRaw;
import com.kodilla.covid_front.dto.CountryDto;
import com.kodilla.covid_front.dto.UserDto;
import com.kodilla.covid_front.service.CountryRawService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class CountryForm extends FormLayout {

    private RestTemplate restTemplate;

    private CountryClient countryClient;

    private Button addToList = new Button("Add country to the list");
    private Button deleteFromList = new Button ("Delete country from list");
    private CountryRawService countryRawService = CountryRawService.getInstance();
    private ComboBox<CountryDto> comboBox = new ComboBox<>();
    private String userId;
    private MainView mainView;

    public CountryForm(){}

    public CountryForm(MainView mainView, CountryClient countryClient, String userId, RestTemplate restTemplate) {
        this.countryClient = countryClient;
        this.userId = userId;
        this.restTemplate = restTemplate;
        comboBox.setLabel("Country");
        List<CountryDto> countryDtoComboBox = countryClient.getCountrys();
        comboBox.setItemLabelGenerator(CountryDto::getCountryName);
        comboBox.setItems(countryDtoComboBox);
        addToList.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(addToList, deleteFromList,comboBox);
        addToList.addClickListener(event -> save());
        deleteFromList.addClickListener(event -> delete());
        this.mainView = mainView;
    }

    public void setCountryRaw (CountryRaw countryRaw) {
    }

    private void save() {
        String countryId = String.valueOf(comboBox.getValue().getCountryId());
        UserDto user = restTemplate.getForObject(
                "http://localhost:8081/addCountry?userId=" + userId + "&countryId=" + countryId,
                UserDto.class);
        mainView.refresh(userId);
    }

    private void delete() {
/*        CountryRaw countryRaw = new CountryRaw();
        countryRaw.setCountryName(type.getValue());
*//*        countryRaw.setDate("dsdasda");
        countryRaw.setCovidGrow("dsda");*//*
        countryRawService.delete(countryRaw);
        mainView.refresh();*/
    }

}
