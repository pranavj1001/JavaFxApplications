package sample;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    Group root = new Group();

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

        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        //Show save file dialog
        File file = fileChooser.showSaveDialog(Main.stage);

        if(file != null){
            SaveFile(taDisplay.getText(), file);
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
