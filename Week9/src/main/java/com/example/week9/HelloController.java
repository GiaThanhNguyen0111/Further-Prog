package com.example.week9;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

import java.time.LocalTime;
import java.util.Date;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private Label result;

    @FXML
    private TextField number1;

    @FXML
    private TextField number2;

    @FXML
    private FlowPane flowPane;

    @FXML
    protected void onHelloButtonClick() {
//        LocalTime currentTime = LocalTime.now();
//        if (currentTime.isBefore(LocalTime.NOON)) {
//            welcomeText.setText("Good morning");
//        } else if (currentTime.isBefore(LocalTime.of(18, 0))) {
//            welcomeText.setText("Good afternoon");
//        } else {
//            welcomeText.setText("Good evening");
//        }
        flowPane.setHgap(10);
        number1.setPrefColumnCount(1);
        number2.setPrefColumnCount(1);
        int finalResult = Integer.parseInt(number1.getText()) + Integer.parseInt(number2.getText());
        result.setText(Integer.toString(finalResult));
    }
}