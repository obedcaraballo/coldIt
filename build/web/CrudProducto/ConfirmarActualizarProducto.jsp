<%-- 
    Document   : confirActualizarPaciente
    Created on : 23/10/2017, 06:31:59 PM
    Author     : jcmm80
--%>

<%@page import="com.entidades.Producto"%>
<%@page import="com.persistencia.MpProducto"%>
<%@page import="com.persistencia.ManejadorBaseDatos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String id=session.getAttribute("ident").toString();
            Producto producto=(Producto)session.getAttribute("IdDelProducto");
            ManejadorBaseDatos mbd= ManejadorBaseDatos.getInstancia();
            mbd.conectar();
            MpProducto mpp=new MpProducto();
            mpp.setCon(mbd.getConexion());
           
            producto.setNombreProducto(request.getParameter("NombreProducto"));
            producto.setValorProducto(request.getParameter("ValorProducto"));
            

            
           
          
            if(mpp.updateProducto(producto, id)){
                
                
                %>
                
                Se actualizo el paciente tal con exito
                  out.println("<meta http-equiv=\"refresh\" content=\"5;url=BuscarProducto.jsp\">");  
                <%
            }else{
                %>
                error al actualizar
        out.println("<meta http-equiv=\"refresh\" content=\"10;url=BuscarProducto.jsp\">");
                <%
            }
            %>
            
    </body>
</html>


