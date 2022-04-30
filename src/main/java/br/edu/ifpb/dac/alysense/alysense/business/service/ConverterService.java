package br.edu.ifpb.dac.alysense.alysense.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.alysense.alysense.model.entity.EvaluateItem;
import br.edu.ifpb.dac.alysense.alysense.model.entity.Product;
import br.edu.ifpb.dac.alysense.alysense.model.entity.User;
import br.edu.ifpb.dac.alysense.alysense.presentation.dto.EvaluateItemDTO;
import br.edu.ifpb.dac.alysense.alysense.presentation.dto.ProductDTO;
import br.edu.ifpb.dac.alysense.alysense.presentation.dto.UserDTO;

@Service
public class ConverterService {
	
	/*-------------------------- EvaluateItem to DTO -------------------------*/
	public EvaluateItemDTO EvaluateItemToDTO(EvaluateItem entity){
		EvaluateItemDTO dto = new EvaluateItemDTO();
		dto.setId(entity.getId());
		dto.setAspectAvaliation(entity.getAspectAvaliation());
		dto.setProduct(entity.getProduct());
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
		entity.setAspectAvaliation(dto.getAspectAvaliation());
		entity.setProduct(dto.getProduct());

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
	public static User conversorToUser(UserDTO dto) {
		User user = new User();
		user.setId(dto.getId());
		user.setName(dto.getName());
		user.setBirthDate(dto.getBirthDate());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		return user;
	}
	
	public static List<UserDTO> conversorToDTO(List<User> users) {
		List<UserDTO> dtos = new ArrayList<>();
		for(User user: users) {
			UserDTO dto = new UserDTO(user);
			dtos.add(dto);
		}
		return dtos;
	}
	
	public static UserDTO conversorToDTO(User user) {
		UserDTO dto = new UserDTO(user);
		return dto;
	}
	/*-------------------------- USER -------------------------*/


	/*-------------------------- product to DTO -------------------------*/
	public ProductDTO ProductToDTO(Product entity){
		ProductDTO dto = new ProductDTO();
		dto.setId(entity.getId());
		dto.setCharacteristic(entity.getCharacteristic());
		dto.setExpirationDate(entity.getExpirationDate());
		dto.setName(entity.getName());
		dto.setOwner(entity.getOwner());

		return dto;
		
	}

	public List<ProductDTO> ProductToDTO(List<Product> entities){
		List<ProductDTO> dtos = new ArrayList<>();

		for (Product entity : entities) {
			ProductDTO dto = ProductToDTO(entity);
			dtos.add(dto);
		}
		return dtos;
	}
	/*-------------------------- product to DTO -------------------------*/



	/*-------------------------- DTO to product -------------------------*/
	public Product DTOToProduct(ProductDTO dto) {
		Product entity = new Product();
		entity.setId(dto.getId());
		entity.setCharacteristic(dto.getCharacteristic());
		entity.setExpirationDate(dto.getExpirationDate());
		entity.setName(dto.getName());
		entity.setOwner(dto.getOwner());

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

}
