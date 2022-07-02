package br.edu.ifpb.dac.alysense.alysense.business.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import br.edu.ifpb.dac.alysense.alysense.model.entity.Avaliation;
import br.edu.ifpb.dac.alysense.alysense.model.repository.AvaliationRepository;
import br.edu.ifpb.dac.alysense.alysense.presentation.dto.AvaliationDTO;

@Service
public class AvaliationService {
    
    @Autowired
	private AvaliationRepository avaliationDAO;

    @Autowired
    private ConverterService service;
	
	
	public Avaliation save(Avaliation avaliation) {
		return avaliationDAO.save(avaliation);
	}
	
	public AvaliationDTO findById(Long id) {
		Avaliation entity = avaliationDAO.findById(id).get();
		AvaliationDTO dto = service.AvaliationToDTO(entity);
		return dto;
	}
	
	public Iterable<Avaliation> findAll(){
		return avaliationDAO.findAll();
	}
	
	public List<Avaliation> find(Avaliation filter){
		Example example = Example.of(filter,
				ExampleMatcher.matching().withIgnoreCase()
				.withStringMatcher(StringMatcher.CONTAINING));
		return  avaliationDAO.findAll(example);
	}
	
	public Avaliation update(Avaliation avaliation) {
		return avaliationDAO.save(avaliation);
	}
	
	public void delete(Long id) {
		avaliationDAO.deleteById(id);
	}
}
