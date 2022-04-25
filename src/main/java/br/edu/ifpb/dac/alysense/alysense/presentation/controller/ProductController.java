package br.edu.ifpb.dac.alysense.alysense.presentation.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.dac.alysense.alysense.business.service.ConverterService;
import br.edu.ifpb.dac.alysense.alysense.business.service.ProductService;
import br.edu.ifpb.dac.alysense.alysense.model.entity.Characteristic;
import br.edu.ifpb.dac.alysense.alysense.model.entity.Product;
import br.edu.ifpb.dac.alysense.alysense.presentation.dto.ProductDTO;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    
    @Autowired
    private ProductService service;

    @Autowired
    private ConverterService converter;

    
    /*-----Create-----*/
    @PostMapping
    public ResponseEntity save(@RequestBody ProductDTO dto){
        try {
            Product entity = converter.DTOToProduct(dto);
            service.save(entity);
            dto = converter.ProductToDTO(entity);

            return new ResponseEntity(dto, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    /*-----Read-----*/
    @GetMapping("/filter")
    public ResponseEntity find(
        @RequestParam(value = "id", required = false) Long id,
        @RequestParam(value = "name", required = false) String name,
        @RequestParam(value = "expirationDate", required = false) LocalDate expirationDate,
        @RequestParam(value = "owner", required = false) String owner,
        @RequestParam(value = "characteristic", required = false) Characteristic characteristic
        ){
        try {
            Product filter = new Product();
            filter.setCharacteristic(characteristic);
            filter.setExpirationDate(expirationDate);
            filter.setId(id);
            filter.setName(name);
            filter.setOwner(owner);

            List<Product> entities = service.find(filter);
            List<ProductDTO> dtos = converter.ProductToDTO(entities);

            return ResponseEntity.ok(dtos);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity findAll(){
        try {
            List<Product> entities = service.findAll();
            List<ProductDTO> dtos = converter.ProductToDTO(entities);

            return ResponseEntity.ok(dtos);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id){
        try {
            Product entity = service.findById(id);
            ProductDTO dto = converter.ProductToDTO(entity);

            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    /*-----Update-----*/
    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody ProductDTO dto){
        try {
            dto.setId(id);
            Product entity = converter.DTOToProduct(dto);
            service.update(entity);
            dto = converter.ProductToDTO(entity);

            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    /*-----Delete-----*/
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        try {
            service.delete(id);

            return new ResponseEntity("Succesffuly deleted!", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        
    }

}
