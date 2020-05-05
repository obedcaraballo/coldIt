/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;
import com.entidades.Usuario;
import com.persistencia.MpUsuario;
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
public class IdUserController extends HttpServlet {
    


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
           Usuario usuario=new Usuario();
           usuario.setIdUsuario(request.getParameter("ide"));
           String BuscarUsuario = usuario.getIdUsuario();
             Usuario BusquedaDeUsuario=  buscar(BuscarUsuario);// llamamos al metodo buscar
             if(BusquedaDeUsuario.getIdUsuario()!=null){
                 
                
                 
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
                     out.println("<td><font face=\"Arial\"> Fecha:"+ BusquedaDeUsuario.getIdUsuario()+"<br><br><br></font></td>");
                out.println("</tr>");
                 out.println("<tr>");
                    out.println("<td><font face=\"Arial\">Nombre de Usuario: " + BusquedaDeUsuario.getNombreUsuario()+"     <br><br><br></font></td>");
                    out.println("<td><font face=\"Arial\">Cédula:"+BusquedaDeUsuario.getApellidoUsuario()+" <br><br><br></font></td>");
                out.println("</tr>");
               
             out.println("</tbody>");
        out.println("</table>");
        



            
            
           
           
            out.println("<form action=\"RegistrarUsuario.jsp\" method=\"POST\">");
            out.println("<input type=\"submit\" value=\"Volver\" /></form>");
            out.println("</body>");
            out.println("</html>");
            
        }else if(BusquedaDeUsuario.getIdUsuario()==null){
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
            out.println("<h1>no se encuentra registrado en la base de datos </h1>");
            out.println("<form action=\"RegistrarEquipo.jsp\" method=\"POST\">");
            out.println("<input type=\"submit\" value=\"Registrar Usuario\" /></form>");
            out.println("</body>");
            out.println("</html>");
                 
                 
             }
    
    
    
    
    
    
}
    }
    
      public Usuario buscar(String BuscarUsuario){
        Usuario BuscarDeUsuario = new Usuario();
    try {
        ManejadorBaseDatos mbd=ManejadorBaseDatos.getInstancia();
        MpUsuario mpp=new MpUsuario();
        mbd.conectar();
        mpp.setCon(mbd.getConexion());
        System.out.println(""+mbd.getConexion().toString());
       BuscarDeUsuario = mpp.obtenerPorIdUsuario(BuscarUsuario);
        
    } 

    catch (SQLException ex) {
        System.out.println("Error "+ex.getMessage());
        
    }   catch (Exception ex) {
        
           System.out.println("Error "+"saaaaa"+ex.getMessage());
        }
    
    
    return BuscarDeUsuario;
    }
      
      
      
      public void registrar(Usuario usuario){
        
    try {
        ManejadorBaseDatos mbd=ManejadorBaseDatos.getInstancia();
        MpUsuario mpp=new MpUsuario();
        mbd.conectar();
        mpp.setCon(mbd.getConexion());
        System.out.println(""+mbd.getConexion().toString());
        Usuario CrearUsuario=new Usuario();
        mpp.updatePaciente(usuario,CrearUsuario.getIdUsuario());
        
        
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
