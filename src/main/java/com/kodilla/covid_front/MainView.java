package com.kodilla.covid_front;

import com.kodilla.covid_front.client.CovidClient;
import com.kodilla.covid_front.domain.CountryRaw;
import com.kodilla.covid_front.service.CountryRawService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;


@Route
public class MainView extends VerticalLayout {

    @Autowired
    private CovidClient covidClient;

    private CountryRawService countryRawService = CountryRawService.getInstance();
    private Grid grid = new Grid<>(CountryRaw.class);
    private CountryForm form = new CountryForm(this);
    private Button loginButton = new Button("LOGIN");
    private TextField loginField = new TextField();
    private TextField passwordField = new TextField();

    public MainView() {
//        loginButton.addClickListener(e -> {grid.asSingleSelect().clear();
//        form.setCountry(new CountryForm());});
        loginField.setPlaceholder("Enter login");
        loginField.setClearButtonVisible(true);
        passwordField.setPlaceholder("Enter password");
        passwordField.setClearButtonVisible(true);
        grid.setColumns("countryType", "date", "covidGrow");
        HorizontalLayout toolbar = new HorizontalLayout(loginField, passwordField, loginButton);
        loginButton.addClickListener(event -> loadCovidGrow() );
        HorizontalLayout mainContent = new HorizontalLayout(form);
        mainContent.setSizeFull();
        grid.setSizeFull();
        grid.asSingleSelect().addValueChangeListener(event -> form.setCountryRaw((CountryRaw) grid.asSingleSelect().getValue()));

        add(toolbar, grid, mainContent);
        setSizeFull();
    }

    private void loadCovidGrow() {
        covidClient.getCovidGrow();
    }

    public void refresh() {
        grid.setItems(countryRawService.getCountryRawSet());
    }

/*    private void update() {
        grid.setItems(bookService.findByTitle(filter.getValue()));
    }*/

}
