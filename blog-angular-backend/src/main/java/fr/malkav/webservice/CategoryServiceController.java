package fr.malkav.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.malkav.modele.dto.webservice.CategoryDto;
import fr.malkav.services.ICategoryService;

/**
 * @author jgrimm
 */
@RestController
@RequestMapping("/api")
public class CategoryServiceController {

	@Autowired
	private ICategoryService categoryService;

	/**
	 * @return
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/categories")
	public List<CategoryDto> getAllCategories() {
		return categoryService.findAllCategories();
	}

}
