package fr.sandro642.github.MDBSAPI;

import fr.sandro642.github.Connexion.MongoDBConnection;

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

    public void exampleTestMongoDB() {
        MongoDBConnection.connectionExample();
    }




    public static MDBSAPI getOauth() {
        return instance;
    }

}
