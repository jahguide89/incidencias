/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Equipo 18
 */
public class QuejasDAO {
    
    private Session session;
    private Transaction transaction;
    
    public long guardarQuejas(Queja queja) throws HibernateException{
        long id = 0;
        try {
            iniciaOperacion();
            id = (long) session.save(queja);
            transaction.commit();
        } catch (HibernateException e) {
            manejarExcepcion(e);
            throw e;
        } finally{
            session.close();
        }
        return id;
    }
    
    public void actualizaQuejas(Queja queja) throws HibernateException { 
        try { 
            iniciaOperacion(); 
            session.update(queja); 
            transaction.commit(); 
        } catch (HibernateException e) { 
            manejarExcepcion(e);
            throw e; 
        } finally { 
            session.close(); 
        } 
    }
    
    public void eliminaQuejas(Queja queja) throws HibernateException { 
        try { 
            iniciaOperacion(); 
            session.delete(queja); 
            transaction.commit(); 
        } catch (HibernateException e) { 
            manejarExcepcion(e);
            throw e; 
        } finally { 
            session.close(); 
        } 
    }  

    public Distrito obtenQuejas(long idContacto) throws HibernateException { 
        Distrito contacto = null;  
        try { 
            iniciaOperacion(); 
            contacto = (Distrito) session.get(Distrito.class, idContacto); 
        } finally { 
            session.close(); 
        }  
        return contacto; 
    }
    
    private void iniciaOperacion() {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }
    
    private void manejarExcepcion(HibernateException e)throws HibernateException{
        transaction.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", e); 
    }
    
}
