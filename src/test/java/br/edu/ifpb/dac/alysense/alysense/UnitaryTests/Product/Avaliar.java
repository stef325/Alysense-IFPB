package br.edu.ifpb.dac.alysense.alysense.UnitaryTests.Product;

import br.edu.ifpb.dac.alysense.alysense.model.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Avaliar {

    Product produto;

    public String getMedia() {
        return "muito bom";
    }

}
