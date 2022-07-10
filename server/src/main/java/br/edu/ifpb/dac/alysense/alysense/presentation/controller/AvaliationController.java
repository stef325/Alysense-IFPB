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
import br.edu.ifpb.dac.alysense.alysense.presentation.dto.AvaliationDTO;


@RestController
@RequestMapping("/api/avaliation")
public class AvaliationController {
    @Autowired
	private AvaliationService avaliationService;

    @Autowired
    private ConverterService converterService;
	
	@PostMapping
	public ResponseEntity save(@RequestBody List<AvaliationDTO> dtos) {
		List<AvaliationDTO> dtosReturn = new ArrayList<>();
		try {
			for(AvaliationDTO dto : dtos) {
				Avaliation avaliation = converterService.DTOToAvaliation(dto);
				avaliation = avaliationService.save(avaliation);
				dto = converterService.AvaliationToDTO(avaliation);
				dtosReturn.add(dto);
			}
			return new ResponseEntity(dtosReturn, HttpStatus.CREATED);
		}catch(Exception e) {
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
			@RequestParam(value = "aspect", required = false) String answer,
			@RequestParam(value = "evaluateItems", required = false) List<EvalueteItem> evalueteItems) {
		try {
			Avaliation filter = new Avaliation();
			filter.setId(id);
            filter.setAnswer(answer);
            filter.setEvalueteItems(evalueteItems);
			
			
			List<Avaliation> entities = avaliationService.find(filter);
			List<AvaliationDTO> dtos = converterService.AvaliationToDTO(entities);
			return ResponseEntity.ok(dtos);
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}
}
