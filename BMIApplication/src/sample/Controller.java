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

        if(bmi <= 15){
            remark = "You are very severely underweight. Please consult a doctor.";
            lRemark.setStyle("-fx-text-fill: darkblue;");
            lBMI.setStyle("-fx-text-fill: darkblue;");
        }else if(bmi > 15 && bmi <= 16){
            remark = "You are severely underweight. Please consult a doctor.";
            lRemark.setStyle("-fx-text-fill: darkblue;");
            lBMI.setStyle("-fx-text-fill: darkblue;");
        }else if(bmi > 16 && bmi <= 18.5){
            remark = "You are underweight. Please gain some weight.";
            lRemark.setStyle("-fx-text-fill: blue;");
            lBMI.setStyle("-fx-text-fill: blue;");
        }else if(bmi > 18.5 && bmi <= 25){
            remark = "You are healthy! Good work!";
            lRemark.setStyle("-fx-text-fill: green;");
            lBMI.setStyle("-fx-text-fill: green;");
        }else if(bmi > 25 && bmi <= 30){
            remark = "You are overweight. Please try to reduce your weight.";
            lRemark.setStyle("-fx-text-fill: red;");
            lBMI.setStyle("-fx-text-fill: red;");
        }else if(bmi > 30 && bmi <= 35){
            remark = "You are moderately obese. Please try to reduce your weight.";
            lRemark.setStyle("-fx-text-fill: darkred;");
            lBMI.setStyle("-fx-text-fill: darkred;");
        }else if(bmi > 35 && bmi <= 40){
            remark = "You are severely obese.Please consult a doctor.";
            lRemark.setStyle("-fx-text-fill: darkred;");
            lBMI.setStyle("-fx-text-fill: darkred;");
        }else if(bmi > 40){
            remark = "You are very severely obese. Please consult a doctor.";
            lRemark.setStyle("-fx-text-fill: darkred;");
            lBMI.setStyle("-fx-text-fill: darkred;");
        }else{
            remark = "There's an error in the system. Please give us time to fix it";
        }

        lBMI.setText(String.valueOf(bmi));
        lRemark.setText(remark);

    }


}
