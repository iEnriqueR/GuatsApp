/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

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
@Table(name="chat", catalog="mydb")
public class Chat {
    
    @Id @GeneratedValue
    @Column(name="idChat")
    private int idChat;
    
    @ManyToOne
    @JoinColumn(name="idUsuario")
    private Usuario idUsuarioC;
    
    @ManyToOne
    @JoinColumn(name="idUsuario")
    private Usuario idUsuarioD;

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
     * @return the idUsuarioC
     */
    public Usuario getIdUsuarioC() {
        return idUsuarioC;
    }

    /**
     * @param idUsuarioC the idUsuarioC to set
     */
    public void setIdUsuarioC(Usuario idUsuarioC) {
        this.idUsuarioC = idUsuarioC;
    }

    /**
     * @return the idUsuarioD
     */
    public Usuario getIdUsuarioD() {
        return idUsuarioD;
    }

    /**
     * @param idUsuarioD the idUsuarioD to set
     */
    public void setIdUsuarioD(Usuario idUsuarioD) {
        this.idUsuarioD = idUsuarioD;
    }
    
    
}
