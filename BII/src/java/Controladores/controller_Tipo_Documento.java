/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.DAO_Tipo_Documento;
import DAO.ITipo_Documento;
import Modelos.Tipo_Documento;
import java.util.List;

/**
 *
 * @author scardonas
 */
public class controller_Tipo_Documento {

    public List<Tipo_Documento> getTiposDocumentos() {
        ITipo_Documento td_dao = new DAO_Tipo_Documento();
        return td_dao.getTipo_Documento();        
    }
}
