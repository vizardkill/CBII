/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import Controladores.controller_Usuario;
import Modelos.Usuario;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 *
 * @author clan-
 */
public class Json_Datos {

    public Json_Datos() {
    }

    public String Json_Login(Usuario user) {
        JsonObject json = new JsonObject();
        controller_Usuario cuser = new controller_Usuario();

        boolean aux = cuser.P_Login(user);
        if (aux) {
            JsonArray array = new JsonArray();
            JsonObject item = new JsonObject();

            item.addProperty("resulset", aux);
            item.addProperty("nombres", user.getNombres());
            item.addProperty("apellidos", user.getApellidos());
            item.addProperty("documento", user.getPk_documento());
            array.add(item);
            json.add("data", array);
            return json.toString();
        }
        return "false";
    }


}
