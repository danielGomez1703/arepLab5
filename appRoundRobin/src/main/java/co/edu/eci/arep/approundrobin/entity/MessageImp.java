/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eci.arep.approundrobin.entity;

import java.util.Date;
import javax.persistence.Id;

/**
 *
 * @author Jairo Gomez
 */
public class MessageImp {


    private String mensaje;
    private Date fecha;

    public MessageImp(String mensaje, Date fecha) {
        this.mensaje = mensaje;
        this.fecha = fecha;
    }


    
    
    public MessageImp(Date fecha, String mensaje) {
        this.mensaje = mensaje;
        this.fecha = fecha;
    }

    public MessageImp() {
    }
    
    
    


    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    
}
