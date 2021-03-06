package model;
// Generated 02-nov-2016 17:00:05 by Hibernate Tools 4.3.1



/**
 * Distrito generated by hbm2java
 */
public class Queja  implements java.io.Serializable {


     private int id;
     private int codDistrito;
     private int x;
     private int y;
     private String sexo;
     private String tipo;
     private String perfil;
     private String descripcion;

    public Queja() {
    }

    public Queja(int codDistrito, int x, int y, String sexo, String tipo, String perfil, String descripcion) {
        this.codDistrito = codDistrito;
        this.x = x;
        this.y = y;
        this.sexo = sexo;
        this.tipo = tipo;
        this.perfil = perfil;
        this.descripcion = descripcion;
    }

    public Queja(int id, int codDistrito, int x, int y, String sexo, String tipo, String perfil, String descripcion) {
        this.id = id;
        this.codDistrito = codDistrito;
        this.x = x;
        this.y = y;
        this.sexo = sexo;
        this.tipo = tipo;
        this.perfil = perfil;
        this.descripcion = descripcion;
    }

    /**
     * @return the codDistrito
     */
    public int getCodDistrito() {
        return codDistrito;
    }

    /**
     * @param codDistrito the codDistrito to set
     */
    public void setCodDistrito(int codDistrito) {
        this.codDistrito = codDistrito;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the perfil
     */
    public String getPerfil() {
        return perfil;
    }

    /**
     * @param perfil the perfil to set
     */
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

}


