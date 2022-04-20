package br.edu.ifpb.dac.alysense.alysense.util;

import br.edu.ifpb.dac.alysense.alysense.model.entity.Product;

public class ProductWithSV extends Product{
    
    private boolean SVverified;


    public boolean isSVverified() {
        return this.SVverified;
    }

    public boolean getSVverified() {
        return this.SVverified;
    }

    public void setSVverified(boolean SVverified) {
        this.SVverified = SVverified;
    }


}
