package br.edu.ifpb.dac.alysense.alysense.business.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.alysense.alysense.model.entity.EvalueteItem;
import br.edu.ifpb.dac.alysense.alysense.model.repository.EvaluateItemRepository;
import br.edu.ifpb.dac.alysense.alysense.presentation.dto.EvalueteItemDTO;

@Service
public class EvalueteItemService {

    @Autowired
	private EvaluateItemRepository evaluateItemDAO;

    @Autowired
    private ConverterService service;
	
	
	public EvalueteItem save(EvalueteItem evaluateItem) {
		return evaluateItemDAO.save(evaluateItem);
	}
	
	public EvalueteItemDTO findById(Long id) {
		EvalueteItem entity = evaluateItemDAO.findById(id).get();
		EvalueteItemDTO dto = service.EvalueteItemToDTO(entity);
		return dto;
	}
	
	public Iterable<EvalueteItem> findAll(){
		return evaluateItemDAO.findAll();
	}
	
	public List<EvalueteItem> find(EvalueteItem filter){
		Example example = Example.of(filter,
				ExampleMatcher.matching().withIgnoreCase()
				.withStringMatcher(StringMatcher.CONTAINING));
		return evaluateItemDAO.findAll(example);
	}
	
	public EvalueteItem update(EvalueteItem evaluateItem) {
		return evaluateItemDAO.save(evaluateItem);
	}
	
	public void delete(Long id) {
		evaluateItemDAO.deleteById(id);
	}
    
}
