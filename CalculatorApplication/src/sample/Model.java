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

            case "x^0.5":
                return Math.sqrt(n2);

            case "x^2":
                return n2 * n2;

            case "1/x":
                return 1 / n2;

            case "!":
                return factorial(n2);

        }

        return 0;

    }

    private double factorial(double number){
        int i;
        double fact = 1;
        for(i = 1;i <= number; i++){
            fact = fact * i;
        }
        return fact;
    }

}
