package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;

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
    String task = "";
    String preview = "";
    String priorityRadioButton = "";

    @FXML private void checkPriority(){
        if(radioButton1.isSelected()){
            priorityRadioButton = radioButton1.getText();
        }else if (radioButton2.isSelected()){
            priorityRadioButton = radioButton2.getText();
        }else if(radioButton3.isSelected()){
            priorityRadioButton = radioButton3.getText();
        }else if(radioButton4.isSelected()){
            priorityRadioButton = radioButton4.getText();
        }else if (radioButton5.isSelected()){
            priorityRadioButton = radioButton5.getText();
        }
        steps[1] = true;
    }

    @FXML private void addTask(){

        

    }

    @FXML private void clearTask(){

    }

    @FXML private void saveList(){

    }

    @FXML private void clearList(){

    }

    @FXML private void sortList(){

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
                return false;
            }
        }
        return false;

    }

    private void setSteps(){

        if(!datePicker.getValue().toString().isEmpty())
            steps[0] = true;
        if(!tfTime.getText().isEmpty())
            steps[1] = true;
        if(!taTask.getText().isEmpty())
            steps[2] = true;

    }

}
