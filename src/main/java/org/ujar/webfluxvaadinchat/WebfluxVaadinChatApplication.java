package org.ujar.webfluxvaadinchat;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.component.page.Push;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;

@SpringBootApplication
@Push
public class WebfluxVaadinChatApplication implements AppShellConfigurator {
  public static void main(String[] args) {
    SpringApplication springApplication = new SpringApplication(WebfluxVaadinChatApplication.class);
    springApplication.setApplicationStartup(new BufferingApplicationStartup(2048));
    springApplication.run(args);
  }
}


