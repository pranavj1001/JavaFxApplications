package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {

    //set up the variables of the DatePicker
    @FXML private DatePicker datePicker;

    //set up the variables of the Button
    @FXML private Button bAddTask;
    @FXML private Button bClearTask;
    @FXML private Button bSaveList;
    @FXML private Button bClearList;
    @FXML private Button bSortList;

    //set up the variables of the Label
    @FXML private Label lError;

    //set up the variables of the Text Field
    @FXML private TextField tfTime;

    //set up the variables of the Text Field
    @FXML private TextArea taTask;
    @FXML private TextArea taPreview;

    //set up the variables of the Radio Buttons
    @FXML private RadioButton radioButton1;
    @FXML private RadioButton radioButton2;
    @FXML private RadioButton radioButton3;
    @FXML private RadioButton radioButton4;
    @FXML private RadioButton radioButton5;

    //set up the variables of the ToggleGroup
    @FXML private ToggleGroup priority;

    //set up the variables that we need to run the program;
    private boolean[] steps = {false, false, false, false};
    private String task = "";
    private ArrayList<String> priorityList1 = new ArrayList<>();
    private ArrayList<String> priorityList2 = new ArrayList<>();
    private ArrayList<String> priorityList3 = new ArrayList<>();
    private ArrayList<String> priorityList4 = new ArrayList<>();
    private ArrayList<String> priorityList5 = new ArrayList<>();
    private String priorityRadioButton = "";
    private int priorityNumber = 0;

    @FXML private void checkPriority(){
        if(radioButton1.isSelected()){
            priorityRadioButton = radioButton1.getText();
            priorityNumber = 1;
        }else if (radioButton2.isSelected()){
            priorityRadioButton = radioButton2.getText() + "     ";
            priorityNumber = 2;
        }else if(radioButton3.isSelected()){
            priorityRadioButton = radioButton3.getText() + "      ";
            priorityNumber = 3;
        }else if(radioButton4.isSelected()){
            priorityRadioButton = radioButton4.getText() + "      ";
            priorityNumber = 4;
        }else if (radioButton5.isSelected()){
            priorityRadioButton = radioButton5.getText() + " ";
            priorityNumber = 5;
        }
        steps[2] = true;
    }

    @FXML private void addTask(){

        setSteps();

        if(goAhead()){

            task = datePicker.getValue().toString() + "\t" +
                   tfTime.getText() + "\t" +
                   priorityRadioButton + "\t\t" +
                   taTask.getText() + "\n";

            taPreview.appendText(task);

            if(priorityNumber == 1)
                priorityList1.add(task);
            if(priorityNumber == 2)
                priorityList2.add(task);
            if(priorityNumber == 3)
                priorityList3.add(task);
            if(priorityNumber == 4)
                priorityList4.add(task);
            if(priorityNumber == 5)
                priorityList5.add(task);

            lError.setText("Task Added");

        }

    }

    @FXML private void clearTask(){

        datePicker.setValue(null);
        tfTime.setText("");
        taTask.setText("");

        for(int i = 0; i < steps.length; i++){
            steps[i] = false;
            if(i == 2)
                steps[i] = true;
        }

        lError.setText("Task was Cleared");

    }

    @FXML private void saveList(){

        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        //Show save file dialog
        File file = fileChooser.showSaveDialog(Main.stage);

        if(file != null){
            SaveFile(taPreview.getText(), file);
        }

        lError.setText("The List was Saved");

    }

    @FXML private void clearList(){

        taPreview.setText("");
        priorityList1.clear();
        priorityList2.clear();
        priorityList3.clear();
        priorityList4.clear();
        priorityList5.clear();

        lError.setText("The List was cleared");

    }

    @FXML private void sortList(){

        taPreview.setText("");

        taPreview.appendText("// Very High\n");
        for(String x : priorityList1)
            taPreview.appendText(x);
        taPreview.appendText("\n// High");
        for(String x : priorityList2)
            taPreview.appendText(x);
        taPreview.appendText("\n// Mid");
        for(String x : priorityList3)
            taPreview.appendText(x);
        taPreview.appendText("\n// Low");
        for(String x : priorityList4)
            taPreview.appendText(x);
        taPreview.appendText("\n// VeryLow");
        for(String x : priorityList5)
            taPreview.appendText(x);
        taPreview.appendText("\n");

        lError.setText("The list was sorted");

    }

    private boolean goAhead(){

        boolean check = false;

        for(int i = 0; i < steps.length; i++){
            if(steps[i])
                check = true;
            else
                check = false;
        }

        if(check){
            return true;
        }else {
            if(!steps[0])
                lError.setText("Please select the date");
            else if(!steps[1]){
                lError.setText("Please select the time");
            }else if(!steps[2]){
                lError.setText("Please select the priority");
            }else if(!steps[3]){
                lError.setText("Please write something for the Task ");
            }else {
                lError.setText("System Error");
            }
        }
        return false;

    }

    private void setSteps(){

        if(datePicker.getValue() != null)
            steps[0] = true;
        if(!tfTime.getText().isEmpty())
            steps[1] = true;
        if(!taTask.getText().isEmpty())
            steps[3] = true;

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
