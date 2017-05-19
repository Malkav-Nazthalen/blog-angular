package fr.malkav.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.malkav.modele.dto.webservice.ItemDto;
import fr.malkav.modele.dto.webservice.ItemLiteDto;
import fr.malkav.modele.dto.webservice.ItemNameDto;
import fr.malkav.services.IItemService;

/**
 * @author jgrimm
 */
@RestController
@RequestMapping("/api/items")
public class ItemServiceController {

	@Autowired
	private IItemService itemService;

	/**
	 * @param categoryId
	 * @return
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/names/{categoryId:^[0-9]*$}")
	public List<ItemNameDto> getItemNameForCategory(@PathVariable int categoryId) {
		return itemService.getListOfItemNameDtoByCategory(categoryId);
	}

	/**
	 * @param categoryId
	 * @return
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/lite/{categoryId:^[0-9]*$}")
	public List<ItemLiteDto> getItemLiteForCategory(@PathVariable int categoryId) {
		return itemService.getListOfItemLiteDtoByCategory(categoryId);
	}

	/**
	 * @param itemID
	 * @return
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{itemId:^[0-9]*$}")
	public ItemDto findById(@PathVariable int itemId) {
		return itemService.getItemDtoById(itemId);
	}

	/**
	 * @param itemID
	 * @return
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(path = "", method = RequestMethod.PUT)
	public ItemDto update(@RequestBody ItemDto item) {
		return itemService.update(item);
	}

}
