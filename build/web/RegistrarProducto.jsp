<%-- 
    Document   : RegistrarProducto
    Created on : 4/05/2020, 07:33:56 PM
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
        <title>JSP Page</title>
    </head>
    <body>
        <div style="text-align:center;">
            
            <form method="POST" action="RegistroProductoController">
                <table border="0">
                <thead>
                    <tr>
                   
                        
                <label> ID:  </label><input type="text" name="IdProducto" value="" placeholder="123"> 
                 <br/><br>
                 <label> Nombres <input type="text" name="NombreProducto" value="" placeholder="Producto1"/>
                          <br/><br>
                          <label> Valor    </label><input type="text" name="ValorProducto" value=""  placeholder="1200"> 
                       <br/><br> <input type="submit" value="Registrar"  /> 
                    </tr>
                  </thead>
            </form>
            
            
            
        </div>
    </body>
</html>
