/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.ChatDAO;
import dao.MensajeDAO;
import dao.UsuarioDAO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Enrique
 */
public class TestDAOs {
    
    public TestDAOs() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {
         ChatDAO cDao = new ChatDAO();
         UsuarioDAO uDao = new UsuarioDAO();
         MensajeDAO mDao = new MensajeDAO();
                  
         //uDao.saveUsuario("enrique", "rivera", "enri", "rivera321");
         //uDao.saveUsuario("enrique2", "rivera2", "enri2", "2rivera321");
         
         //cDao.saveChat(uDao.getUsuarioById(1).getIdUsuario(), uDao.getUsuarioById(2).getIdUsuario());
         //mDao.saveMensaje(1, "holiwi dijo el kiwi", 1);
         //mDao.saveMensaje(1, 2, "holiwi dijo el kiwi");
         //mDao.saveMensaje(cDao.getChatById(1), "holiwi dijo el kiwi");
         //System.out.println(cDao.getChatById(1).getIdChat());
     }
}
