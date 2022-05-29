package br.edu.ifpb.dac.alysense.alysense.util;

import java.util.ArrayList;
import java.util.List;

public class EventTest {

    private int qtdgeral = 10;

    private int qtdPessoas;

    private List<String> inscritos = new ArrayList<>();
    private int ctPessoas;

    public int getQtdPessoas() {
        return this.qtdPessoas;
    }

    public void setQtdPessoas(int qtdPessoas) throws OutOfLimitException {
        if (qtdPessoas > this.qtdgeral) {
            throw new OutOfLimitException();

        } else {
            this.qtdPessoas = qtdPessoas;
        }

    }

    public List<String> getInscritos() {
        return this.inscritos;
    }

    public void subscribePeople(List<String> inscritos) throws ToMuchPeopleException {
        if (inscritos.size() > qtdPessoas) {
            throw new ToMuchPeopleException();
        } else {
            this.inscritos = inscritos;
        }

    }

    public void subscribePerson(String subscriber) throws ToMuchPeopleException {
        if (ctPessoas >= qtdPessoas) {
            throw new ToMuchPeopleException();
        } else {
            this.inscritos.add(subscriber);
            ctPessoas += 1;

        }
    }

    public int getCtPessoas() {
        return this.ctPessoas;
    }

}
