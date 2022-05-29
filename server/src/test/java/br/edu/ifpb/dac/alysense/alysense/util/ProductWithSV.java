package br.edu.ifpb.dac.alysense.alysense.util;

import br.edu.ifpb.dac.alysense.alysense.model.entity.Product;

public class ProductWithSV extends Product{

    private Long code;
    private Long lote;
    
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


    public Long getCode() {
        return this.code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Long getLote() {
        return this.lote;
    }

    public void setLote(Long lote) {
        this.lote = lote;
    }


}
