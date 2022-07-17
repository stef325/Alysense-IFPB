package br.edu.ifpb.dac.alysense.alysense.business.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.alysense.alysense.business.service.interfaces.RoleServiceIntrfc;
import br.edu.ifpb.dac.alysense.alysense.model.entity.Role;
import br.edu.ifpb.dac.alysense.alysense.model.repository.RoleRepository;

@Service
public class RoleService implements RoleServiceIntrfc{
    
    @Autowired
    private RoleRepository repo;


    public void createDefaultValues(){
        for (AVAILABLE_ROLES availableRole : AVAILABLE_ROLES.values()) {
            Role role = findByName(availableRole.name());
            if (role == null) {
                role = new Role();
                role.setName(availableRole.name());
                repo.save(role);
            }
        }
        
    }


    @Override
    public Role findByName(String name) {
        if (name == null) {
            throw new IllegalStateException("Name Cannot be null");
        }
        Optional<Role> optional = repo.findByName(name);
        return optional.isPresent()? optional.get():null;
    }


    @Override
    public Role findDefault() {
        return findByName(AVAILABLE_ROLES.AVALIATOR.name());
    }

   

    

}
