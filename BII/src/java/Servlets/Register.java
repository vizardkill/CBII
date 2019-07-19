/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controladores.controller_Solicitud;
import Controladores.controller_Usuario;
import Metodos.Calendario;
import Modelos.Solicitud;
import Modelos.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author scardonas
 */
public class Register extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Register</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Register at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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

        response.setContentType("text/html;charset=UTF-8");
        String Peticion = request.getParameter("Peticion");

        //************************************** Validaciones de la Tabla Usuario *********************************
        if (Peticion.equals("ValidarNickUsuario")) {
            Usuario user = new Usuario();
            user.setUsername(request.getParameter("form_reg_username"));
            controller_Usuario cuser = new controller_Usuario();
            boolean result = cuser.P_ValidUser(Peticion, user);
            if (result) {
                response.getWriter().write("false");
            } else {
                response.getWriter().write("true");
            }
        }

        if (Peticion.equals("ValidarEmailUsuario")) {
            Usuario user = new Usuario();
            user.setCorreo(request.getParameter("form_reg_correo"));
            controller_Usuario cuser = new controller_Usuario();
            boolean result = cuser.P_ValidUser(Peticion, user);
            if (result) {
                response.getWriter().write("false");
            } else {
                response.getWriter().write("true");
            }
        }

        if (Peticion.equals("ValidarDocUsuario")) {
            Usuario user = new Usuario();
            user.setPk_documento(request.getParameter("form_reg_documento"));
            controller_Usuario cuser = new controller_Usuario();
            boolean result = cuser.P_ValidUser(Peticion, user);
            if (result) {
                response.getWriter().write("false");
            } else {
                response.getWriter().write("true");
            }
        }
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
        HttpSession session = request.getSession(true);
        response.setContentType("text/html;charset=UTF-8");
        String Peticion = request.getParameter("Peticion");

        if (Peticion.equals("Registro_Usuario")) {
            Usuario user = new Usuario(
                    request.getParameter("form_reg_documento"),
                    Integer.valueOf(request.getParameter("form_reg_usuario_tipo_documento")),
                    Integer.valueOf(request.getParameter("form_reg_fk_tipo_usuario")),
                    request.getParameter("form_reg_nombre"),
                    request.getParameter("form_reg_apellidos"),
                    request.getParameter("form_reg_telefono"),
                    request.getParameter("form_reg_correo"),
                    request.getParameter("form_reg_username"),
                    request.getParameter("form_reg_pwd")
            );
            controller_Usuario cuser = new controller_Usuario();

            boolean result = cuser.setUser(user);
            if (result) {
                response.getWriter().write("true");
            } else {
                response.getWriter().write("false");
            }
        }
        
        if (Peticion.equals("Registro_Solicitud")) {
            Calendario fechaR = new Calendario();
            String fecha_registro = fechaR.Fecha_Registro();
            Solicitud sol = new Solicitud(
                    0,
                    String.valueOf(session.getAttribute("documento_usuario")),
                    null,
                    request.getParameter("form_reg_sol_fk_estado"),
                    request.getParameter("form_reg_sol_fk_categoria"),
                    request.getParameter("form_reg_sol_fk_programa_academico"),
                    request.getParameter("form_reg_sol_titulo"),
                    request.getParameter("form_reg_sol_descripcion_problema"),
                    request.getParameter("form_reg_sol_descripcion_peticion"),
                    null,
                    fecha_registro,
                    null               
            );
            controller_Solicitud csol = new controller_Solicitud();
            
            boolean result = csol.setSolicitud(sol);
            if (result) {
                response.getWriter().write("true");
            } else {
                response.getWriter().write("false");
            }
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
