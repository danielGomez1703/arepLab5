/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eci.arep.logapp;

import co.edu.eci.arep.logapp.client.HTTPClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.internal.LinkedTreeMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import spark.Request;
import spark.Response;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

/**
 *
 * @author Jairo Gomez
 */
public class App {

    static HTTPClient httpclient = new HTTPClient();

    public static void main(String[] args) {
        port(getPort());
        get("/messages", (req, res) -> inputDataPage(req, res));
        post("/messages", (req, res) -> resultPage(req, res));
    }

    private static String inputDataPage(Request req, Response res) {

        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + " <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n"
                + "  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n"
                + "  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>"
                + "</head>"
                + "<body>"
                + "<script>"
                + "var numbers=[];"
                + "function myFunction() {"
                + "var n = document.getElementById(\"numero\").value;"
                + "numbers.push(n);"
                + "console.log(numbers);"
                + "document.getElementById(\"numero\").value=\"\";"
                + "document.getElementById(\"lista\").value = numbers.toString()};"
                + "</script>"
                + "<center>"
                + "<h1> Docker & AWS</h1>"
                + "<h3>Lab 5 </h3>"
                + "<hr/>"
                + "<form method='post' action=\"/messages\">"
                + "<label>"
                + "  <input id=\"mensaje\" type=\"text\" name=\"mensaje\" placeholder=\"que quieres enviar ?\">"
                + " <br/>"
                + " <br/>"
                + "</label>"
                + " <br/>"
                + "<p>laboratorio docker y aws</p>"
                + "  <br>"
                + "  <button type=\"submit\" value=\"enviar\" class=\"btn btn-success\"> enviar </button> "
                + "</form>"
                + "<table class=\"table table-striped\">"
                + "  <caption>Recently Messages</caption>"
                + "  <tr>"
                + "    <th>Mensaje</th>"
                + "    <th>Date</th>"
                + loadMessage(req, res)
                + "  </tr>"
                + "</table>"
                + "<center>"
                + "</body>"
                + "</html>";
        return pageContent;
    }

    private static String resultPage(Request req, Response res) {
        httpclient.AddMessage(req, res);
        return inputDataPage(req, res);
    }

    private static String loadMessage(Request req, Response res) {
        String resultados = httpclient.getMessage(req, res);
        Gson g = new Gson();
        JsonElement listJson = g.toJsonTree(resultados);
        ArrayList<LinkedTreeMap> listaJson = g.fromJson(resultados, ArrayList.class);
        String cadenaFinal = "";

        for (int i = listaJson.size()-1; i > listaJson.size()-11 ; i--) {
            String msj = listaJson.get(i).get("mensaje").toString();
            String linea = "<tr>"
                    + "<td>" + msj.replace("_", " ") + "</td>"
                    + "<td>" + listaJson.get(i).get("fecha") + "</td>"
                    + "</tr>";

            System.out.println("" + listaJson.get(i).get("mensaje") + listaJson.get(i).get("fecha"));
            cadenaFinal += linea;
        }
        return cadenaFinal;

    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 37000; //returns default port if heroku-port isn't set (i.e. on localhost)
    }

}
