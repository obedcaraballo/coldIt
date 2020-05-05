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
// creamos la clase Producto
public class Producto implements Serializable{

    /**
     * @return the ValorProducto
     */
    public String getValorProducto() {
        return ValorProducto;
    }

    /**
     * @param ValorProducto the ValorProducto to set
     */
    public void setValorProducto(String ValorProducto) {
        this.ValorProducto = ValorProducto;
    }
// get y set
    /**
     * @return the IdProducto
     */
    public String getIdProducto() {
        return IdProducto;
    }

    /**
     * @param IdProducto the IdProducto to set
     */
    public void setIdProducto(String IdProducto) {
        this.IdProducto = IdProducto;
    }

    /**
     * @return the NombreProducto
     */
    public String getNombreProducto() {
        return NombreProducto;
    }

    /**
     * @param NombreProducto the NombreProducto to set
     */
    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    
      // declaramos nuestras variables, que seran los a tributos de nuestra clase Producto  
  private String IdProducto;   
  private String NombreProducto; 
  private String ValorProducto;
  
   public static Producto ObtenerProducto(ResultSet rsProducto) throws SQLException {
   Producto producto= new Producto(); // creamos una instancia 
   
   // obtenemos los datos de las variables
   producto.setIdProducto(rsProducto.getString(1));
   producto.setNombreProducto(rsProducto.getString(2));
   producto.setValorProducto(rsProducto.getString(3));
   return producto; // retornamos los datos
 }
    
}
