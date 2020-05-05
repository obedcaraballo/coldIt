/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.persistencia;

import com.entidades.Factura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.sql.Statement;

/**
 *
 * @author mipc
 */
// creamos la clase MpFactura, Mp=Manejador de Persistencia
public class MpFactura {
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
   
    // metodo obtener por id el del Factura
	    public Factura obtenerPorIdFactura(String idFactura) throws SQLException {
                
//pasamos los datos  para poder validar si es nulo el resultado              
if (idFactura==null) {
          throw new SQLException("s");
          
     }
     //preparamos todo para comenzar con la conexion y la busqueda de los datos en la BD
         ResultSet rsFactura = null;
         PreparedStatement pstFactura = null;
         Factura factura = null;
     try {
         pstFactura = getCon().prepareStatement("select * from factura where IdFactura = ?");
          pstFactura.setString(1, idFactura.trim());
        
         rsFactura = pstFactura.executeQuery();
         while(rsFactura.next()) {
             factura = Factura.ObtenerFactura(rsFactura);
         }
  
         
    } 

     finally {
         rsFactura.last();
         int numRows = rsFactura.getRow();
         System.out.println(numRows);
         if (numRows==0) {
         factura.setNombreUsuario("No hay registro");
          System.out.println(factura.getIdFactura());
         }
         if (rsFactura != null) {
            rsFactura.close();
         }
         if (pstFactura != null) {
           pstFactura.close();
         }
         
    }
     
      return factura;
     
}
 
 
 // metodo crear el factura 
            
 public void crearFactura(Factura factura) throws SQLException {
     if (getCon() == null ) { 
          throw new SQLException( "no hay conexion ");
    }
     PreparedStatement pstcrearFactura = null;
     try {
          pstcrearFactura = getCon().prepareStatement("Insert Into factura values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
          pstcrearFactura.setString(1,factura.getIdFactura());
          pstcrearFactura.setString(2,factura.getNombreUsuario());
          pstcrearFactura.setString(3,factura.getValorTotal());
          pstcrearFactura.setString(4,factura.getNombreProducto1());
          pstcrearFactura.setString(5,factura.getCantidadProducto1());
          pstcrearFactura.setString(6,factura.getNombreProducto2());
          pstcrearFactura.setString(7,factura.getCantidadProducto2());
          pstcrearFactura.setString(8,factura.getNombreProducto3());
          pstcrearFactura.setString(9,factura.getCantidadProducto3());
          pstcrearFactura.setString(10,factura.getNombreProducto4());
          pstcrearFactura.setString(11,factura.getCantidadProducto4());
          pstcrearFactura.setString(12,factura.getNombreProducto5());
          pstcrearFactura.setString(13,factura.getCantidadProducto5());
          pstcrearFactura.setString(14,factura.getNombreProducto6());
          pstcrearFactura.setString(15,factura.getCantidadProducto6());
          pstcrearFactura.setString(16,factura.getNombreProducto7());
          pstcrearFactura.setString(17,factura.getCantidadProducto7());
          pstcrearFactura.setString(18,factura.getNombreProducto8());
          pstcrearFactura.setString(19,factura.getCantidadProducto8());
          pstcrearFactura.setString(20,factura.getNombreProducto9());
          pstcrearFactura.setString(21,factura.getCantidadProducto9());
          pstcrearFactura.setString(22,factura.getNombreProducto10());
          pstcrearFactura.setString(23,factura.getCantidadProducto10());
          
    
   
          pstcrearFactura.executeUpdate();
    }finally {
        if (pstcrearFactura != null) {
             pstcrearFactura.close();
        }
   }
}             
            

            
            
 
 public boolean updateFactura (Factura factura, String codigo) throws SQLException {
       if ( obtenerPorIdFactura(codigo) == null) {
           throw new SQLException ("Factura no registrado ");
       }
       PreparedStatement pstupdateFactura = null;
       boolean res = false;
       try {
         pstupdateFactura = getCon().prepareStatement("Update factura set NombreFactura = ?, ValorFactura = ? where IdFactura= ?") ;
               pstupdateFactura.setString(1,factura.getNombreUsuario());
          pstupdateFactura.setString(2,factura.getValorTotal());
          
        
         
         
           pstupdateFactura.setString(3, codigo.trim());
         
         int r = pstupdateFactura.executeUpdate();
       if (r != 0) {
          res = true;
       }
       } finally {
          if (pstupdateFactura != null) {
            pstupdateFactura.close();
          }
       }
         return res;
 } 
 
 
   public boolean deleteFactura(String codigo) throws SQLException {
     if (obtenerPorIdFactura(codigo) == null) {
        throw new SQLException("No hay elemento clave de la clase equipos");
     }
     PreparedStatement pstIdFactura = null;
     boolean resultadoIdFactura = false;
     try {
        pstIdFactura = getCon().prepareStatement("delete from factura where IdFactura = ?");
        pstIdFactura.setString(1, codigo.trim());
        int r = pstIdFactura.executeUpdate();
        if (r != 0) {
           resultadoIdFactura = true;
        }
     } finally {
        if (pstIdFactura != null) {
           pstIdFactura.close();
        }
     }
     return resultadoIdFactura;
}
  
 
 
 
 public List<Factura> listarPaciente() throws SQLException {
     ResultSet rs = null;
     PreparedStatement pst = null;
     List<Factura> ListarFactura = new LinkedList();
     try {
        pst = getCon().prepareStatement("select * from factura ");
        rs = pst.executeQuery();
        while(rs.next()) {
           ListarFactura.add(Factura.ObtenerFactura(rs));
        }
    } finally {
        if (rs != null) {
           rs.close();
       }
        if (pst != null) {
          pst.close();
       }
    }

  return ListarFactura;
}
}
