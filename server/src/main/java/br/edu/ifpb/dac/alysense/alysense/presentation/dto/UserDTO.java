package br.edu.ifpb.dac.alysense.alysense.presentation.dto;

import java.time.LocalDate;

import br.edu.ifpb.dac.alysense.alysense.model.entity.User;

public class UserDTO {
	private Long id;

	private String name;
	
	private LocalDate birthDate;
	
	private String email;
	
	private String password;
	
	public UserDTO() {
		
	}
	
	public UserDTO(User user) {
		id = user.getId();
		name = user.getName();
		birthDate = user.getBirthDate();
		email = user.getEmail();
	}


	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
