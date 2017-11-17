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
import pojo.Mensaje;
import java.util.List;
import org.hibernate.type.StandardBasicTypes;
import org.json.JSONObject;
import pojo.Chat;
import pojo.cStatus;

/**
 *
 * @author Enrique
 */
public class MensajeDAO {
    Session sesion;
    
    public MensajeDAO(){
        sesion = HibernateUtil.getLocalSession();
    }
    
    public JSONObject getMensajeById(int id){
        JSONObject jm = new JSONObject();
        Mensaje m = (Mensaje)sesion.createCriteria(Mensaje.class)
                .add(Restrictions.eq("idMensaje",id));
        return jm;
    }
    
    public JSONArray getConversacion(int idA, int idB){
        ChatDAO cDao = new ChatDAO();
        int idChatA, idChatB;
        JSONArray retorno = new JSONArray();
        JSONObject o;
        
        idChatA = cDao.getChatByIds(idA, idB).getIdChat();
        idChatB = cDao.getChatByIds(idB, idA).getIdChat();
        List<Mensaje> mensajes = (List)sesion.createCriteria(Mensaje.class)
                .add(Restrictions.eq("idChat", idChatA))
                .add(Restrictions.eq("idChat", idChatB))
                .list();
        
        for (int i = 0; i < mensajes.size(); i++) {
            o = new JSONObject();
            o.put("id", mensajes.get(i).getIdChat());
            o.put("contenido", mensajes.get(i).getContenido());
            o.put("fecha", mensajes.get(i).getFecha());
            o.put("status", mensajes.get(i).getIdStatus());
            retorno.put(o);
        }
        return retorno;
    }    
    public boolean saveMensaje(int idChat, String contenido, int idStatus){
        try{
            ChatDAO dao = new ChatDAO();        
            Mensaje m = new Mensaje(dao.getChatById(idChat), contenido, 
                    (cStatus)sesion.load(cStatus.class, idStatus));
            Transaction transaccion=sesion.beginTransaction();
            sesion.save(m);
            transaccion.commit();
            return true;
        }catch(Exception e){
            
        }finally{
            HibernateUtil.closeLocalSession();
        }
        return false;
    }
    
//    public boolean saveMensaje(Chat idChat, String contenido){
//        try{
//            ChatDAO dao = new ChatDAO();        
//            Mensaje m = new Mensaje(idChat, contenido);
//            Transaction transaccion=sesion.beginTransaction();
//            sesion.save(m);
//            transaccion.commit();
//            return true;
//        }catch(Exception e){
//            
//        }finally{
//            HibernateUtil.closeLocalSession();
//        }
//        return false;
//    }
//    
//    public boolean saveMensaje(int idE, int idR, String contenido){
//        try{
//            ChatDAO dao = new ChatDAO();        
//            Mensaje m = new Mensaje(dao.getChatByIds(idE, idR), contenido);
//            Transaction transaccion=sesion.beginTransaction();
//            sesion.save(m);
//            transaccion.commit();
//            return true;
//        }catch(Exception e){
//            
//        }finally{
//            HibernateUtil.closeLocalSession();
//        }
//        return false;
//    }
//    
//    public Mensaje getMensajeByIdChat(int idChat){
//        boolean hayMensaje = true;
//        ChatDAO dao = new ChatDAO(); 
//        if(hayMensaje)
//            return new Mensaje(dao.getChatById(idChat), "holiwi dijo el kiwi");
//        else{
//            return null;
//        }
//    }
//    
}
