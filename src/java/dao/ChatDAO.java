/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import pojo.Chat;

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
        return (Chat)sesion.createCriteria(Chat.class)
                .add(Restrictions.eq("idA", idA))
                .add(Restrictions.eq("idB", idB)).uniqueResult();
    }
    
    public boolean saveChat(int idA, int idB){
        try{
            Transaction transaccion=sesion.beginTransaction();
            sesion.save(new Chat(idA, idB));
            transaccion.commit();
            return true;
        }catch(Exception e){
            return false;     
        }finally{
            HibernateUtil.closeLocalSession();
        } 
    }
}
