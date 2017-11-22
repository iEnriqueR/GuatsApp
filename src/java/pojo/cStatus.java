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
import static org.hibernate.criterion.Projections.id;

/**
 *
 * @author Enrique
 */
@Entity
@Table(name="cStatus", catalog="guatsapp")
public class cStatus {
    
    @Id @GeneratedValue
    @Column(name="idStatus")
    private int idStatus;
    
    @Column(name="nombre")
    private String nombre;
    
    public cStatus(){
        
    }
    
    /**
     * @return the idStatus
     */
    public int getIdStatus() {
        return idStatus;
    }

    /**
     * @param idStatus the idStatus to set
     */
    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
        
}
