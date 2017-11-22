/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import dao.UsuarioDAO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name="chat", catalog="guatsapp")
public class Chat {
    
    @Id @GeneratedValue
    @Column(name="idChat")
    private int idChat;
    
    @ManyToOne
    @JoinColumn(name="idUsuarioE")
    private Usuario idUsuarioE;
    
    @ManyToOne
    @JoinColumn(name="idUsuarioR")
    private Usuario idUsuarioR;
    
    public Chat(int idA, int idB){
        UsuarioDAO dao = new UsuarioDAO();
        setIdUsuarioE(dao.getUsuarioById(idA));
        setIdUsuarioR(dao.getUsuarioById(idB));
    }
    
    public Chat(Usuario idA, Usuario idB){
        setIdUsuarioE(idA);
        setIdUsuarioR(idB);
    }
    
    public Chat(){
        
    }

    /**
     * @return the idChat
     */
    public int getIdChat() {
        return idChat;
    }

    /**
     * @param idChat the idChat to set
     */
    public void setIdChat(int idChat) {
        this.idChat = idChat;
    }

    /**
     * @return the idUsuarioE
     */
    public Usuario getIdUsuarioE() {
        return idUsuarioE;
    }

    /**
     * @param idUsuarioE the idUsuarioE to set
     */
    public void setIdUsuarioE(Usuario idUsuarioE) {
        this.idUsuarioE = idUsuarioE;
    }

    /**
     * @return the idUsuarioR
     */
    public Usuario getIdUsuarioR() {
        return idUsuarioR;
    }

    /**
     * @param idUsuarioR the idUsuarioR to set
     */
    public void setIdUsuarioR(Usuario idUsuarioR) {
        this.idUsuarioR = idUsuarioR;
    }
}
