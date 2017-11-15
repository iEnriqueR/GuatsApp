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
@Table(name="contacto", catalog="guatsapp")
public class Contacto {
    
    @Id @GeneratedValue
    @Column(name="idContacto")
    private int idContacto;
    
    @ManyToOne
    @JoinColumn(name="idUsuario")
    private Usuario idUsuarioD;
    
    @ManyToOne
    @JoinColumn(name="idUsuario")
    private Usuario idUsuarioC;

    /**
     * @return the idContacto
     */
    public int getIdContacto() {
        return idContacto;
    }

    /**
     * @param idContacto the idContacto to set
     */
    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
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

 
    
}
