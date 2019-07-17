/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Modelos.Tipo_Documento;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author scardonas
 */
public class DAO_Tipo_Documento implements ITipo_Documento {

    @Override
    public List<Tipo_Documento> getTipo_Documento() {
        Connection con;
        Statement stm;
        ResultSet rs;

        String sql = "SELECT * FROM TIPOS_DOCUMENTOS ORDER BY nombre";

        List<Tipo_Documento> lista_TP = new ArrayList<>();

        try {
            con = Conexion.getConexion();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Tipo_Documento tp = new Tipo_Documento();
                tp.setPk_id(rs.getInt("pk_id"));
                tp.setNombre(rs.getString("nombre"));
                tp.setAbreviatura(rs.getString("abreviatura"));
                lista_TP.add(tp);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Tipo_Documento, método getTipo_Documento: " + e);
        }
        return lista_TP;
    }
    
}
