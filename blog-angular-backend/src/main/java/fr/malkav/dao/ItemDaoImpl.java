package fr.malkav.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.malkav.modele.dto.data.ItemLiteData;
import fr.malkav.modele.dto.data.ItemNameData;
import fr.malkav.modele.entity.Item;

@Repository
public class ItemDaoImpl implements IItemDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<ItemLiteData> getItemsLiteByCategory(int idCategory) {
		String queryBuilder = "SELECT new ";
		queryBuilder = queryBuilder.concat(ItemLiteData.class.getName());
		queryBuilder = queryBuilder
				.concat("( item.id, item.name, category.id, creator.id, item.imageHeadUrl, item.commentaire ) ");
		queryBuilder = queryBuilder.concat("FROM ");
		queryBuilder = queryBuilder.concat(Item.class.getName());
		queryBuilder = queryBuilder.concat(" item ");
		queryBuilder = queryBuilder.concat("left join item.category category ");
		queryBuilder = queryBuilder.concat("left join item.creator creator ");
		queryBuilder = queryBuilder.concat("where category.id = :idCategory");
		TypedQuery<ItemLiteData> query = entityManager.createQuery(queryBuilder, ItemLiteData.class);
		query.setParameter("idCategory", idCategory);
		return query.getResultList();
	}

	@Override
	public List<ItemNameData> getItemsNameByCategory(int idCategory) {
		String queryBuilder = "SELECT new ";
		queryBuilder = queryBuilder.concat(ItemNameData.class.getName());
		queryBuilder = queryBuilder.concat("( item.id, item.name, category.id ) ");
		queryBuilder = queryBuilder.concat("FROM ");
		queryBuilder = queryBuilder.concat(Item.class.getName());
		queryBuilder = queryBuilder.concat(" item ");
		queryBuilder = queryBuilder.concat("left join item.category category ");
		queryBuilder = queryBuilder.concat("where category.id = :idCategory");
		TypedQuery<ItemNameData> query = entityManager.createQuery(queryBuilder, ItemNameData.class);
		query.setParameter("idCategory", idCategory);
		return query.getResultList();
	}

	@Override
	public Item findById(int id) {
		return entityManager.find(Item.class, id);
	}

	@Override
	public Item update(Item item) {
		return entityManager.merge(item);
	}

}
