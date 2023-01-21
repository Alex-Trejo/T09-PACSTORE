
package ec.edu.espe.ecomarket.controller;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author Alex Trejo, PACSTORE, DCCO-ESPE
 */
public class MongoConection {
    
    public static MongoDatabase database = null;
    public MongoDatabase connectDatabase(){
        
        if (database == null) {
            String uri = "mongodb+srv://alextrejo:1402oop@cluster0.ydafxco.mongodb.net/?retryWrites=true&w=majority";
            String db = "T09-PACSTORE";

            com.mongodb.client.MongoClient mongoClient = MongoClients.create(uri);

            MongoConection.database = mongoClient.getDatabase(db);
        }
        return MongoConection.database;
    }
    
}
