package br.edu.ifpb.dac.alysense.alysense.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.dac.alysense.alysense.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    List<User> findByName(String name);

    List<User> findByEmail(String email);
}
