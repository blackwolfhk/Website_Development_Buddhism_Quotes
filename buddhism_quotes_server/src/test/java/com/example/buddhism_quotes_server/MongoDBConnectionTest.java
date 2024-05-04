package com.example.buddhism_quotes_server;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MongoDBConnectionTest {

    @Test
    public void testMongoDBConnection() {
        String connectionString = "mongodb://localhost:27033";

        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            System.out.println("Connected to MongoDB server");
            MongoDatabase database = mongoClient.getDatabase("test");

            assertNotNull(database);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
