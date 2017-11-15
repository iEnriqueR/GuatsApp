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

/**
 *
 * @author Enrique
 */
@Entity
@Table(name="mensaje", catalog="mydb")
public class Mensaje {
    
    public Mensaje(int idChat, String contenido){
        LocalDate ld = LocalDate.now();
        //Date fechaActual = LocalDate.;
        
    }
    
    public Mensaje(){
        
    }
}
