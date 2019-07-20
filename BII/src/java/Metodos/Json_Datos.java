/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import Controladores.controller_Categoria_Solicitud;
import Controladores.controller_Programa_Academico;
import Controladores.controller_Solicitud;
import Controladores.controller_Tipo_Documento;
import Controladores.controller_Usuario;
import Modelos.Categoria_Solicitud;
import Modelos.Programa_Academico;
import Modelos.Solicitud;
import Modelos.Tipo_Documento;
import Modelos.Usuario;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.List;

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

    public String Json_Tipo_Documentos() {
        JsonObject json = new JsonObject();
        controller_Tipo_Documento ctp = new controller_Tipo_Documento();
        List<Tipo_Documento> lista_TP = ctp.getTiposDocumentos();

        JsonArray array = new JsonArray();
        for (Tipo_Documento x : lista_TP) {
            JsonObject item = new JsonObject();

            item.addProperty("pk_id", x.getPk_id());
            item.addProperty("nombre", x.getNombre());
            item.addProperty("abreviatura", x.getAbreviatura());
            array.add(item);
        }
        json.add("TIPOS_DOCUMENTOS", array);
        return json.toString();
    }

    public String Json_Solicitudes_Usuarios(Solicitud sol) {
        JsonObject json = new JsonObject();
        controller_Solicitud csol = new controller_Solicitud();
        List<Solicitud> lista_sol = csol.getSolicitud(sol);

        JsonArray array = new JsonArray();
        for (Solicitud x : lista_sol) {
            JsonObject item = new JsonObject();

            item.addProperty("pk_id", x.getPk_id());
            item.addProperty("fk_estado", x.getFk_estado());
            item.addProperty("fk_categoria", x.getFk_categoria());
            item.addProperty("fk_programa_academico", x.getFk_programa_academico());
            item.addProperty("titulo", x.getTitulo());
            item.addProperty("descripcion_problema", x.getDescripcion_problema());
            item.addProperty("descripcion_peticion", x.getDescripcion_peticion());
            item.addProperty("descripcion_solucion", x.getDescripcion_solucion());
            item.addProperty("fecha_creacion", x.getFecha_creacion());
            array.add(item);
        }
        json.add("v_Solicitudes_Usuarios", array);
        return json.toString();

    }

    public String Json_Categorias_Solicitudes() {
        JsonObject json = new JsonObject();
        controller_Categoria_Solicitud ccs = new controller_Categoria_Solicitud();
        List<Categoria_Solicitud> lista_cs = ccs.getCategoria_Solicitud();

        JsonArray array = new JsonArray();
        for (Categoria_Solicitud x : lista_cs) {
            JsonObject item = new JsonObject();

            item.addProperty("pk_id", x.getPk_id());
            item.addProperty("nombre", x.getNombre());
            item.addProperty("prioridad", x.getPrioridad());
            item.addProperty("descripcion", x.getDescripcion());
            array.add(item);
        }
        json.add("CATEGORIAS_SOLICITUDES", array);
        return json.toString();
    }
    
    public String Json_Programas_Academicos() {
        JsonObject json = new JsonObject();
        controller_Programa_Academico cpa = new controller_Programa_Academico();
        
        List<Programa_Academico> lista_pa = cpa.getPrograma_Academico();
        
        JsonArray array = new JsonArray();
        for (Programa_Academico x : lista_pa) {
            JsonObject item = new JsonObject();
            
            item.addProperty("pk_id", x.getPk_id());
            item.addProperty("nombre", x.getNombre());
            item.addProperty("codigo", x.getCodigo());
            item.addProperty("descripcion", x.getDescripcion());
            array.add(item);  
        }
        json.add("PROGRAMAS_ACADEMICOS", array);
        return json.toString();
    }

}
