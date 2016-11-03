/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
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
    
    public long guardarQueja(Queja queja) throws HibernateException{
        int id = 0;
        try {
            iniciaOperacion();
            id = (int) session.save(queja);
            transaction.commit();
        } catch (HibernateException e) {
            manejarExcepcion(e);
            throw e;
        } finally{
            session.close();
        }
        return id;
    }
    
    public void actualizarQueja(Queja queja) throws HibernateException { 
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
    
    public void eliminarQueja(Queja queja) throws HibernateException { 
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

    public Queja obtenerQueja(int idQueja) throws HibernateException { 
        Queja queja = null;  
        try { 
            iniciaOperacion(); 
            queja = (Queja) session.get(Queja.class, idQueja); 
        } finally { 
            session.close(); 
        }  
        return queja; 
    }
    
    public List<Queja> obtenerQuejas() throws HibernateException { 
        List<Queja> listaQuejas = null;
        try { 
            iniciaOperacion(); 
            listaQuejas = session.createQuery("from Queja").list(); 
        } finally {
            session.close(); 
        }
        return listaQuejas; 
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
