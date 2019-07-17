/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author scardonas
 */
public class Tipo_Documento {
    private int pk_id;
    private String nombre;
    private String abreviatura;

    public Tipo_Documento() {
    }

    public Tipo_Documento(int pk_id, String nombre, String descripcion) {
        this.pk_id = pk_id;
        this.nombre = nombre;
        this.abreviatura = descripcion;
    }

    public int getPk_id() {
        return pk_id;
    }

    public void setPk_id(int pk_id) {
        this.pk_id = pk_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }
    
    
    
}
