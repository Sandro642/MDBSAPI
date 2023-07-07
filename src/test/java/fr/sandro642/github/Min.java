package fr.sandro642.github;

import fr.sandro642.github.MDBSAPI.MDBSAPI;

public class Min {

    public static void main(String[] args) {
        MDBSAPI.getApi().addDocument("23912301321", 23212, "OUPOUP");

        MDBSAPI.Post post = MDBSAPI.Post.builder()
                .id("DPZIOQ")
                        .title("DZQP")
                                .content("dzqio").build();

        MDBSAPI.InsertDocument.insert("MDBSAPI.Post", MDBSAPI.Post.class, post);

    }


}
