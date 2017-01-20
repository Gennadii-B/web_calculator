package main.java;

import java.io.IOException;

/**
 * Created by user on 19.01.2017.
 */
public class Calculate {

    private static int result = 0;

    public static int resultCalculate(String[] arguments, char operation)
            throws IOException, NumberFormatException {
        if(arguments.length == 2) {
            result = Integer.parseInt(arguments[0]);
            result = calculate(result, Integer.parseInt(arguments[1]), operation);
        }
        else if((arguments.length <= 1)){
            result = calculate(result, Integer.parseInt(arguments[1]), operation);
        }
        return result;
    }

    private static int calculate(int one, int two, char operation)
            throws NullPointerException{
        int res = 0;
        if(operation == '-'){ res = one - two;}
        if(operation == '+'){ res = one + two;}
        if(operation == '/'){ res = one / two;}
        if(operation == '*'){ res = one * two;}
        return res;
    }

    public static void setResult(int result) {
        Calculate.result = result;
    }
}
