package lt.msi2015.category;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryRest {
	
	CategoryService categoryService;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@RequestMapping(value = "/api/categories", method = RequestMethod.GET)
	List<CategoryDto> getCategories() {
		List<CategoryDto> categories = new ArrayList<>();
		for (Category category : categoryRepository.findAll()) {
			if (category.isEnabled()) {
				categories.add(new CategoryDto(
					category.getId(),
					category.getName()
				));
			}
		}
		return categories;
	}
	
	@RequestMapping(value = "api/categories", method = RequestMethod.POST)
	ResponseEntity<?> newCategory(@RequestBody CategoryDto dto){
		categoryService.saveCategory(dto);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "api/category/{id}", method = RequestMethod.DELETE)
	ResponseEntity<?> deleteCategory(@PathVariable Long id){
		
		Category category = categoryRepository.findById(id);
		category.toggleEnabled();
		if (category != null && categoryRepository.save(category) != null) {
			return new ResponseEntity<>(null, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
}
