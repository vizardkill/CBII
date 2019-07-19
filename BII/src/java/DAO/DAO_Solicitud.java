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
                ps.setInt(4, Integer.valueOf(sol.getFk_estado()));
                ps.setInt(5, Integer.valueOf(sol.getFk_categoria()));
                ps.setInt(6, Integer.valueOf(sol.getFk_programa_academico()));
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
                ps.setInt(1, Integer.valueOf(sol.getFk_categoria()));
                ps.setInt(2, Integer.valueOf(sol.getFk_programa_academico()));
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
    public List<Solicitud> getSolicitud(Solicitud sol) {
        Connection con;
        ResultSet rs;
        PreparedStatement ps;

        String sql = 
                  "SELECT * FROM v_Solicitudes_Usuarios ORDER BY fecha_creacion"
                + "WHERE pk_documento = ?";

        List<Solicitud> lista_sol = new ArrayList<>();

        try { 
            con = Conexion.getConexion();
            
            ps = con.prepareStatement(sql);
            ps.setString(1, sol.getFk_usuario_solicitante()); 
  
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                Solicitud aux_sol = new Solicitud();
                aux_sol.setPk_id(rs.getInt("Id"));
                aux_sol.setFk_estado(rs.getString("Estado"));
                aux_sol.setFk_categoria(rs.getString("Categoria"));
                aux_sol.setFk_programa_academico(rs.getString("Programa_Academico"));
                aux_sol.setDescripcion_problema(rs.getString("descripcion_problema"));
                aux_sol.setDescripcion_peticion(rs.getString("descripcion_peticion"));
                aux_sol.setDescripcion_solucion(rs.getString("descripcion_solucion"));
                aux_sol.setFecha_creacion(rs.getString("fecha_creacion"));
                aux_sol.setFecha_solucion(rs.getString("fecha_solucion"));
                lista_sol.add(aux_sol);
            }
            ps.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Solicitud, método getSolicitud: " + e);
        }
        return lista_sol;
    }
    
}
