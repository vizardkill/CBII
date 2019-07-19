/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Modelos.Solicitud;
import Modelos.Tipo_Documento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author clan-
 */
public class DAO_Solicitud implements ISolicitud {

    @Override
    public boolean setSolicitud(Solicitud sol) {
        Connection con;
        String sql = "INSERT INTO SOLICITUDES VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            con = Conexion.getConexion();
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, sol.getPk_id());
                ps.setString(2, sol.getFk_usuario_solicitante());
                ps.setString(3, sol.getFk_usuario_encargado());
                ps.setInt(4, sol.getFk_estado());
                ps.setInt(5, sol.getFk_categoria());
                ps.setInt(6, sol.getFk_programa_academico());
                ps.setString(7, sol.getTitulo());
                ps.setString(8, sol.getDescripcion_problema());
                ps.setString(9, sol.getDescripcion_peticion());
                ps.setString(10, sol.getDescripcion_solucion());
                ps.setString(11, sol.getFecha_creacion());
                ps.setString(12, sol.getFecha_solucion());
                
                
                ps.executeUpdate();
                ps.close();
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Solicitud, método setSolicitud: " + e);
            return false;
        }
        return true;
    }

    @Override
    public boolean updateSolicitud(Solicitud sol) {
          Connection con;

        String sql = "UPDATE SOLICITUDES SET "
                + "fk_categoria                     = ?, "
                + "fk_programa_academico            = ?, "
                + "titulo                           = ?, "
                + "descripcion_problema             = ?, "
                + "descripcion_peticion             = ?  "
                + "WHERE pk_id                      = ?";
        try {
            con = Conexion.getConexion();
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, sol.getFk_categoria());
                ps.setInt(2, sol.getFk_programa_academico());
                ps.setString(3, sol.getTitulo());
                ps.setString(4, sol.getDescripcion_problema());
                ps.setString(5, sol.getDescripcion_peticion());
                ps.setInt(6, sol.getPk_id());
                
                ps.executeUpdate();
                ps.close();
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Solicitud, método updateSolicitud: " + e);
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteSolicitud(Solicitud sol) {
       Connection con;

        String sql = "DELETE FROM SOLICITUDES WHERE pk_id = ?";

        try {
            con = Conexion.getConexion();
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, sol.getPk_id());
                
                ps.executeUpdate();
                ps.close();
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Solicitud, método deleteSolicitud: " + e);
            return false;
        }
        return true;
    }

    @Override
    public List<Solicitud> getSolicitud() {
        Connection con;
        Statement stm;
        ResultSet rs;

        String sql = "SELECT * FROM SOLICITUDES ORDER BY fecha_creacion";

        List<Solicitud> lista_sol = new ArrayList<>();

        try {
            con = Conexion.getConexion();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Solicitud sol = new Solicitud();
                sol.setPk_id(rs.getInt("pk_id"));
                sol.setFk_usuario_solicitante(rs.getString("fk_usuario_solicitante"));
                sol.setFk_usuario_encargado(rs.getString("fk_usuario_encargado"));
                sol.setFk_estado();
                lista_sol.add(sol);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Solicitud, método getSolicitud: " + e);
        }
        return lista_sol;
    }
    
}
