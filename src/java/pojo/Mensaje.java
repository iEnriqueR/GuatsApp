/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import dao.ChatDAO;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name="mensaje", catalog="guatsapp")
public class Mensaje {
    
    @Id @GeneratedValue
    @Column(name="idMensaje")
    private int idMensaje;
    
    
    @Column(name="contenido")
    private String contenido;
    
    
    @Column(name="fecha")
    private Date fecha;
    
    @ManyToOne
    @JoinColumn(name="idChat")
    private Chat idChat;
    
    @ManyToOne
    @JoinColumn(name="idStatus")
    private cStatus idStatus;
    
    public Mensaje(Chat idChat, String contenido, cStatus idStatus){
        setIdChat(idChat);
        setContenido(contenido);
        setIdStatus(idStatus);
        setFecha(new Date());        
    }
    
    public Mensaje(){
        
    }

    /**
     * @return the idMensaje
     */
    public int getIdMensaje() {
        return idMensaje;
    }

    /**
     * @param idMensaje the idMensaje to set
     */
    public void setIdMensaje(int idMensaje) {
        this.idMensaje = idMensaje;
    }

    /**
     * @return the contenido
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * @param contenido the contenido to set
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the idChat
     */
    public Chat getIdChat() {
        return idChat;
    }

    /**
     * @param idChat the idChat to set
     */
    public void setIdChat(Chat idChat) {
        this.idChat = idChat;
    }

    /**
     * @return the idStatus
     */
    public cStatus getIdStatus() {
        return idStatus;
    }

    /**
     * @param idStatus the idStatus to set
     */
    public void setIdStatus(cStatus idStatus) {
        this.idStatus = idStatus;
    }

    
}