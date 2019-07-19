/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author clan-
 */
public class Solicitud {
    private int pk_id;
    private String fk_usuario_solicitante;
    private String fk_usuario_encargado;
    private String fk_estado;
    private String fk_categoria;
    private String fk_programa_academico;
    private String titulo;
    private String descripcion_problema;
    private String descripcion_peticion;
    private String descripcion_solucion;
    private String fecha_creacion;
    private String fecha_solucion;

    public Solicitud() {
    }

    public Solicitud(int pk_id, String fk_usuario_solicitante, String fk_usuario_encargado, String fk_estado, String fk_categoria, String fk_programa_academico, String titulo, String descripcion_problema, String descripcion_peticion, String descripcion_solucion, String fecha_creacion, String fecha_solucion) {
        this.pk_id = pk_id;
        this.fk_usuario_solicitante = fk_usuario_solicitante;
        this.fk_usuario_encargado = fk_usuario_encargado;
        this.fk_estado = fk_estado;
        this.fk_categoria = fk_categoria;
        this.fk_programa_academico = fk_programa_academico;
        this.titulo = titulo;
        this.descripcion_problema = descripcion_problema;
        this.descripcion_peticion = descripcion_peticion;
        this.descripcion_solucion = descripcion_solucion;
        this.fecha_creacion = fecha_creacion;
        this.fecha_solucion = fecha_solucion;
    }

    public int getPk_id() {
        return pk_id;
    }

    public void setPk_id(int pk_id) {
        this.pk_id = pk_id;
    }

    public String getFk_usuario_solicitante() {
        return fk_usuario_solicitante;
    }

    public void setFk_usuario_solicitante(String fk_usuario_solicitante) {
        this.fk_usuario_solicitante = fk_usuario_solicitante;
    }

    public String getFk_usuario_encargado() {
        return fk_usuario_encargado;
    }

    public void setFk_usuario_encargado(String fk_usuario_encargado) {
        this.fk_usuario_encargado = fk_usuario_encargado;
    }

    public String getFk_estado() {
        return fk_estado;
    }

    public void setFk_estado(String fk_estado) {
        this.fk_estado = fk_estado;
    }

    public String getFk_categoria() {
        return fk_categoria;
    }

    public void setFk_categoria(String fk_categoria) {
        this.fk_categoria = fk_categoria;
    }

    public String getFk_programa_academico() {
        return fk_programa_academico;
    }

    public void setFk_programa_academico(String fk_programa_academico) {
        this.fk_programa_academico = fk_programa_academico;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion_problema() {
        return descripcion_problema;
    }

    public void setDescripcion_problema(String descripcion_problema) {
        this.descripcion_problema = descripcion_problema;
    }

    public String getDescripcion_peticion() {
        return descripcion_peticion;
    }

    public void setDescripcion_peticion(String descripcion_peticion) {
        this.descripcion_peticion = descripcion_peticion;
    }

    public String getDescripcion_solucion() {
        return descripcion_solucion;
    }

    public void setDescripcion_solucion(String descripcion_solucion) {
        this.descripcion_solucion = descripcion_solucion;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getFecha_solucion() {
        return fecha_solucion;
    }

    public void setFecha_solucion(String fecha_solucion) {
        this.fecha_solucion = fecha_solucion;
    }

    
}
