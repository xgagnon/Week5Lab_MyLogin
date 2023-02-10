<%-- 
    Document   : home
    Created on : 9-Feb-2023, 12:00:47 PM
    Author     : Xavier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Home Page</h1>
        <h3>Hello ${user.username}</h3>
        <a href="login?logout">Log out</a>
    </body>
</html>
