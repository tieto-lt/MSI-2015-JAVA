package lt.msi2015.category;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository catRepo;

	@Transactional
	public void saveCategory(CategoryDto dto){
		
		adjustTitle(dto);
		
		Category catToSave = categoryToSave(dto);
		
		catRepo.save(catToSave);
	}
	
	private void adjustTitle(CategoryDto dto){
		dto.name = dto.name.toLowerCase();
		dto.name = WordUtils.capitalize(dto.name);
	}
	
	private Category categoryToSave(CategoryDto dto){
		List<Category> duplicateList = catRepo.findByName(dto.name);
		if(duplicateList.isEmpty()){
			return new Category(dto.name, dto.enabled);
		} else {
			Category cat = duplicateList.get(0);
			cat.toggleEnabled();
			return cat;
		}
	}
}
