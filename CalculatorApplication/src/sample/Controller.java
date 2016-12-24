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
    private Model model = new Model();

    @FXML private void processNumber(ActionEvent actionEvent){

        if(start){
            screen.setText("");
            start = false;
        }

        String value  = ((Button) actionEvent.getSource()).getText();
        screen.setText(screen.getText() + value);

    }

    @FXML private void processOperator(ActionEvent actionEvent){

        String value  = ((Button) actionEvent.getSource()).getText();

        if(!"=".equals(value)){
            if(!operator.isEmpty())
                return;

            operator = value;
            number = Double.parseDouble(screen.getText());
            screen.setText("");

        }else{
            if(operator.isEmpty())
                return;

            if(!screen.getText().isEmpty())
                screen.setText(String.valueOf(model.calculate(number, Double.parseDouble(screen.getText()), operator)));
            else
                screen.setText(String.valueOf(model.calculate(0.0, number, operator)));

            operator = "";
            start = true;

        }

    }

    @FXML private void clearText(){

        start = true;
        operator = "";
        number = 0;
        screen.setText("");

    }

}
