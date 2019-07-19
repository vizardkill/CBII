/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Modelos.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author clan-
 */
public class DAO_Usuario implements IUsuario {

    @Override
    public boolean setUser(Usuario user) {
        Connection con;
        String sql = "INSERT INTO USUARIOS VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            con = Conexion.getConexion();
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, user.getPk_documento());
                ps.setInt(2, user.getFk_tipo_documento());
                ps.setInt(3, user.getFk_tipo_usuario());
                ps.setString(4, user.getNombres());
                ps.setString(5, user.getApellidos());
                ps.setString(6, user.getTelefono());
                ps.setString(7, user.getCorreo());
                ps.setString(8, user.getUsername());
                ps.setString(9, user.getPwd());
                ps.executeUpdate();
                ps.close();
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Usuario, método registrar: " + e);
            return false;
        }
        return true;
    }

    @Override
    public boolean updateUser(Usuario user) {
        Connection con;

        String sql = "UPDATE USUARIO SET "
                + "pwd                    = ?, "
                + "nombres                = ?, "
                + "apellidos              = ?, "
                + "telefono               = ?, "
                + "correo                 = ?  "
                + "WHERE pk_documento     = ?";
        try {
            con = Conexion.getConexion();
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, user.getPwd());
                ps.setString(2, user.getNombres());
                ps.setString(3, user.getApellidos());
                ps.setString(4, user.getTelefono());
                ps.setString(5, user.getCorreo());
                ps.setString(6, user.getPk_documento());
                
                ps.executeUpdate();
                ps.close();
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Usuario, método actualizar: " + e);
            return false;
        }
        return true;
    }


    //**************************************************Procedimientos Almacenados******************************************************
    @Override
    public boolean P_Login(Usuario user) {
        Connection con;
        con = Conexion.getConexion();
        int valor;
        try (CallableStatement cst = con.prepareCall("{call LOGIN_USUARIO (?,?,?,?,?,?,?,?)}")) {

            cst.setString(1, user.getUsername());
            cst.setString(2, user.getPwd());

            cst.registerOutParameter(3, java.sql.Types.VARCHAR);
            cst.registerOutParameter(4, java.sql.Types.VARCHAR);
            cst.registerOutParameter(5, java.sql.Types.VARCHAR);
            cst.registerOutParameter(6, java.sql.Types.INTEGER);
            cst.registerOutParameter(7, java.sql.Types.VARCHAR);
            cst.registerOutParameter(8, java.sql.Types.INTEGER);

            cst.execute();

            
            user.setNombres(cst.getString(3));
            user.setApellidos(cst.getString(4));
            user.setCorreo(cst.getString(5));
            user.setFk_tipo_usuario(cst.getInt(6));
            user.setPk_documento(cst.getString(7));
            
            valor = cst.getInt(8);

            cst.close();

        } catch (SQLException ex) {
            System.out.println("Error: Procedimiento Almacenado, método P_Login: " + ex);
            return false;
        }

        if (valor == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean P_ValidUser(String tipo, Usuario user) {
        Connection con;
        con = Conexion.getConexion();
        int valor;
        try (CallableStatement cst = con.prepareCall("{ ? = call Validaciones_Usuario (?,?)}")) {

            cst.setString(2, tipo);
            
            if (tipo.equals("ValidarNickUsuario")) {
                cst.setString(3, user.getUsername());
            }
            
            if (tipo.equals("ValidarEmailUsuario")) {
                cst.setString(3, user.getCorreo());
            }
            
            if (tipo.equals("ValidarDocUsuario")) {
                cst.setString(3, user.getPk_documento());
            }   
            cst.registerOutParameter(1, java.sql.Types.INTEGER);

            cst.execute();

            valor = cst.getInt(1);

            cst.close();

        } catch (SQLException ex) {
            System.out.println("Error: Procedimiento Almacenado, método P_ValidUser: " + ex);
            return false;
        }

        if (valor == 1) {
            return true;
        }
        return false;
    }
}
