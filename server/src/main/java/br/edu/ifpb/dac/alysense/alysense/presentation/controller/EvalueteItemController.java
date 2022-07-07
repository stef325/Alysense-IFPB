package br.edu.ifpb.dac.alysense.alysense.presentation.controller;

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
import br.edu.ifpb.dac.alysense.alysense.business.service.EvalueteItemService;
import br.edu.ifpb.dac.alysense.alysense.model.entity.EvalueteItem;
import br.edu.ifpb.dac.alysense.alysense.model.entity.Note;
import br.edu.ifpb.dac.alysense.alysense.model.entity.Sample;
import br.edu.ifpb.dac.alysense.alysense.model.entity.User;
import br.edu.ifpb.dac.alysense.alysense.presentation.dto.EvalueteItemDTO;

@RestController
@RequestMapping("/api/evaluete_item")
public class EvalueteItemController {
    @Autowired
	private EvalueteItemService evaluateItemService;

    @Autowired
    private ConverterService converterService;
	
	@PostMapping
	public ResponseEntity save(@RequestBody EvalueteItemDTO dto) {
		try {
			EvalueteItem evaluateItem = converterService.DTOToEvaluateItem(dto);
			evaluateItem = evaluateItemService.save(evaluateItem);
			dto = converterService.EvalueteItemToDTO(evaluateItem);
			return new ResponseEntity(dto, HttpStatus.CREATED);
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping("{id}")
	public ResponseEntity update(@PathVariable("id") Long id,@RequestBody EvalueteItemDTO dto) {
		try {
			dto.setId(id);
			EvalueteItem evaluateItem = converterService.DTOToEvaluateItem(dto);
			evaluateItem = evaluateItemService.update(evaluateItem);
			dto = converterService.EvalueteItemToDTO(evaluateItem);
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
			@RequestParam(value = "evaluator", required = false) User evaluator,
			@RequestParam(value = "sample", required = false) Sample sample,
			@RequestParam(value = "note", required = false) Note note,
			@RequestParam(value = "question", required = false) String question) {
		try {
			EvalueteItem filter = new EvalueteItem();
			filter.setId(id);
			filter.setEvaluator(evaluator);
			filter.setSample(sample);
			filter.setNote(note);
			filter.setQuestion(question);
			
			
			List<EvalueteItem> entities = evaluateItemService.find(filter);
			List<EvalueteItemDTO> dtos = converterService.EvalueteItemToDTO(entities);
			return ResponseEntity.ok(dtos);
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}
}
