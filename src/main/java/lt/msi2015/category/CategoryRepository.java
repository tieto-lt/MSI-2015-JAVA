package lt.msi2015.category;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface CategoryRepository extends Repository<Category, Long> {
	Category findById(Long id);
	List<Category> findAll();
}
