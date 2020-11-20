<%-- 
    Document   : default
    Created on : Nov 20, 2020, 8:13:11 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${sessionScope.USER.fullName}</title>
    </head>
    <body>
        <h1>Hello ${sessionScope.USER.fullName}</h1>
    </body>
</html>
