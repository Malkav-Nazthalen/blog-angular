package fr.malkav.dao;

import java.util.List;

import fr.malkav.modele.entity.Category;

public interface ICategoryDao {

	List<Category> findAll();

	Category getById(int categoryId);
}
