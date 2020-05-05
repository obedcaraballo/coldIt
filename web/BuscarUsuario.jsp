<%-- 
    Document   : BuscarUsuario
    Created on : 4/05/2020, 05:41:40 PM
    Author     : mipc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.controller.IdUserController"%>
<%@page import="com.persistencia.ManejadorBaseDatos"%>
<%@page import="com.persistencia.MpUsuario"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buscar Funcionario Por ID</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <div align="center">
            <form action="IdUserController" method="POST" autocomplete="off">
                
            <h1><font color="blue">ID DEL USUARIO</font></h1>
            <br>
            <input type="text" name="ide" value="" />
           
            <input type="submit" value="Buscar Usuario" />
            </form>
            </div>
    </body>
</html>
