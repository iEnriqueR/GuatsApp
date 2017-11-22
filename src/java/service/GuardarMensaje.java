/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ChatDAO;
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
import org.json.JSONObject;



/**
 *
 * @author Enrique
 */
@WebServlet(name = "GuardarMensaje", urlPatterns = {"/GuardarMensaje"})
public class GuardarMensaje extends HttpServlet {
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
        MensajeDAO mDao = new MensajeDAO();
        ChatDAO cDao = new ChatDAO();
        JSONObject retorno = new JSONObject();
        PrintWriter out = response.getWriter();  
        HttpSession sesion = request.getSession();
        String mensaje = request.getParameter("mensaje");
        int idDestinatario = 0;
        response.setContentType("application/json utf-8");
        ///****cokies
        Cookie[] cookies = request.getCookies();
        if(cookies !=null){
        for(Cookie cookie : cookies){
                if(cookie.getName().equals("idDestinatario")) 
                    idDestinatario = Integer.parseInt(cookie.getValue());
            }
        }        
        //****
        if(mDao.saveMensaje(cDao.getChatByIds((int)sesion.getAttribute("idLocal"), idDestinatario).getIdChat(), mensaje, 1)){            
            retorno.put("resultado", true);            
        }else {
            retorno.put("resultado", false);
        }
        out.print(retorno.toString());
        destroy();
    }
}
