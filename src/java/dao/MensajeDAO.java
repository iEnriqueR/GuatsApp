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

/**
 *
 * @author Enrique
 */
public class MensajeDAO {
    Session sesion;
    
    public MensajeDAO(){
        sesion = HibernateUtil.getLocalSession();
    }
    
    public Mensaje getMensajeByIdChat(int idChat){
        boolean hayMensaje = true;
        if(hayMensaje)
            return new Mensaje();
        else{
            return null;
        }
    }
    
}