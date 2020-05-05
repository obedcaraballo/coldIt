<%-- 
    Document   : RegistrarUsuario
    Created on : 4/05/2020, 06:24:35 PM
    Author     : mipc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Funcionario</title>
    </head>
    <body>
        <div style="text-align:center;">
            
            <form method="POST" action="RegistroUsuarioController">
                <table border="0">
                <thead>
                    <tr>
                   
                        
                <label> ID:  </label><input type="text" name="IdUsuario" value="" placeholder="1234567890"> 
                 <br/><br>
                 <label> Nombres <input type="text" name="NombreUsuario" value="" placeholder="Obed"/>
                          <br/><br>
                          <label> Apellidos    </label><input type="text" name="ApellidoUsuario" value=""  placeholder="Caraballo"> 
                       <br/><br> <input type="submit" value="Registrar"  /> 
                    </tr>
                  </thead>
            </form>
            
            
            
        </div>
    </body>
</html>
