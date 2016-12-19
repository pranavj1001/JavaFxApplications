package sample;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    //set up the variables for the TextFields
    public TextField tfID;
    public TextField tfFirstName;
    public TextField tfLastName;
    public TextField tfEmailAddress;
    public TextField tfContactNumber;
    public TextField tfTotalMarks;

    //set up the variables for the Button
    public Button addButton;

    //set up the variables for the TextArea
    public TextArea taDisplay;

    //the setOnAction method for the button
    //ie whenever the button is clicked this method runs
    public void addTheData(){
        taDisplay.appendText(tfID.getText()+"\t"+
                             tfFirstName.getText()+"\t"+
                             tfLastName.getText()+"\t"+
                             tfEmailAddress.getText()+"\t"+
                             tfContactNumber.getText()+"\t"+
                             tfTotalMarks.getText()+"\n");
    }

}
