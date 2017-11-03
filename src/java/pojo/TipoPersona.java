/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *  #Pray4Tanque
 * @author RigoBono
 */
@Entity //Declara a esta clase como una identidad en la base de datos
@Table(name="TipoPersona", catalog="generationHibernate") //Dice el nombre de la tabla a la que pertenece, asi como el esquema al que pertenece
public class TipoPersona {
    
    @Id @GeneratedValue //Indica que es la clave primaria y que tiene un valor auto-generado
    @Column(name="idTipoPersona") //Indica que es una columna y el nombre de columna a la que se refiere
    private int idTipoPersona;
    
     @Column(name="TipoPersonacol") //Indica que es una columna y el nombre de columna a la que se refiere
    private String TipoPersona;
     
     public TipoPersona(){
         
     }
     

    /**
     * @return the idTipoPersona
     */
    public int getIdTipoPersona() {
        return idTipoPersona;
    }

    /**
     * @param idTipoPersona the idTipoPersona to set
     */
    public void setIdTipoPersona(int idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
    }

    /**
     * @return the TipoPersona
     */
    public String getTipoPersona() {
        return TipoPersona;
    }

    /**
     * @param TipoPersona the TipoPersona to set
     */
    public void setTipoPersona(String TipoPersona) {
        this.TipoPersona = TipoPersona;
    }
     
     
     
     
    
}
