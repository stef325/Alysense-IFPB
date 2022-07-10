package br.edu.ifpb.dac.alysense.alysense.presentation.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

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
import br.edu.ifpb.dac.alysense.alysense.model.entity.Sample;
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
            dto = converter.productToDTO(entity);

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
        @RequestParam(value = "expirationDate", required = false) String expirationDate,
        @RequestParam(value = "owner", required = false) String owner,
        @RequestParam(value = "userId", required = false) Long userId
        //@RequestParam(value = "characteristic", required = false) List<Characteristic> characteristics,
        //@RequestParam(value = "samples", required = false) List<Sample> samples
        ){
        try {
            Product filter = new Product();
            //filter.setCharacteristics(characteristics);
            filter.setExpirationDate(LocalDate.parse(expirationDate));
            filter.setId(id);
            filter.setName(name);
            filter.setOwner(owner);
            filter.setUserId(userId);
            //filter.setSamples(samples);

            List<Product> entities = service.find(filter);
            List<ProductDTO> dtos = converter.productToDTO(entities);

            return ResponseEntity.ok(dtos);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity findAll(){
        try {
            List<Product> entities = service.findAll();
            List<ProductDTO> dtos = converter.productToDTO(entities);

            return ResponseEntity.ok(dtos);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id){
        try {
            Product entity = service.findById(id);
            ProductDTO dto = converter.productToDTO(entity);

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
            dto = converter.productToDTO(entity);

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
