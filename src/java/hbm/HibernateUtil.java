/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbm;

import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author RigoBono
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory; //Es el objeto creador de sesiones para los usuarios del sistema
    private static final ThreadLocal localSession; //Es el objeto que representa una sesion local
    
    static {
        try {
           Configuration config = new Configuration(); //Instancia un nuevo objeto Configuration
            config.configure("hibernate.cfg.xml"); //Le indica la ruta en la que se encuentra el archivo de configuracion de de Hibernate
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder(); //Da contexto al sesionFactory en base a la configuracion
            builder.applySettings(config.getProperties()); //Aplica la confioguracion proveniente de config
            sessionFactory = config.buildSessionFactory(builder.build()); //Inicia la sesion con la configuracion asignada anteriormente
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        localSession = new ThreadLocal(); //Crea un nuevo hilo con la sesion local
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    //Crea y verifica la nueva sesion local y la retorna
    public static Session getLocalSession() {
        Session session = (Session) localSession.get(); //Obtiene un objeto Sesion de la sesion local
        //Evalua si la sesion local es inexistente, y si lo es, instancia una nueva y la asigna a la sesion local
        if (session == null) {
            session = sessionFactory.openSession();
            localSession.set(session);
            System.out.println("\nsesion iniciada");
        }
        return session;
    }
     
    //Cierra la sesion local
     public static void closeLocalSession() {
        Session session = (Session) localSession.get();
        if (session != null) session.close();
        localSession.set(null);
        System.out.println("sesion cerrada\n");
    }
}
