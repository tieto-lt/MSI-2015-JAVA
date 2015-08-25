package lt.msi2015.category;

import lt.msi2015.util.Dto;

public class CategoryDto extends Dto {
	public Long id;
	public String name;
	
	public CategoryDto() {
		
	}
	
	public CategoryDto(Long id, String name) {
		this.id = id;
		this.name = name;
	}	
	
	
}
