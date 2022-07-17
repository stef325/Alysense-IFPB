package br.edu.ifpb.dac.alysense.alysense.business.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import br.edu.ifpb.dac.alysense.alysense.model.entity.User;
import br.edu.ifpb.dac.alysense.alysense.model.repository.UserRepository;
import br.edu.ifpb.dac.alysense.alysense.presentation.dto.UserDTO;


@Service
public class UserService implements UserDetailsService{


	@Autowired
	private UserRepository userDAO;
	
	/*@Autowired
	private SystemRoleService systemRoleService;

	@Autowired
	private PasswordEnconderService passwordEnconderService;
	*/
	public User save(User user) {
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
		return userDAO.save(user);
	}
	
	public void delete(Long id) {
		userDAO.deleteById(id);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
}
