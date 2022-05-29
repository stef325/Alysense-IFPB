package br.edu.ifpb.dac.alysense.alysense.business.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.alysense.alysense.model.entity.Avaliation;
import br.edu.ifpb.dac.alysense.alysense.model.entity.EvaluateItem;
import br.edu.ifpb.dac.alysense.alysense.model.entity.EventSense;
import br.edu.ifpb.dac.alysense.alysense.model.entity.Product;
import br.edu.ifpb.dac.alysense.alysense.model.entity.User;
import br.edu.ifpb.dac.alysense.alysense.presentation.dto.AvaliationDTO;
import br.edu.ifpb.dac.alysense.alysense.presentation.dto.EvaluateItemDTO;
import br.edu.ifpb.dac.alysense.alysense.presentation.dto.EventDTO;
import br.edu.ifpb.dac.alysense.alysense.presentation.dto.ProductDTO;
import br.edu.ifpb.dac.alysense.alysense.presentation.dto.UserDTO;

@Service
public class ConverterService {

		/*-------------------------- Avaliation to DTO -------------------------*/
		public AvaliationDTO AvaliationToDTO(Avaliation entity){
			AvaliationDTO dto = new AvaliationDTO();
			dto.setId(entity.getId());
			dto.setAnswer(entity.getAnswer());
			dto.setEvaluateItems(entity.getEvaluateItems());
			return dto;
			
		}
	
		public List<AvaliationDTO> AvaliationToDTO(List<Avaliation> entities){
			List<AvaliationDTO> dtos = new ArrayList<>();
	
			for (Avaliation entity : entities) {
				AvaliationDTO dto = AvaliationToDTO(entity);
				dtos.add(dto);
			}
			return dtos;
		}
		/*-------------------------- Avaliation to DTO -------------------------*/
	
	
	
		/*-------------------------- DTO to Avaliation -------------------------*/
		public Avaliation DTOToAvaliation(AvaliationDTO dto) {
			Avaliation entity = new Avaliation();
			entity.setId(dto.getId());
			entity.setAnswer(dto.getAnswer());
			entity.setEvaluateItems(dto.getEvaluateItems());
			return entity;
	
		}
	
		public List<Avaliation> DTOToAvaliation(List<AvaliationDTO> dtos) {
			List<Avaliation> entities = new ArrayList<>();
	
			for (AvaliationDTO dto : dtos) {
				Avaliation entity = DTOToAvaliation(dto);
				entities.add(entity);
			}
			return entities;
		}
		/*-------------------------- DTO to Avaliation -------------------------*/


	
	/*-------------------------- EvaluateItem to DTO -------------------------*/
	public EvaluateItemDTO EvaluateItemToDTO(EvaluateItem entity){
		EvaluateItemDTO dto = new EvaluateItemDTO();
		dto.setId(entity.getId());
		dto.setEvaluator(entity.getEvaluator());
		dto.setSample(entity.getSample());
		dto.setNote(entity.getNote());
		dto.setQuestion(entity.getQuestion());
		return dto;
		
	}

	public List<EvaluateItemDTO> EvaluateItemToDTO(List<EvaluateItem> entities){
		List<EvaluateItemDTO> dtos = new ArrayList<>();

		for (EvaluateItem entity : entities) {
			EvaluateItemDTO dto = EvaluateItemToDTO(entity);
			dtos.add(dto);
		}
		return dtos;
	}
	/*-------------------------- EvaluateItem to DTO -------------------------*/



	/*-------------------------- DTO to EvaluateItem -------------------------*/
	public EvaluateItem DTOToEvaluateItem(EvaluateItemDTO dto) {
		EvaluateItem entity = new EvaluateItem();
		entity.setId(dto.getId());
		entity.setEvaluator(dto.getEvaluator());
		entity.setSample(dto.getSample());
		entity.setNote(dto.getNote());
		entity.setQuestion(dto.getQuestion());
		return entity;

	}

	public List<EvaluateItem> DTOToEvaluateItem(List<EvaluateItemDTO> dtos) {
		List<EvaluateItem> entities = new ArrayList<>();

		for (EvaluateItemDTO dto : dtos) {
			EvaluateItem entity = DTOToEvaluateItem(dto);
			entities.add(entity);
		}
		return entities;
	}
	/*-------------------------- DTO to EvaluateItem -------------------------*/

	/*-------------------------- USER -------------------------*/
	public static User converterToUser(UserDTO dto) {
		User user = new User();
		user.setId(dto.getId());
		user.setName(dto.getName());
		user.setBirthDate(dto.getBirthDate());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		return user;
	}
	
	public static Set<UserDTO> converterToDTO(Set<User> users) {
		Set<UserDTO> dtos = new HashSet<>();
		for(User user: users) {
			UserDTO dto = new UserDTO(user);
			dtos.add(dto);
		}
		return dtos;
	}
	
	public static UserDTO converterToDTO(User user) {
		UserDTO dto = new UserDTO(user);
		return dto;
	}
	/*-------------------------- USER -------------------------*/


	/*-------------------------- product to DTO -------------------------*/
	public ProductDTO productToDTO(Product entity){
		ProductDTO dto = new ProductDTO();
		dto.setId(entity.getId());
		dto.setCharacteristics(entity.getCharacteristics());
		dto.setExpirationDate(entity.getExpirationDate());
		dto.setIngredients(entity.getIngredients());
		dto.setName(entity.getName());
		dto.setOwner(entity.getOwner());
		dto.setSamples(entity.getSamples());
		return dto;
		
	}

	public List<ProductDTO> productToDTO(List<Product> entities){
		List<ProductDTO> dtos = new ArrayList<>();

		for (Product entity : entities) {
			ProductDTO dto = productToDTO(entity);
			dtos.add(dto);
		}
		return dtos;
	}
	/*-------------------------- product to DTO -------------------------*/



	/*-------------------------- DTO to product -------------------------*/
	public Product DTOToProduct(ProductDTO dto) {
		Product entity = new Product();
		entity.setId(dto.getId());
		entity.setCharacteristics(dto.getCharacteristics());
		entity.setExpirationDate(dto.getExpirationDate());
		entity.setIngredients(dto.getIngredients());
		entity.setName(dto.getName());
		entity.setOwner(dto.getOwner());
		entity.setSamples(dto.getSamples());

		return entity;

	}

	public List<Product> DTOToProduct(List<ProductDTO> dtos) {
		List<Product> entities = new ArrayList<>();

		for (ProductDTO dto : dtos) {
			Product entity = DTOToProduct(dto);
			entities.add(entity);
		}
		return entities;
	}
	/*-------------------------- DTO to product -------------------------*/


	/*--------------------------------------------------- Event ---------------------------------------------------*/

	
	/*-------------------------- Event to DTO -------------------------*/
	public EventDTO EventToDTO(EventSense entity){
		EventDTO dto = new EventDTO();
		dto.setId(entity.getId());
		dto.setTitle(entity.getTitle());
		dto.setDate(entity.getDate());
		dto.setPeopleLimit(entity.getPeopleLimit());
		dto.setItems(entity.getItems());
		dto.setLocal(entity.getLocal());
		dto.getAdmUser().setPassword(null);
		dto.setAdmUser(entity.getAdmUser());
		dto.setEvaluators(converterToDTO(entity.getEvaluators()));
		dto.setNumberSample(entity.getNumberSample());
		return dto;
		
	}

	public List<EventDTO> EventToDTO(List<EventSense> entities){
		List<EventDTO> dtos = new ArrayList<>();

		for (EventSense entity : entities) {
			EventDTO dto = EventToDTO(entity);
			dtos.add(dto);
		}
		return dtos;
	}
	/*-------------------------- Event to DTO -------------------------*/



	/*-------------------------- DTO to Event -------------------------*/
	public EventSense DTOToEvent(EventDTO dto) {
		EventSense entity = new EventSense();
		entity.setId(dto.getId());
		entity.setTitle(dto.getTitle());
		entity.setDate(dto.getDate());
		entity.setPeopleLimit(dto.getPeopleLimit());
		entity.setItems(dto.getItems());
		entity.setLocal(dto.getLocal());
		entity.setAdmUser(dto.getAdmUser());
		entity.setNumberSample(dto.getNumberSample());
		return entity;

	}

	public List<EventSense> DTOToEvent(List<EventDTO> dtos) {
		List<EventSense> entities = new ArrayList<>();

		for (EventDTO dto : dtos) {
			EventSense entity = DTOToEvent(dto);
			entities.add(entity);
		}
		return entities;
	}
	/*-------------------------- DTO to Event -------------------------*/

	
	/*--------------------------------------------------- Event ---------------------------------------------------*/
}
