package com.blitzhetz;

import com.blitzhetz.controller.PasswordController;
import com.blitzhetz.model.PasswordModel;
import com.blitzhetz.view.PasswordView;

public class Main {
    public static void main(String[] args) {
        PasswordModel model = new PasswordModel("passwords.txt");
        PasswordView view = new PasswordView();
        PasswordController controller = new PasswordController(model, view);

        controller.addPassword("gmail", "jakasifra123");
        controller.addPassword("facebook", "slobodanz123");
        controller.getPasswords();
        controller.copyPassword("gmail");
    }
}
