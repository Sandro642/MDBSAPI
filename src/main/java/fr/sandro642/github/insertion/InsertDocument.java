package fr.sandro642.github.insertion;

import fr.sandro642.github.Connexion.MongoDBConnection;
import fr.sandro642.github.data.post;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.List;
import java.util.UUID;

public class InsertDocument {

    private MongoDatabase mongoDatabase;

    public InsertDocument(String ip, int port, String databaseName) {
        MongoClient mongoClient = MongoDBConnection.connectMongoDBWithPOJOs(ip, port);
        this.mongoDatabase = mongoClient.getDatabase(databaseName);
    }

    public <T> void insert(String collectionName, Class<T> classType, T document){
        MongoCollection<T> collection = mongoDatabase.getCollection(collectionName, classType);
        collection.insertOne(document);
    }

    public <T> void insertMany(String collectionName, Class<T> classType, T... documents) {
        MongoCollection<T> collection = mongoDatabase.getCollection(collectionName, classType);
        collection.insertMany(List.of(documents));
    }

    public static void main(String[] args) {
        insertDocumentExample();
    }

    private static void insertDocumentExample() {
        InsertDocument insertDocument = new InsertDocument("localhost", 27017, "HungcDev");
        post Post = post.builder()
                .id(UUID.randomUUID().toString())
                .title("Mongodb Java tutorial")
                .user("Hungcdev")
                .content("Huong dan intert Document trong MongoDB")
                .tags(List.of("Mongodb", "Mongodb Java"))
                .enable(true)
                .build();
        insertDocument.insert("Post", post.class, Post);
        System.out.println("Insert Post Successful!");
    }


}