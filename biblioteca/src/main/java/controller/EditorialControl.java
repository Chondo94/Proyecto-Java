/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EditorialDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Editorial;

/**
 *
 * @author estua
 */
public class EditorialControl extends HttpServlet {

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
            out.println("<title>Servlet EditorialControl</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditorialControl at " + request.getContextPath() + "</h1>");
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
        /**
         * aca recogemos lo que viene del formulario*
         */
        String nit = request.getParameter("nit");
        /**
         * este nit que esta en verde, es el nombre que tiene el imput*
         */
        String nombre = request.getParameter("nombre");
        /**
         * lo mismo es con este, y con los que siguen*
         */
        String telefono = request.getParameter("telefono");
        String direccion = request.getParameter("direccion");
        String email = request.getParameter("email");
        String sitioweb = request.getParameter("sitioweb");

        /**
         * aca creamos un objeto editorial
         */
        Editorial e = new Editorial();

        /**
         * le asiganoms el nit, nombre,telefono, etc. a la editorial
         */
        e.setNit(nit);
        e.setNombre(nombre);
        e.setTelefono(telefono);
        e.setDireccion(direccion);
        e.setEmail(email);
        e.setSitioweb(sitioweb);

        /**
         * en este condicional le decimos que si nos crea la editorial nos de un
         * mensaje, de lo contrario, que nos de el otro mensaje y nos retorne.*
         */
        if (EditorialDao.registrar(e)) {
            request.setAttribute("mensaje", "la editorial se registro con exito");
        } else {
            request.setAttribute("mensaje", "el registro de la editorial no se completo con exito");
        }
        request.getRequestDispatcher("registroEditorial.jsp").forward(request, response);
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
