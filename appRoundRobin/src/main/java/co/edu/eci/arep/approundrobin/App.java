/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eci.arep.approundrobin;

/**
 *
 * @author Jairo Gomez
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import co.edu.eci.arep.approundrobin.service.ServiceMessage;
import co.edu.eci.arep.approundrobin.service.ServiceMessageImp;
import com.google.gson.Gson;
import java.util.List;
import spark.Request;
import spark.Response;
import static spark.Spark.*;

/**
 *
 * @author Jairo Gomez
 */
public class App {

    static ServiceMessage sm = new ServiceMessageImp();

    public static void main(String[] args) {
        port(getPort());
        get("/messages", (req, res) -> listMessage(req, res));
        get("/addMessage", (req, res) -> addMessage(req, res));
    }

    static String listMessage(Request req, Response res) {
        
        res.status(200);
        res.type("application/json");
        System.out.println(sm.getMessages());
        return new Gson().toJson(sm.getMessages());
    }

    static String addMessage(Request req, Response res) {
        System.out.println("entra al add en  round");
        String mensaje = req.queryParams("mensaje");
        res.type("application/json");
        System.out.println(mensaje);
        sm.addMessage(mensaje);
        return new Gson().toJson(sm.getMessages());
    }

    public static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 35000;
    }

}
