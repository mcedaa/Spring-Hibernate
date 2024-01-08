package com.example.demo;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;


@Entity
@Table(name= "users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String username;
	private String name;
	private String surname;
	private String email;
	private String pass;
	private boolean active=false;
	private Date creat_date = new Date();
	private String user_key;
	@Transient
	private String pass2;
	public String getPass2() {
		return pass2;
	}
	public void setPass2(String pass2) {
		this.pass2 = pass2;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Date getCreat_date() {
		return creat_date;
	}
	public void setCreat_date(Date creat_date) {
		this.creat_date = creat_date;
	}
	public String getKey() {
		return user_key;
	}
	public void setKey(String user_key) {
		this.user_key = user_key;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", name=" + name + ", surname=" + surname + ", email="
				+ email + ", pass=" + pass + ", active=" + active + ", creat_date=" + creat_date + ", user_key="
				+ user_key + ", pass2=" + pass2 + "]";
	}
	

}
