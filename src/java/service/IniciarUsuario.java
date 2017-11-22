/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;

/**
 *
 * @author Enrique
 */
@WebServlet(name = "IniciarUsuario", urlPatterns = {"/IniciarUsuario"})
public class IniciarUsuario extends HttpServlet {
    private int id;
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
        id = Integer.parseInt(request.getParameter("id"));
        System.out.println("Se guardo el id: " + id);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("idLocal", id);
        Cookie loginCookie = new Cookie("idLocal", request.getParameter("id"));        
	loginCookie.setMaxAge(30*60);
        response.addCookie(loginCookie);
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JSONObject retorno = new JSONObject();
        PrintWriter out = response.getWriter();
        System.out.println("Se envio el id: " + id);
        retorno.put("id", id);
        response.setContentType("application/json utf-8");        
        out.print(retorno.toString());
        destroy();
    }
}
