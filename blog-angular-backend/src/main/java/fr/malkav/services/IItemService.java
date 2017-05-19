package fr.malkav.services;

import java.util.List;

import fr.malkav.modele.dto.webservice.ItemDto;
import fr.malkav.modele.dto.webservice.ItemLiteDto;
import fr.malkav.modele.dto.webservice.ItemNameDto;

public interface IItemService {

	List<ItemLiteDto> getListOfItemLiteDtoByCategory(int categoryId);

	List<ItemNameDto> getListOfItemNameDtoByCategory(int categoryId);

	ItemDto getItemDtoById(int itemId);

	ItemDto update(ItemDto itemDto);
}
