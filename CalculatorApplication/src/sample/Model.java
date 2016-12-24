package sample;

/**
 * Created by Pranav Jain on 12/24/2016.
 */
public class Model {

    public double calculate(double n1, double n2, String operator){

        switch (operator){

            case "+":
                return n1 + n2;

            case "-":
                return n1 - n2;

            case "*":
                return n1 * n2;

            case "/":
                if(n2 != 0)
                    return n1 / n2;
                return 0;

            case "%":
                if(n2 != 0)
                    return (n1 / n2) * 100;
                return 0;

        }

        return 0;

    }

}
