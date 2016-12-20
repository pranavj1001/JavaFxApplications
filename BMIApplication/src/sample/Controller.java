package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    //set up the variables of the TextFields
    @FXML private TextField tfHeight;
    @FXML private TextField tfWeight;

    //set up the variables of the Labels
    @FXML private Label lBMI;
    @FXML private Label lRemark;

    @FXML private void calculateTheBMI(){

        double height;
        double weight;
        double bmi;
        String remark;

        height = Double.parseDouble(tfHeight.getText());
        weight = Double.parseDouble(tfWeight.getText());

        bmi = weight / (height * height);

        lBMI.setText(String.valueOf(bmi));

    }


}
