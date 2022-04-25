package br.edu.ifpb.dac.alysense.alysense.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.alysense.alysense.model.entity.Product;
import br.edu.ifpb.dac.alysense.alysense.model.entity.User;
import br.edu.ifpb.dac.alysense.alysense.presentation.dto.ProductDTO;
import br.edu.ifpb.dac.alysense.alysense.presentation.dto.UserDTO;

@Service
public class ConverterService {

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
