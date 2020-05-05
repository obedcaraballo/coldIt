/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.persistencia;
// importamos los paquetes que utilizaremos.

import com.entidades.Producto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author mipc
 */
// creamos la clase MpProducto, Mp=Manejador de Persistencia
public class MpProducto {
    
    // get y set de la variable con
    /**
     * @return the con
     */
    public Connection getCon() {
        return con;
    }

    /**
     * @param con the con to set
     */
    public void setCon(Connection con) {
        this.con = con;
    }

    
 private Connection con; // declaramos nuestra variable con para la conexion con la base de datos 
   
    // metodo obtener por id el del Producto
	    public Producto obtenerPorIdProducto(String idProducto) throws SQLException {
                
//pasamos los datos  para poder validar si es nulo el resultado              
if (idProducto==null) {
          throw new SQLException("s");
          
     }
     //preparamos todo para comenzar con la conexion y la busqueda de los datos en la BD
         ResultSet rsProducto = null;
         PreparedStatement pstProducto = null;
         Producto producto = null;
     try {
         pstProducto = getCon().prepareStatement("select * from producto where IdProducto = ?");
          pstProducto.setString(1, idProducto.trim());
        
         rsProducto = pstProducto.executeQuery();
         while(rsProducto.next()) {
             producto = Producto.ObtenerProducto(rsProducto);
         }
  
         
    } 

     finally {
         rsProducto.last();
         int numRows = rsProducto.getRow();
         System.out.println(numRows);
         if (numRows==0) {
         producto.setNombreProducto("No hay registro");
          System.out.println(producto.getIdProducto());
         }
         if (rsProducto != null) {
            rsProducto.close();
         }
         if (pstProducto != null) {
           pstProducto.close();
         }
         
    }
     
      return producto;
     
}
 
 
 // metodo crear el producto 
            
 public void crearProducto(Producto producto) throws SQLException {
     if (getCon() == null ) { 
          throw new SQLException( "no hay conexion ");
    }
     PreparedStatement pstcrearProducto = null;
     
      
     try {
         
          pstcrearProducto = getCon().prepareStatement("Insert Into producto values(?,?,?)");
          pstcrearProducto.setString(1,producto.getIdProducto());
          pstcrearProducto.setString(2,producto.getNombreProducto());
          pstcrearProducto.setString(3,producto.getValorProducto());
         
     
   
          pstcrearProducto.executeUpdate();
          String cantidad=producto.getNombreProducto();
           Statement st = con.createStatement();
				String sql = "ALTER TABLE factura ADD '" +cantidad+"' VARCHAR(10) NOT NULL AFTER `ValorTotal`";
				st.executeUpdate(sql);
				System.out.println("Table is altered successfully");

           
    }finally {
        if (pstcrearProducto != null) {
             pstcrearProducto.close();
        }
       
   }
     
     
     
     
          
}             
            
            
            
 
 public boolean updateProducto (Producto producto, String codigo) throws SQLException {
       if ( obtenerPorIdProducto(codigo) == null) {
           throw new SQLException ("Producto no registrado ");
       }
       PreparedStatement pstupdateProducto = null;
       boolean res = false;
       try {
         pstupdateProducto = getCon().prepareStatement("Update producto set NombreProducto = ?, ValorProducto = ? where IdProducto= ?") ;
               pstupdateProducto.setString(1,producto.getNombreProducto());
          pstupdateProducto.setString(2,producto.getValorProducto());
          
        
         
         
           pstupdateProducto.setString(3, codigo.trim());
         
         int r = pstupdateProducto.executeUpdate();
       if (r != 0) {
          res = true;
       }
       } finally {
          if (pstupdateProducto != null) {
            pstupdateProducto.close();
          }
       }
         return res;
 } 
 
 
   public boolean deleteProducto(String codigo) throws SQLException {
     if (obtenerPorIdProducto(codigo) == null) {
        throw new SQLException("No hay elemento clave de la clase equipos");
     }
     PreparedStatement pstIdProducto = null;
     boolean resultadoIdProducto = false;
     try {
        pstIdProducto = getCon().prepareStatement("delete from producto where IdProducto = ?");
        pstIdProducto.setString(1, codigo.trim());
        int r = pstIdProducto.executeUpdate();
        if (r != 0) {
           resultadoIdProducto = true;
        }
     } finally {
        if (pstIdProducto != null) {
           pstIdProducto.close();
        }
     }
     return resultadoIdProducto;
}
  
 
 
 
 public List<Producto> listarProducto() throws SQLException {
     ResultSet rs = null;
     PreparedStatement pst = null;
     List<Producto> ListarProducto = new LinkedList();
     try {
        pst = getCon().prepareStatement("select * from producto ");
        rs = pst.executeQuery();
        while(rs.next()) {
           ListarProducto.add(Producto.ObtenerProducto(rs));
        }
    } finally {
        if (rs != null) {
           rs.close();
       }
        if (pst != null) {
          pst.close();
       }
    }

  return ListarProducto;
}
 
 
 
    
}
