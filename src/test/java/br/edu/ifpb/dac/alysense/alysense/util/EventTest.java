package br.edu.ifpb.dac.alysense.alysense.util;

import java.util.List;

public class EventTest {
    
    private int qtdgeral = 10;

    private int qtdPessoas;
    
    private List<String> inscritos;

    public int getQtdPessoas() {
        return this.qtdPessoas;
    }

    public void setQtdPessoas(int qtdPessoas) throws OutOfLimitException{
        if (qtdPessoas > this.qtdgeral) {
            throw new OutOfLimitException();

        }else{
           this.qtdPessoas = qtdPessoas; 
        }
        
    }

    public List<String> getInscritos() {
        return this.inscritos;
    }

    public void setInscritos(List<String> inscritos) throws ToMuchPeopleException{
        if (inscritos.size()> qtdPessoas) {
            throw new ToMuchPeopleException();
        }else{
            this.inscritos = inscritos;
        }
        
    }

    
}
