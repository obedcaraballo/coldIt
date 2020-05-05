/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function agregarFila(){
     var table = document.getElementById("tablafractura");
    var rowCounts = table.rows.length;
  
   
  if(rowCounts <= 10){
      document.getElementById("tablafractura").insertRow(-1).innerHTML = '<td><input type="text" size="10" id="IdProducto" value="0" name="IdProducto"></td><td><input type="text" size="10" value="0" id="NombreProducto" name="NombreProducto"></td><td><input type="text" size="10" id="CantidadProducto" value="0" name="CantidadProducto"></td><td><input type="text" size="10" id="TotalProducto" value="0" name="ValorPorUnidad"></td>';

  
  } else 
       alert('No se pueden agregar mas productos ');
    var cambiarnombreidproducto = document.getElementById("IdProducto").name = "IdProducto"+rowCounts;
    var cambiarnombrenombreproducto = document.getElementById("NombreProducto").name = "NombreProducto"+rowCounts;
    var cambiarnombrecantidadproducto = document.getElementById("CantidadProducto").name = "CantidadProducto"+rowCounts;
    var cambiarnombretotalproducto = document.getElementById("TotalProducto").name = "TotalProducto"+rowCounts;
}

function eliminarFila(){
  var table = document.getElementById("tablafractura");
  var rowCount = table.rows.length;
  //console.log(rowCount);
  
  if(rowCount <= 1)
    alert('No se puede eliminar el encabezado');
  else
    table.deleteRow(rowCount -1);
}