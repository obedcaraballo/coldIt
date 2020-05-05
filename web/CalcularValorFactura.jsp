<%-- 
    Document   : CalcularValorFactura
    Created on : 5/05/2020, 01:58:58 PM
    Author     : mipc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calcular Valor  Cancelar</title>
    </head>
    <body>
        
        <%
            //RECIBIMOS TODOS LOS DATOS QUE INGRESAMOS EN LA FACTURA
            String Nombreusuario=request.getParameter("NombreUsuario");
            
       String Nombreproducto1=request.getParameter("NombreProducto1");
   String Nombreproducto2=request.getParameter("NombreProducto2");
   String Nombreproducto3=request.getParameter("NombreProducto3");
   String Nombreproducto4=request.getParameter("NombreProducto4");
   String Nombreproducto5=request.getParameter("NombreProducto5");
   String Nombreproducto6=request.getParameter("NombreProducto6");
   String Nombreproducto7=request.getParameter("NombreProducto7");
   String Nombreproducto8=request.getParameter("NombreProducto8");
   String Nombreproducto9=request.getParameter("NombreProducto9");
   String Nombreproducto10=request.getParameter("NombreProducto10");

   String Cantidad1=request.getParameter("CantidadProducto1");
   String Cantidad2=request.getParameter("CantidadProducto2");
   String Cantidad3=request.getParameter("CantidadProducto3");
   String Cantidad4=request.getParameter("CantidadProducto4");
   String Cantidad5=request.getParameter("CantidadProducto5");
   String Cantidad6=request.getParameter("CantidadProducto6");
   String Cantidad7=request.getParameter("CantidadProducto7");
   String Cantidad8=request.getParameter("CantidadProducto8");
   String Cantidade9=request.getParameter("CantidadProducto9");
   String Cantidade10=request.getParameter("CantidadProducto10");
   
   String Valor1=request.getParameter("TotalProducto1");
   String Valor2=request.getParameter("TotalProducto2");
   String Valor3=request.getParameter("TotalProducto3");
   String Valor4=request.getParameter("TotalProducto4");
   String Valor5=request.getParameter("TotalProducto5");
   String Valor6=request.getParameter("TotalProducto6");
   String Valor7=request.getParameter("TotalProducto7");
   String Valor8=request.getParameter("TotalProducto8");
   String Valore9=request.getParameter("TotalProducto9");
   String Valore10=request.getParameter("TotalProducto10");
       
      

    int uno = Integer.parseInt(Cantidad1);
    int dos = Integer.parseInt(Cantidad2);
    int tres= Integer.parseInt(Cantidad3);
    int cuatro= Integer.parseInt(Cantidad4);
       int cinco= Integer.parseInt(Cantidad5);
       int seis= Integer.parseInt(Cantidad6);
       int siete= Integer.parseInt(Cantidad7);
       int ocho= Integer.parseInt(Cantidad8);
       int nueve= Integer.parseInt(Cantidade9);
       int diez= Integer.parseInt(Cantidade10);
      
       int Total=(uno+dos+tres+cuatro+cinco+seis+siete+ocho+nueve+diez);
   
           out.print("El resto de la división es :" +Total);
           

       double valorproducto1 = Double.parseDouble(Valor1);
       double valorproducto2 = Double.parseDouble(Valor2);
       double valorproducto3 = Double.parseDouble(Valor3);
       double valorproducto4 = Double.parseDouble(Valor4);
       double valorproducto5 = Double.parseDouble(Valor5);
       double valorproducto6 = Double.parseDouble(Valor6);
       double valorproducto7 = Double.parseDouble(Valor7);
       double valorproducto8 = Double.parseDouble(Valor8);
       double valorproductot9 = Double.parseDouble(Valore9);
       double valorproductot10 = Double.parseDouble(Valore10);
       
 double TotalProducto=(valorproducto1+valorproducto2+valorproducto3+valorproducto4+valorproducto5+valorproducto6+valorproducto7+valorproductot9+valorproducto8+valorproductot10);
   
           out.print("El resto de la división es :" +TotalProducto);
           

    double totalapagar=((valorproducto1*uno)+(valorproducto2*dos)+(valorproducto3*tres)+(valorproducto4*cuatro)+(valorproducto5*cinco)+(valorproducto6*seis)+(valorproducto7*siete)+(valorproducto8*ocho)+(valorproductot9*nueve)+(valorproductot10*diez));   
 out.print("El resto de la división es :" +totalapagar);
       %>
        
       
       
       
       <form method="POST" action="RegistroFacturaController">
          <label> Nombre Usuario <input type="text" name="NombreUsuario" value="<%= Nombreusuario%>" placeholder="Obed Caraballo"/>
      <table border="1">
          <thead>
              <tr>
                  <th>IdProducto</th>
                  <th>Nombre Producto</th>
                  <th>Cantidad</th>
                  <th>Valor</th>
              </tr>
          </thead>
          <tbody>
              <tr>
                  <td><input type="text" value="0"  name="IdFactura1"></td>
                  <td><input type="text" value="<%= Nombreproducto1%>" name="NombreProducto1"></td>
                  <td><input type="text" value="<%= Cantidad1%>"name="CantidadProducto1"></td>
                  <td><input type="text" value="<%= Valor1%>" name="TotalProducto1"></td>
              </tr>
              <tr>
                    <td><input type="text" value="0" name="IdFactura2"></td>
                  <td><input type="text" value="<%= Nombreproducto2%>"name="NombreProducto2"></td>
                  <td><input type="text" value="<%= Cantidad2%>" name="CantidadProducto2"></td>
                  <td><input type="text" value="<%= Valor2%>" name="TotalProducto2"></td>
              </tr>
              <tr>
                   <td><input type="text"  value="0" name="IdFactura3"></td>
                  <td><input type="text" value="<%= Nombreproducto3%>" name="NombreProducto3"></td>
                  <td><input type="text" value="<%= Cantidad3%>" name="CantidadProducto3"></td>
                  <td><input type="text" value="<%= Valor3%>" name="TotalProducto3"></td>
              </tr>
              <tr>
                    <td><input type="text" value="0" name="IdFactura4"></td>
                  <td><input type="text" value="<%= Nombreproducto4%>"  name="NombreProducto4"></td>
                  <td><input type="text" value="<%= Cantidad4%>" name="CantidadProducto4"></td>
                  <td><input type="text" value="<%= Valor4%>" name="TotalProducto4"></td>
              </tr>
              <tr>
                    <td><input type="text" value="0" name="IdFactura5"></td>
                  <td><input type="text" value="<%= Nombreproducto5%>" name="NombreProducto5"></td>
                  <td><input type="text" value="<%= Cantidad5%>"  name="CantidadProducto5"></td>
                  <td><input type="text" value="<%= Valor5%>" name="TotalProducto5"></td>
              </tr>
              <tr>
                    <td><input type="text" value="0" name="IdFactura6"></td>
                  <td><input type="text" value="<%= Nombreproducto6%>" name="NombreProducto6"></td>
                  <td><input type="text" value="<%= Cantidad6%>"  name="CantidadProducto6"></td>
                  <td><input type="text" value="<%= Valor6%>" name="TotalProducto6"></td>
              </tr>
              <tr>
                    <td><input type="text" value="0" name="IdFactura7"></td>
                  <td><input type="text" value="<%= Nombreproducto7%>" name="NombreProducto7"></td>
                  <td><input type="text" value="<%= Cantidad7%>"  name="CantidadProducto7"></td>
                  <td><input type="text" value="<%= Valor7%>" name="TotalProducto7"></td>
              </tr>
              <tr>
                    <td><input type="text" value="0" name="IdFactura8"></td>
                  <td><input type="text" value="<%= Nombreproducto8%>" name="NombreProducto8"></td>
                  <td><input type="text" value="<%= Cantidad8%>"  name="CantidadProducto8"></td>
                  <td><input type="text" value="<%= Valor8%>" name="TotalProducto8"></td>
              </tr>
              <tr>
                    <td><input type="text" value="0" name="IdFactura9"></td>
                  <td><input type="text" value="<%= Nombreproducto9%>" name="NombreProducto9"></td>
                  <td><input type="text" value="<%= Cantidade9%>"  name="CantidadProducto9"></td>
                  <td><input type="text" value="<%= Valore9%>" name="TotalProducto9"></td>
              </tr>
              <tr>
                    <td><input type="text" value="0" name="IdFactura10"></td>
                  <td><input type="text" value="<%= Nombreproducto10%>" name="NombreProducto10"></td>
                  <td><input type="text" value="<%= Cantidade10%>"  name="CantidadProducto10"></td>
                  <td><input type="text" value="<%= Valore10%>" name="TotalProducto10"></td>1
              </tr>
          </tbody>
      </table>
              <input type="text" value="<%= totalapagar%>" name="ValorTotal">

      <h1>Total a Cancelar: <%= totalapagar%></h1>
        <br><br> <input type="submit" value="Calcular Valor"  />         
</form>
    </body>
</html>
