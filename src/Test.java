
import java.util.List;
import model.Distrito;
import model.DistritoDAO;
import model.Queja;
import model.QuejaDAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Equipo 18
 */
public class Test {
    
    public static void main(String[] args) {
        DistritoDAO daoDistrito = new DistritoDAO();
        List<Distrito> ld = daoDistrito.obtenerDistritos();
        for (Distrito distrito : ld) {
            System.out.println(distrito.getNombre());
        }
        
        QuejaDAO daoQueja = new QuejaDAO();
        List<Queja> lq = daoQueja.obtenerQuejas();
        for (Queja queja : lq) {
            System.out.println(queja.getDescripcion());
        }
    }
    
}
