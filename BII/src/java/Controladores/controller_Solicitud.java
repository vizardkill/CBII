/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.DAO_Solicitud;
import DAO.ISolicitud;
import Modelos.Solicitud;
import java.util.List;

/**
 *
 * @author scardonas
 */
public class controller_Solicitud {

    public boolean setSolicitud(Solicitud sol) {
        ISolicitud sol_dao = new DAO_Solicitud();
        return sol_dao.setSolicitud(sol);      
    }

    public boolean updateSolicitud(Solicitud sol) {
        ISolicitud sol_dao = new DAO_Solicitud();
        return sol_dao.updateSolicitud(sol);
    }

    public boolean deleteSolicitud(Solicitud sol) {
        ISolicitud sol_dao = new DAO_Solicitud();
        return sol_dao.deleteSolicitud(sol);       
    }

    public List<Solicitud> getSolicitud(Solicitud sol) {
        ISolicitud sol_dao = new DAO_Solicitud();
        return sol_dao.getSolicitud(sol);       
    }

}
