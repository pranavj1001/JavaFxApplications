package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {

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
    private boolean[] steps = new boolean[5];
    String task = "";
    String preview = "";

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

}
