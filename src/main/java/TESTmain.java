package main.java;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by user on 19.01.2017.
 */
public class TESTmain {
    public static void main(String[] args) throws SQLException{
        DAO dao = DAO.getInstance();
        ArrayList<ExpLine> el = dao.getResultsFromDB();
        for(ExpLine exli : el){
            System.out.println(exli.getId());
            System.out.println(exli.getExpression());
            System.out.println(exli.getResult());
        }


    }
}
