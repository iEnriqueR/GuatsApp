/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;

/**
 *
 * @author citlalli
 */
@WebServlet(name = "Registro", urlPatterns = {"/Registro"})
public class Registro extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre=request.getParameter("nombre");
        String apellido=request.getParameter("apellido");
        String usuario=request.getParameter("usuario");
        String contrasena=request.getParameter("contrasena");
        HttpSession sesion = request.getSession();
        UsuarioDAO usuarioDAO=new UsuarioDAO();
        
        if(usuarioDAO.saveUsuario(nombre, apellido, usuario, contrasena)){
            
        }
            //sesion;
                
        
//        response.setContentType("application/json utf-8");
//        PrintWriter out=response.getWriter();
//        JSONObject jrespuesta= new JSONObject();
//        
//        jrespuesta.put("Exitoso", true);
//        
//        out.print(jrespuesta.toString());
//        destroy();
        //Crear Procesos DAO para guardar      
    }
}