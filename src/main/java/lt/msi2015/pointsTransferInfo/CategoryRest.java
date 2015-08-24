package lt.msi2015.pointsTransferInfo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryRest {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@RequestMapping(value = "/api/categories", method = RequestMethod.GET)
	List<CategoryDto> getCategories() {
		List<CategoryDto> categories = new ArrayList<>();
		if (categories != null) {
			for (Category category : categoryRepository.findAll()) {
				categories.add(new CategoryDto(
					category.getId(),
					category.getName(),
					category.isEnabled()
				));
			}
		}
		return categories;
	}
}
