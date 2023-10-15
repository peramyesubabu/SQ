package com.example.demo.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="lesson")
public class Lesson {
    @Id
    @Column(name="lesson_id")
    int lesson_id;

    @Column(name="lesson_name")
    String lesson_name;
    
    @Column(name="topics")
    String topics;

    @Column(name="link")
    String link;

    

    @ManyToOne
    Course course;

    public Lesson() {
        super();
    }

    public Lesson(int lesson_id, String lesson_name,  String topics , String link,Course course) {
        super();
        this.lesson_id = lesson_id;
        this.lesson_name = lesson_name;
        
        this.topics = topics;
        this.link = link;
        this.course=course;
    }

    public int getLesson_id() {
        return lesson_id;
    }

    public void setLesson_id(int lesson_id) {
        this.lesson_id = lesson_id;
    }

    public String getLesson_name() {
        return lesson_name;
    }

    public void setLesson_name(String lesson_name) {
        this.lesson_name = lesson_name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTopics() {
        return topics;
    }

    public void setTopics(String topics) {
        this.topics = topics;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Lesson [lesson_id=" + lesson_id + ", lesson_name=" + lesson_name + ", link=" + link + ", topics="
                + topics + "]";
    }
}
