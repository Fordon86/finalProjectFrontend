package com.kodilla.covid_front;

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

@Route
public class MainView extends VerticalLayout {

    @Autowired
    private UserClient userClient;

    private CountryRawService countryRawService = CountryRawService.getInstance();
    private Grid grid = new Grid<>(CountryRaw.class);
    private CountryForm form = new CountryForm(this);
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
        form.setVisible(false);
        refreshButton.setVisible(false);
        newUserNameTextField.setVisible(false);
        newUserPasswordTextField.setVisible(false);
        saveUser.setVisible(false);
//        loginButton.addClickListener(e -> {grid.asSingleSelect().clear();
        loginButton.addClickListener(e -> {
        boolean result = userClient.validateUser(userNameLoginField.getValue(),
                    userPasswordField.getValue());
//            userClient.getUserFullView(userNameLoginField.getValue());
            grid.setVisible(result);
            form.setVisible(result);
            refreshButton.setVisible(result);;
            addUser.setVisible(result);});
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
        grid.setColumns("countryType", "date", "date_1", "date_2", "date_3", "date_4");
        HorizontalLayout toolbar = new HorizontalLayout(userNameLoginField, userPasswordField, loginButton, addUser, refreshButton, newUserNameTextField, newUserPasswordTextField, saveUser);
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
