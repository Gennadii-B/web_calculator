package main.java;

import java.sql.*;
import java.util.*;
/**
 * Created by user on 19.01.2017.
 */
public class DAO {
    private static DAO ourInstance = new DAO();

    public static DAO getInstance() {
        return ourInstance;
    }

    private DAO() {
    }

    private String JDBCdriver;
    private String url;
    private Connection connection;
    private PreparedStatement ps;
    private Statement st;
    ResultSet rs;

    private static Properties properties() {
        Properties property = new Properties();
        property.put("database", "jdbc:postgresql://localhost:5432/test");
        property.put("user", "postgres");
        property.put("password", "admin1788");
        return property;
    }

    void regDriverManager() {
        try {
            JDBCdriver = "org.postgresql.Driver";
            Class.forName(JDBCdriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void connect() {
        try {

            url = "jdbc:postgresql://localhost:5432/test";
            connection = DriverManager.getConnection(url, properties());
            System.out.println("connect [ on ]");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnect(){
        try {
            if(connection != null)connection.close();
            System.out.println("connect [ off ]");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void putResExpr(String expression, String result) {
        String insert = "INSERT INTO CALCULATOR (EXPRESSION, RESULT) VALUES (?,?);";
        try {
            ps = connection.prepareStatement(insert);
            ps.setString(1, expression);
            ps.setString(2, result);
            ps.executeUpdate();
            System.out.println("запись в БД прошла!!!");
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if(ps != null)ps.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public ArrayList<ExpLine> getResultsFromDB() throws SQLException{
        regDriverManager();
        connect();
        String select = "SELECT ID, EXPRESSION, RESULT FROM CALCULATOR";
        ArrayList<ExpLine> expLines = new ArrayList<ExpLine>();
        try {
            st = connection.createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                ExpLine expLine = new ExpLine();
                expLine.setId(rs.getString("ID"));
                expLine.setExpression(rs.getString("EXPRESSION"));
                expLine.setResult(rs.getString("RESULT"));
                expLines.add(expLine);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            rs.close();
            st.close();
            disconnect();
            return expLines;
        }
    }
}
