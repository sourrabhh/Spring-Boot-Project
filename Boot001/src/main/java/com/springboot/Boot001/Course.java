package com.springboot.Boot001;

public class Course 
{
    private String id;
    private String name;
    private String author;

// Constructor 
    // Getters and Setters
    // toString Method


// Constructor
    public Course(String id, String name, String author) 
    {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public Course(int i, String name2, String author2) {
    }

    // Getters and Setters
    public String getId() 
    {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
    }

}
