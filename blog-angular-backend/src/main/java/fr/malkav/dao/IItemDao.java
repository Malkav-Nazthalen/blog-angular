package fr.malkav.dao;

import java.util.List;

import fr.malkav.modele.dto.data.ItemLiteData;
import fr.malkav.modele.dto.data.ItemNameData;
import fr.malkav.modele.entity.Item;

public interface IItemDao {

	List<ItemLiteData> getItemsLiteByCategory(int idCategory);

	List<ItemNameData> getItemsNameByCategory(int idCategory);

	Item findById(int id);

	Item update(Item item);
}
