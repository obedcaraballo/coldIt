/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.persistencia;

// importamos los paquetes que utilizaremos.

import com.entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author mipc
 */

// creamos la clase MpUsuario , Mp=Manejador de Persistencia
public class MpUsuario { 
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
   
    // metodo obtener por id el usuario
	    public Usuario obtenerPorIdUsuario(String idUsuario) throws SQLException {
                
//pasamos los datos  para poder validar si es nulo el resultado              
if (idUsuario==null) {
          throw new SQLException("s");
          
     }
     //preparamos todo para comenzar con la conexion y la busqueda de los datos en la BD
         ResultSet rsUsuario = null;
         PreparedStatement pstUsuario = null;
         Usuario usuario = null;
     try {
         pstUsuario = getCon().prepareStatement("select * from usuario where IdUsuario = ?");
          pstUsuario.setString(1, idUsuario.trim());
        
         rsUsuario = pstUsuario.executeQuery();
         while(rsUsuario.next()) {
             usuario = Usuario.ObtenerUsuario(rsUsuario);
         }
  
         
    } 

     finally {
         rsUsuario.last();
         int numRows = rsUsuario.getRow();
         System.out.println(numRows);
         if (numRows==0) {
         usuario.setNombreUsuario("No hay registro");
          System.out.println(usuario.getIdUsuario());
         }
         if (rsUsuario != null) {
            rsUsuario.close();
         }
         if (pstUsuario != null) {
           pstUsuario.close();
         }
         
    }
     
      return usuario;
     
}
 
 
 // metodo crear el usuario 
            
 public void crearUsuario(Usuario usuario) throws SQLException {
     if (getCon() == null ) { 
          throw new SQLException( "no hay conexion ");
    }
     PreparedStatement pstcrearUsuario = null;
     try {
          pstcrearUsuario = getCon().prepareStatement("Insert Into usuario values(?,?,?)");
          pstcrearUsuario.setString(1,usuario.getIdUsuario());
          pstcrearUsuario.setString(2,usuario.getNombreUsuario());
          pstcrearUsuario.setString(3,usuario.getApellidoUsuario());
    
   
          pstcrearUsuario.executeUpdate();
    }finally {
        if (pstcrearUsuario != null) {
             pstcrearUsuario.close();
        }
   }
}             
            
            
            
 
 public boolean updatePaciente (Usuario usuario, String IdUsuario) throws SQLException {
       if ( obtenerPorIdUsuario(IdUsuario) == null) {
           throw new SQLException ("Usuario no registrado ");
       }
       PreparedStatement pstupdatePaciente = null;
       boolean res = false;
       try {
         pstupdatePaciente = getCon().prepareStatement("Update usuario "
                + "set NombreUsuario = ?, ApellidoUsuario = ?, "
              //   + "identificacion = ?, "
                 
                 + "where IdUsuario = ? ") ;
               pstupdatePaciente.setString(1,usuario.getNombreUsuario());
          pstupdatePaciente.setString(2,usuario.getApellidoUsuario());
         // pst.setString(3,paciente.getIdentificacion());
         
         
         
          
           pstupdatePaciente.setString(3, IdUsuario.trim());
         int r = pstupdatePaciente.executeUpdate();
       if (r != 0) {
          res = true;
       }
       } finally {
          if (pstupdatePaciente != null) {
            pstupdatePaciente.close();
          }
       }
         return res;
 }       
 
 
 
 public List<Usuario> listarUsuario() throws SQLException {
     ResultSet rs = null;
     PreparedStatement pst = null;
     List<Usuario> ListarUsuario = new LinkedList();
     try {
        pst = getCon().prepareStatement("select * from usuario ");
        rs = pst.executeQuery();
        while(rs.next()) {
           ListarUsuario.add(Usuario.ObtenerUsuario(rs));
        }
    } finally {
        if (rs != null) {
           rs.close();
       }
        if (pst != null) {
          pst.close();
       }
    }

  return ListarUsuario;
}
 
 
 
 
 
 
 
 
 
 
 
}
