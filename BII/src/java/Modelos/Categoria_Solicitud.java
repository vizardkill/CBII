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
public class Categoria_Solicitud {
    private int pk_id;
    private String nombre;
    private int prioridad;
    private String descripcion;

    public Categoria_Solicitud() {
    }

    public Categoria_Solicitud(int pk_id, String nombre, int prioridad, String descripcion) {
        this.pk_id = pk_id;
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.descripcion = descripcion;
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

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
