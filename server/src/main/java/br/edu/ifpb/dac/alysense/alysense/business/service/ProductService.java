package br.edu.ifpb.dac.alysense.alysense.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.alysense.alysense.model.entity.Product;
import br.edu.ifpb.dac.alysense.alysense.model.repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository repository;

    /*-----Create-----*/
    public void save(Product product){
        repository.save(product);
    }


    /*-----Read-----*/
    public List<Product> find(Product filter ){
        Example<Product> example = Example.of(filter, ExampleMatcher.matching().withIgnoreCase().withStringMatcher(StringMatcher.CONTAINING));
        return repository.findAll(example);
    }

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(Long id){
        return repository.getById(id);
    }


    /*-----Update-----*/
    public Product update(Product entity){
        return repository.save(entity);
    }
    
    /*-----Delete-----*/
    public void delete(Long id){
        repository.deleteById(id);
    }
}
