/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import hbm.HibernateUtil;
import org.hibernate.type.Type;
import java.util.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.json.JSONArray;
import pojo.Usuario;
import java.util.List;
import org.hibernate.type.StandardBasicTypes;
import org.json.JSONObject;

/**
 *
 * @author Enrique
 */
public class UsuarioDAO {
    Session sesion;
    
    public UsuarioDAO(){
        sesion = HibernateUtil.getLocalSession();
    }
    
    public Usuario logUsuario(String usuario, String pass){
        return (Usuario)sesion.createCriteria(Usuario.class)
                .add(Restrictions.eq("usuario", usuario))
                .add(Restrictions.eq("contrasena", pass)).uniqueResult();
    }
    
    public JSONArray listarContactos(){
        List<Usuario> usuarios = (List)sesion.createCriteria(Usuario.class).list();
        JSONArray retorno = new JSONArray();
        JSONObject o;
        for (int i = 0; i < usuarios.size(); i++) {
            o = new JSONObject();
            o.put("id", usuarios.get(i).getIdUsuario());
            o.put("nombre", usuarios.get(i).getNombre());
            o.put("estado", "Disponible");
            retorno.put(o);
        }
        return retorno;
    }
    
    public Usuario getUsuarioById(int id){
        return (Usuario)sesion.createCriteria(Usuario.class)
                .add(Restrictions.eq("idUsuario", id)).uniqueResult();
    }
    
    public boolean saveUsuario(String nombre, String apellido,
            String usuario, String pass){        
        try{
            Transaction transaccion=sesion.beginTransaction();
            sesion.save(new Usuario(nombre, apellido, usuario, pass));
            transaccion.commit();
            return true;
        }catch(Exception e){
            return false;     
        }finally{
            HibernateUtil.closeLocalSession();
        }               
    }
}
