/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entidades.Factura;
import com.persistencia.ManejadorBaseDatos;
import com.persistencia.MpFactura;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mipc
 */
public class RegistroFacturaController extends HttpServlet {

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
                Factura factura=new Factura();
            factura.setIdFactura(request.getParameter("IdFactura"));
           factura.setNombreUsuario(request.getParameter("NombreUsuario"));
           factura.setValorTotal(request.getParameter("ValorTotal"));
           factura.setNombreProducto1(request.getParameter("NombreProducto1"));
           factura.setCantidadProducto1(request.getParameter("CantidadProducto1"));
           factura.setNombreProducto2(request.getParameter("NombreProducto2"));
           factura.setCantidadProducto2(request.getParameter("CantidadProducto2"));
           factura.setNombreProducto3(request.getParameter("NombreProducto3"));
           factura.setCantidadProducto3(request.getParameter("CantidadProducto3"));
           factura.setNombreProducto4(request.getParameter("NombreProducto4"));
           factura.setCantidadProducto4(request.getParameter("CantidadProducto4"));
           factura.setNombreProducto5(request.getParameter("NombreProducto5"));
           factura.setCantidadProducto5(request.getParameter("CantidadProducto5"));
           factura.setNombreProducto6(request.getParameter("NombreProducto6"));
           factura.setCantidadProducto6(request.getParameter("CantidadProducto6"));
           factura.setNombreProducto7(request.getParameter("NombreProducto7"));
           factura.setCantidadProducto7(request.getParameter("CantidadProducto7"));
           factura.setNombreProducto8(request.getParameter("NombreProducto8"));
           factura.setCantidadProducto8(request.getParameter("CantidadProducto8"));
           factura.setNombreProducto9(request.getParameter("NombreProducto9"));
           factura.setCantidadProducto9(request.getParameter("CantidadProducto9"));
           factura.setNombreProducto10(request.getParameter("NombreProducto10"));
           factura.setCantidadProducto10(request.getParameter("CantidadProducto10"));
           
         
             crearFactura(factura);
           out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Registrado</title>");
            out.println("<meta http-equiv=\"refresh\" content=\"2;url=RegistrarFactura.jsp\">");
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
    
    
         public void crearFactura(Factura factura){
    try {
        ManejadorBaseDatos mbd=ManejadorBaseDatos.getInstancia();
        MpFactura mpp=new MpFactura();
        mbd.conectar();
        mpp.setCon(mbd.getConexion());
        System.out.println(""+mbd.getConexion().toString());
        mpp.crearFactura(factura);
        
        
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
