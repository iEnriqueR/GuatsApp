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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MensajeDAO mDao = new MensajeDAO();
        JSONArray mensajes;
        HttpSession sesion = request.getSession();
        int idE, idR;
        idE = (int)sesion.getAttribute("idLocal");
        idR = Integer.parseInt(request.getParameter("destinatario"));
        sesion.setAttribute("idDestinatario", idR);
        //****cookieasdasdasd\
        Cookie loginCookie = new Cookie("idDestinatario", request.getParameter("destinatario"));
			//setting cookie to expiry in 30 mins
			loginCookie.setMaxAge(30*60);
			response.addCookie(loginCookie);
        //*****
        response.setContentType("application/json utf-8");
        PrintWriter out = response.getWriter();
        System.out.println("IdE: " + idE);
        System.out.println("IdR: " + idR);
        mensajes = mDao.getConversacion(idE, idR);
        //mensajes = mDao.getConversacion((int)sesion.getAttribute("idLocal"), 2);
        System.out.println(mensajes.toString());
        out.print(mensajes.toString());
        destroy();
    }
}
