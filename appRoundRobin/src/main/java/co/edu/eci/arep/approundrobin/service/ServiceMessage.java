/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eci.arep.approundrobin.service;


import co.edu.eci.arep.approundrobin.entity.MessageImp;
import java.util.List;

/**
 *
 * @author Jairo Gomez
 */
public interface ServiceMessage {
    
    public void addMessage(String m);
    public  List<MessageImp> getMessages();
}
