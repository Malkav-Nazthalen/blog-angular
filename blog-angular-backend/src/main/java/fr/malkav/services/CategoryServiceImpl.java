package fr.malkav.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.malkav.dao.ICategoryDao;
import fr.malkav.modele.dto.webservice.CategoryDto;
import fr.malkav.modele.entity.Category;
import fr.malkav.services.mapper.IMapperDataToDtoService;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private ICategoryDao categoryDao;

	@Autowired
	private IMapperDataToDtoService mapperDataToDto;

	@Override
	public List<CategoryDto> findAllCategories() {
		List<Category> listOfCategory = categoryDao.findAll();
		List<CategoryDto> listOfCategoryDto = new ArrayList<>();
		listOfCategory.stream().forEach(c -> listOfCategoryDto.add(mapperDataToDto.transformToDto(c)));
		return listOfCategoryDto;
	}
}
