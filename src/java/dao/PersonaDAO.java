/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import hbm.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import pojo.Persona;
import pojo.TipoPersona;

/**
 *
 * @author RigoBono
 */
public class PersonaDAO {
    Session session; //Es una sesion creada por HibernateUtil para cada usuario
    
    public PersonaDAO(){
        session=HibernateUtil.getLocalSession(); //Obtiene una sesion local desde el creador de sesiones de HibernateUtil
    }
    
    public  Persona getPersonaById(int id){
        return (Persona)session.load(Persona.class, id); //Consulta la base de datos para obtener un objeto Persona con su id
    }
    
    //Consulta la base de datos para obtener una lista de todas las filas que tengan como nombre el recibido en los parametros
    public List<Persona>  getPersonaByName(String nombre){
        List<Persona> listaDePersonas=(List<Persona>)
                session.createCriteria(Persona.class)
                .add(Restrictions.eq("Nombre", nombre)); 
        return listaDePersonas;
    }
    
    //Actualiza el nombre de la fila que tenga el id recibido en los parametros
    public boolean updateById(int id,Persona persona){ 
        Persona personaAModificar=getPersonaById(id); //Utiliza el metodo getPersonaById de esta misma clase para obtener un objeto tipo Persona el cual se editara
        try{
            Transaction transaccion=session.beginTransaction(); //Inicia una nueva transaccion desde el objeto local sesion
            personaAModificar.setNombre(persona.getNombre()); //Asigna el nuevo nombre desde el objeto Persona recibido en los parametros
            session.update(personaAModificar); //Le pide a la sesion local que actualice los datos de el objeto modificado
            transaccion.commit(); //Le ordena a la transaccion intentar realizar la operacion
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    //Guarda un nuevo objeto tipo Persona con los parametros recibidos en la operacion
    public boolean savePersona(String nombre,String materno,String paterno,String telefono,int idTipoPersona){
        Persona personaDeTanque=new Persona();
        TipoPersona tipoDeTanque=(TipoPersona)session.load(TipoPersona.class, idTipoPersona);
        personaDeTanque.setNombre(nombre);
        personaDeTanque.setMaterno(materno);
        personaDeTanque.setPaterno(paterno);
        personaDeTanque.setTelefono(telefono);
        personaDeTanque.setTipoPersona(tipoDeTanque);
        try{
            Transaction transaccion=session.beginTransaction();
            session.save(personaDeTanque);
            transaccion.commit();
            return true;
        }catch(Exception e){
            
        }finally{
            
        }
        return true;
    }
    
}
