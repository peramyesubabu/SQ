package com.example.demo.Entity;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="course")
public class Course {
    @Id
    @Column(name="course_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int course_id;

    @Column(name="course_name")
    String course_name;

    @Column(name="course_price")
    int course_price;

    
    @OneToMany

    List<Lesson> lessons;
    
    
    @ManyToMany
    List<Users> userList;
    public List<Users> getUserList()
    {
    return userList;
    }
 
    public Course() {
        super();
    }

    public Course(int course_id, String course_name, int course_price, List<Lesson> lessons) {
        super();
        this.course_id = course_id;
        this.course_name = course_name;
        this.course_price = course_price;
        this.lessons=lessons;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getCourse_price() {
        return course_price;
    }

    public void setCourse_price(int course_price) {
        this.course_price = course_price;
    }


   

	public List<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}

	@Override
    public String toString() {
        return "Course [course_id=" + course_id + ", course_name=" + course_name + ", course_price=" + course_price
                + "]";
    }

	
}
