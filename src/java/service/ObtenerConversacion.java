/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.MensajeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;

/**
 *
 * @author Enrique
 */
@WebServlet(name = "ObtenerConversacion", urlPatterns = {"/ObtenerConversacion"})
public class ObtenerConversacion extends HttpServlet {
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
        MensajeDAO mDao = new MensajeDAO();
        JSONArray mensajes;
        int idE, idR;
        idE = Integer.parseInt(request.getParameter("emisor"));
        idR = Integer.parseInt(request.getParameter("destinatario"));
        response.setContentType("application/json utf-8");
        PrintWriter out = response.getWriter();
        //mensajes = mDao.getConversacion(idE, idR);
        mensajes = mDao.getConversacion(1, 2);
        out.print(mensajes.toString());
        destroy();
    }
}
