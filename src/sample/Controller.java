package sample;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.text.DecimalFormat;

public class Controller {

    @FXML
    private TextField weight;

    @FXML
    private TextField height;

    @FXML
    private Button calculate;

    @FXML
    private TextField bmi;

    @FXML
    private ImageView image;

    @FXML
    void calculateButtonPressed(ActionEvent event) {
        try {
            Image bmi_img = new Image("images/bmi.png");

            Image normal_img = new Image("images/normal.gif");
            Image overweight_img = new Image("images/overweight.gif");
            Image underweight_img = new Image("images/underweight.jpg");
            Image obese_img = new Image("images/obese.gif");

            Double calculateBmi = null;
            Double w = new Double(weight.getText());
            Double h = new Double(height.getText());

            if ((h == 0 && w == 0) || h == 0) {
                bmi.setText("Incorrect. Please try again");
                image.setImage(bmi_img);
            } else {
                calculateBmi = (w)/Math.pow(h, 2);

                if (calculateBmi <= 18.5) {
                    image.setImage(underweight_img);
                    bmi.setText(String.format("%.2f", calculateBmi));
                }

                if (calculateBmi > 18.5 && calculateBmi <= 24.9) {
                    image.setImage(normal_img);
                    bmi.setText(String.format("%.2f", calculateBmi));
                }

                if (calculateBmi >= 25 && calculateBmi <= 29.9) {
                    image.setImage(overweight_img);
                    bmi.setText(String.format("%.2f", calculateBmi));
                }

                if (calculateBmi >= 30) {
                    image.setImage(obese_img);
                    bmi.setText(String.format("%.2f", calculateBmi));
                }
            }
        }
        catch (NumberFormatException ex) {
            weight.setText("Try again");
            weight.selectAll();
            weight.requestFocus();

            height.setText("Try again");
            height.selectAll();
            height.requestFocus();
        }
    }

}
