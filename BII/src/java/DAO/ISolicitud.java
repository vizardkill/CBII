/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelos.Solicitud;
import java.util.List;

/**
 *
 * @author clan-
 */
public interface ISolicitud {
    public boolean setSolicitud(Solicitud sol);
    
    public boolean updateSolicitud(Solicitud sol);
    
    public boolean deleteSolicitud(Solicitud sol);
    
    public List<Solicitud> getSolicitud(Solicitud sol);
    
}
