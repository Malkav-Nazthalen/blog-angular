package fr.malkav.services.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

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

/**
 * Simple naive implementation to transform Entities and datas to DTO (front).
 * XXX : use a real design pattern (not necessary as long as the model is
 * simple.
 * 
 * @author jgrimm
 *
 */
@Service
public class SimpleMapperDataToDto implements IMapperDataToDtoService {

	@Override
	public CategoryDto transformToDto(Category category) {
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setId(category.getId());
		categoryDto.setCode(category.getCode());
		categoryDto.setName(category.getName());
		categoryDto.setMore(category.getMore());
		List<CategoryDto> listOfChildCategoryDto = new ArrayList<>();
		for (Category childCategory : category.getListOfChild()) {
			CategoryDto childCategoryDto = transformToDto(childCategory);
			childCategoryDto.setParent(categoryDto);
			listOfChildCategoryDto.add(childCategoryDto);
		}
		categoryDto.setListOfChildCategory(listOfChildCategoryDto);
		return categoryDto;
	}

	@Override
	public ItemDto transformToDto(Item item) {
		ItemDto itemDto = new ItemDto();
		itemDto.setId(item.getId());
		itemDto.setCategory(transformToDto(item.getCategory()));
		itemDto.setCommentaire(item.getCommentaire());
		itemDto.setContent(item.getContent());
		itemDto.setImageHeadUrl(item.getImageHeadUrl());
		itemDto.setName(item.getName());
		itemDto.setCreator(transformToDto(item.getCreator()));
		return itemDto;
	}

	@Override
	public ItemNameDto transformToDto(ItemNameData itemData, Category category) {
		ItemNameDto itemNameDto = new ItemNameDto();
		itemNameDto.setId(itemData.getId());
		itemNameDto.setCategory(transformToDto(category));
		itemNameDto.setName(itemData.getName());
		return itemNameDto;
	}

	@Override
	public ItemLiteDto transformToDto(ItemLiteData itemData, Category category, User user) {
		ItemLiteDto itemLiteDto = new ItemLiteDto();
		itemLiteDto.setId(itemData.getId());
		itemLiteDto.setCategory(transformToDto(category));
		itemLiteDto.setName(itemData.getName());
		itemLiteDto.setCommentaire(itemData.getCommentaire());
		itemLiteDto.setImageHeadUrl(itemData.getImageHeadUrl());
		itemLiteDto.setCreator(transformToDto(user));
		return itemLiteDto;
	}

	@Override
	public UserDto transformToDto(User user) {
		return new UserDto(user.getName());
	}

}
