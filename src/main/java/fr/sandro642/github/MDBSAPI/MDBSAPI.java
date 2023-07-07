package fr.sandro642.github.MDBSAPI;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import fr.sandro642.github.Connexion.MongoDBConnection;
import lombok.*;

import java.util.List;

public class MDBSAPI {

    private static MDBSAPI instance;

    public void setStatus(boolean status) {
        if (!status == false) return;
    }


    // methods.

    public void connectMongoDB(String ip, int port) {
        MongoDBConnection.connectMongoDB(ip, port);
    }

    public void connectMongoDBWithPOJOs(String ip, int port) {
        MongoDBConnection.connectMongoDBWithPOJOs(ip, port);
    }

    public void addDocument(String ip, int port, String databaseName) {
        MongoClient mongoClient = MongoDBConnection.connectMongoDBWithPOJOs(ip, port);
        InsertDocument.mongoDatabase = mongoClient.getDatabase(databaseName);
    }


    public static MDBSAPI getApi() {
        return instance;
    }

    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public class Post {
        private String id;
        private String title;
        private String user;
        private String content;
        private List<String> tags;
        private List<Integer> numbers;
        private List<comment> comments;
        private postQuality PostQuality;
        private int view;
        private boolean enable;
    }

    public class postQuality {
        private int likeNumber;
        private int shareNumber;
    }

    public class InsertDocument {

        public static MongoDatabase mongoDatabase;

        public static <T> void insert(String collectionName, Class<T> classType, T document){
            MongoCollection<T> collection = mongoDatabase.getCollection(collectionName, classType);
            collection.insertOne(document);
        }

        public static <T> void insertMany(String collectionName, Class<T> classType, T... documents) {
            MongoCollection<T> collection = mongoDatabase.getCollection(collectionName, classType);
            collection.insertMany(List.of(documents));
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public class comment {
        private String user;
        private String message;
        private int likeNumber;
    }
}
