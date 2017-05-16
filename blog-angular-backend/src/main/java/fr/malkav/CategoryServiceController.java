package fr.malkav;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jgrimm
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CategoryServiceController {

	/**
	 * @param login
	 * @param password
	 * @return
	 */
	@GetMapping("/categories")
	public List<Category> getAllCategories() {
		Category cat1 = new Category(1, "tombe", "Tombes", true);
		Category cat2 = new Category(2, "temple", "Temples", true);
		Category cat3 = new Category(3, "autre", "Autres bizarreries", false);
		List<Category> categories = new ArrayList<>();
		categories.add(cat1);
		categories.add(cat2);
		categories.add(cat3);
		return categories;
	}

}
