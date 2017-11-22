/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import hbm.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import pojo.Chat;
import pojo.Usuario;

/**
 *
 * @author Enrique
 */
public class ChatDAO {
    Session sesion;
    
    public ChatDAO(){
        sesion = HibernateUtil.getLocalSession();
    }
    
    public Chat getChatByIds(int idA, int idB){
        Usuario usB=(Usuario)sesion.load(Usuario.class, idB);
        Usuario usA=(Usuario)sesion.load(Usuario.class, idA);
        
        return (Chat)sesion.createCriteria(Chat.class)
                .add(Restrictions.eq("idUsuarioE", usA))
                .add(Restrictions.eq("idUsuarioR", usB)).uniqueResult();
    }
    
    public Chat getChatById(int id){
        Chat c = (Chat)sesion.createCriteria(Chat.class)
                .add(Restrictions.eq("idChat", id)).uniqueResult();        
        return c;
    }
    
    public boolean saveChat(int idA, int idB){
        try{
            UsuarioDAO dao = new UsuarioDAO();
            Usuario uA = dao.getUsuarioById(idA);
            Usuario uB = dao.getUsuarioById(idB);
            Chat c = new Chat(uA, uB);
            Transaction transaccion=sesion.beginTransaction();
            sesion.save(c);
            transaccion.commit();
            return true;
        }catch(Exception e){
            return false;     
        }finally{
            HibernateUtil.closeLocalSession();
        } 
    }
}
