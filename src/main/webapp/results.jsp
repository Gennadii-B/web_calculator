<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*, main.java.*" %>


<html>
  <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Результаты работы калькулятора</title>
       <style type="text/css">
                     table {
                         border-collapse: collapse;
                     }
                     table th,
                     table td {
                         padding: 0 5px;
                         border: 1px solid #000;
                         text-align: center;
                     }
               </style>
  </head>
  <body>

        <form action="http://localhost:8080/webcalculator">
             <button type="submit"><< Calculator</button>
        </form>

       <h2>Results:</h2>

       <%
           DAO dao = DAO.getInstance();
           ArrayList<ExpLine> expLists = dao.getResultsFromDB();
           String[] test = {"hello", "world"};
           pageContext.setAttribute("test", test);

       %>
       <c:set var="count" value="${empty count?20:count}" />
      <c:forEach var="i" begin="1" end="15">
          <p>
              <c:out value="${i}" />
          </p>
      </c:forEach>


        <table >
                         <tr>
                           <th>id</th>
                           <th>expression</th>
                           <th>result</th>
                         </tr>

                         <tr>
                           <td>1</td>
                           <td>2+2</td>
                           <td>5</td>
                         </tr>

                    <%= Main.allResultsV2() %>
        </table><br/><br/>



  </body>
</html>