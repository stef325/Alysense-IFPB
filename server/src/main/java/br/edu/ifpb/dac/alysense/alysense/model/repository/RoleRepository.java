package br.edu.ifpb.dac.alysense.alysense.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.dac.alysense.alysense.model.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{

    Optional<Role> findByName(String name);
    
}
