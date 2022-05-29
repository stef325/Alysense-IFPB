package br.edu.ifpb.dac.alysense.alysense.UnitaryTests.Product;

import br.edu.ifpb.dac.alysense.alysense.model.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Categoria {

    private Product produto;

    public String getGosto() {
        return "medio";
    }

    public String getCheiro() {
        return "muito ruim";
    }

    public String getVisual() {
        return "ruim";
    }

}
