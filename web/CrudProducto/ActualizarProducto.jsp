<%-- 
    Document   : ActualizarUsuario
    Created on : 4/05/2020, 06:51:03 PM
    Author     : mipc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.entidades.Producto"%>
<%@page import="com.persistencia.MpProducto"%>
<%@page import="com.persistencia.ManejadorBaseDatos"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Producto</title>
    </head>
    <body>
         <%
            String idProducto=request.getParameter("ident");
            ManejadorBaseDatos mbd= ManejadorBaseDatos.getInstancia();
            mbd.conectar();
            MpProducto mpp=new MpProducto();
            mpp.setCon(mbd.getConexion());
            Producto IdDelProducto=mpp.obtenerPorIdProducto(idProducto);
            session.setAttribute("ident", idProducto);
            session.setAttribute("IdDelProducto", IdDelProducto);
            %>
            <div align="center">
                 <h2> Datos Basicos</h2><br><br>
                 <form action="ConfirmarActualizarProducto.jsp" method="POST">
            
           Nombre Del Producto: <input type="text" name="NombreProducto" value="<%= IdDelProducto.getNombreProducto()%>" />&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
          Valor Del Producto <input type="text" name="ValorProducto" value="<%=    IdDelProducto.getValorProducto()%>" />&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
         <form action="ConfirmarActualizarProducto.jsp" method="POST">
                <input type="submit" value="Editar" />  
            </form>
                 </form>
                     
         
            
         <form action="EliminarProducto.jsp" method="POST">
                <input type="submit" value="Eliminar" />  
            </form>
    </body>
</html>
