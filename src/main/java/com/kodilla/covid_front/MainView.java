package com.kodilla.covid_front;

import com.kodilla.covid_front.client.CountryClient;
import com.kodilla.covid_front.client.UserClient;
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

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserClient userClient;
    @Autowired
    private CountryClient countryClient;

    private CountryRawService countryRawService = CountryRawService.getInstance();
    private Grid grid = new Grid<>(CountryRaw.class);
    private CountryForm form;
    private Button loginButton = new Button("LOGIN");
    private Button refreshButton = new Button("REFRESH");
    private Button addUser = new Button("ADD USER");
    private Button saveUser = new Button ("SAVE USER");
    private TextField userNameLoginField = new TextField();
    private TextField userPasswordField = new TextField();
    private TextField newUserNameTextField = new TextField();
    private TextField newUserPasswordTextField = new TextField();

    public MainView() {
        grid.setVisible(false);
        refreshButton.setVisible(false);
        newUserNameTextField.setVisible(false);
        newUserPasswordTextField.setVisible(false);
        saveUser.setVisible(false);
        loginButton.addClickListener(e -> {
        String userId = userClient.validateUser(userNameLoginField.getValue(),
                    userPasswordField.getValue());
            if (form == null){
                form = new CountryForm(this, countryClient, userId, restTemplate);
                HorizontalLayout mainContent = new HorizontalLayout(form);
                mainContent.setSizeFull();
                grid.setSizeFull();
                add(grid, mainContent);
            }
            boolean setVisible = userId != null;
            refresh(userId);
            grid.setVisible(setVisible);
            form.setVisible(setVisible);
            refreshButton.setVisible(setVisible);;
            addUser.setVisible(!setVisible);});
        addUser.addClickListener(e -> {
            newUserNameTextField.setVisible(true);
            newUserPasswordTextField.setVisible(true);
            saveUser.setVisible(true);});
        saveUser.addClickListener(e -> {
            userClient.addUser(newUserNameTextField.getValue(),
                    newUserPasswordTextField.getValue());
            saveUser.setVisible(false);
            newUserNameTextField.setVisible(false);
            newUserPasswordTextField.setVisible(false);});
        userNameLoginField.setPlaceholder("Enter login");
        userNameLoginField.setClearButtonVisible(true);
        userPasswordField.setPlaceholder("Enter password");
        userPasswordField.setClearButtonVisible(true);
        newUserNameTextField.setPlaceholder("Enter login");
        newUserNameTextField.setClearButtonVisible(true);
        newUserPasswordTextField.setPlaceholder("Enter password");
        newUserPasswordTextField.setClearButtonVisible(true);
        grid.setColumns("countryName", "total_cases", "tomorrow_grow", "day_after_tomorrow_grow", "date_3", "date_4");
        HorizontalLayout toolbar = new HorizontalLayout(userNameLoginField, userPasswordField, loginButton, addUser, refreshButton, newUserNameTextField, newUserPasswordTextField, saveUser);
        grid.asSingleSelect().addValueChangeListener(event -> form.setCountryRaw((CountryRaw) grid.asSingleSelect().getValue()));
        add(toolbar);

        setSizeFull();
    }

    public void refresh(String userId) {
        grid.setItems(countryRawService.getCountryRawSet(userId, userClient));
    }

}
