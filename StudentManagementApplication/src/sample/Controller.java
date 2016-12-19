package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import jdk.nashorn.internal.objects.NativeUint8Array;

public class Controller {

    //set up the variables for the TextFields
    @FXML private TextField tfID;
    @FXML private TextField tfFirstName;
    @FXML private TextField tfLastName;
    @FXML private TextField tfEmailAddress;
    @FXML private TextField tfContactNumber;
    @FXML private TextField tfTotalMarks;

    //set up the variables for the Button
    @FXML private Button addButton;

    //set up the variables for the TextArea
    @FXML private TextArea taDisplay;

    //the setOnAction method for the button
    //ie whenever the button is clicked this method runs
    public void addTheData(){
        taDisplay.setEditable(false);
        taDisplay.setMouseTransparent(true);
        taDisplay.setFocusTraversable(false);
        taDisplay.appendText(tfID.getText()+"\t"+
                             tfFirstName.getText()+"\t"+
                             tfLastName.getText()+"\t"+
                             tfEmailAddress.getText()+"\t"+
                             tfContactNumber.getText()+"\t"+
                             tfTotalMarks.getText()+"\n");
        tfID.setText(null);
        tfFirstName.setText(null);
        tfLastName.setText(null);
        tfEmailAddress.setText(null);
        tfContactNumber.setText(null);
        tfTotalMarks.setText(null);
    }

}
