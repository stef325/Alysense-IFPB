package br.edu.ifpb.dac.alysense.alysense.business.service;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public interface UserDetails extends Serializable{
    
    Collection<? extends GrantedAuthority> getAuthorities();

    String getPassword();

    String getUserName();

    boolean isAccountNonExpired();

    boolean isAccountNonLocked();

    boolean isCredentialsNonExpired();

    boolean isEnabled();
}
