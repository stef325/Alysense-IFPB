package br.edu.ifpb.dac.alysense.alysense.model.Enum;

public enum Aspect {
    APARENCIA("aparencia"),
    ODOR("odor"),
    SABOR("sabor"),
    SOM("som"),
    TEXTURA("textura");

    private String descricao;

    Aspect(String descricao){
        this.descricao = descricao;
    }
    
    public String getDescricao(){
        return descricao;
    }
}
