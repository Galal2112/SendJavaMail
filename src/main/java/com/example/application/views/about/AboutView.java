package com.example.application.views.about;

import com.example.application.javamail.CommonsEmailService;
import com.example.application.views.main.MainView;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.apache.commons.mail.EmailException;

import java.io.IOException;
import java.util.Arrays;

@Route(value = "about", layout = MainView.class)
@PageTitle("About")
public class AboutView extends Div {

    public AboutView() {
        setId("about-view");
        add(new Text("Content placeholder"));
        String from = "test1@test.com";
        String to = "test2@test.com";
        String subject = "Test mail";
        String text = "Hello mail";
        try {
            CommonsEmailService.send(from, Arrays.asList(to), subject, text);
        } catch (IOException | EmailException e) {
            e.printStackTrace();
        }
    }

}
