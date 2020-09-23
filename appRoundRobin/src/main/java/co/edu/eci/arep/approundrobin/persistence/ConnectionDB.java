/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eci.arep.approundrobin.persistence;

import co.edu.eci.arep.approundrobin.entity.MessageImp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

/**
 *
 * @author Jairo Gomez
 */
public class ConnectionDB {

    public MongoClientURI mongoClientUri;
    public MongoClient mongoClient;
    public MongoDatabase db;

    public ConnectionDB() {
        mongoClientUri = new MongoClientURI(
                "mongodb://ec2-34-226-211-147.compute-1.amazonaws.com:27017/arepdb?serverSelectionTimeoutMS=5000&connectTimeoutMS=10000&3t.uriVersion=3&3t.connection.name=mongoAWS&3t.databases=arepdb");
        mongoClient = new MongoClient(mongoClientUri);
        db = mongoClient.getDatabase("arepdb");
    }

    public void AddMessage(MessageImp msj) {

        MongoCollection<Document> collection = db.getCollection("Mensaje");
        Document document = new Document();
        document.put("mensaje", msj.getMensaje());
        document.put("fecha", msj.getFecha());
        collection.insertOne(document);

    }

    public ArrayList<MessageImp> getMessages() {

        ArrayList<MessageImp> mensajesR = new ArrayList<MessageImp>();
        MongoCollection<Document> collections = db.getCollection("Mensaje");
        FindIterable<Document> resultados = collections.find();
        String datos = "";

        for (Document r : resultados) {
              System.out.println(r.toString());
            try {
                String valuem = r.getString("mensaje");
                Date fecham =(Date) r.get("fecha");
                MessageImp m = new MessageImp(valuem,fecham);
                //MessageImp m = new ObjectMapper().readValue(r.toJson(), MessageImp.class);
                System.out.println(m);
                datos += "\n" + r.toJson();
                System.out.println(r.toJson());
                mensajesR.add(m);
            } catch (Exception ex) {
                Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // System.out.println(datos);
        return mensajesR;

    }
}
