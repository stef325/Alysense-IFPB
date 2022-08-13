package br.edu.ifpb.dac.alysense.alysense.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.alysense.alysense.business.service.interfaces.UserServiceIntrfc;
import br.edu.ifpb.dac.alysense.alysense.model.entity.Role;
import br.edu.ifpb.dac.alysense.alysense.model.entity.User;
import br.edu.ifpb.dac.alysense.alysense.model.repository.UserRepository;
import br.edu.ifpb.dac.alysense.alysense.presentation.dto.UserDTO;

@Service
public class UserService implements UserServiceIntrfc{


	@Autowired
	private UserRepository userDAO;
	
	@Autowired
	private RoleService systemRoleService;

	@Autowired
	private PasswordEncoderService passwordEnconderService;

	public User save(User user) {
		if(user.getId() != null){
			throw new IllegalStateException("User ja existe tente atualizar!");
		}
		passwordEnconderService.encryptPassword(user);
		List<Role> roles = new ArrayList<>();
		roles.add(systemRoleService.findDefault());
		user.setRoles(roles);
		return userDAO.save(user);
	}
	
	public UserDTO findByIdDTO(Long id) {
		User entity = userDAO.findById(id).get();
		UserDTO dto = new UserDTO(entity);
		return dto;
	}

	public User findById(Long id) {
		User entity = userDAO.findById(id).get();
		return entity;
	}
	
	public Iterable<User> findAll(){
		return userDAO.findAll();
	}
	
	public List<User> find(User filter){
		Example example = Example.of(filter,
				ExampleMatcher.matching().withIgnoreCase()
				.withStringMatcher(StringMatcher.CONTAINING));
		return  userDAO.findAll(example);
	}
	
	public User update(User user) {
		if(user.getId() == null){
			throw new IllegalStateException("Id não pode ser vazio!");
		}
		passwordEnconderService.encryptPassword(user);
		return userDAO.save(user);
	}
	
	public void delete(Long id) {
		userDAO.deleteById(id);
	}



	@Override
	public User findByEmail(String email) {
		List<User> user = userDAO.findByEmail(email);
		return (User) user.get(0);
	}

	@Override
	public User findByUseName(String name) {
		List<User> user = userDAO.findByName(name);
		return (User) user.get(0);
	}

	@Override
	public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username){
		User user = findByEmail(username);
		if(user == null){
			throw new UsernameNotFoundException(String.format("Could not find any use with usename %s", username));
		}
		
		return (org.springframework.security.core.userdetails.UserDetails) user;
	}
}
