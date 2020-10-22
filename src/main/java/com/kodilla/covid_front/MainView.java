package com.kodilla.covid_front;

import com.kodilla.covid_front.domain.CountryRaw;
import com.kodilla.covid_front.service.CountryRawService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

@Route
public class MainView extends VerticalLayout {

/*    @Autowired
    private RestTemplate restTemplate;*/

    private CountryRawService countryRawService = CountryRawService.getInstance();
    private Grid grid = new Grid<>(CountryRaw.class);
    private CountryForm form = new CountryForm(this);
    private Button loginButton = new Button("LOGIN");
    private Button refreshButton = new Button("REFRESH");
    private Button addUser = new Button("ADD USER");
    private TextField loginField = new TextField();
    private TextField passwordField = new TextField();
    private TextField addNewUser = new TextField();
    private TextField setPassword = new TextField();

    public MainView() {
        grid.setVisible(false);
        form.setVisible(false);
        refreshButton.setVisible(false);
        addNewUser.setVisible(false);
        setPassword.setVisible(false);
//        loginButton.addClickListener(e -> {grid.asSingleSelect().clear();
        loginButton.addClickListener(e -> {grid.setVisible(true);
            form.setVisible(true);
            refreshButton.setVisible(true);
            refreshButton.setVisible(true);
            addUser.setVisible(false);});
        addUser.addClickListener(e -> {addNewUser.setVisible(true);
            setPassword.setVisible(true);});
        loginField.setPlaceholder("Enter login");
        loginField.setClearButtonVisible(true);
        passwordField.setPlaceholder("Enter password");
        passwordField.setClearButtonVisible(true);
        addNewUser.setPlaceholder("Enter login");
        addNewUser.setClearButtonVisible(true);
        setPassword.setPlaceholder("Enter password");
        setPassword.setClearButtonVisible(true);
        grid.setColumns("countryType", "date", "covidGrow");
        HorizontalLayout toolbar = new HorizontalLayout(loginField, passwordField, loginButton, addUser, refreshButton, addNewUser, setPassword);
        HorizontalLayout mainContent = new HorizontalLayout(form);
        mainContent.setSizeFull();
        grid.setSizeFull();
        grid.asSingleSelect().addValueChangeListener(event -> form.setCountryRaw((CountryRaw) grid.asSingleSelect().getValue()));

        add(toolbar, grid, mainContent);
        setSizeFull();
    }

    public void refresh() {
        grid.setItems(countryRawService.getCountryRawSet());
    }

}
