<%-- 
    Document   : Factura
    Created on : 5/05/2020, 03:00:28 AM
    Author     : mipc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="Factura.js"></script>
        <title>Factura</title>
    </head>
    <body>
       <div >
  <div >
       <form method="POST" action="CalcularValorFactura.jsp">
          <label> Nombre Usuario <input type="text" name="NombreUsuario" value="" placeholder="Obed Caraballo"/>
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
                  <td><input type="text" value="0" name="IdFactura1"></td>
                  <td><input type="text" value="0" name="NombreProducto1"></td>
                  <td><input type="text" value="0" name="CantidadProducto1"></td>
                  <td><input type="text" value="0" name="TotalProducto1"></td>
              </tr>
              <tr>
                    <td><input type="text" value="0" name="IdFactura2"></td>
                  <td><input type="text" value="0" name="NombreProducto2"></td>
                  <td><input type="text" value="0" name="CantidadProducto2"></td>
                  <td><input type="text" value="0" name="TotalProducto2"></td>
              </tr>
              <tr>
                   <td><input type="text" value="0" name="IdFactura3"></td>
                  <td><input type="text" value="0" name="NombreProducto3"></td>
                  <td><input type="text" value="0" name="CantidadProducto3"></td>
                  <td><input type="text" value="0" name="TotalProducto3"></td>
              </tr>
              <tr>
                    <td><input type="text" value="0" name="IdFactura4"></td>
                  <td><input type="text" value="0" name="NombreProducto4"></td>
                  <td><input type="text" value="0" name="CantidadProducto4"></td>
                  <td><input type="text" value="0" name="TotalProducto4"></td>
              </tr>
              <tr>
                    <td><input type="text" value="0" name="IdFactura5"></td>
                  <td><input type="text" value="0" name="NombreProducto5"></td>
                  <td><input type="text" value="0" name="CantidadProducto5"></td>
                  <td><input type="text" value="0" name="TotalProducto5"></td>
              </tr>
              <tr>
                    <td><input type="text" value="0" name="IdFactura6"></td>
                  <td><input type="text" value="0" name="NombreProducto6"></td>
                  <td><input type="text" value="0" name="CantidadProducto6"></td>
                  <td><input type="text" value="0" name="TotalProducto6"></td>
              </tr>
              <tr>
                    <td><input type="text" value="0" name="IdFactura7"></td>
                  <td><input type="text" value="0" name="NombreProducto7"></td>
                  <td><input type="text" value="0" name="CantidadProducto7"></td>
                  <td><input type="text" value="0" name="TotalProducto7"></td>
              </tr>
              <tr>
                    <td><input type="text" value="0" name="IdFactura8"></td>
                  <td><input type="text" value="0" name="NombreProducto8"></td>
                  <td><input type="text" value="0" name="CantidadProducto8"></td>
                  <td><input type="text" value="0" name="TotalProducto8"></td>
              </tr>
              <tr>
                    <td><input type="text" value="0" name="IdFactura9"></td>
                  <td><input type="text" value="0" name="NombreProducto9"></td>
                  <td><input type="text" value="0" name="CantidadProducto9"></td>
                  <td><input type="text" value="0" name="TotalProducto9"></td>
              </tr>
              <tr>
                    <td><input type="text" value="0" name="IdFactura10"></td>
                  <td><input type="text" value="0" name="NombreProducto10"></td>
                  <td><input type="text" value="0" name="CantidadProducto10"></td>
                  <td><input type="text" value="0" name="TotalProducto10"></td>1
              </tr>
          </tbody>
      </table>

      
        <br><br> <input type="submit" value="Calcular Valor"  />         
</form>
   
  </div>
</div>
      
        
        
        

    </body>
</html>
