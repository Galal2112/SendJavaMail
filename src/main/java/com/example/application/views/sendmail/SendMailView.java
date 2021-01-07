package com.example.application.views.sendmail;

import com.example.application.javamail.CommonsEmailService;
import com.example.application.views.main.MainView;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.apache.commons.mail.EmailException;

import java.io.IOException;
import java.util.Arrays;

@Route(value = "sendMail", layout = MainView.class)
@PageTitle("Send Mail")
public class SendMailView extends VerticalLayout {

    TextField fromTextField = new TextField("Your email:");
    TextField subjectTextField = new TextField("Subject:");
    private TextArea notificationTextArea = new TextArea("Your Message:");
    private Button send = new Button("Send");

    public SendMailView() {
        setId("send-mail-view");
        add(new Text("Send Mail:"));
        setSizeFull();
        notificationTextArea.setHeight("30%");
        notificationTextArea.setWidth("20%");
        add(fromTextField);
        add(subjectTextField);
        add(notificationTextArea);
        add(send);
        send.addClickListener(e -> sendMail());
    }

    private void sendMail() {
        try {
            // TODO: Get all users
            String to = "myUser@test.com";
            CommonsEmailService.send(fromTextField.getValue(), Arrays.asList(to),
                    subjectTextField.getValue(), notificationTextArea.getValue());
        } catch (IOException | EmailException e) {
            e.printStackTrace();
        }
    }

}
