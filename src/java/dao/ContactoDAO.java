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
import pojo.Contacto;

/**
 *
 * @author Enrique
 */
public class ContactoDAO {
    Session sesion;
    
    public ContactoDAO(){
        sesion = HibernateUtil.getLocalSession();
    }
    
//    public Chat getChatByIds(int idA, int idB){
//        return (Chat)sesion.createCriteria(Chat.class)
//                .add(Restrictions.eq("idA", idA))
//                .add(Restrictions.eq("idB", idB)).uniqueResult();
//    }
    
    public boolean saveChat(int idD, int idC){
        try{
            Transaction transaccion=sesion.beginTransaction();
            sesion.save(new Contacto(idD, idC));
            transaccion.commit();
            return true;
        }catch(Exception e){
            return false;     
        }finally{
            HibernateUtil.closeLocalSession();
        } 
    }
}
