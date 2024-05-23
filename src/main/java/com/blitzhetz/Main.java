package com.blitzhetz;

import com.blitzhetz.controller.PasswordController;
import com.blitzhetz.model.PasswordModel;
import com.blitzhetz.view.PasswordView;

public class Main {

    public static void main(String[] args) {
        PasswordModel model = new PasswordModel();
        PasswordView view = new PasswordView();
        PasswordController controller = new PasswordController(model, view);

        controller.startApplication();
    }
}
