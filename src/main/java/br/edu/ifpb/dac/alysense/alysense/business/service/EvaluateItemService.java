package br.edu.ifpb.dac.alysense.alysense.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.alysense.alysense.model.entity.EvaluateItem;
import br.edu.ifpb.dac.alysense.alysense.model.repository.EvaluateItemRepository;
import br.edu.ifpb.dac.alysense.alysense.presentation.dto.EvaluateItemDTO;

@Service
public class EvaluateItemService {

    @Autowired
	private EvaluateItemRepository evaluateItemDAO;

    @Autowired
    private ConverterService service;
	
	
	public EvaluateItem save(EvaluateItem evaluateItem) {
		return evaluateItemDAO.save(evaluateItem);
	}
	
	public EvaluateItemDTO findById(Long id) {
		EvaluateItem entity = evaluateItemDAO.findById(id).get();
		EvaluateItemDTO dto = service.EvaluateItemToDTO(entity);
		return dto;
	}
	
	public Iterable<EvaluateItem> findAll(){
		return evaluateItemDAO.findAll();
	}
	
	public List<EvaluateItem> find(EvaluateItem filter){
		Example example = Example.of(filter,
				ExampleMatcher.matching().withIgnoreCase()
				.withStringMatcher(StringMatcher.CONTAINING));
		return evaluateItemDAO.findAll(example);
	}
	
	public EvaluateItem update(EvaluateItem user) {
		return evaluateItemDAO.save(user);
	}
	
	public void delete(Long id) {
		evaluateItemDAO.deleteById(id);
	}
    
}
