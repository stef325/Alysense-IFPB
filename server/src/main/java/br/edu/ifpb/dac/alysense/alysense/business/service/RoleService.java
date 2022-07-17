package br.edu.ifpb.dac.alysense.alysense.business.service;

import br.edu.ifpb.dac.alysense.alysense.model.entity.Role;

public interface RoleService{
    public enum AVAILABLE_ROLES{ADMIN,AVALIATOR};
    public Role findByName(String name);
    public Role findDefault();
    
}
