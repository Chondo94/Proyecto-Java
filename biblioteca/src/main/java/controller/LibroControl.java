/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.LibroDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Libro;

/**
 *
 * @author estua
 */
public class LibroControl extends HttpServlet {

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
            out.println("<title>Servlet LibroControl</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LibroControl at " + request.getContextPath() + "</h1>");
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
         * creo las variables para poder obtner los parametros.
         * aca recogemos lo que viene del formulario*
         */
        String isbn = request.getParameter("isbn");
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        String publicacion = request.getParameter("publicacion");
        int categoria = Integer.parseInt(request.getParameter("categoria"));
        String editorial = request.getParameter("editorial");
        String descripcion = request.getParameter("descripcion");
        /**
        *el parametro accion, es el nombre que se le dio a los botones, para elegir el CRUD, crear, eliminar o actualizar.
        * */
        String accion = request.getParameter("accion").toLowerCase();
        System.out.println("variable es = " + accion);
        /**
         * aca se crea el objeto 
         */
        Libro l = new Libro();

        l.setIsbn(isbn);
        l.setTitulo(titulo);
        l.setNombre_autor(autor);
        l.setPublicacion(publicacion);
        l.setCodigo_categoria(categoria);
        l.setNit_editorial(editorial);
        l.setDescripcion(descripcion);
        /**
         * este condicional es para verificar si se cumple la accion o no.
         */
        
        if (accion.equals("registrar")) {
            if (LibroDao.registrar(l)) {
                request.setAttribute("mensaje", "Libro registrado");
            } else {
                request.setAttribute("mensaje", "fallo registro de libro");
            }
        } else {
            request.setAttribute("mensaje", "No se reconoce la acción");
        }
        request.getRequestDispatcher("registroLibro.jsp").forward(request, response);
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
