/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Modelos.Categoria_Solicitud;
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
public class DAO_Categoria_Solicitud implements ICategoria_Solicitud{

    @Override
    public List<Categoria_Solicitud> getCategoria_Solicitud() {
        Connection con;
        Statement stm;
        ResultSet rs;

        String sql = "SELECT * FROM CATEGORIAS_SOLICITUDES ORDER BY nombre";

        List<Categoria_Solicitud> lista_cs = new ArrayList<>();

        try {
            con = Conexion.getConexion();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Categoria_Solicitud cs = new Categoria_Solicitud();
                cs.setPk_id(rs.getInt("pk_id"));
                cs.setNombre(rs.getString("nombre"));
                cs.setPrioridad(rs.getInt("prioridad"));
                cs.setDescripcion(rs.getString("descripcion"));
                
                lista_cs.add(cs);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Categoria_Solicitud, método getCategoria_Solicitud: " + e);
        }
        return lista_cs;
    }
    
    
}
