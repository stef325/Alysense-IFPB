package br.edu.ifpb.dac.alysense.alysense.business.service;

public class AvaliationStringService{
    private String valorString;

    public String valueToString(float valor){
        if(valor == -1){
            valorString = "Nenhuma avaliação registrada";
        }
        else if(valor >= 0 && valor <= 1){
            valorString = "Muito ruim";
        }
        else if(valor <=2){
            valorString = "Ruim";
        }
        else if(valor <=3){
            valorString = "medio";
        }
        else if(valor <=4){
            valorString = "Bom";
        }
        else if(valor <=5){
            valorString = "Muito bom";
        }
        return valorString;
    }
}