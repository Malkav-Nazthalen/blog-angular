package fr.malkav.webservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.malkav.modele.Category;

/**
 * @author jgrimm
 */
@RestController
@RequestMapping("/api")
public class CategoryServiceController {

	public static final Category cat1 = new Category(1, "tombe", "Tombes", true);
	public static final Category cat2 = new Category(2, "temple", "Temples", true);
	public static final Category cat3 = new Category(3, "autre", "Autres bizarreries", false);

	/**
	 * @param login
	 * @param password
	 * @return
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/categories")
	public List<Category> getAllCategories() {
		List<Category> categories = new ArrayList<>();
		categories.add(cat1);
		categories.add(cat2);
		categories.add(cat3);
		return categories;
	}

}
