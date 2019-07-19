/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Modelos.Programa_Academico;
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
public class DAO_Programa_Academico implements IPrograma_Academico {

    @Override
    public List<Programa_Academico> getPrograma_Academico() {
        Connection con;
        Statement stm;
        ResultSet rs;

        String sql = "SELECT * FROM PROGRAMAS_ACADEMICOS ORDER BY nombre";

        List<Programa_Academico> lista_pa = new ArrayList<>();

        try {
            con = Conexion.getConexion();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Programa_Academico pa = new Programa_Academico();
                pa.setPk_id(rs.getInt("pk_id"));
                pa.setNombre(rs.getString("nombre"));
                pa.setCodigo(rs.getString("codigo"));
                pa.setDescripcion(rs.getString("descripcion"));
                
                lista_pa.add(pa);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Programa_Academico, método getPrograma_Academico: " + e);
        }
        return lista_pa;
    }
    
}
