/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelos.Usuario;
import java.util.List;

/**
 *
 * @author scardonas
 */
public interface IUsuario {
    
    public boolean setUser(Usuario user);

    public boolean updateUser(Usuario user);
    
    //Procedimientos Almacenados
    public boolean P_Login(Usuario user);
    
    public boolean P_ValidUser(String tipo, Usuario user);
    
}
