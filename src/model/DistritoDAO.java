/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Equipo 18
 */
public class DistritoDAO {
    
    private Session session;
    private Transaction transaction;
    
    public long guardarDistrito(Distrito distrito) throws HibernateException{
        long id = 0;
        try {
            iniciaOperacion();
            id = (long) session.save(distrito);
            transaction.commit();
        } catch (HibernateException e) {
            manejarExcepcion(e);
            throw e;
        } finally{
            session.close();
        }
        return id;
    }
    
    public void actualizarDistrito(Distrito distrito) throws HibernateException { 
        try { 
            iniciaOperacion(); 
            session.update(distrito); 
            transaction.commit(); 
        } catch (HibernateException e) { 
            manejarExcepcion(e);
            throw e; 
        } finally { 
            session.close(); 
        } 
    }
    
    public void eliminarDistrito(Distrito distrito) throws HibernateException { 
        try { 
            iniciaOperacion(); 
            session.delete(distrito); 
            transaction.commit(); 
        } catch (HibernateException e) { 
            manejarExcepcion(e);
            throw e; 
        } finally { 
            session.close(); 
        } 
    }  

    public Distrito obtenerDistrito(int codigo) throws HibernateException { 
        Distrito distrito = null;  
        try { 
            iniciaOperacion(); 
            distrito = (Distrito) session.get(Distrito.class, codigo); 
        } finally { 
            session.close(); 
        }  
        return distrito; 
    }
    
    public List<Queja> obtenerDistritos() throws HibernateException { 
        List<Queja> listaDistritos = null;
        try { 
            iniciaOperacion(); 
            listaDistritos = session.createQuery("from Distrito").list(); 
        } finally {
            session.close(); 
        }
        return listaDistritos; 
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
