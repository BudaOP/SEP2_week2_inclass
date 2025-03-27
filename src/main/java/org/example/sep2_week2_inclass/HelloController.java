package org.example.sep2_week2_inclass;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Locale;

public class HelloController {
    @FXML private Label lblDistance;
    @FXML private Label lblFuel;
    @FXML private Label lblResult;
    @FXML private TextField txtDistance;
    @FXML private TextField txtFuel;
    @FXML private Button btnCalculate;

    private ResourceBundle rb;

    public void initialize() {
        setLanguage(new Locale("en", "US"));
    }

    private void setLanguage(Locale locale) {
        lblResult.setText("");
        try {
            rb = ResourceBundle.getBundle("messages", locale);
            lblDistance.setText(rb.getString("distance.label"));
            lblFuel.setText(rb.getString("fuel.label"));
            btnCalculate.setText(rb.getString("calculate.button"));
        } catch (MissingResourceException e) {
            e.printStackTrace();
            lblResult.setText("Error loading resources.");
        }
    }

    @FXML
    public void onCalculateClick(ActionEvent event) {
        try {
            double distance = Double.parseDouble(txtDistance.getText());
            double fuel = Double.parseDouble(txtFuel.getText());
            double consumption = (fuel / distance) * 100;
            DecimalFormat df = new DecimalFormat("#0.00");
            String consumptionString = df.format(consumption);
            String resultTemplate = rb.getString("result.label");
            String resultText = MessageFormat.format(resultTemplate, consumptionString);
            lblResult.setText(resultText);
        } catch (NumberFormatException e) {
            lblResult.setText(rb != null ? rb.getString("invalid.input") : "Invalid input, please enter valid numbers.");
        }
    }

    @FXML public void onENClick(ActionEvent event) {
        setLanguage(new Locale("en", "US"));
    }

    @FXML public void onFRClick(ActionEvent event) {
        setLanguage(new Locale("fr", "FR"));
    }

    @FXML public void onJPClick(ActionEvent event) {
        setLanguage(new Locale("ja", "JP"));
    }

    @FXML public void onIRClick(ActionEvent event) {
        setLanguage(new Locale("fa", "IR"));
    }
}
