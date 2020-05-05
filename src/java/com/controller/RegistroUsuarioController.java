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
public class RegistroUsuarioController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Usuario usuario=new Usuario();
            usuario.setIdUsuario(request.getParameter("IdUsuario"));
           usuario.setNombreUsuario(request.getParameter("NombreUsuario"));
           usuario.setApellidoUsuario(request.getParameter("ApellidoUsuario"));
             registrar(usuario);
           out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Registrado</title>");
            out.println("<meta http-equiv=\"refresh\" content=\"2;url=RegistrarUsuario.jsp\">");
            out.println("<style type=\"text/css\">");
            out.println("		body{\n" +
"			background-color: #fff;\n" +
"			text-align: center;\n" +
"			border-style: solid;\n" +
"			border-color: #FA5858;\n" +
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
            out.println("<h1>Registrado</h1>");
            out.println("</body>");
            out.println("</html>");
    
        }
    }
    
    
         public void registrar(Usuario usuario){
    try {
        ManejadorBaseDatos mbd=ManejadorBaseDatos.getInstancia();
        MpUsuario mpp=new MpUsuario();
        mbd.conectar();
        mpp.setCon(mbd.getConexion());
        System.out.println(""+mbd.getConexion().toString());
        mpp.crearUsuario(usuario);
        
        
    } catch (SQLException ex) {
        System.out.println(""+ex.getMessage());
    }   catch (Exception ex) {
           System.out.println(""+ex.getMessage());
        }
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
