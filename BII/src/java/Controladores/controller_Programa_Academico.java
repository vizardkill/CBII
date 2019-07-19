/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.DAO_Programa_Academico;
import DAO.IPrograma_Academico;
import Modelos.Programa_Academico;
import java.util.List;

/**
 *
 * @author scardonas
 */
public class controller_Programa_Academico {
    public List<Programa_Academico> getPrograma_Academico() {
        IPrograma_Academico pa_dao = new DAO_Programa_Academico();
        return pa_dao.getPrograma_Academico();
    }
    
}
