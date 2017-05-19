package fr.malkav.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.malkav.dao.ICategoryDao;
import fr.malkav.dao.IItemDao;
import fr.malkav.dao.IUserDao;
import fr.malkav.modele.dto.data.ItemLiteData;
import fr.malkav.modele.dto.data.ItemNameData;
import fr.malkav.modele.dto.webservice.ItemDto;
import fr.malkav.modele.dto.webservice.ItemLiteDto;
import fr.malkav.modele.dto.webservice.ItemNameDto;
import fr.malkav.modele.entity.Category;
import fr.malkav.modele.entity.Item;
import fr.malkav.modele.entity.User;
import fr.malkav.services.mapper.IMapperDataToDtoService;

@Service
public class ItemServiceImpl implements IItemService {

	@Autowired
	private IItemDao itemDao;

	@Autowired
	private ICategoryDao categoryDao;

	@Autowired
	private IUserDao userDao;

	@Autowired
	private IMapperDataToDtoService mapperDataToDto;

	@Override
	public List<ItemLiteDto> getListOfItemLiteDtoByCategory(int categoryId) {
		List<ItemLiteData> listOfItemLiteData = itemDao.getItemsLiteByCategory(categoryId);
		List<ItemLiteDto> listOfItemLiteDto = new ArrayList<>();
		Category category = categoryDao.getById(categoryId);
		listOfItemLiteData.stream().forEach(itemData -> {
			User user = userDao.getById(itemData.getCreatorId());
			listOfItemLiteDto.add(mapperDataToDto.transformToDto(itemData, category, user));
		});
		return listOfItemLiteDto;
	}

	@Override
	public List<ItemNameDto> getListOfItemNameDtoByCategory(int categoryId) {
		List<ItemNameData> listOfItemLiteData = itemDao.getItemsNameByCategory(categoryId);
		List<ItemNameDto> listOfItemLiteDto = new ArrayList<>();
		Category category = categoryDao.getById(categoryId);
		listOfItemLiteData.stream()
				.forEach(itemData -> listOfItemLiteDto.add(mapperDataToDto.transformToDto(itemData, category)));
		return listOfItemLiteDto;
	}

	@Override
	public ItemDto getItemDtoById(int itemId) {
		Item item = itemDao.findById(itemId);
		return mapperDataToDto.transformToDto(item);
	}

	@Transactional
	@Override
	public ItemDto update(ItemDto itemDto) {
		Item item = itemDao.findById(itemDto.getId());
		Category category = categoryDao.getById(itemDto.getCategory().getId());
		item.setCategory(category);
		item.setCommentaire(itemDto.getCommentaire());
		item.setContent(itemDto.getContent());
		item.setImageHeadUrl(itemDto.getImageHeadUrl());
		item.setName(itemDto.getName());
		item = itemDao.update(item);
		return mapperDataToDto.transformToDto(item);
	}

}
