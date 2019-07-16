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
public class Usuario {
    private String pk_documento;
    private int fk_tipo_documento;
    private int fk_tipo_usuario;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String correo;
    private String username;
    private String pwd;

    public Usuario() {
    }

    public Usuario(String pk_documento, int fk_tipo_documento, int fk_tipo_usuario, String nombres, String apellidos, String telefono, String correo, String username, String pwd) {
        this.pk_documento = pk_documento;
        this.fk_tipo_documento = fk_tipo_documento;
        this.fk_tipo_usuario = fk_tipo_usuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
        this.username = username;
        this.pwd = pwd;
    }

    public String getPk_documento() {
        return pk_documento;
    }

    public void setPk_documento(String pk_documento) {
        this.pk_documento = pk_documento;
    }

    public int getFk_tipo_documento() {
        return fk_tipo_documento;
    }

    public void setFk_tipo_documento(int fk_tipo_documento) {
        this.fk_tipo_documento = fk_tipo_documento;
    }

    public int getFk_tipo_usuario() {
        return fk_tipo_usuario;
    }

    public void setFk_tipo_usuario(int fk_tipo_usuario) {
        this.fk_tipo_usuario = fk_tipo_usuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    
    
}
