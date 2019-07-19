/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author scardonas
 */
public class Calendario {
    public String Fecha_Registro()  {
        Calendar cal = Calendar.getInstance();
        String sqlDate = fechaString(cal);

        String f = sqlDate;
        return f;
    }

    private String fechaString(Calendar cal) {
        String aux = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        if (cal != null) {
            aux = sdf.format(cal.getTime());
        }
        return aux;
    }
}
