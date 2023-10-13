<%-- 
    Document   : admin
    Created on : Jun 26, 2023, 7:23:01 AM
    Author     : 84398
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="BasicObject.Food"%>
<%@page import="BasicObject.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% User u = (User) request.getAttribute("logined");

            if (u == null) {
                response.sendRedirect("login.jsp");
            } else {
        %>
        <h1>Welcome <%= u.getFullname()%></h1>

        <%
            ArrayList<Food> list = (ArrayList<Food>) request.getAttribute("FoodList");
            if (list != null && list.size() > 0) {
        %>
        <table border = "1">
            <tr style="color: red" >
                <td>ID</td>
                <td>Name</td>
                <td>Description</td>
                <td>Price</td>
                <td>Cooking Time</td>
                <td>Status</td>
            </tr>
            <%
                for (Food f : list) {
            %>

            <tr>
                <td><%= f.getId()%></td>
                <td><%= f.getName()%></td>
                <td><%= f.getDescription()%></td>
                <td><%= f.getPrice()%></td>
                <td><%= f.getTime()%></td>
                <td><%= f.isStatus()%></td>
            </tr>


            <%
                }
            %>
            <form action="AddServlet" method="post">
                <td><input type="text" name="txtid" placeholder="Insert ID"></td>
                <td><input type="text" name="txtname" placeholder="Insert name"></td>
                <td><input type="text" name="txtdes" placeholder="Insert description"></td>
                <td><input type="number" name="txtprice" min="1" placeholder="Insert price"></td>
                <td><input type="number" name="txttime" placeholder="Insert time"></td>
                <td><input type="text" name="txtstatus" placeholder="Insert status"></td>
                <td><input type="submit" value="Add"></td>
            </form>
            <%
                } else {
                    out.print("<h4>No Data</h4>");
                }
            %>
        </table>
        <%
            }
        %>
    </body>
</html>
