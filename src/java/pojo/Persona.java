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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author RigoBono
 */

@Entity //Declara a esta clase como una identidad en la base de datos
@Table(name="Persona",catalog="generationHibernate") //Dice el nombre de la tabla a la que pertenece, asi como el esquema al que pertenece
public class Persona {
    
    @Id @GeneratedValue //Indica que es la clave primaria y que tiene un valor auto-generado
    @Column(name="idPersona") //Indica que es una columna y el nombre de columna a la que se refiere
    private int idPersona;
    
    @Column(name="Nombre",nullable=true) //Indica que es una columna, su nombre y que puede ser null
    private String Nombre;
    
    @Column(name="Paterno") //Indica que es una columna y el nombre de columna a la que se refiere
    private String Paterno;
    
     @Column(name="Materno") //Indica que es una columna y el nombre de columna a la que se refiere
    private String Materno;
     
     @Column(name="Telefono") //Indica que es una columna y el nombre de columna a la que se refiere
    private String Telefono;
    
     @ManyToOne //Indica cual es la cardinalidad con la tabla a la que se conecta
     @JoinColumn(name="idTipoPersona") //Indica que es una columna formada por otra table y el nombre de dicha tabla
    private TipoPersona tipoPersona;

    /**
     * @return the idPersona
     */
    public int getIdPersona() {
        return idPersona;
    }

    /**
     * @param idPersona the idPersona to set
     */
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Paterno
     */
    public String getPaterno() {
        return Paterno;
    }

    /**
     * @param Paterno the Paterno to set
     */
    public void setPaterno(String Paterno) {
        this.Paterno = Paterno;
    }

    /**
     * @return the Materno
     */
    public String getMaterno() {
        return Materno;
    }

    /**
     * @param Materno the Materno to set
     */
    public void setMaterno(String Materno) {
        this.Materno = Materno;
    }

    /**
     * @return the Telefono
     */
    public String getTelefono() {
        return Telefono;
    }

    /**
     * @param Telefono the Telefono to set
     */
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    /**
     * @return the tipoPersona
     */
    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }

    /**
     * @param tipoPersona the tipoPersona to set
     */
    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }
     
     
    
}
