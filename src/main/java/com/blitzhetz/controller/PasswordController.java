package com.blitzhetz.controller;

import java.util.List;

import com.blitzhetz.model.PasswordModel;
import com.blitzhetz.view.PasswordView;

public class PasswordController {
    private PasswordModel model;
    private PasswordView view;

    public PasswordController(PasswordModel model, PasswordView view) {
        this.model = model;
        this.view = view;
    }

    public void addPassword(String name, String password) {
        model.addPassword(name, password);
        view.displayMessage("Password added");
    }

    public void getPasswords() {
        List<String> passwords = model.getPasswords();
        view.displayPasswords(passwords);
    }

    public void copyPassword(String name) {
        model.copyPassword(name);
    }
}