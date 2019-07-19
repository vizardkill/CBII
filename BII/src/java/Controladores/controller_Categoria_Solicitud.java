/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.DAO_Categoria_Solicitud;
import DAO.ICategoria_Solicitud;
import Modelos.Categoria_Solicitud;
import java.util.List;

/**
 *
 * @author scardonas
 */
public class controller_Categoria_Solicitud {
    public List<Categoria_Solicitud> getCategoria_Solicitud() {
        ICategoria_Solicitud ics_dao = new DAO_Categoria_Solicitud();
        return ics_dao.getCategoria_Solicitud();
    }
    
}
