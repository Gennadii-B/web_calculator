<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*, main.java.*, java.sql.*" %>


<html>
  <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Simple калькулятор</title>
  </head>
  <body>
       <h3>Welcome to calculator</h3>
       <h1>2+2</h1>

       <%
             String expression = request.getParameter("numbers");

        %>


        <form action="">
            <input type="text" name="numbers"/><br/>
            <input type="submit" value="RESULT" value="result">
            <input type="reset" name="RESET" value="reset"><br/>
            <input type="text" readonly="readonly" value= <%= Main.genAction(expression)%>>
        </form><br/><br/>

        <form action="results.jsp">
                <button type="submit">All results</button>
        </form>

   </body>
</html>

