package com.example.demo.Entity;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    
    int id;

    @Column(name="email")
    String email;

    @Column(name="name")
    String name;

    @Column(name="password")
    String password;

    @Column(name="role")
    String role;

    @OneToMany
    private List<Course> courses;

    public Users() {
        super();
    }

    public Users(int id, String email, String name, String password, String role, List<Course> course) {
        super();
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.role = role;
        this.courses = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

   
    

    public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
    public String toString() {
        return "Users [id=" + id + ", email=" + email + ", name=" + name + ", password=" + password + ", role=" + role
                + "]";
    }
}
