package com.luv2code.cruddemo.Entity;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;

//annotate the class as an entity and map to the database
@Entity
@Table(name="instructor_detail")
public class InstructorDetails {



    //define the fields and annotate the fields with column names
   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   @Column(name="id")
    private int id;
   @Column(name = "youtube_channel")
   private String youtubeChannel;
    @Column(name = "hobby")
    private String hobby;


    //create default-empty constructor and a value holding constructor
    //create default-empty constructor
    public InstructorDetails(){
    }
    //create a value holding constructor
    public InstructorDetails(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }


    //create getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

  //generate toString() method


    @Override
    public String toString() {
        return "InstructorDetails{" +
                "id=" + id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
