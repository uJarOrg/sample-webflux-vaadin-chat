package com.iqkv.incubator.sample.reactivevaadinchat;

import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("login")
class LoginView extends VerticalLayout {

  LoginView() {
    var form = new LoginForm();
    form.setAction("login");
    add(form);
  }
}
