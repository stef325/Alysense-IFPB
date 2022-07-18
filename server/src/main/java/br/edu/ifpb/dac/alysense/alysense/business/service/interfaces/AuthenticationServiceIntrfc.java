package br.edu.ifpb.dac.alysense.alysense.business.service.interfaces;

import br.edu.ifpb.dac.alysense.alysense.model.entity.User;

public interface AuthenticationServiceIntrfc {
    public String login(String username, String password);
    public User getLoggedUser();
}
