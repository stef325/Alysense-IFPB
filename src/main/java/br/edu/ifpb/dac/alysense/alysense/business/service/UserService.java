package br.edu.ifpb.dac.alysense.alysense.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import br.edu.ifpb.dac.alysense.alysense.model.entity.User;
import br.edu.ifpb.dac.alysense.alysense.model.repository.UserRepository;
import br.edu.ifpb.dac.alysense.alysense.presentation.dto.UserDTO;


@Service
public class UserService {


	@Autowired
	private UserRepository userDAO;
	
	
	public User save(User user) {
		return userDAO.save(user);
	}
	
	public UserDTO findById(Long id) {
		User entity = userDAO.findById(id).get();
		UserDTO dto = new UserDTO(entity);
		return dto;
	}
	
	public Iterable<User> findAll(){
		return userDAO.findAll();
	}
	
	public List<User> find(User filter){
		Example example = Example.of(filter,
				ExampleMatcher.matching().withIgnoreCase()
				.withStringMatcher(StringMatcher.CONTAINING));
		return userDAO.findAll(example);
	}
	
	public User update(User user) {
		return userDAO.save(user);
	}
	
	public void delete(Long id) {
		userDAO.deleteById(id);
	}
}
