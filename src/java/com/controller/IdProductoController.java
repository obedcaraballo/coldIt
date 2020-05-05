/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;
import com.entidades.Producto;
import com.persistencia.MpProducto;
import com.persistencia.ManejadorBaseDatos;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.logging.Level;
 import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mipc
 */
public class IdProductoController extends HttpServlet {
    


    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       
    }

   
        
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
        
        
        
        
        
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
         response.setContentType("text/html;charset=UTF-8");
         try (PrintWriter out = response.getWriter()) {
           Producto producto=new Producto();
           producto.setIdProducto(request.getParameter("ide"));
           String BuscarProducto = producto.getIdProducto();
             Producto BusquedaDeProducto=  buscar(BuscarProducto); // llamamos al metodo buscar
             if(BusquedaDeProducto.getIdProducto()!=null){
                 
                
                 
                 out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
           
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            
    	 out.println("<form> <input  type=\"button\" name=\"imprimir\" value=\"Imprimir\" onclick=\"window.print();\"> </form>");
         out.println("<div  style=\"text-align:center;\">");
        out.println("<table  WIDTH=1000 cellspacing=0 cellpadding=2 border=\"1\" align=\"center\">");


            out.println("<tbody>");
         
    out.println("</div>");
        out.println("<table  WIDTH=1000  cellspacing=0 cellpadding=2 border=\"1\" align=\"center\">");

             out.println("<tbody>");
                
                 out.println("<tr>");
                    out.println("<td style=\" text-align:center \" ><font face=\"Arial\"><b>I. INFORMACIÓN GENERAL</b><br><br><br></font></td>");
                     out.println("<td><font face=\"Arial\"> ID Producto:"+ BusquedaDeProducto.getIdProducto()+"<br><br><br></font></td>");
                out.println("</tr>");
                 out.println("<tr>");
                    out.println("<td><font face=\"Arial\">Nombre de Producto: " + BusquedaDeProducto.getNombreProducto()+"     <br><br><br></font></td>");
                    out.println("<td><font face=\"Arial\">Valor Producto:"+BusquedaDeProducto.getValorProducto()+" <br><br><br></font></td>");
                out.println("</tr>");
               
             out.println("</tbody>");
        out.println("</table>");
        



       
           
           
            out.println("<form action=\"RegistrarProducto.jsp\" method=\"POST\">");
            out.println("<input type=\"submit\" value=\"Volver\" /></form>");
            out.println("<form action=\"CrudProducto/ActualizarProducto.jsp\" method=\"POST\">");
            out.println("<input type=\"text\" name=\"ident\" value="+ BusquedaDeProducto.getIdProducto()+" />");
            out.println("<input type=\"submit\" value=\"Actualizar Producto\" /></form>");
            out.println("</body>");
            out.println("</html>");
            
        }else if(BusquedaDeProducto.getIdProducto()==null){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Paciente</title>");
            out.println("<style type=\"text/css\">");
            out.println("		body{\n" +
"			background-color: #D6EAF8;\n" +
"			text-align: center;\n" +
"			border-style: solid;\n" +
"			border-color: #FDFEFE;\n" +
"			border-radius:50px;\n" +
"			padding: 30px;\n" +
"			margin: 50px;\n" +
"			margin-left: 20%;\n" +
"			margin-right: 20%;\n" +
"		}");
            out.println("h1{\n" +
"			font-family: \"Lucida Console\", Courier, monospace;\n" +
"			font-size: 20px;\n" +
"		}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> se encuentra registrado en la base de datos </h1>");
            out.println("<form action=\"RegistrarProducto.jsp\" method=\"POST\">");
            out.println("<input type=\"submit\" value=\"Registrar Equipo\" /></form>");
            out.println("</body>");
            out.println("</html>");
                 
                 
             }
    
    
    
    
    
    
}
    }
    
      public Producto buscar(String BuscarProducto){
        Producto BuscarDeProducto = new Producto();
    try {
        ManejadorBaseDatos mbd=ManejadorBaseDatos.getInstancia();
        MpProducto mpp=new MpProducto();
        mbd.conectar();
        mpp.setCon(mbd.getConexion());
        System.out.println(""+mbd.getConexion().toString());
       BuscarDeProducto = mpp.obtenerPorIdProducto(BuscarProducto);
        
    } 

    catch (SQLException ex) {
        System.out.println("Error "+ex.getMessage());
        
    }   catch (Exception ex) {
        
           System.out.println("Error "+"saaaaa"+ex.getMessage());
        }
    
    
    return BuscarDeProducto;
    }
      
      
      
      public void registrar(Producto producto){
        
    try {
        ManejadorBaseDatos mbd=ManejadorBaseDatos.getInstancia();
        MpProducto mpp=new MpProducto();
        mbd.conectar();
        mpp.setCon(mbd.getConexion());
        System.out.println(""+mbd.getConexion().toString());
        Producto CrearProducto=new Producto();
        mpp.updateProducto(producto,CrearProducto.getIdProducto());
        
        
    } catch (SQLException ex) {
        System.out.println(""+ex.getMessage());
    }   catch (Exception ex) {
           System.out.println(""+ex.getMessage());
        }
    }
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
}
