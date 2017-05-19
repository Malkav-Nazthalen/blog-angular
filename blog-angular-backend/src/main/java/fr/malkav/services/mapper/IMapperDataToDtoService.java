package fr.malkav.services.mapper;

import fr.malkav.modele.dto.data.ItemLiteData;
import fr.malkav.modele.dto.data.ItemNameData;
import fr.malkav.modele.dto.webservice.CategoryDto;
import fr.malkav.modele.dto.webservice.ItemDto;
import fr.malkav.modele.dto.webservice.ItemLiteDto;
import fr.malkav.modele.dto.webservice.ItemNameDto;
import fr.malkav.modele.dto.webservice.UserDto;
import fr.malkav.modele.entity.Category;
import fr.malkav.modele.entity.Item;
import fr.malkav.modele.entity.User;

public interface IMapperDataToDtoService {

	 CategoryDto transformToDto(Category category);
	 
	 ItemDto transformToDto(Item item);
	 
	 ItemNameDto transformToDto(ItemNameData itemData, Category category);
	 
	 ItemLiteDto transformToDto(ItemLiteData itemData, Category category, User user);
	 
	 UserDto transformToDto(User user);
}
