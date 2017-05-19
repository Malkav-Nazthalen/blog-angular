package fr.malkav.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.malkav.modele.entity.Category;

@Repository
public class CategoryDaoImpl implements ICategoryDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Category> findAll() {
		String queryBuilder = "FROM ";
		queryBuilder = queryBuilder.concat(Category.class.getName());
		TypedQuery<Category> query = entityManager.createQuery(queryBuilder, Category.class);
		return query.getResultList();
	}

	@Override
	public Category getById(int categoryId) {
		return entityManager.find(Category.class, categoryId);
	}

}
