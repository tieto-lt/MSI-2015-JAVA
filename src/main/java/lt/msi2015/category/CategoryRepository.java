package lt.msi2015.category;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import java.lang.String;
import lt.msi2015.category.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	Category findById(Long id);
	List<Category> findAll();
	List<Category> findByName(String name);
}
