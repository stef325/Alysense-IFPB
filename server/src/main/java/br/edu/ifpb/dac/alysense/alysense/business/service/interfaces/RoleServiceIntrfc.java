package br.edu.ifpb.dac.alysense.alysense.business.service.interfaces;

import br.edu.ifpb.dac.alysense.alysense.model.entity.Role;

public interface RoleServiceIntrfc{
    public enum AVAILABLE_ROLES{ADMIN,CREATOR,AVALIATOR};
    public Role findByName(String name);
    public Role findDefault();
    
}
