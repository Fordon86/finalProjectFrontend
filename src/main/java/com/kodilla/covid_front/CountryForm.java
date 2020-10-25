package com.kodilla.covid_front;

import com.kodilla.covid_front.client.CountryClient;
import com.kodilla.covid_front.domain.CountryRaw;
import com.kodilla.covid_front.dto.CountryDto;
import com.kodilla.covid_front.service.CountryRawService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;

public class CountryForm extends FormLayout {

    private CountryClient countryClient;

    private ComboBox<CountryType> type = new ComboBox<>("Country list");
    private Button addToList = new Button("Add country to the list");
    private Button deleteFromList = new Button ("Delete country from list");
    private CountryRawService countryRawService = CountryRawService.getInstance();

    private MainView mainView;

    public CountryForm(){}

    public CountryForm(MainView mainView, CountryClient countryClient) {
        this.countryClient = countryClient;
        ComboBox<CountryDto> countryDtoComboBox = new ComboBox<>();
        countryDtoComboBox.setItems(countryClient.getCountrys());
        countryDtoComboBox.setItemLabelGenerator(CountryDto::getCountryName);
//        setContent(new CssLayout(countryDtoComboBox));
        type.setItems(CountryType.values());
        addToList.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(addToList, deleteFromList,countryDtoComboBox);
        addToList.addClickListener(event -> save());
        deleteFromList.addClickListener(event -> delete());
        this.mainView = mainView;
    }

    public void setCountryRaw (CountryRaw countryRaw) {
    }

    private void save() {
/*        CountryRaw countryRaw = new CountryRaw();
        countryRaw.setCountryName(type.getValue());
*//*        countryRaw.setDate("dsdasda");
        countryRaw.setCovidGrow("dsda");*//*
        countryRawService.save(countryRaw);
        mainView.refresh();*/
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
