package br.edu.ifpb.dac.alysense.alysense.presentation.dto;

import java.time.LocalDate;

import br.edu.ifpb.dac.alysense.alysense.model.entity.User;

public class UserDTO {
	private Long id;

	private String name;
	
	private LocalDate age;
	
	private String email;
	
	private String password;
	
	public UserDTO() {
		
	}
	
	public UserDTO(User user) {
		id = user.getId();
		name = user.getName();
		age = user.getAge();
		email = user.getEmail();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getAge() {
		return age;
	}

	public void setAge(LocalDate age) {
		this.age = age;
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

}
