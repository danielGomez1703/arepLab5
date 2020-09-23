/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eci.arep.logapp.client;

import co.edu.eci.arep.logapp.App;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import spark.Request;
import spark.Response;

/**
 *
 * @author Jairo Gomez
 */
public class HTTPClient {
    private int[] ports = {6001,6002,6003};
    private int actualPort = 0;
    private String baseUrl;
    private URLConnection connection;

    public HTTPClient() {
            baseUrl = "https://localhost:4567";
    }
    

    public void AddMessage(Request req,Response res) {
        try {
            System.out.println("entra al addmessage");
            String mensaje = req.queryParams("mensaje");
            System.out.println(mensaje + " desde log");
            URL url = new URL("http://localhost:8089"  + "/addMessage?mensaje=" + (mensaje.replace(' ', '_')));
            //URL url = new URL("http://localhost:" + String.valueOf(ports[actualPort]) + "/addMessage?mensaje=" + (mensaje.replace(' ', '_')));
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public String getMessage(Request req,Response res) {
        try {
            String mensaje = req.queryParams("message");
            URL url = new URL("http://localhost:8089" + "/messages");
            //URL url = new URL("http://localhost:" + String.valueOf(ports[actualPort]) + "/addMessage?mensaje=" + (mensaje.replace(' ', '_')));
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine;
            String result = "";
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);
                result  += inputLine+ "\n";
            }
            return result;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }


}
