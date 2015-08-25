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
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	CategoryService categoryService;
	
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
	
	@RequestMapping(value = "api/categories", method = RequestMethod.POST)
	ResponseEntity<?> newCategory(@RequestBody CategoryDto dto){
		categoryService.saveCategory(dto);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "api/category/{id}", method = RequestMethod.DELETE)
	ResponseEntity<?> deleteCategory(@PathVariable Long id){
		
		Category category = categoryRepository.findById(id);
		category.toggleEnabled();
		categoryRepository.save(category);
		
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	
}
