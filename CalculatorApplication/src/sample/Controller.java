package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controller {

    //set up the variables of the text
    @FXML private Text screen;

    //set up the variables
    private double number = 0;
    private String operator = "";
    private boolean start = true;

    @FXML private void processNumber(ActionEvent actionEvent){

        if(start){
            screen.setText("");
            start = false;
        }

        String value  = ((Button) actionEvent.getSource()).getText();
        screen.setText(screen.getText() + value);

    }

    @FXML private void processOperator(){

    }

    @FXML private void calculateAnswer(){

    }


}
