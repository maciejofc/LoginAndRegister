package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class User implements Serializable {
	Logger logger = LogManager.getLogger("User");
	Integer id;
	Role role;
	String fullName;
	LocalDate birthday;
	String email;
	String password;
	LocalDateTime createdAt;
	LocalDateTime updatedAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Role getRole() {
		
		
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User() {

	}

	public User(String fullName, LocalDate birthday, String email, String password) {
		this.fullName = fullName;
		this.birthday = birthday;
		this.email = email;
		this.password = password;
	}

	public User(String fullName, LocalDate birthday, String email, String password, LocalDateTime createdAt,
			LocalDateTime updatedAt) {

		this.fullName = fullName;
		this.birthday = birthday;
		this.email = email;
		this.password = password;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public User(Role role, String fullName, LocalDate birthday, String email, String password, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		super();
		this.role = role;
		this.fullName = fullName;
		this.birthday = birthday;
		this.email = email;
		this.password = password;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public User(Integer id, Role role, String fullName, LocalDate birthday, String email, String password,
			LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.role = role;
		this.fullName = fullName;
		this.birthday = birthday;
		this.email = email;
		this.password = password;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [fullName=");
		builder.append(fullName);
		builder.append(", birthday=");
		builder.append(birthday);
		builder.append(", email=");
		builder.append(email);
		builder.append(", password=");
		builder.append(password);
		builder.append(", createdAt=");
		builder.append(createdAt);
		builder.append(", updatedAt=");
		builder.append(updatedAt);
		builder.append("]");
		return builder.toString();
	}

}
