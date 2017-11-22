/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbm;

import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author RigoBono
 */
public class HibernateUtil {
    //se declara las sentencias que te diran la accion a tomar
    private static final SessionFactory sessionFactory;
    private static final ThreadLocal localSession;
    
    static {
        try {
            //Se declarara un objeto config y se trae la configuracion de Sesion 
           Configuration config = new Configuration();
            config.configure("hibernate.cfg.xml");
            //Se crea un constructor para atraer mis declaraciones 
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
            applySettings(config.getProperties());
            sessionFactory = config.buildSessionFactory(builder.build());
            //Si esta acciones es validad se realiza
        } catch (Throwable ex) {
            // Se imprime un letrero de la creacion inicializada 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        localSession = new ThreadLocal();
    }
    //Se hace la sesion para iniciarla 
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    //Se inicia la sesion y mandar mensaje de iniciada
     public static Session getLocalSession() {
        Session session = (Session) localSession.get();
        if (session == null) {
            session = sessionFactory.openSession();
            localSession.set(session);
            System.out.println("\nsesion iniciada");
        }
        return session;
    }
     //Para cerrar la sesion y mandar mensaje de cerrada
     public static void closeLocalSession() {
        Session session = (Session) localSession.get();
        if (session != null) session.close();
        localSession.set(null);
        System.out.println("sesion cerrada\n");
    }
}
