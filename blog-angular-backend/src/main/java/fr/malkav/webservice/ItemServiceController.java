package fr.malkav.webservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.malkav.modele.Item;
import fr.malkav.modele.ItemLite;
import fr.malkav.modele.ItemName;
import fr.malkav.modele.Test;
import fr.malkav.modele.User;

/**
 * @author jgrimm
 */
@RestController
@RequestMapping("/api")
public class ItemServiceController {

	private User creator = new User("test1");

	Item tomb1 = new Item(1, "tombe1", CategoryServiceController.cat1, this.creator,
			"../../../../assets/images/imageTombe1.jpg", "La tombe 1 est blablabla", "Test de contenu tombe1");
	Item tomb2 = new Item(2, "tombe2", CategoryServiceController.cat1, this.creator,
			"../../../../assets/images/imageTombe2.jpg", "La tombe 2 est encore mieux", "Test de contenu tombe2");
	Item tomb3 = new Item(3, "tombe3", CategoryServiceController.cat1, this.creator,
			"../../../../assets/images/imageTombe3.jpg", "La tombe 3 oulala", "Test de contenu tombe3");
	Item temp1 = new Item(4, "temple1", CategoryServiceController.cat2, this.creator,
			"../../../../assets/images/imageTombe3.jpg", "Le temple 1 trop beau", "Test de contenu temple1");
	Item temp2 = new Item(5, "temple2", CategoryServiceController.cat2, this.creator,
			"../../../../assets/images/imageTombe3.jpg", "Le temple 2 pas mal", "Test de contenu temple2");
	Item temp3 = new Item(6, "temple3", CategoryServiceController.cat2, this.creator,
			"../../../../assets/images/imageTombe3.jpg", "Ah ? un temple3 ça ?", "Test de contenu temple3");
	Item dive1 = new Item(7, "Divers1", CategoryServiceController.cat3, this.creator,
			"../../../../assets/images/imageTombe3.jpg", "Heu, quoi ça ?", "Test de contenu divers");

	/**
	 * @param categoryId
	 * @return
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/items/names/{categoryId:^[0-9]*$}")
	public List<ItemName> getItemNameForCategory(@PathVariable int categoryId) {
		// TODO : implémenter
		List<ItemName> retour = new ArrayList<>();
		if (categoryId == 1) {
			ItemName t1 = new ItemName(tomb1.getId(), tomb1.getName(), tomb1.getCategory());
			ItemName t2 = new ItemName(tomb2.getId(), tomb2.getName(), tomb2.getCategory());
			ItemName t3 = new ItemName(tomb3.getId(), tomb3.getName(), tomb3.getCategory());
			retour.add(t1);
			retour.add(t2);
			retour.add(t3);
		} else if (categoryId == 2) {
			ItemName t1 = new ItemName(temp1.getId(), temp1.getName(), temp1.getCategory());
			ItemName t2 = new ItemName(temp2.getId(), temp2.getName(), temp2.getCategory());
			ItemName t3 = new ItemName(temp3.getId(), temp3.getName(), temp3.getCategory());
			retour.add(t1);
			retour.add(t2);
			retour.add(t3);
		} else {
			ItemName t1 = new ItemName(dive1.getId(), dive1.getName(), dive1.getCategory());
			retour.add(t1);
		}
		return retour;
	}

	/**
	 * @param categoryId
	 * @return
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/items/lite/{categoryId:^[0-9]*$}")
	public List<ItemLite> getItemLiteForCategory(@PathVariable int categoryId) {
		// TODO : implémenter
		List<ItemLite> retour = new ArrayList<>();
		if (categoryId == 1) {
			ItemLite t1 = new ItemLite(tomb1.getId(), tomb1.getName(), tomb1.getCategory(), tomb1.getCreator(),
					tomb1.getImageHeadUrl(), tomb1.getCommentaire());
			ItemLite t2 = new ItemLite(tomb2.getId(), tomb2.getName(), tomb2.getCategory(), tomb2.getCreator(),
					tomb2.getImageHeadUrl(), tomb2.getCommentaire());
			ItemLite t3 = new ItemLite(tomb3.getId(), tomb3.getName(), tomb3.getCategory(), tomb3.getCreator(),
					tomb3.getImageHeadUrl(), tomb3.getCommentaire());
			retour.add(t1);
			retour.add(t2);
			retour.add(t3);
		} else if (categoryId == 2) {
			ItemLite t1 = new ItemLite(temp1.getId(), temp1.getName(), temp1.getCategory(), temp1.getCreator(),
					temp1.getImageHeadUrl(), temp1.getCommentaire());
			ItemLite t2 = new ItemLite(temp2.getId(), temp2.getName(), temp2.getCategory(), temp2.getCreator(),
					temp2.getImageHeadUrl(), temp2.getCommentaire());
			ItemLite t3 = new ItemLite(temp3.getId(), temp3.getName(), temp3.getCategory(), temp3.getCreator(),
					temp3.getImageHeadUrl(), temp3.getCommentaire());
			retour.add(t1);
			retour.add(t2);
			retour.add(t3);
		} else {
			ItemLite t1 = new ItemLite(dive1.getId(), dive1.getName(), dive1.getCategory(), dive1.getCreator(),
					dive1.getImageHeadUrl(), dive1.getCommentaire());
			retour.add(t1);
		}
		return retour;
	}

	/**
	 * @param item
	 *            ID
	 * @return
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/items/{itemId:^[0-9]*$}")
	public Item findById(@PathVariable int itemId) {
		// TODO : implémenter
		List<Item> listOfItems = new ArrayList<>();
		listOfItems.add(tomb1);
		listOfItems.add(tomb2);
		listOfItems.add(tomb3);
		listOfItems.add(temp1);
		listOfItems.add(temp2);
		listOfItems.add(temp3);
		listOfItems.add(dive1);
		for (Item item : listOfItems) {
			if (item.getId() == itemId) {
				return item;
			}
		}
		return null;
	}

	/**
	 * @param item
	 *            ID
	 * @return
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/items")
	@RequestMapping(value="/items", method=RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody Test item) {
		System.out.println("TEST");
		List<Item> listOfItems = new ArrayList<>();
		listOfItems.add(tomb1);
		listOfItems.add(tomb2);
		listOfItems.add(tomb3);
		listOfItems.add(temp1);
		listOfItems.add(temp2);
		listOfItems.add(temp3);
		listOfItems.add(dive1);
//		for (Item existingItem : listOfItems) {
//			if (existingItem.getId() == item.getId()) {
//				existingItem = item;
//			}
//		}
	}

}
