package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Created by user on 19.01.2017.
 */
public class Reader {
    private static char[] allOperations = new char[]{'*', '/', '-', '+'};
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static char needOper;

    public static String ReadLine() throws IOException{
        return reader.readLine();
    }

    public static char readOperation(String str) throws IOException {
        int idCom;
        for(char oper: allOperations){
            idCom = str.indexOf(oper);
            if(idCom >= 0) needOper = str.charAt(idCom);
        }
        return needOper;
    }

    public static String[] readNumbers(String str) throws IOException{
        String[] expression = str.split("[\\/]|[\\+]|[\\*]|[\\-]");
        return expression;
    }
}
