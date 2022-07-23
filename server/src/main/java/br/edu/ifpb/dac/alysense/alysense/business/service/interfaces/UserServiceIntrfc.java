package br.edu.ifpb.dac.alysense.alysense.business.service.interfaces;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.alysense.alysense.model.entity.User;

@Service
public interface UserServiceIntrfc extends UserDetailsService{
    
    public User save(User user);

    public User update(User user);

    public void delete(Long id);

    public User findById(Long id);

    public User findByEmail(String email);

    public User findByUseName(String name);

    public Iterable<User> findAll();

    public List<User> find(User filter);
}
