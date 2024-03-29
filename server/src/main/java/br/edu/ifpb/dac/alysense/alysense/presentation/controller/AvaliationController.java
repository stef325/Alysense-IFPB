package br.edu.ifpb.dac.alysense.alysense.presentation.controller;

import java.util.ArrayList;
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
import br.edu.ifpb.dac.alysense.alysense.business.service.AvaliationService;
import br.edu.ifpb.dac.alysense.alysense.business.service.ConverterService;
import br.edu.ifpb.dac.alysense.alysense.model.entity.Avaliation;
import br.edu.ifpb.dac.alysense.alysense.model.entity.EvalueteItem;
import br.edu.ifpb.dac.alysense.alysense.model.entity.Product;
import br.edu.ifpb.dac.alysense.alysense.model.entity.User;
import br.edu.ifpb.dac.alysense.alysense.presentation.dto.AvaliationDTO;


@RestController
@RequestMapping("/api/avaliation")
public class AvaliationController {
    @Autowired
	private AvaliationService avaliationService;

    @Autowired
    private ConverterService converterService;
	
	@PostMapping
	public ResponseEntity save(@RequestBody AvaliationDTO dto) {

		try {
			Avaliation entity = converterService.DTOToAvaliation(dto);
			avaliationService.save(entity);
			dto = converterService.AvaliationToDTO(entity);
			return new ResponseEntity(dto, HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping("{id}")
	public ResponseEntity update(@PathVariable("id") Long id,@RequestBody AvaliationDTO dto) {
		try {
			dto.setId(id);
			Avaliation avaliation = converterService.DTOToAvaliation(dto);
			avaliation = avaliationService.update(avaliation);
			dto = converterService.AvaliationToDTO(avaliation);
			return ResponseEntity.ok(dto);
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping("{id}")
	public ResponseEntity delete(@PathVariable("id") Long id){
		try {
			avaliationService.delete(id);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	
	@GetMapping
	public ResponseEntity find( @RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "aspect", required = false) String question,
			@RequestParam(value = "product", required = false) Product product,
			@RequestParam(value = "evaluateItems", required = false) List<EvalueteItem> evalueteItems) {
		try {
			Avaliation filter = new Avaliation();
			filter.setId(id);
            filter.setQuestion(question);
			filter.setProduct(product);
            filter.setEvalueteItems(evalueteItems);
			
			
			List<Avaliation> entities = avaliationService.find(filter);
			List<AvaliationDTO> dtos = converterService.AvaliationToDTO(entities);
			return ResponseEntity.ok(dtos);
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}
}
