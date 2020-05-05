<%-- 
    Document   : eliminarPaciente
    Created on : 23/10/2017, 06:51:25 PM
    Author     : jcmm80
--%>

<%@page import="com.persistencia.MpProducto"%>
<%@page import="com.persistencia.ManejadorBaseDatos"%>
<%@page import="com.entidades.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
          <%
            String ide=session.getAttribute("ident").toString();            
            ManejadorBaseDatos mbd= ManejadorBaseDatos.getInstancia();
            mbd.conectar();
            MpProducto mpp=new MpProducto();
            mpp.setCon(mbd.getConexion());
            
            if(mpp.deleteProducto(ide)){
                %>
                
                <%
                    %>
                    <h1> <CENTER>Se elimino el producto  con exito</CENTER></h1>
                    <form action="ActualizarProducto.jsp">
                        <br>
                       <CENTER> <input type="submit" value="Volver" /> </CENTER> 
                    </form>
          
           <%
                    
            }else{
                %>
                error al eliminar
        
                <%
                   
            }
            %>
    </body>
</html>
