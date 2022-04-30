package br.edu.ifpb.dac.alysense.alysense.presentation.controller;

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
import br.edu.ifpb.dac.alysense.alysense.business.service.EvaluateItemService;
import br.edu.ifpb.dac.alysense.alysense.model.entity.AspectAvaliation;
import br.edu.ifpb.dac.alysense.alysense.model.entity.EvaluateItem;
import br.edu.ifpb.dac.alysense.alysense.model.entity.Product;
import br.edu.ifpb.dac.alysense.alysense.presentation.dto.EvaluateItemDTO;

@RestController
@RequestMapping("/api/evaluete_item")
public class EvalueteItemController {
    @Autowired
	private EvaluateItemService evaluateItemService;

    @Autowired
    private ConverterService converterService;
	
	@PostMapping
	public ResponseEntity save(@RequestBody EvaluateItemDTO dto) {
		try {
			EvaluateItem evaluateItem = converterService.DTOToEvaluateItem(dto);
			evaluateItem = evaluateItemService.save(evaluateItem);
			dto = converterService.EvaluateItemToDTO(evaluateItem);
			return new ResponseEntity(dto, HttpStatus.CREATED);
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping("{id}")
	public ResponseEntity update(@PathVariable("id") Long id,@RequestBody EvaluateItemDTO dto) {
		try {
			dto.setId(id);
			EvaluateItem evaluateItem = converterService.DTOToEvaluateItem(dto);
			evaluateItem = evaluateItemService.update(evaluateItem);
			dto = converterService.EvaluateItemToDTO(evaluateItem);
			return ResponseEntity.ok(dto);
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping("{id}")
	public ResponseEntity delete(@PathVariable("id") Long id){
		try {
			evaluateItemService.delete(id);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	
	@GetMapping
	public ResponseEntity find( @RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "product", required = false) Product product,
			@RequestParam(value = "aspect", required = false) AspectAvaliation aspect) {
		try {
			EvaluateItem filter = new EvaluateItem();
			filter.setId(id);
            filter.setProduct(product);
			filter.setAspectAvaliation(aspect);
			
			
			List<EvaluateItem> entities = evaluateItemService.find(filter);
			List<EvaluateItemDTO> dtos = converterService.EvaluateItemToDTO(entities);
			return ResponseEntity.ok(dtos);
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}
}
