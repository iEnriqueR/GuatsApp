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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UsuarioDAO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;
import pojo.Usuario;

/**
 *
 * @author Enrique
 */
@WebServlet(name = "ValidarLogin", urlPatterns = {"/ValidarLogin"})
public class ValidarLogin extends HttpServlet {
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
        UsuarioDAO uDao = new UsuarioDAO();
        JSONObject retorno = new JSONObject();
        Usuario u;
        PrintWriter out=response.getWriter();
        
        u = uDao.logUsuario(request.getParameter("usuario"),
                request.getParameter("pass"));
        if(u != null){
//            Cookie loginCookie = new Cookie("idLocal",u.getIdUsuario());
//			//setting cookie to expiry in 30 mins
//			loginCookie.setMaxAge(30*60);
//			response.addCookie(loginCookie);
            retorno.put("resultado", true);
            retorno.put("id", u.getIdUsuario());
            HttpSession sesion = request.getSession();
            sesion.setAttribute("idLocal", u.getIdUsuario());
        }
        else{
            retorno.put("resultado", false);
        } 
        response.setContentType("application/json utf-8");        
        out.print(retorno.toString());
        destroy();
    }
}
