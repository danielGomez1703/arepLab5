/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eci.arep.approundrobin.service;


import co.edu.eci.arep.approundrobin.entity.MessageImp;
import co.edu.eci.arep.approundrobin.persistence.ConnectionDB;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jairo Gomez
 */
public class ServiceMessageImp  implements ServiceMessage{
    ConnectionDB db = new ConnectionDB();
    ArrayList <MessageImp> mensajes;
    
    public void addMessage(String cadena){
        MessageImp m = new MessageImp(cadena, new Date());
        db.AddMessage(m);
    }
    
   
    public List<MessageImp> getMessages(){
        mensajes = db.getMessages(); 
        return mensajes; 
    }
    
    
   
  
    
    
}
