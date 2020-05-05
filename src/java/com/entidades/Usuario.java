/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades;
// importamos los paquetes que utilizaremos.
import java.io.*;
import java.sql.*;
import java.util.*;
/**
 *
 * @author mipc
 */
// creamos la clase usuario
public class Usuario implements Serializable { 
// get y set
    /**
     * @return the idUsuario
     */
    public String getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * @return the apellidoUsuario
     */
    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    /**
     * @param apellidoUsuario the apellidoUsuario to set
     */
    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }



   
  // declaramos nuestras variables, que seran los a tributos de nuestra clase Usuario  
  private String idUsuario;   
  private String nombreUsuario; 
  private String apellidoUsuario;
  
 public static Usuario ObtenerUsuario(ResultSet rsUsuario) throws SQLException {
   Usuario usuario= new Usuario(); // creamos una instancia 
   
   // obtenemos los datos de las variables
   usuario.setIdUsuario(rsUsuario.getString(1));
   usuario.setNombreUsuario(rsUsuario.getString(2));
   usuario.setApellidoUsuario(rsUsuario.getString(3));
   return usuario; // retornamos los datos
 }
  

  
}
