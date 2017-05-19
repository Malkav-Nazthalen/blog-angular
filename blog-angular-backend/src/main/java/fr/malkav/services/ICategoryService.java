package fr.malkav.services;

import java.util.List;

import fr.malkav.modele.dto.webservice.CategoryDto;

public interface ICategoryService {

	List<CategoryDto> findAllCategories();

}
