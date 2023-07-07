package fr.sandro642.github.data;

import java.util.List;

public class post {
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