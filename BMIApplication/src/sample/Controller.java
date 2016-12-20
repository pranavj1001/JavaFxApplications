package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {

    String remark = "";
    String bmiResult = "";

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

        height = Double.parseDouble(tfHeight.getText());
        weight = Double.parseDouble(tfWeight.getText());

        if(tfHeight.getText() != "" && tfWeight.getText() != "") {

            bmi = weight / (height * height);
            bmiResult = String.valueOf(bmi);

            if (bmi <= 15) {
                remark = "You are very severely underweight. Please consult a doctor.";
                lRemark.setStyle("-fx-text-fill: darkblue;");
                lBMI.setStyle("-fx-text-fill: darkblue;");
            } else if (bmi > 15 && bmi <= 16) {
                remark = "You are severely underweight. Please consult a doctor.";
                lRemark.setStyle("-fx-text-fill: darkblue;");
                lBMI.setStyle("-fx-text-fill: darkblue;");
            } else if (bmi > 16 && bmi <= 18.5) {
                remark = "You are underweight. Please gain some weight.";
                lRemark.setStyle("-fx-text-fill: blue;");
                lBMI.setStyle("-fx-text-fill: blue;");
            } else if (bmi > 18.5 && bmi <= 25) {
                remark = "You are healthy! Good work!";
                lRemark.setStyle("-fx-text-fill: green;");
                lBMI.setStyle("-fx-text-fill: green;");
            } else if (bmi > 25 && bmi <= 30) {
                remark = "You are overweight. Please try to reduce your weight.";
                lRemark.setStyle("-fx-text-fill: red;");
                lBMI.setStyle("-fx-text-fill: red;");
            } else if (bmi > 30 && bmi <= 35) {
                remark = "You are moderately obese. Please try to reduce your weight.";
                lRemark.setStyle("-fx-text-fill: darkred;");
                lBMI.setStyle("-fx-text-fill: darkred;");
            } else if (bmi > 35 && bmi <= 40) {
                remark = "You are severely obese.Please consult a doctor.";
                lRemark.setStyle("-fx-text-fill: darkred;");
                lBMI.setStyle("-fx-text-fill: darkred;");
            } else if (bmi > 40) {
                remark = "You are very severely obese. Please consult a doctor.";
                lRemark.setStyle("-fx-text-fill: darkred;");
                lBMI.setStyle("-fx-text-fill: darkred;");
            } else {
                remark = "There's an error in the system. Please give us time to fix it";
            }

            lBMI.setText(bmiResult);
            lRemark.setText(remark);

        } else {

        }

    }

    @FXML private void saveTheBMI(){

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //get current date time with Date()
        Date date = new Date();

        String data = bmiResult + "\n" + remark + "\n" + dateFormat.format(date);

        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        //Show save file dialog
        File file = fileChooser.showSaveDialog(Main.stage);

        if(file != null){
            SaveFile(data, file);
        }
    }

    private void SaveFile(String content, File file){
        try {
            FileWriter fileWriter;

            fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(Controller.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

}
