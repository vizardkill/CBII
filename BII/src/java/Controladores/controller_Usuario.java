/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.DAO_Usuario;
import Metodos.SecurityPass;
import DAO.IUsuario;
import Modelos.Usuario;

/**
 *
 * @author clan-
 */
public class controller_Usuario {

    public boolean setUser(Usuario user) {
        SecurityPass md5 = new SecurityPass();
        String hash = md5.getMD5(user.getPwd());
        user.setPwd(hash);

        IUsuario udao = new DAO_Usuario();
        return udao.setUser(user);     
    }

    public boolean updateUser(Usuario user) {
        IUsuario udao = new DAO_Usuario();
        return udao.updateUser(user);    
    }

    //**********************************PROCEDIMIENTOS ALMACENADOS**************************************
    public boolean P_Login(Usuario user) {
        SecurityPass md5 = new SecurityPass();
        String hash = md5.getMD5(user.getPwd());
        user.setPwd(hash);

        IUsuario udao = new DAO_Usuario();
        return udao.P_Login(user);    
    }

    public boolean P_ValidUser(String tipo, Usuario user) {
        IUsuario udao = new DAO_Usuario();
        return udao.P_ValidUser(tipo, user);      
    }
}
