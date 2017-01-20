package main.java;

import java.io.IOException;

import main.java.Calculate;
import main.java.Reader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static java.lang.System.err;
import static java.lang.System.out;

/**
 * Created by user on 19.01.2017.
 */
public class Main {

    private static String[] numbers = {"2", "2"};
    private static char operation = '+';
    private static DAO dao = DAO.getInstance();
    private static String res = "1";

    public static String genAction(String expression) {
            res = count(expression);
            dao.regDriverManager();
            dao.connect();
            dao.putResExpr(expression, res);
            dao.disconnect();
            return res;
    }


    public static String allResultsV2() throws SQLException{
        ArrayList<ExpLine> res = dao.getResultsFromDB();
        String results = "\n";
        for(ExpLine el : res){
            results+= "<tr> <td>" + el.getId() +"</td>" +
                    "<td>" + el.getExpression() + "</td>" +
                    "<td>" + el.getResult() + "</td> " +
                    "</tr>";
        }
        return results;
    }

    static String count(String expression){
        try {
                try {
                    numbers = Reader.readNumbers(expression);
                    operation = Reader.readOperation(expression);
                    String result = String.valueOf(Calculate.resultCalculate(numbers, operation));
                    return result;

                } catch (NumberFormatException e) {
                    err.println("неправильный ввод");
                    return "неправильный ввод";
                } catch (NullPointerException e) {
                    err.println("переменная не инициализирована");
                    return "переменная не инициализирована";
                } catch (ArrayIndexOutOfBoundsException e) {
                    err.println("неправильный ввод, результат сброшен");
                    Calculate.setResult(0);
                    return "неправильный ввод, результат сброшен";
                } catch (IOException e) {
                    err.println("ошибка ввода/вывода");
                    return "ошибка ввода/вывода";
                }
            }catch(Throwable T) {
            System.err.println("произошло нечто страшное");
                T.printStackTrace();
                return "произошло нечто страшное";
            }
        }

}