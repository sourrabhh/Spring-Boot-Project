package com.springboot.Boot001;

public class Course 
{
    private int id;
    private String name;
    private String author;

// Constructor 
    // Getters and Setters
    // toString Method


// Constructor
    public Course(int id, String name, String author) 
    {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    // Getters and Setters
    public int getId() 
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
